package com.tutu.tallybook.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.common.utils.SizeUtils;
import com.hzecool.core.base.TBaseFragment;
import com.tutu.tallybook.R;

/**
 * Created by tu on 2017/12/17.
 */

public class DetailFragment extends TBaseFragment<IDetailView, DetailPresenter>
        implements IDetailView {

    private static final String ARG_C = "content";

    public static DetailFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_C, content);
        DetailFragment fragment = new DetailFragment();
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
        return R.layout.detail_fragment;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        llBack.setVisibility(View.GONE);
        tvMenu.setVisibility(View.GONE);
        titleName.setText(ResourceUtils.getString(R.string.app_name));
        titleName.setTextSize(SizeUtils.sp2px(10));
    }

    @Override
    protected DetailPresenter createPresenter() {
        return new DetailPresenter();
    }
}
