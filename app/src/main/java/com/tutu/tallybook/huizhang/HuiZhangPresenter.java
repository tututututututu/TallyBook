package com.tutu.tallybook.huizhang;

import com.hzecool.core.base.TBasePresenter;
import com.tutu.tallybook.R;
import com.tutu.tallybook.bean.HuiZhangBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tu on 2017/12/20.
 */

public class HuiZhangPresenter extends TBasePresenter<IHuiZhangView> {
    @Override
    protected void start() {

    }

    public List<HuiZhangBean> getDakaList(){
        List data = new ArrayList();
        HuiZhangBean huiZhangBean1 = new HuiZhangBean("连续3天徽章", R.mipmap.badge_icon_dialog_sign_in_continue_3_not_get);
        HuiZhangBean huiZhangBean2 = new HuiZhangBean("连续7天徽章", R.mipmap.badge_icon_dialog_sign_in_continue_7_not_get);
        HuiZhangBean huiZhangBean3 = new HuiZhangBean("连续21天徽章", R.mipmap.badge_icon_dialog_sign_in_continue_21_not_get);
        HuiZhangBean huiZhangBean4 = new HuiZhangBean("连续50天徽章", R.mipmap.badge_icon_dialog_sign_in_continue_50_not_get);
        HuiZhangBean huiZhangBean5 = new HuiZhangBean("连续100天徽章", R.mipmap.badge_icon_dialog_sign_in_continue_100_not_get);
        HuiZhangBean huiZhangBean6 = new HuiZhangBean("连续200天徽章", R.mipmap.badge_icon_dialog_sign_in_continue_200_not_get);
        data.add(huiZhangBean1);
        data.add(huiZhangBean2);
        data.add(huiZhangBean3);
        data.add(huiZhangBean4);
        data.add(huiZhangBean5);
        data.add(huiZhangBean6);

        return data;
    }


    public List<HuiZhangBean> getJiZhangList(){
        List data = new ArrayList();
        HuiZhangBean huiZhangBean1 = new HuiZhangBean("累计记账30天", R.mipmap.badge_icon_item_cumulative_day_30_not_get);
        HuiZhangBean huiZhangBean3 = new HuiZhangBean("累计记账100天", R.mipmap.badge_icon_item_cumulative_day_100_not_get);
        HuiZhangBean huiZhangBean4 = new HuiZhangBean("累计记账365天", R.mipmap.badge_icon_item_cumulative_day_365_not_get);
        HuiZhangBean huiZhangBean5 = new HuiZhangBean("累计记账500天", R.mipmap.badge_icon_item_cumulative_day_500_not_get);
        HuiZhangBean huiZhangBean6 = new HuiZhangBean("累计记账800天", R.mipmap.badge_icon_item_cumulative_day_800_not_get);
        HuiZhangBean huiZhangBean2 = new HuiZhangBean("累计记账1000天", R.mipmap.badge_icon_item_cumulative_day_1000_not_get);
        data.add(huiZhangBean1);
        data.add(huiZhangBean2);
        data.add(huiZhangBean3);
        data.add(huiZhangBean4);
        data.add(huiZhangBean5);
        data.add(huiZhangBean6);
        return data;
    }

}
