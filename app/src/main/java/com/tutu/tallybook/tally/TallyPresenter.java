package com.tutu.tallybook.tally;

import com.hzecool.core.base.TBasePresenter;
import com.tutu.tallybook.bean.BillTypeBean;
import com.tutu.tallybook.data.Constans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tu on 2017/12/17.
 */

public class TallyPresenter extends TBasePresenter<ITallyView> {
    @Override
    protected void start() {

    }

    public List getData(boolean inCome) {
        List data = new ArrayList();
        for (int i = 1; i < 41; i++) {
            BillTypeBean billTypeBean = new BillTypeBean();
            billTypeBean.setId(i);
            billTypeBean.setName(Constans.getResource(i).getName());
            billTypeBean.setResId(Constans.getResource(i).getResId());
            if (inCome) {
                if (Constans.getResource(i).isInCome()) {
                    data.add(billTypeBean);
                }
            } else {
                if (!Constans.getResource(i).isInCome()) {
                    data.add(billTypeBean);
                }
            }
        }

        return data;
    }
}
