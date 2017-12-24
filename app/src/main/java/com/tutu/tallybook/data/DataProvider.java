package com.tutu.tallybook.data;

import com.hzecool.core.log.L;
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

        RxBus.postEvent(new DataBaseChangeEvent(1), DataBaseChangeEvent.class);
    }

    public static void delete(TallyRecode tallyRecode) {
        DaoManager.getDaoInstant().getTallyRecodeDao()
                .delete(tallyRecode);
        RxBus.postEvent(new DataBaseChangeEvent(1), DataBaseChangeEvent.class);
    }

    public static void update(TallyRecode tallyRecode) {
        DaoManager.getDaoInstant().getTallyRecodeDao()
                .update(tallyRecode);
    }

    public static List<TallyRecode> queryAll() {
        List<TallyRecode> data = DaoManager.getDaoInstant().getTallyRecodeDao()
                .queryBuilder()
                .orderDesc(TallyRecodeDao.Properties.Date)
                .list();

        L.i(data.toString());
        return data;
    }


    public static List<TallyRecode> queryByDate(Date start, Date end) {
        return DaoManager.getDaoInstant().getTallyRecodeDao()
                .queryBuilder()
                .where(TallyRecodeDao.Properties.Date.gt(start))
                .where(TallyRecodeDao.Properties.Date.lt(end))
                .orderDesc(TallyRecodeDao.Properties.Date)
                .list();
    }

    public static List<TallyRecode> queryByDateIncomeOrderMoney(Date start, Date end,boolean isIncome) {
        return DaoManager.getDaoInstant().getTallyRecodeDao()
                .queryBuilder()
                .where(TallyRecodeDao.Properties.Date.gt(start))
                .where(TallyRecodeDao.Properties.Date.lt(end))
                .where(TallyRecodeDao.Properties.IsInCome.eq(isIncome))
                .orderDesc(TallyRecodeDao.Properties.Money)
                .list();
    }

    public static List<TallyRecode> queryByDateIncome(Date start, Date end,boolean isIncome) {
        return DaoManager.getDaoInstant().getTallyRecodeDao()
                .queryBuilder()
                .where(TallyRecodeDao.Properties.Date.gt(start))
                .where(TallyRecodeDao.Properties.Date.lt(end))
                .where(TallyRecodeDao.Properties.IsInCome.eq(isIncome))
                .orderDesc(TallyRecodeDao.Properties.Date)
                .list();
    }


    public static long queryCount() {
        return DaoManager.getDaoInstant().getTallyRecodeDao()
                .queryBuilder()
                .orderDesc(TallyRecodeDao.Properties.Date)
                .count();
    }
}
