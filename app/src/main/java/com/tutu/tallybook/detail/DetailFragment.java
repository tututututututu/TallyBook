package com.tutu.tallybook.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.common.utils.SizeUtils;
import com.hzecool.core.base.TBaseFragment;
import com.hzecool.db.bean.TallyRecode;
import com.tutu.tallybook.R;
import com.tutu.tallybook.detail.item.ItemDetailActivity;
import com.tutu.tallybook.view.YearMonthDatePickerDialog;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tu on 2017/12/17.
 */

public class DetailFragment extends TBaseFragment<IDetailView, DetailPresenter>
        implements IDetailView {

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
    @BindView(R.id.tv_year)
    TextView tvYear;
    @BindView(R.id.tv_month)
    TextView tvMonth;
    @BindView(R.id.ll_time)
    LinearLayout llTime;
    @BindView(R.id.divider)
    View divider;
    @BindView(R.id.tv_income)
    TextView tvIncome;
    @BindView(R.id.tv_expend)
    TextView tvExpend;
    @BindView(R.id.rv)
    RecyclerView rv;
    private DetailAdapter adapter;
    private YearMonthDatePickerDialog yearMonthDatePickerDialog;

    public static DetailFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_C, content);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onLoadData(Object o) {
        adapter.setNewData((List<TallyRecode>) o);

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

        tvIncome.setText(inCome + "");
        tvExpend.setText(outPut + "");
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
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new DetailAdapter(null);
        rv.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), ItemDetailActivity.class);
                intent.putExtra("item",(TallyRecode)adapter.getData().get(position));
                startActivity(intent);
            }
        });

        yearMonthDatePickerDialog = new YearMonthDatePickerDialog(getActivity()
                , (view1, year, month, dayOfMonth) -> {

            tvYear.setText(year + "");
            tvMonth.setText(month + 1 + "");
            yearMonthDatePickerDialog.dismiss();
            mPresenter.getDateData(year, month + 1);
        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH)
                , Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
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

    @OnClick({R.id.ll_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_time:
                yearMonthDatePickerDialog.show();
                break;
        }
    }
}
