package com.tutu.tallybook.discover;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hzecool.core.activity.webview.JsBridgeWebViewActivity;
import com.hzecool.core.base.TBaseFragment;
import com.hzecool.db.bean.TallyRecode;
import com.tutu.tallybook.R;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by tu on 2017/12/17.
 */

public class DiscoverFragment extends TBaseFragment<IDiscoverView, DiscoverPresenter>
        implements IDiscoverView {

    private static final String ARG_C = "content";
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
    @BindView(R.id.tv_month)
    TextView tvMonth;
    @BindView(R.id.tv_shouru)
    TextView tvShouru;
    @BindView(R.id.tv_zhichu)
    TextView tvZhichu;
    @BindView(R.id.tv_jieyu)
    TextView tvJieyu;
    Unbinder unbinder;
    @BindView(R.id.ll_1)
    LinearLayout ll1;
    @BindView(R.id.ll_2)
    LinearLayout ll2;
    @BindView(R.id.ll_3)
    LinearLayout ll3;
    @BindView(R.id.ll_4)
    LinearLayout ll4;
    Unbinder unbinder1;

    public static DiscoverFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_C, content);
        DiscoverFragment fragment = new DiscoverFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onLoadData(Object o) {
        computOther((List<TallyRecode>) o);
    }

    private void computOther(List<TallyRecode> data) {
        double inCome = 0;
        double outPut = 0;

        for (TallyRecode datum : data) {
            if (datum.getIsInCome()) {
                inCome += datum.getMoney();
            } else {
                outPut += datum.getMoney();
            }
        }

        tvShouru.setText(inCome + "");
        tvZhichu.setText(outPut + "");
        tvJieyu.setText((inCome - outPut) + "");
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
        return R.layout.discover_fragment;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        llBack.setVisibility(View.GONE);
        titleName.setText("发现");
    }

    @Override
    protected DiscoverPresenter createPresenter() {
        return new DiscoverPresenter();
    }

    @OnClick({R.id.ll_1, R.id.ll_2, R.id.ll_3, R.id.ll_4})
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), JsBridgeWebViewActivity.class);
        switch (v.getId()) {
            case R.id.ll_1:
                intent.putExtra("url","http://2.zol.com.cn/");
                intent.putExtra("title","二手交易");
                break;
            case R.id.ll_2:
                intent.putExtra("url","http://2.zol.com.cn/");
                intent.putExtra("title","养车");
                break;
            case R.id.ll_3:
                intent.putExtra("url","http://2.zol.com.cn/");
                intent.putExtra("title","房产");
                break;
            case R.id.ll_4:
                intent.putExtra("url","http://2.zol.com.cn/");
                intent.putExtra("title","维修");
                break;
        }

        startActivity(intent);
    }
}
