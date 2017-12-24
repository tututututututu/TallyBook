package com.tutu.tallybook.chart;

import com.hzecool.core.base.TIBaseView;

/**
 * Created by tu on 2017/12/17.
 */

public interface IChartView extends TIBaseView{
    int getTimeType();
    boolean isIncome();
    void onLoadChart(Object o);
}
