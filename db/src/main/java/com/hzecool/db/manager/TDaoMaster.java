package com.hzecool.db.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hzecool.db.bean.DaoMaster;


/**
 * DB升级子类 处理表结构等问题
 * Created by tutu on 2017/2/26.
 */

public class TDaoMaster extends DaoMaster.OpenHelper {
    public TDaoMaster(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //ShopDao 更新了就像下面这段代码
        //MigrationHelper.migrate(db, DressStyleDaoBeanDao.class, ScDictColorDaoBeanDao.class, ScDictColorDaoBeanDao.class, ScDwxxDaoBeanDao.class);
    }
}
