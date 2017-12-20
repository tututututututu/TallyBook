package com.tutu.tallybook.huizhang;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tutu.tallybook.R;
import com.tutu.tallybook.bean.HuiZhangBean;

import java.util.List;

/**
 * Created by tu on 2017/12/18.
 */

public class HuiZhangAdapter extends BaseQuickAdapter<HuiZhangBean, BaseViewHolder> {
    public HuiZhangAdapter(List<HuiZhangBean> data) {
        super(R.layout.huizhang_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HuiZhangBean item) {
        helper.setImageResource(R.id.iv, item.getResId());
        helper.setText(R.id.tv, item.getText());
    }
}
