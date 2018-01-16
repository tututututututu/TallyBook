package com.tutu.tallybook.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.hzecool.common.json.GsonUtils;
import com.hzecool.common.utils.AppUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tutu.tallybook.R;
import com.tutu.tallybook.bean.ShowTypeBean;
import com.tutu.tallybook.main.MainActivity;
import com.tutu.tallybook.web.Constants;
import com.tutu.tallybook.web.WebMainActivity;

/**
 * @author yksoft
 */
public class FlashActivity extends AppCompatActivity {
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        iv = findViewById(R.id.iv_img);


        OkGo.<String>post(Constants.STATUS_JUDGE_URL)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("tag", response.body());

                        ShowTypeBean bean = GsonUtils.jsonToObj(response.body(), ShowTypeBean.class);

                        if (bean.getIosversion().getVersion().equals(AppUtils.getAppVersionName()) && bean.getIosversion().getStruts().equals("0")) {
                            /**
                             * 显示网页
                             */
                            iv.postDelayed(() -> jumpWeb(), 2000);
                        } else {
                            /**
                             * 显示原生
                             */
                            iv.postDelayed(() -> jumpNative(), 2000);
                        }
                    }
                });
    }


    private void jumpWeb() {
        Intent intent = new Intent(FlashActivity.this, WebMainActivity.class);
        startActivity(intent);
        finish();
    }

    private void jumpNative() {
        Intent intent = new Intent(FlashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
