package com.tutu.tallybook.main.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hzecool.core.log.L;
import com.tutu.tallybook.chart.ChartFragment;
import com.tutu.tallybook.detail.DetailFragment;
import com.tutu.tallybook.discover.DiscoverFragment;
import com.tutu.tallybook.empty.EmptyFragment;
import com.tutu.tallybook.my.MyFragment;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private int size;

    public MainViewPagerAdapter(FragmentManager fm, int size) {
        super(fm);
        this.size = size;
    }

    @Override
    public Fragment getItem(int position) {
        L.i("主界面切换 position=" + position);
        switch (position) {
            case 0:
                return DetailFragment.newInstance(position + "");
            case 1:
                return ChartFragment.newInstance(position + "");
            case 2:
                return EmptyFragment.newInstance(position + "");
            case 3:
                return DiscoverFragment.newInstance(position + "");
            case 4:
                return MyFragment.newInstance(position + "");
        }

        return DetailFragment.newInstance(position + "");
    }

    @Override
    public int getCount() {
        return size;
    }
}
