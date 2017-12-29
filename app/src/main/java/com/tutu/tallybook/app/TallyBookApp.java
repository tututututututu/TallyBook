package com.tutu.tallybook.app;

import com.hzecool.common.utils.SPUtils;
import com.hzecool.core.base.BaseApp;
import com.tutu.tallybook.data.Constans;

/**
 *
 * @author tu
 * @date 2017/12/17
 */

public class TallyBookApp extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();

        Constans.init();
        SPUtils.initSP("appData");
    }
}
