package com.tutu.tallybook.detail;

import com.hzecool.core.base.TBasePresenter;
import com.hzecool.core.rxbus.RxBus;
import com.hzecool.db.bean.TallyRecode;
import com.tutu.tallybook.bean.DataBaseChangeEvent;
import com.tutu.tallybook.data.DataProvider;

import java.util.List;

/**
 * Created by tu on 2017/12/17.
 */

public class DetailPresenter extends TBasePresenter<IDetailView> {
    @Override
    protected void start() {
        queryAll();
        addEvent();
    }

    private void queryAll() {
        List<TallyRecode> data = DataProvider.queryAll();
        getView().onLoadData(data);
    }

    private void addEvent() {
        mSubscriptionList.add(
                RxBus.obtainEvent(DataBaseChangeEvent.class)
                        .subscribe(dataBaseChangeEvent -> {
                            if (dataBaseChangeEvent.getType() == 1) {
                                List<TallyRecode> data = DataProvider.queryAll();
                                loadData(data);
                            }
                        })
        );
    }

    private void loadData(List<TallyRecode> data) {
//        List<DetailBean> viewData = new ArrayList<>();
//
//        for (int i = 0; i < data.size(); i++) {
//            TallyRecode tallyRecode = data.get(i);
//            if (i==0){
//                DetailBean detailBean = new DetailBean();
//                detailBean.setDate(TimeUtils.getYYMMDDWString(tallyRecode.getDate()));
//                detailBean.getDataList().add(tallyRecode);
//                viewData.add(detailBean);
//            }else {
//                if (viewData.get(viewData.size()-1).getDate().equals(TimeUtils.getYYMMDDWString(tallyRecode.getDate()))){
//                    viewData.get(viewData.size()-1).getDataList().add(tallyRecode);
//                }else {
//                    DetailBean detailBean = new DetailBean();
//                    detailBean.setDate(TimeUtils.getYYMMDDWString(tallyRecode.getDate()));
//                    detailBean.getDataList().add(tallyRecode);
//                    viewData.add(detailBean);
//                }
//            }
//        }

        getView().onLoadData(data);
    }
}
