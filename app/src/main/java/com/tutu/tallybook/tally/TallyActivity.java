package com.tutu.tallybook.tally;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBaseActivity;
import com.hzecool.db.bean.TallyRecode;
import com.hzecool.widget.materialdialog.MaterialDialog;
import com.tutu.tallybook.R;
import com.tutu.tallybook.bean.BillTypeBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tu on 2017/12/17.
 */

public class TallyActivity extends TBaseActivity<ITallyView, TallyPresenter>
        implements ITallyView {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_top)
    LinearLayout llTop;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;

    private boolean inCome = false;
    private BaseQuickAdapter adapter;

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

    @Override
    public int getLayoutID() {
        return R.layout.tally_activity;
    }

    @Override
    public void initView() {
        tvCancel.setOnClickListener(v -> finish());
        rv.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new TypeAdapter(mPresenter.getData(inCome));
        rv.setAdapter(adapter);

        adapter.setOnItemClickListener((adapter, view, position) -> {
            BillTypeBean billTypeBean = (BillTypeBean) adapter.getData().get(position);

            new MaterialDialog.Builder(this)
                    .title("请输入金额")
                    //.content(R.string.input_content)
                    .inputType(InputType.TYPE_CLASS_NUMBER)
                    .input(billTypeBean.getName(), "", (dialog, input) -> {
                        try {
                            TallyRecode tallyRecode = new TallyRecode();
                            tallyRecode.setDate(new Date());
                            tallyRecode.setIsInCome(inCome);
                            tallyRecode.setMoney(Double.valueOf(input.toString()));
                            tallyRecode.setTypeId(billTypeBean.getId());
                            mPresenter.add(tallyRecode);
                            ToastUtils.showShortToast("新增成功");
                        } catch (Exception e) {
                            ToastUtils.showShortToast("请输入正确的金额");
                        }
                    }).show();
        });
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected TallyPresenter createPresenter() {
        return new TallyPresenter();
    }


    @OnClick({R.id.ll_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_top:
                showTypeChoice();
                break;
        }
    }

    private void showTypeChoice() {
        List<String> typeList = new ArrayList<>();
        typeList.add("支出");
        typeList.add("收入");
        new MaterialDialog.Builder(this)
                .title("选择类型")
                .items(typeList)
                .itemsCallbackSingleChoice(0, (dialog, view, which, text) -> {
                    tvName.setText(typeList.get(which));
                    changeAdapterData(which);
                    return true;
                })
                .positiveText("确定")
                .show();
    }

    private void changeAdapterData(int which) {
        if (which == 0) {
            inCome = false;
            adapter.setNewData(mPresenter.getData(false));
        } else {
            inCome = true;
            adapter.setNewData(mPresenter.getData(true));
        }
    }
}
