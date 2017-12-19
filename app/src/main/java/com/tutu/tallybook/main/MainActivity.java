package com.tutu.tallybook.main;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.common.utils.HandlerUtil;
import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.core.base.TBaseActivity;
import com.tutu.tallybook.R;
import com.tutu.tallybook.main.adapter.MainViewPagerAdapter;
import com.tutu.tallybook.main.widget.SpecialTab;
import com.tutu.tallybook.main.widget.SpecialTabRound;
import com.tutu.tallybook.tally.TallyActivity;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends TBaseActivity<IMainView, MainPresenter>
        implements IMainView {

    private ViewPager viewPager;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        PageNavigationView tab = (PageNavigationView) findViewById(R.id.tab);

        NavigationController navigationController = tab.custom()
                .addItem(newItem(R.mipmap.bottom_detail_normal, R.mipmap.bottom_detail_pressed, "明细"))
                .addItem(newItem(R.mipmap.bottom_chart_normal, R.mipmap.bottom_chart_pressed, "图表"))
                .addItem(newRoundItem(R.mipmap.bottom_add_normal, R.mipmap.bottom_add_pressed, "记账"))
                .addItem(newItem(R.mipmap.bottom_find_normal, R.mipmap.bottom_find_pressed, "发现"))
                .addItem(newItem(R.mipmap.bottom_me_normal, R.mipmap.bottom_me_pressed, "我的"))
                .build();

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), navigationController.getItemCount()));

        //自动适配ViewPager页面切换
        navigationController.setupWithViewPager(viewPager);
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                if (index == 2) {
                    Intent intent = new Intent(MainActivity.this, TallyActivity.class);
                    startActivity(intent);
                    HandlerUtil.postDelay(() -> viewPager.setCurrentItem(old), 1000);
                }
            }

            @Override
            public void onRepeat(int index) {

            }
        });
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onLoadData(Object o) {

    }

    @Override
    public void onEmptyData() {

    }

    @Override
    public void onLoadError(String msg) {

    }

    @Override
    public void onNetError(String msg) {

    }

    /**
     * 正常tab
     */
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        SpecialTab mainTab = new SpecialTab(this);
        mainTab.initialize(drawable, checkedDrawable, text);
        mainTab.setTextDefaultColor(ResourceUtils.getColor(R.color.base_font1));
        mainTab.setTextCheckedColor(ResourceUtils.getColor(R.color.base_font1));
        return mainTab;
    }

    /**
     * 圆形tab
     */
    private BaseTabItem newRoundItem(int drawable, int checkedDrawable, String text) {
        SpecialTabRound mainTab = new SpecialTabRound(this);
        mainTab.initialize(drawable, checkedDrawable, text);
        mainTab.setTextDefaultColor(ResourceUtils.getColor(R.color.base_font1));
        mainTab.setTextCheckedColor(ResourceUtils.getColor(R.color.base_font1));
        return mainTab;
    }
}
