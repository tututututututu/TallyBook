package com.tutu.tallybook.tally;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hzecool.core.base.TBaseActivity;
import com.tutu.tallybook.R;

import butterknife.BindView;

/**
 * Created by tu on 2017/12/17.
 */

public class TallyActivity extends TBaseActivity<ITallyView, TallyPresenter>
        implements ITallyView {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_top)
    LinearLayout llTop;
    @BindView(R.id.rv)
    RecyclerView rv;


    private boolean inCome = false;
    private BaseQuickAdapter adapter;

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
        return R.layout.tally_activity;
    }

    @Override
    public void initView() {
        rv.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new TypeAdapter(mPresenter.getData(inCome));
        rv.setAdapter(adapter);

        adapter.setOnItemClickListener((adapter, view, position) -> {

        });
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected TallyPresenter createPresenter() {
        return new TallyPresenter();
    }



}
