package com.hzecool.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

import java.util.Date;

/**
 * 记账表
 */

@Entity
public class TallyRecode {
    @Unique
    private String id;
    private boolean isInCome;
    /**
     * 类型id  根据id可以获取name resId
     */
    private String typeId;
    private double money;
    private Date date;
    @Generated(hash = 2133859813)
    public TallyRecode(String id, boolean isInCome, String typeId, double money,
            Date date) {
        this.id = id;
        this.isInCome = isInCome;
        this.typeId = typeId;
        this.money = money;
        this.date = date;
    }
    @Generated(hash = 957767067)
    public TallyRecode() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public boolean getIsInCome() {
        return this.isInCome;
    }
    public void setIsInCome(boolean isInCome) {
        this.isInCome = isInCome;
    }
    public String getTypeId() {
        return this.typeId;
    }
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    public double getMoney() {
        return this.money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
