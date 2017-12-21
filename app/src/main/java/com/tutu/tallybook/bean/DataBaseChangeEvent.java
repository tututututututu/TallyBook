package com.tutu.tallybook.bean;

/**
 * Created by tu on 2017/12/21.
 */

public class DataBaseChangeEvent {
    /**
     * 1增
     * 2删
     * 3改
     * 4查
     */
    private int type;

    public DataBaseChangeEvent(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DataBaseChangeEvent{" +
                "type=" + type +
                '}';
    }
}
