package com.tutu.tallybook.tally;

import com.hzecool.core.base.TBasePresenter;
import com.tutu.tallybook.bean.BillTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tu on 2017/12/17.
 */

public class TallyPresenter extends TBasePresenter<ITallyView> {
    @Override
    protected void start() {

    }

    public List getData() {
        List data = new ArrayList();
        for (int i = 0; i < 50; i++) {
            BillTypeBean billTypeBean = new BillTypeBean();
            billTypeBean.setId(i);
            billTypeBean.setName("类型" + i);
            billTypeBean.setResId(i + "");
            data.add(billTypeBean);
        }

        return data;
    }
}
