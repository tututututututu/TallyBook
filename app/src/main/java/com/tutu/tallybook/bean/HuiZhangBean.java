package com.tutu.tallybook.bean;

/**
 * Created by tu on 2017/12/20.
 */

public class HuiZhangBean {
    private String text;
    private int resId;

    public HuiZhangBean(String text, int resId) {
        this.text = text;
        this.resId = resId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    @Override
    public String toString() {
        return "HuiZhangBean{" +
                "text='" + text + '\'' +
                ", resId=" + resId +
                '}';
    }
}
