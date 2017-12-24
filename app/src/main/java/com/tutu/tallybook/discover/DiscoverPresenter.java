package com.tutu.tallybook.discover;

import com.hzecool.common.utils.TimeUtils;
import com.hzecool.core.base.TBasePresenter;
import com.hzecool.core.rxbus.RxBus;
import com.hzecool.db.bean.TallyRecode;
import com.tutu.tallybook.bean.DataBaseChangeEvent;
import com.tutu.tallybook.data.DataProvider;

import java.util.Calendar;
import java.util.List;

/**
 * Created by tu on 2017/12/17.
 */

public class DiscoverPresenter extends TBasePresenter<IDiscoverView> {
    @Override
    protected void start() {
        addEvent();
        loadData();
    }

    private void loadData() {
        List<TallyRecode> data = DataProvider.queryByDate(
                TimeUtils.getFirstDayOfMonth(Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH)+1),
                TimeUtils.getLastDayOfMonth(Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH)+1));
        getView().onLoadData(data);
    }

    private void addEvent() {
        mSubscriptionList.add(
                RxBus.obtainEvent(DataBaseChangeEvent.class)
                        .subscribe(dataBaseChangeEvent -> {
                            if (dataBaseChangeEvent.getType() == 1) {
                                loadData();
                            }
                        })
        );
    }
}
