package com.tutu.tallybook.web;

import android.Manifest;
import android.app.Activity;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.hzecool.common.utils.SPUtils;
import com.hzecool.common.utils.Utils;
import com.hzecool.core.rxbus.RxBus;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.tutu.tallybook.web.beana.CameraEvent;
import com.tutu.tallybook.web.beana.JumpEvent;
import com.tutu.tallybook.web.contact.ContactGetHelper;

import java.util.HashMap;
import java.util.Map;

import rx.functions.Action1;

/**
 * @author 47066
 * @date 2017/9/6
 * 18535703424
 * a5201314
 */

public class JavaScriptInterface {
    private Activity context;
    private int count = 1;


    public JavaScriptInterface(Activity context) {
        this.context = context;
    }

    @JavascriptInterface
    public void upLoadAddressBook(final String card) {
        HandlerUtil.post(new Runnable() {
            @Override
            public void run() {
                requestPermissionContact(card);
            }
        });
    }

    @JavascriptInterface
    public void onUploadLocation(final String card) {
        count = 1;
        HandlerUtil.post(new Runnable() {
            @Override
            public void run() {
                requestPermissionLocation(card);
            }
        });
    }

    @JavascriptInterface
    public void onGetPicReq(String type) {
        RxBus.postEvent(new CameraEvent(type), CameraEvent.class);
    }


    private void requestPermissionLocation(final String card) {
        RxPermissions rxPermissions = new RxPermissions(context);

        rxPermissions.request(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {
                            requestLocation(card);
                        } else {
                            Toast.makeText(Utils.getContext(), "没有获取到需要的权限", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void requestPermissionContact(final String card) {
        RxPermissions rxPermissions = new RxPermissions(context);

        rxPermissions.request(
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {
                            requestContacts(card);
                        } else {
                            Toast.makeText(Utils.getContext(), "没有获取到需要的权限", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void requestContacts(String card) {
        if (TextUtils.isEmpty(card)) {
            Toast.makeText(Utils.getContext(), "上传失败", Toast.LENGTH_SHORT).show();
            return;
        }


        Map<String, String> params = new HashMap<>();
        params.put("card", card);
        params.put("datas", GsonUtils.listToJson(new ContactGetHelper().getContacts(Utils.getContext())));


        OkGo.<String>post(Constants.UPLOAD_CONTACTS_URL)
                .tag(this)
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        ResponBean responBean = GsonUtils.jsonToObj(response.body().toString(), ResponBean.class);
                        if (responBean != null && "3".equals(responBean.getStruts())) {
                            Toast.makeText(Utils.getContext(), "上传成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Utils.getContext(), "上传失败", Toast.LENGTH_LONG).show();
                        }

                        RxBus.postEvent(new JumpEvent(Constants.UPLOAD_SUCCESS_URL), JumpEvent.class);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });

    }

    private void requestLocation(final String card) {
        String lng = SPUtils.getString(Constants.LNG);
        String lat = SPUtils.getString(Constants.LAT);

        if ("4.9E-324".equals(lng) || "4.9E-324".equals(lat)) {
            Toast.makeText(Utils.getContext(), "正在定位", Toast.LENGTH_SHORT).show();
            retry(card);
            return;
        }

        if (TextUtils.isEmpty(lng) ||
                TextUtils.isEmpty(lat)) {
            Toast.makeText(Utils.getContext(), "定位失败", Toast.LENGTH_SHORT).show();
            return;
        }


        Map<String, String> params = new HashMap<>();
        params.put("card", card);
        params.put("lng", lng);  //经度
        params.put("lat", lat);  //纬度

//        Toast.makeText(App.app, "lat=" + lat + " lng=" + lng, Toast.LENGTH_SHORT).show();

//        latitude : 4.9E-324
//        lontitude : 4.9E-324
//        params.put("lng", "120.423");  //经度
//        params.put("lat", "65.432");  //纬度


        OkGo.<String>post(Constants.UPLOAD_LOCATION_URL)
                .tag(this)
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        LocationRes responBean = GsonUtils.jsonToObj(response.body().toString(), LocationRes.class);
                        if (responBean != null && "0".equals(responBean.getCode())) {
                            Toast.makeText(Utils.getContext(), "上传成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Utils.getContext(), "上传失败", Toast.LENGTH_LONG).show();
                        }
                        RxBus.postEvent(new JumpEvent(Constants.UPLOAD_SUCCESS_URL), JumpEvent.class);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });

    }

    private void retry(final String card) {
        HandlerUtil.postDelay(new Runnable() {
            @Override
            public void run() {
                requestLocation(card);
                count++;
            }
        }, 3000);
    }

}
