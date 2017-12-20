package com.tutu.tallybook.tally;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tutu.tallybook.R;
import com.tutu.tallybook.bean.BillTypeBean;

import java.util.List;

/**
 * Created by tu on 2017/12/18.
 */

public class TypeAdapter extends BaseQuickAdapter<BillTypeBean,BaseViewHolder> {
    public TypeAdapter(List<BillTypeBean> data) {
        super(R.layout.tally_type_item_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BillTypeBean item) {
        helper.setText(R.id.tv,item.getName());
        helper.setImageResource(R.id.iv,item.getResId());
    }
}
