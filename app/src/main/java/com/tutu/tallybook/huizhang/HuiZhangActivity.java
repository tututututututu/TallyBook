package com.tutu.tallybook.huizhang;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hzecool.core.base.TBaseActivity;
import com.tutu.tallybook.R;

import butterknife.BindView;

public class HuiZhangActivity extends TBaseActivity<IHuiZhangView, HuiZhangPresenter> {

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
    @BindView(R.id.rv_daka)
    RecyclerView rvDaka;
    @BindView(R.id.rv_jizhang)
    RecyclerView rvJizhang;

    @Override
    public int getLayoutID() {
        return R.layout.activity_hui_zhang;
    }

    @Override
    public void initView() {
        rvDaka.setLayoutManager(new GridLayoutManager(this, 3));
        BaseQuickAdapter adapter = new HuiZhangAdapter(mPresenter.getDakaList());
        rvDaka.setAdapter(adapter);

        rvJizhang.setLayoutManager(new GridLayoutManager(this, 3));
        BaseQuickAdapter adapter1 = new HuiZhangAdapter(mPresenter.getJiZhangList());
        rvJizhang.setAdapter(adapter1);
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {
        titleName.setText("徽章");
    }

    @Override
    protected HuiZhangPresenter createPresenter() {
        return new HuiZhangPresenter();
    }
}
