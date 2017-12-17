package com.tutu.tallybook.my;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseFragment;
import com.tutu.tallybook.R;

/**
 * Created by tu on 2017/12/17.
 */

public class MyFragment extends TBaseFragment<IMyView, MyPresenter>
        implements IMyView {

    private static final String ARG_C = "content";

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
}
