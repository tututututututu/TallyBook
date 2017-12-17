package com.hzecool.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 开单草稿实体类
 * Created by tutu on 2017/5/10.
 */

@Entity
public class DraftSaleBillingDaoBean {

    @Id(autoincrement = true)
    private Long id;
    private String time;
    private String customName;
    private String shopName;
    private String count;
    private String amount;
    private String contentJson;
    private int type;
    @Generated(hash = 106389060)
    public DraftSaleBillingDaoBean(Long id, String time, String customName,
            String shopName, String count, String amount, String contentJson,
            int type) {
        this.id = id;
        this.time = time;
        this.customName = customName;
        this.shopName = shopName;
        this.count = count;
        this.amount = amount;
        this.contentJson = contentJson;
        this.type = type;
    }
    @Generated(hash = 248625689)
    public DraftSaleBillingDaoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getCustomName() {
        return this.customName;
    }
    public void setCustomName(String customName) {
        this.customName = customName;
    }
    public String getShopName() {
        return this.shopName;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    public String getCount() {
        return this.count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public String getAmount() {
        return this.amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getContentJson() {
        return this.contentJson;
    }
    public void setContentJson(String contentJson) {
        this.contentJson = contentJson;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
}
