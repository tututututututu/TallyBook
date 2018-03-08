package com.tutu.tallybook.web;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.widget.LinearLayout;

import com.hzecool.common.utils.ImageUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.common.utils.Utils;
import com.hzecool.core.rxbus.RxBus;
import com.hzecool.db.utils.utils;
import com.hzecool.widget.materialdialog.MaterialDialog;
import com.just.library.AgentWeb;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.tutu.tallybook.R;
import com.tutu.tallybook.web.beana.CameraEvent;
import com.tutu.tallybook.web.beana.JumpEvent;
import com.tutu.tallybook.web.beana.ScanQrCodeEvent;
import com.tutu.tallybook.web.gps.LocationHelper;

import java.io.ByteArrayOutputStream;
import java.io.File;

import io.github.xudaojie.qrcodelib.CaptureActivity;
import me.shaohui.advancedluban.Luban;
import rx.functions.Action1;



/**
 * @author yksoft
 */
public class WebMainActivity extends AppCompatActivity {
    private AgentWeb mAgentWeb;
    private LinearLayout parent;
    private LocationHelper locationHelper;
    private File file;

    public static int REQUEST_CAMERA = 101;

    private String type = "";
    private MaterialDialog dialog;

    //15116318447   zxc123
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web);

        parent = (LinearLayout) findViewById(R.id.parent);

        //传入Activity
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(parent, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()// 使用默认进度条
                .defaultProgressBarColor() // 使用默认进度条颜色
                //.setReceivedTitleCallback(mCallback) //设置 Web 页面的 title 回调
                .createAgentWeb()//
                .ready()
                .go(Constants.INDEX_URL);

        mAgentWeb.getAgentWebSettings().getWebSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        mAgentWeb.getJsInterfaceHolder().addJavaObject("js", new JavaScriptInterface(this));
        RxBus.obtainEvent(JumpEvent.class).subscribe(new Action1<JumpEvent>() {
            @Override
            public void call(JumpEvent jumpEvent) {
                mAgentWeb.getWebCreator().create().get().loadUrl(jumpEvent.getUrl());
            }
        });


        RxPermissions rxPermissions = new RxPermissions(this);

        rxPermissions.request(
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {
                            locationHelper = new LocationHelper(getApplicationContext());
                            locationHelper.initLocation();
                        } else {
                            new MaterialDialog.Builder(WebMainActivity.this)
                                    .title("提示")
                                    .content("没有获取到相应权限,请允许权限后重试")
                                    .positiveText("确定")
                                    .show();
                        }
                    }
                });

        registEvent();
    }

    private void registEvent() {
        RxBus.obtainEvent(CameraEvent.class)
                .subscribe(cameraEvent -> {
                    type = cameraEvent.getType();
                    RxPermissions rxPermissions = new RxPermissions(this);
                    rxPermissions.request(Manifest.permission.CAMERA)
                            .subscribe(aBoolean -> {
                                if (aBoolean) {
                                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                    file = new File(utils.getCacheDirectory(Utils.getContext(), true).getAbsolutePath()
                                            + "/img/" + System.currentTimeMillis() + ".jpg");
                                    file.getParentFile().mkdirs();
                                    Uri uri = FileProvider.getUriForFile(WebMainActivity.this, "com.hzecool.common.fileProvider", file);
                                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                                    startActivityForResult(intent, REQUEST_CAMERA);
                                } else {
                                    ToastUtils.showShortToast("没有照相机权限");
                                }
                            });


                });

        RxBus.obtainEvent(ScanQrCodeEvent.class)
                .subscribe(new Action1<ScanQrCodeEvent>() {
                    @Override
                    public void call(ScanQrCodeEvent scanQrCodeEvent) {
                        Intent i = new Intent(WebMainActivity.this, CaptureActivity.class);
                        startActivityForResult(i, 999);
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {

            if (!TextUtils.isEmpty(type)) {
                yasuo(file);
            } else {
                ToastUtils.showShortToast("照片类型为空");
            }
        }


        if (resultCode == RESULT_OK
                && requestCode == 999
                && data != null) {
            String result = data.getStringExtra("result");
            if (result.startsWith("http")){
                RxBus.postEvent(new JumpEvent(result), JumpEvent.class);
            }else {
                ToastUtils.showShortToast("二维码不是网址");
            }

        }
    }


    public void yasuo(File filePa) {
        Luban.get(this)
                .load(filePa)
                .setMaxSize(2000)
                .setMaxHeight(1920)
                .setMaxWidth(1080)
                .putGear(Luban.CUSTOM_GEAR)
                .asObservable()
                .subscribe(file -> {
                    Log.i("TAG", file.getAbsolutePath());
                    mAgentWeb.getJsEntraceAccess().quickCallJs("onGetPic", type, file.getAbsolutePath());

                }, throwable -> ToastUtils.showShortToast("压缩失败"));

    }


    String getBitmapBase64(String path) {
        Bitmap bm = ImageUtils.getBitmap(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //1.5M的压缩后在100Kb以内，测试得值,压缩后的大小=94486字节,压缩后的大小=74473字节
        //这里的JPEG 如果换成PNG，那么压缩的就有600kB这样
        bm.compress(Bitmap.CompressFormat.JPEG, 80, baos);
        byte[] b = baos.toByteArray();
        String img64 = Base64.encodeToString(b, Base64.DEFAULT);
        Log.d("getBitmapBase64", "压缩后的大小=" + b.length);
        return img64;
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAgentWeb.getWebLifeCycle().onDestroy();
    }
}
