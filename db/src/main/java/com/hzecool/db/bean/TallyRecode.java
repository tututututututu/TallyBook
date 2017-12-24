package com.hzecool.db.bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;

/**
 * 记账表
 */

@Entity
public class TallyRecode implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeByte(this.isInCome ? (byte) 1 : (byte) 0);
        dest.writeInt(this.typeId);
        dest.writeDouble(this.money);
        dest.writeLong(this.date != null ? this.date.getTime() : -1);
    }

    protected TallyRecode(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.isInCome = in.readByte() != 0;
        this.typeId = in.readInt();
        this.money = in.readDouble();
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
    }

    public static final Parcelable.Creator<TallyRecode> CREATOR = new Parcelable.Creator<TallyRecode>() {
        @Override
        public TallyRecode createFromParcel(Parcel source) {
            return new TallyRecode(source);
        }

        @Override
        public TallyRecode[] newArray(int size) {
            return new TallyRecode[size];
        }
    };
}
