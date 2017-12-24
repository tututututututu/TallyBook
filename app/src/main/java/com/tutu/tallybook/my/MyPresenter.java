package com.tutu.tallybook.my;

import com.hzecool.common.utils.TimeUtils;
import com.hzecool.core.base.TBasePresenter;
import com.hzecool.core.rxbus.RxBus;
import com.hzecool.db.bean.TallyRecode;
import com.tutu.tallybook.bean.DataBaseChangeEvent;
import com.tutu.tallybook.data.DataProvider;

import java.util.List;

/**
 * Created by tu on 2017/12/17.
 */

public class MyPresenter extends TBasePresenter<IMyView> {
    @Override
    protected void start() {
        query();
        addEvent();
    }

    private void query() {
        long count = DataProvider.queryCount();
        getView().setCount(count);

        List<TallyRecode> list = DataProvider.queryAll();
        int dateCount = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                dateCount += 1;
            } else {
                if (!TimeUtils.getYYMMDDString(list.get(i).getDate())
                        .equals(TimeUtils.getYYMMDDString(list.get(i - 1).getDate()))) {
                    dateCount += 1;
                }
            }
        }

        getView().setDayCount(dateCount);
    }

    private void addEvent() {
        mSubscriptionList.add(
                RxBus.obtainEvent(DataBaseChangeEvent.class)
                        .subscribe(dataBaseChangeEvent -> {
                            if (dataBaseChangeEvent.getType() == 1) {
                                query();
                            }
                        })
        );
    }
}
