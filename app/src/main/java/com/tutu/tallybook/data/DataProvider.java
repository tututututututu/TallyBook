package com.tutu.tallybook.data;

import com.hzecool.core.rxbus.RxBus;
import com.hzecool.db.bean.TallyRecode;
import com.hzecool.db.bean.TallyRecodeDao;
import com.hzecool.db.manager.DaoManager;
import com.tutu.tallybook.bean.DataBaseChangeEvent;

import java.util.Date;
import java.util.List;

/**
 * Created by tu on 2017/12/21.
 */

public class DataProvider {
    public static void add(TallyRecode tallyRecode) {
        DaoManager.getDaoInstant().getTallyRecodeDao()
                .insertOrReplaceInTx(tallyRecode);

        RxBus.postEvent(new DataBaseChangeEvent(1),DataBaseChangeEvent.class);
    }

    public static void delete(TallyRecode tallyRecode) {
        DaoManager.getDaoInstant().getTallyRecodeDao()
                .delete(tallyRecode);
        RxBus.postEvent(new DataBaseChangeEvent(2),DataBaseChangeEvent.class);
    }

    public static void update(TallyRecode tallyRecode){
        DaoManager.getDaoInstant().getTallyRecodeDao()
                .update(tallyRecode);
        RxBus.postEvent(new DataBaseChangeEvent(3),DataBaseChangeEvent.class);
    }

    public static List<TallyRecode> queryAll(){
        RxBus.postEvent(new DataBaseChangeEvent(4),DataBaseChangeEvent.class);
       return DaoManager.getDaoInstant().getTallyRecodeDao()
                .queryBuilder()
                .orderDesc(TallyRecodeDao.Properties.Date)
                .list();
    }


    public static List<TallyRecode> queryByDate(Date start,Date end){
        RxBus.postEvent(new DataBaseChangeEvent(4),DataBaseChangeEvent.class);
        return DaoManager.getDaoInstant().getTallyRecodeDao()
                .queryBuilder()
                .where(TallyRecodeDao.Properties.Date.gt(start))
                .where(TallyRecodeDao.Properties.Date.lt(end))
                .orderDesc(TallyRecodeDao.Properties.Date)
                .list();
    }


}
