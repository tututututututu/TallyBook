package com.hzecool.core.base;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hzecool.app.AppConstans;
import com.hzecool.core.R;
import com.hzecool.core.log.L;
import com.hzecool.widget.materialdialog.MaterialDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.internal.util.SubscriptionList;


/**
 * Activity基类  所有的应用中的activity都应该继承该类
 * 该类实现了一些常用方法
 * dialog
 * rxBus事件容器
 * view和presneter的绑定 解绑
 * Created by tutu on 16/4/10.
 */
public abstract class TBaseActivity<V, T extends TBasePresenter<V>> extends TAbsActivity {

    /**
     * butterknife绑定
     */
    private Unbinder unbinder;

    /**
     * 返回布局文件id
     *
     * @return
     */
    public abstract int getLayoutID();

    /**
     * 控件初始化完成 在这个方法中可以使用控件了
     */
    public abstract void initView();

    /**
     * 初始化标题栏
     *
     * @param ivBack    返回图标ImageView
     * @param tvBack    返回文字TextView
     * @param titleName 标题栏TextView
     * @param tvMenu    菜单TextView
     * @param titleRoot 整个布局View
     */
    public abstract void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot);

    protected abstract T createPresenter();

    /**
     * 当前activity对象
     * 提供给fragment使用
     */
    protected Context mBaseActivityContext;

    /**
     * app级别的Context
     */
    protected Context mApplicationContext;

    /**
     * 订阅者容器
     * 所有的activity中的订阅者都应该放在此容器中
     * 已保证不会被泄漏
     */
    protected SubscriptionList mSubscriptionList;

    /**
     * 进度框
     */
    public MaterialDialog progressDialog;

    /**
     * presenter 不能为空
     */
    protected T mPresenter;

    TextView titleName;
    ImageView ivBack;
    TextView tvMenu;
    View titleRoot;
    TextView tvBack;
    View llBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppConstans.LOG_DEBUG) {
            // 线程检测策略
//            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                    .detectDiskReads()
//                    .detectDiskWrites()
//                    .detectAll()
//                    .detectNetwork()   // or .detectAll() for all detectable problems
//                    .penaltyLog()
//                    .build());
//            // 虚拟机检测策略
//            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                    .detectLeakedSqlLiteObjects()
//                    .detectLeakedClosableObjects()
//                    .penaltyLog()
//                    .penaltyDeath()
//                    .build());
        }

        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            L.logFile("程序被系统回收,重新启动 " + getClass().getSimpleName());
            Intent i = getBaseContext().getPackageManager()
                    .getLaunchIntentForPackage(getBaseContext().getPackageName());
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
            return;
        }

        ARouter.getInstance().inject(this);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(
                    R.color.base_theme));

        }


        //创建Presenter
        mPresenter = createPresenter();
        //内存泄漏
        //关联View
        mPresenter.attachView((V) this);

        setContentView(getLayoutID());
        unbinder = ButterKnife.bind(this);

        titleName = (TextView) findViewById(R.id.tv_titel);
        ivBack = (ImageView) findViewById(R.id.iv_back);
        tvMenu = (TextView) findViewById(R.id.tv_menu);
        titleRoot = findViewById(R.id.title_root);
        llBack = findViewById(R.id.ll_back);
        tvBack = (TextView) findViewById(R.id.tv_back);

        mSubscriptionList = new SubscriptionList();


        mBaseActivityContext = this;
        mApplicationContext = getApplicationContext();
        initView();

        if (llBack != null) {
            llBack.setOnClickListener(v -> finish());
        }

        initTitle(ivBack, tvBack, llBack, titleName, tvMenu, titleRoot);

        mPresenter.start();
        L.logFile("创建activity=====" + getClass().getSimpleName());
    }

    /**
     * 显示加在框
     *
     * @param progress 是否需要准确的进度 true 需要     false不需要
     * @param msg      内容字符串
     */
    public void showLoadingDialog(boolean progress, boolean cancelable, String msg) {
        L.iTag("progress", "show");
        if (progress && progressDialog == null) {
            progressDialog = new MaterialDialog.Builder(this).progress(false, 100).cancelable(cancelable).build();
        } else if (progressDialog == null) {
            progressDialog = new MaterialDialog.Builder(this).progress(true, 0).cancelable(cancelable).build();
        }
        if (progressDialog.isShowing()) {
            L.iTag("progress", "isShowing");
            progressDialog.dismiss();
            L.iTag("progress", "dismiss");
        }
        progressDialog.setContent(msg);
        progressDialog.show();
        L.iTag("progress", "showAgain");
    }

    /**
     * 显示加在框
     *
     * @param progress 是否需要准确的进度 true 需要     false不需要
     * @param ids      内容资源文件
     */
    public void showLoadingDialog(boolean progress, boolean cancelable, int ids) {
        showLoadingDialog(progress, cancelable, getString(ids));
    }

    public void cancelLoadingDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            L.iTag("progress", "cancelLoadingDialog()  dismiss");
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        hideKeyBoard();
        //解除butterknife绑定
        if (unbinder != null) {
            unbinder.unbind();
        }
        //解除presenter和view的绑定
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        //解除观察者的订阅关系
        if (mSubscriptionList != null) {
            mSubscriptionList.unsubscribe();
        }

        //存在进度框并且在显示状态 关闭它
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        L.logFile("退出activity=====" + getClass().getSimpleName());
        super.onDestroy();
    }
}
