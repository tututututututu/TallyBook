package com.tutu.tallybook.tally;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.core.base.TBaseFragment;
import com.tutu.tallybook.R;

/**
 * Created by tu on 2017/12/17.
 */

public class TallyFragment extends TBaseFragment<ITallyView, TallyPresenter>
        implements ITallyView {

    private static final String ARG_C = "content";

    public static TallyFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_C, content);
        TallyFragment fragment = new TallyFragment();
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
        return R.layout.tally_fragment;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected TallyPresenter createPresenter() {
        return new TallyPresenter();
    }
}
