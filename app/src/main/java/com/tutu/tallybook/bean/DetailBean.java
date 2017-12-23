package com.tutu.tallybook.bean;

import com.hzecool.db.bean.TallyRecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tu on 2017/12/22.
 */

public class DetailBean {
    private String date;
    private double inCome;
    private double outPut;

    private List<TallyRecode> dataList = new ArrayList<>();


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getInCome() {
        return inCome;
    }

    public void setInCome(double inCome) {
        this.inCome = inCome;
    }

    public double getOutPut() {
        return outPut;
    }

    public void setOutPut(double outPut) {
        this.outPut = outPut;
    }

    public List<TallyRecode> getDataList() {
        return dataList;
    }

    public void setDataList(List<TallyRecode> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "DetailBean{" +
                "date='" + date + '\'' +
                ", inCome=" + inCome +
                ", outPut=" + outPut +
                ", dataList=" + dataList +
                '}';
    }
}
