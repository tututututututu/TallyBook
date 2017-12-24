package com.tutu.tallybook.chart;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.hzecool.core.base.TBaseFragment;
import com.hzecool.db.bean.TallyRecode;
import com.hzecool.widget.materialdialog.MaterialDialog;
import com.tutu.tallybook.R;
import com.tutu.tallybook.view.DayAxisValueFormatter;
import com.tutu.tallybook.view.MyAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tu on 2017/12/17.
 */

public class ChartFragment extends TBaseFragment<IChartView, ChartPresenter>
        implements IChartView {

    private static final String ARG_C = "content";
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_top)
    LinearLayout llTop;
    @BindView(R.id.tl)
    TabLayout tl;
    @BindView(R.id.chart)
    BarChart mChart;
    @BindView(R.id.rv)
    RecyclerView rv;


    private boolean inCome = false;
    private int timeType = 1;
    private RangAdapter adapter;

    public static ChartFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_C, content);
        ChartFragment fragment = new ChartFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onLoadData(Object o) {
        adapter.setNewData((List<TallyRecode>) o);
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
        return R.layout.chart_fragment;
    }

    @Override
    public void initView() {
        tl.addTab(tl.newTab().setText("周"));
        tl.addTab(tl.newTab().setText("月"));
        tl.addTab(tl.newTab().setText("年"));
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                timeType = tab.getPosition() + 1;
                mPresenter.queryData();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        initChart();

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RangAdapter(null);
        rv.setAdapter(adapter);
    }

    private void initChart() {
        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);
        mChart.getDescription().setEnabled(false);
        //mChart.setMaxVisibleValueCount(31);
        mChart.setPinchZoom(false);
        mChart.setDragEnabled(true);
        mChart.setDrawGridBackground(false);
        IAxisValueFormatter xAxisFormatter = new DayAxisValueFormatter(mChart);
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(3);
        xAxis.setValueFormatter(xAxisFormatter);
        xAxis.setEnabled(false);
        IAxisValueFormatter custom = new MyAxisValueFormatter();
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f);
        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setEnabled(false);
        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);

        Matrix m = new Matrix();
        m.postScale(1.1f, 1f);//两个参数分别是x,y轴的缩放比例。例如：将x轴的数据放大为之前的1.5倍
        mChart.getViewPortHandler().refresh(m, mChart, false);//将图表动画显示之前进行缩放
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected ChartPresenter createPresenter() {
        return new ChartPresenter();
    }

    @OnClick({R.id.ll_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_top:
                showTypeChoice();
                break;
        }
    }


    private void showTypeChoice() {
        List<String> typeList = new ArrayList<>();
        typeList.add("支出");
        typeList.add("收入");
        new MaterialDialog.Builder(getActivity())
                .title("选择类型")
                .items(typeList)
                .itemsCallbackSingleChoice(inCome ? 1 : 0, (dialog, view, which, text) -> {
                    tvName.setText(typeList.get(which));
                    changeAdapterData(which);
                    if (which == 0) {
                        inCome = false;
                    } else {
                        inCome = true;
                    }

                    mPresenter.queryData();
                    return true;
                })
                .positiveText("确定")
                .show();
    }

    private void changeAdapterData(int which) {

    }


    private void setData(List<TallyRecode> list) {

        float start = 1f;

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        for (int i = 0; i < list.size(); i++) {
            TallyRecode tallyRecode = list.get(i);

            yVals1.add(new BarEntry(i, Float.valueOf(tallyRecode.getMoney() + "")));
        }

        BarDataSet set1;

        StringBuilder sb = new StringBuilder();
        sb.append("当前");

        if (timeType==1){
            sb.append("周");
        }else if (timeType==2){
            sb.append("月");
        }else if (timeType==2){
            sb.append("年");
        }

        if (inCome){
            sb.append("收入");
        }else {
            sb.append("支出");
        }
        sb.append("趋势");

        set1 = new BarDataSet(yVals1, sb.toString());

        set1.setDrawIcons(false);

        set1.setColors(ColorTemplate.MATERIAL_COLORS);

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        BarData data = new BarData(dataSets);
        data.setValueTextSize(10f);
        data.setBarWidth(0.9f);

        mChart.setData(data);
        mChart.animateY(2000);
    }

    @Override
    public int getTimeType() {
        return timeType;
    }

    @Override
    public boolean isIncome() {
        return inCome;
    }

    @Override
    public void onLoadChart(Object o) {
        setData((List<TallyRecode>) o);
    }
}
