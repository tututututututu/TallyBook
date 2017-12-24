package com.tutu.tallybook.detail.item;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzecool.common.utils.AppUtils;
import com.hzecool.common.utils.TimeUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.base.TBaseActivity;
import com.hzecool.db.bean.TallyRecode;
import com.tutu.tallybook.R;
import com.tutu.tallybook.data.Constans;
import com.tutu.tallybook.data.DataProvider;

import butterknife.BindView;
import butterknife.OnClick;

public class ItemDetailActivity extends TBaseActivity<ItemDetailView, ItemDetailPresenter> {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_account)
    TextView tvAccount;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_remark)
    TextView tvRemark;
    @BindView(R.id.tv_delete)
    TextView tvDelete;
    @BindView(R.id.tv_type_name)
    TextView tvTypeName;
    private TallyRecode tallyRecode;

    @Override
    public int getLayoutID() {
        return R.layout.activity_item_detail;
    }

    @Override
    public void initView() {
        tallyRecode = getIntent().getParcelableExtra("item");

        tvType.setText(tallyRecode.getIsInCome() ? "收入" : "支出");
        tvAccount.setText(tallyRecode.getMoney() + "");
        tvDate.setText(TimeUtils.getYYMMDDWString(tallyRecode.getDate()));
        tvRemark.setText(Constans.getResource(tallyRecode.getTypeId()).getName());
        tvTypeName.setText(Constans.getResource(tallyRecode.getTypeId()).getName());
        iv.setImageResource(Constans.getResource(tallyRecode.getTypeId()).getResId());
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected ItemDetailPresenter createPresenter() {
        return new ItemDetailPresenter();
    }

    @OnClick({R.id.iv_back, R.id.tv_share, R.id.tv_delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_share:
                Intent textIntent = new Intent(Intent.ACTION_SEND);
                textIntent.setType("text/plain");
                textIntent.putExtra(Intent.EXTRA_TEXT, "快来使用<" +
                        AppUtils.getAppName(this.getApplicationContext()) + "吧");
                startActivity(Intent.createChooser(textIntent, "分享"));
                break;
            case R.id.tv_delete:
                DataProvider.delete(tallyRecode);
                ToastUtils.showShortToast("删除成功");
                finish();
                break;
        }
    }

}
