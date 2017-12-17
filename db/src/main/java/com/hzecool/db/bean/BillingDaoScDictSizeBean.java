package com.hzecool.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 尺码表
 * Created by tutu on 2017/4/6.
 */

@Entity
public class BillingDaoScDictSizeBean {
    /**
     * id
     */
    @Unique
    private String id;
    /**
     * 项目id
     */
    private String sid;
    /**
     * 名称
     */
    private String name;

    /**
     * 上级节点,暂时未用
     */
    private String parentid;
    /**
     * 帐套id
     */
    private String epid;
    /**
     * 备注
     */
    private String remark;
    /**
     * 尺码中有使用  童装 一手代表的件数
     */
    private String num;
    /**
     * 最后更新时间
     */
    private String optime;
    /**
     * 单位
     */
    private String unit;
    /**
     * 停用标记 0正常  1停用
     */
    private String delflag;

    /**
     * 如果是均色均码 freeflag = 1
     */
    private String freeflag;
    /**
     * 暂时未用
     */
    private String parenttypeid;
    @Generated(hash = 490405661)
    public BillingDaoScDictSizeBean(String id, String sid, String name,
            String parentid, String epid, String remark, String num, String optime,
            String unit, String delflag, String freeflag, String parenttypeid) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.parentid = parentid;
        this.epid = epid;
        this.remark = remark;
        this.num = num;
        this.optime = optime;
        this.unit = unit;
        this.delflag = delflag;
        this.freeflag = freeflag;
        this.parenttypeid = parenttypeid;
    }
    @Generated(hash = 1135312806)
    public BillingDaoScDictSizeBean() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSid() {
        return this.sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getParentid() {
        return this.parentid;
    }
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
    public String getEpid() {
        return this.epid;
    }
    public void setEpid(String epid) {
        this.epid = epid;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getNum() {
        return this.num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getOptime() {
        return this.optime;
    }
    public void setOptime(String optime) {
        this.optime = optime;
    }
    public String getUnit() {
        return this.unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getDelflag() {
        return this.delflag;
    }
    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }
    public String getParenttypeid() {
        return this.parenttypeid;
    }
    public void setParenttypeid(String parenttypeid) {
        this.parenttypeid = parenttypeid;
    }

    @Override
    public String toString() {
        return "BillingDaoScDictSizeBean{" +
                "id='" + id + '\'' +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", parentid='" + parentid + '\'' +
                ", epid='" + epid + '\'' +
                ", remark='" + remark + '\'' +
                ", num='" + num + '\'' +
                ", optime='" + optime + '\'' +
                ", unit='" + unit + '\'' +
                ", delflag='" + delflag + '\'' +
                ", parenttypeid='" + parenttypeid + '\'' +
                '}';
    }
    public String getFreeflag() {
        return this.freeflag;
    }
    public void setFreeflag(String freeflag) {
        this.freeflag = freeflag;
    }
}
