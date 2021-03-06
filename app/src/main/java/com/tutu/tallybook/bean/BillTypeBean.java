package com.tutu.tallybook.bean;

/**
 * Created by tu on 2017/12/18.
 */

public class BillTypeBean {
    private int id;
    private String name;
    private int resId;
    private boolean inCome;

    public boolean isInCome() {
        return inCome;
    }

    public void setInCome(boolean inCome) {
        this.inCome = inCome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    @Override
    public String toString() {
        return "BillTypeBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resId='" + resId + '\'' +
                ", inCome=" + inCome +
                '}';
    }
}
