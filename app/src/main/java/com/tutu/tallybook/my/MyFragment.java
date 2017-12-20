package com.tutu.tallybook.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hzecool.common.utils.AppUtils;
import com.hzecool.common.utils.HandlerUtil;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBaseActivity;
import com.hzecool.core.base.TBaseFragment;
import com.makeramen.roundedimageview.RoundedImageView;
import com.tutu.tallybook.R;
import com.tutu.tallybook.huizhang.HuiZhangActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tu on 2017/12/17.
 */

public class MyFragment extends TBaseFragment<IMyView, MyPresenter>
        implements IMyView {

    private static final String ARG_C = "content";
    @BindView(R.id.iv_touxiang)
    RoundedImageView ivTouxiang;
    @BindView(R.id.tv_daka_count)
    TextView tvDakaCount;
    @BindView(R.id.tv_bi_count)
    TextView tvBiCount;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.tv_arr)
    ImageView tvArr;
    @BindView(R.id.rl_huizhang)
    RelativeLayout rlHuizhang;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.rl_qinglihuancun)
    RelativeLayout rlQinglihuancun;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.rl_fenxiang)
    RelativeLayout rlFenxiang;
    @BindView(R.id.iv4)
    ImageView iv4;
    @BindView(R.id.rl_fankui)
    RelativeLayout rlFankui;
    @BindView(R.id.tv_daka)
    TextView tvDaka;


    public static MyFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_C, content);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
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
    public int getLayoutID() {
        return R.layout.my_fragment;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter();
    }

    @OnClick({R.id.tv_daka, R.id.rl_huizhang, R.id.rl_qinglihuancun, R.id.rl_fankui, R.id.rl_fenxiang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_daka:
                tvDaka.setText("已打卡");
                tvDakaCount.setText("1");
                break;
            case R.id.rl_huizhang:
                Intent intent = new Intent(getActivity(), HuiZhangActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_fenxiang:
                Intent textIntent = new Intent(Intent.ACTION_SEND);
                textIntent.setType("text/plain");
                textIntent.putExtra(Intent.EXTRA_TEXT, "快来使用<" +
                        AppUtils.getAppName(getActivity().getApplicationContext()) + "吧");
                startActivity(Intent.createChooser(textIntent, "分享"));
                break;
            case R.id.rl_qinglihuancun:
                ((TBaseActivity) getActivity()).showLoadingDialog(false, false, "正在清理");
                HandlerUtil.postDelay(() -> {
                    ((TBaseActivity) getActivity()).cancelLoadingDialog();
                    ToastUtils.showShortToast("清理成功");
                }, 1500);
                break;
            case R.id.rl_fankui:
                break;
        }
    }
}
