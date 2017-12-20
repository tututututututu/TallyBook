package com.tutu.tallybook.bean;

/**
 * Created by tu on 2017/12/20.
 */

public class ResourceBean {
    private String name;
    private int resId;
    private boolean inCome;

    public ResourceBean(boolean inCome,String name, int resId) {
        this.name = name;
        this.resId = resId;
        this.inCome = inCome;
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

    public boolean isInCome() {
        return inCome;
    }

    public void setInCome(boolean inCome) {
        this.inCome = inCome;
    }

    @Override
    public String toString() {
        return "ResourceBean{" +
                "name='" + name + '\'' +
                ", resId=" + resId +
                ", inCome=" + inCome +
                '}';
    }
}
