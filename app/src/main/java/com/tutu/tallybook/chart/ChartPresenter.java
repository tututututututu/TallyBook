package com.tutu.tallybook.chart;

import com.hzecool.common.utils.TimeUtils;
import com.hzecool.core.base.TBasePresenter;
import com.hzecool.core.rxbus.RxBus;
import com.hzecool.db.bean.TallyRecode;
import com.tutu.tallybook.bean.DataBaseChangeEvent;
import com.tutu.tallybook.data.DataProvider;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by tu on 2017/12/17.
 */

public class ChartPresenter extends TBasePresenter<IChartView> {
    @Override
    protected void start() {
        queryData();
        addEvent();
    }

    public void queryData() {
        Date start = new Date();
        Date end = new Date();
        switch (getView().getTimeType()) {
            case 1:
                start = TimeUtils.getFirstDateOfWeek();
                end = TimeUtils.getLastDateOfWeek();
                break;
            case 2:
                start = TimeUtils.getFirstDayOfMonth(Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH) + 1);
                end = TimeUtils.getLastDayOfMonth(Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH) + 1);
                break;
            case 3:
                start = TimeUtils.getFirstDayOfMonth(Calendar.getInstance().get(Calendar.YEAR),
                        1);
                end = TimeUtils.getLastDayOfMonth(Calendar.getInstance().get(Calendar.YEAR),
                        12);
                break;
        }

        List<TallyRecode> data = DataProvider.queryByDateIncome(start, end, getView().isIncome());
        getView().onLoadChart(data);

        List<TallyRecode> data1 = DataProvider.queryByDateIncomeOrderMoney(start, end, getView().isIncome());
        getView().onLoadData(data1);
    }

    private void addEvent() {
        mSubscriptionList.add(
                RxBus.obtainEvent(DataBaseChangeEvent.class)
                        .subscribe(dataBaseChangeEvent -> {
                            if (dataBaseChangeEvent.getType() == 1) {
                                queryData();
                            }
                        })
        );
    }
}
