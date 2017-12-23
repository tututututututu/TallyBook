package com.hzecool.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;

/**
 * 记账表
 */

@Entity
public class TallyRecode {
    @Id(autoincrement = true)
    private Long id;
    private boolean isInCome;
    /**
     * 类型id  根据id可以获取name resId
     */
    private int typeId;
    private double money;
    private Date date;
    @Generated(hash = 1774712256)
    public TallyRecode(Long id, boolean isInCome, int typeId, double money,
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
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean getIsInCome() {
        return this.isInCome;
    }
    public void setIsInCome(boolean isInCome) {
        this.isInCome = isInCome;
    }
    public int getTypeId() {
        return this.typeId;
    }
    public void setTypeId(int typeId) {
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

    @Override
    public String toString() {
        return "TallyRecode{" +
                "id=" + id +
                ", isInCome=" + isInCome +
                ", typeId=" + typeId +
                ", money=" + money +
                ", date=" + date +
                '}';
    }
}
