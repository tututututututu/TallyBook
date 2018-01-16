package com.tutu.tallybook.web.auth;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hzecool.common.utils.ImageUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.common.utils.Utils;
import com.hzecool.core.base.TBaseActivity;
import com.hzecool.core.log.L;
import com.hzecool.core.rxbus.RxBus;
import com.hzecool.db.utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.tutu.tallybook.R;
import com.tutu.tallybook.bean.AuthResultBean;
import com.tutu.tallybook.bean.AuthUploadBean;
import com.tutu.tallybook.bean.FacePPComparaResultBean;
import com.tutu.tallybook.bean.SFZAuthBean;
import com.tutu.tallybook.web.Constants;
import com.tutu.tallybook.web.GsonUtils;
import com.tutu.tallybook.web.beana.JumpEvent;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.shaohui.advancedluban.Luban;

/**
 * @author yksoft
 */
public class AuthenActivity extends TBaseActivity<IAuthenView, AuthenPresenter>
        implements IAuthenView {

    public static final int SFZM = 1;
    public static final int SFFM = 2;
    public static final int RL = 3;

    @BindView(R.id.tv_titel)
    TextView tvTitel;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.title_root)
    RelativeLayout titleRoot;
    @BindView(R.id.iv_zm)
    ImageView ivZm;
    @BindView(R.id.iv_fm)
    ImageView ivFm;
    @BindView(R.id.iv_rl)
    ImageView ivRl;
    @BindView(R.id.tv_save)
    TextView tvSave;


    private File zmFile;
    private String zmBase64;
    private String zmResult;
    private File fmFile;
    private String fmBase64;
    private String fmResult;
    private File rlFile;
    private String rlBase64;
    private String rlResult;


    @Override
    public int getLayoutID() {
        return R.layout.activity_authen;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("身份认证");
    }

    @Override
    protected AuthenPresenter createPresenter() {
        return new AuthenPresenter();
    }

    @Override
    public void onLoadData(Object o) {

    }

    @Override
    public void onEmptyData() {

    }

    @Override
    public void onLoadError(String msg) {

    }

    @Override
    public void onNetError(String msg) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case SFFM:
                    zmFile = file;
                    Glide.with(this)
                            .load(zmFile)
                            .into(ivFm);
                    yasuo(zmFile, SFFM);
                    break;
                case SFZM:
                    fmFile = file;
                    Glide.with(this)
                            .load(fmFile)
                            .into(ivZm);
                    yasuo(fmFile, SFZM);
                    break;
                case RL:
                    rlFile = file;
                    Glide.with(this)
                            .load(rlFile)
                            .into(ivRl);
                    yasuo(rlFile, RL);
                    break;
                default:
                    break;
            }
        }
    }

    @OnClick({R.id.iv_rl, R.id.iv_zm, R.id.iv_fm, R.id.tv_save})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_rl:
                startCamara(RL);
                break;
            case R.id.iv_zm:
                startCamara(SFZM);
                break;
            case R.id.iv_fm:
                startCamara(SFFM);
                break;
            case R.id.tv_save:
                showLoadingDialog(false, false, "正在认证,请等待1-3分钟");
                getSFZZM();
                break;
            default:
                break;
        }
    }

    /**
     * 身份证正面信息
     */
    private void getSFZZM() {
        if (TextUtils.isEmpty(zmBase64)) {
            ToastUtils.showLongToast("请选择正面照片");
            cancelLoadingDialog();
            return;
        }

        if (TextUtils.isEmpty(fmBase64)) {
            ToastUtils.showLongToast("请选择反面照片");
            cancelLoadingDialog();
            return;
        }

        if (TextUtils.isEmpty(rlBase64)) {
            ToastUtils.showLongToast("请选择手持照片");
            cancelLoadingDialog();
            return;
        }

        Map<String, String> params = new HashMap<>();
        params.put("api_key", "pRe_Om0oHIwQhM1nnehJl4K8k8BUkbw_");
        params.put("api_secret", "eJx2DFcEB0kbS69BjIMDYfUqQuEZsJxZ");
        params.put("image_base64", zmBase64);
        params.put("legality", "1");


        OkGo.<String>post(Constants.FACE_PP_OCR)
                .tag(this)
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        L.e("身份证正面信息:" + response.body().toString());


                        SFZAuthBean sfzAuthBean = GsonUtils.jsonToObj(response.body().toString(), SFZAuthBean.class);

                        if (sfzAuthBean.getCards() == null || sfzAuthBean.getCards().size() == 0) {
                            ToastUtils.showLongToast("请重新上传正面身份证");
                            cancelLoadingDialog();
                            return;
                        }

                        zmResult = response.body().toString();
                        getSFZFM();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        cancelLoadingDialog();
                        ToastUtils.showShortToast("正面认证失败");
                        super.onError(response);
                    }
                });

    }

    /**
     * 身份证反面
     */
    private void getSFZFM() {
        Map<String, String> params = new HashMap<>();
        params.put("api_key", "pRe_Om0oHIwQhM1nnehJl4K8k8BUkbw_");
        params.put("api_secret", "eJx2DFcEB0kbS69BjIMDYfUqQuEZsJxZ");
        params.put("image_base64", fmBase64);
        params.put("legality", "1");

        OkGo.<String>post(Constants.FACE_PP_OCR)
                .tag(this)
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        L.e("身份证反面:" + response.body().toString());


                        SFZAuthBean sfzAuthBean = GsonUtils.jsonToObj(response.body().toString(), SFZAuthBean.class);

                        if (sfzAuthBean.getCards() == null || sfzAuthBean.getCards().size() == 0) {
                            ToastUtils.showLongToast("请重新上传反面身份证");
                            cancelLoadingDialog();
                            return;
                        }

                        fmResult = response.body().toString();
                        getCompara();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        cancelLoadingDialog();
                        ToastUtils.showShortToast("反面认证失败");
                        super.onError(response);
                    }
                });
    }

    /**
     * 对比结果
     */
    private void getCompara() {
        Map<String, String> params = new HashMap<>();
        params.put("api_key", "pRe_Om0oHIwQhM1nnehJl4K8k8BUkbw_");
        params.put("api_secret", "eJx2DFcEB0kbS69BjIMDYfUqQuEZsJxZ");
        params.put("image_base64_1", zmBase64);
        params.put("image_base64_2", rlBase64);


        OkGo.<String>post(Constants.FACE_PP_C)
                .tag(this)
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        L.e("对比结果:" + response.body().toString());

                        try {
                            FacePPComparaResultBean bean = GsonUtils.jsonToObj(response.body(), FacePPComparaResultBean.class);
                            if (bean != null) {
                                rlResult = response.body().toString();
                                if (bean.getConfidence() > 70) {
                                    uploadAll();
                                } else {
                                    cancelLoadingDialog();
                                    ToastUtils.showLongToast("匹配度"+bean.getConfidence()+" 身份证正面和面部照片不匹配");
                                }

                            } else {
                                cancelLoadingDialog();
                                ToastUtils.showShortToast("认证失败");
                            }


                        } catch (Exception e) {
                            cancelLoadingDialog();
                            ToastUtils.showShortToast("认证失败");
                        }

                    }

                    @Override
                    public void onError(Response<String> response) {
                        cancelLoadingDialog();
                        ToastUtils.showShortToast("请求失败");
                        super.onError(response);
                    }
                });
    }


    public void uploadAll() {

        String userId = getIntent().getStringExtra("userId");

        Map<String, String> params = new HashMap<>();
        params.put("compareResult", rlResult);
        params.put("userid", TextUtils.isEmpty(userId) ? "" : userId);
        params.put("imgs", getImgJson());

        OkGo.<String>post(Constants.UPLOAD_AUTH)
                .tag(this)
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String result = response.body().toString();

                        AuthResultBean authResultBean = GsonUtils.jsonToObj(result, AuthResultBean.class);
                        if (authResultBean.getFh() == 1) {
                            ToastUtils.showShortToast("提交成功");
                            cancelLoadingDialog();

                            RxBus.postEvent(new JumpEvent(Constants.UPLOAD_AUTH_SUCCESS_REDIRECTION), JumpEvent.class);
                            finish();
                        } else {
                            cancelLoadingDialog();
                            ToastUtils.showShortToast(authResultBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        cancelLoadingDialog();
                        ToastUtils.showShortToast("请求失败");
                        super.onError(response);
                    }
                });

    }

    private String getImgJson() {
        List<AuthUploadBean> beans = new ArrayList<>();
        beans.add(new AuthUploadBean("1", zmBase64, zmResult));
        beans.add(new AuthUploadBean("2", fmBase64, fmResult));
        beans.add(new AuthUploadBean("3", rlBase64, "人脸照片没有详细信息"));

        return GsonUtils.listToJson(beans);
    }

    private File file;

    public void startCamara(int type) {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.CAMERA)
                .subscribe(aBoolean -> {
                    if (aBoolean) {


                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                        file = new File(utils.getCacheDirectory(Utils.getContext(), true).getAbsolutePath()
                                + "/img/" + System.currentTimeMillis() + ".jpg");
                        file.getParentFile().mkdirs();
                        Uri uri = FileProvider.getUriForFile(AuthenActivity.this, "com.hzecool.common.fileProvider", file);

                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                        startActivityForResult(intent, type);
                    } else {
                        ToastUtils.showShortToast("没有照相机权限");
                    }
                });
    }


    public void yasuo(File filePa, int type) {
        Luban.get(this)
                .load(filePa)
                .setMaxSize(1000)
                .setMaxHeight(1920)
                .setMaxWidth(1080)
                .putGear(Luban.CUSTOM_GEAR)
                .asObservable()
                .subscribe(file -> {
                    Log.i("TAG", file.getAbsolutePath());

                    switch (type) {
                        case SFZM:
                            zmBase64 = getBitmapBase64(file.getAbsolutePath());
                            break;
                        case SFFM:
                            fmBase64 = getBitmapBase64(file.getAbsolutePath());
                            break;
                        case RL:
                            rlBase64 = getBitmapBase64(file.getAbsolutePath());
                            break;
                        default:
                            break;
                    }

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
}
