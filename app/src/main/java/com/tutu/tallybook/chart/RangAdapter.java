package com.tutu.tallybook.chart;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.common.utils.TimeUtils;
import com.hzecool.db.bean.TallyRecode;
import com.tutu.tallybook.R;
import com.tutu.tallybook.data.Constans;

import java.util.List;

/**
 * Created by tu on 2017/12/23.
 */

public class RangAdapter extends BaseQuickAdapter<TallyRecode, BaseViewHolder> {
    public RangAdapter(List<TallyRecode> data) {
        super(R.layout.tally_detail_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TallyRecode item) {
        helper.setText(R.id.tv_name, Constans.getResource(item.getTypeId()).getName());

        helper.setText(R.id.tv_time, TimeUtils.getYYMMDDWString(item.getDate()));
        helper.setImageResource(R.id.iv, Constans.getResource(item.getTypeId()).getResId());
        if (item.getIsInCome()) {
            helper.setText(R.id.tv_money, item.getMoney() + "");
            helper.setTextColor(R.id.tv_money, ResourceUtils.getColor(R.color.base_in_come));
        } else {
            helper.setText(R.id.tv_money, "-" + item.getMoney());
            helper.setTextColor(R.id.tv_money, ResourceUtils.getColor(R.color.base_out_put));
        }
    }
}
