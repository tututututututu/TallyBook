package com.tutu.tallybook.discover;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseFragment;
import com.tutu.tallybook.R;

/**
 * Created by tu on 2017/12/17.
 */

public class DiscoverFragment extends TBaseFragment<IDiscoverView, DiscoverPresenter>
        implements IDiscoverView {

    private static final String ARG_C = "content";

    public static DiscoverFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_C, content);
        DiscoverFragment fragment = new DiscoverFragment();
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
}
