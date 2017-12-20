package com.tutu.tallybook.app;

import com.hzecool.core.base.BaseApp;
import com.tutu.tallybook.data.Constans;

/**
 * Created by tu on 2017/12/17.
 */

public class TallyBookApp extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();

        Constans.init();
    }
}
