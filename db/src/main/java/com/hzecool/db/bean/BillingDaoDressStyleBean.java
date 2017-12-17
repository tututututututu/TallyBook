package com.hzecool.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 款式
 * Created by tutu on 2017/4/6.
 */

@Entity
public class BillingDaoDressStyleBean {

    /**
     * id
     */
    @Unique
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 款号
     */
    private String code;
    /**
     * 款号拼音
     */
    private String codepy;
    /**
     * 颜色组，逗号间隔，业务字典，typeid=601
     */
    private String colorids;
    /**
     * 尺码组，逗号间隔，业务字典，typeid=605
     */
    private String sizeids;
    /**
     * 销售价1 价格名字是由客户自己定义
     */
    private String stdprice1;
    /**
     * 销售价2 价格名字是由客户自己定义
     */
    private String stdprice2;
    /**
     * 销售价3 价格名字是由客户自己定义
     */
    private String stdprice3;
    /**
     * 销售价4 价格名字是由客户自己定义
     */
    private String stdprice4;
    /**
     * 销售价5 价格名字是由客户自己定义
     */
    private String stdprice5;
    /**
     * 进货价，采购价
     */
    private String purprice;
    /**
     * 折扣
     */
    private String discount;
    /**
     * 图片id串，逗号间隔
     */
    private String fileid;
    /**
     * 帐套id
     */
    private String epid;
    /**
     * 备注
     */
    private String remark;
    /**
     * 最后更新时间
     */
    private String optime;
    /**
     * 停用标记 1:停用  2 特殊货品
     */
    private String flag;
    /**
     * 单位
     */
    private String unit;
    /**
     * 停用标记 0正常  1停用
     */
    private String delflag;

    /**
     * 供应商，厂商 sc_dwxx
     */
    private String dwid;

    /**
     * 所属门店，适用于不同门店不同款号的需求
     */
    private String shopid;

    @Generated(hash = 15781476)
    public BillingDaoDressStyleBean(String id, String name, String code,
            String codepy, String colorids, String sizeids, String stdprice1,
            String stdprice2, String stdprice3, String stdprice4, String stdprice5,
            String purprice, String discount, String fileid, String epid,
            String remark, String optime, String flag, String unit, String delflag,
            String dwid, String shopid) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.codepy = codepy;
        this.colorids = colorids;
        this.sizeids = sizeids;
        this.stdprice1 = stdprice1;
        this.stdprice2 = stdprice2;
        this.stdprice3 = stdprice3;
        this.stdprice4 = stdprice4;
        this.stdprice5 = stdprice5;
        this.purprice = purprice;
        this.discount = discount;
        this.fileid = fileid;
        this.epid = epid;
        this.remark = remark;
        this.optime = optime;
        this.flag = flag;
        this.unit = unit;
        this.delflag = delflag;
        this.dwid = dwid;
        this.shopid = shopid;
    }

    @Generated(hash = 1942341293)
    public BillingDaoDressStyleBean() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodepy() {
        return this.codepy;
    }

    public void setCodepy(String codepy) {
        this.codepy = codepy;
    }

    public String getColorids() {
        return this.colorids;
    }

    public void setColorids(String colorids) {
        this.colorids = colorids;
    }

    public String getSizeids() {
        return this.sizeids;
    }

    public void setSizeids(String sizeids) {
        this.sizeids = sizeids;
    }

    public String getStdprice1() {
        return this.stdprice1;
    }

    public void setStdprice1(String stdprice1) {
        this.stdprice1 = stdprice1;
    }

    public String getStdprice2() {
        return this.stdprice2;
    }

    public void setStdprice2(String stdprice2) {
        this.stdprice2 = stdprice2;
    }

    public String getStdprice3() {
        return this.stdprice3;
    }

    public void setStdprice3(String stdprice3) {
        this.stdprice3 = stdprice3;
    }

    public String getStdprice4() {
        return this.stdprice4;
    }

    public void setStdprice4(String stdprice4) {
        this.stdprice4 = stdprice4;
    }

    public String getStdprice5() {
        return this.stdprice5;
    }

    public void setStdprice5(String stdprice5) {
        this.stdprice5 = stdprice5;
    }

    public String getPurprice() {
        return this.purprice;
    }

    public void setPurprice(String purprice) {
        this.purprice = purprice;
    }

    public String getDiscount() {
        return this.discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getFileid() {
        return this.fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
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

    public String getOptime() {
        return this.optime;
    }

    public void setOptime(String optime) {
        this.optime = optime;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public String getDwid() {
        return this.dwid;
    }

    public void setDwid(String dwid) {
        this.dwid = dwid;
    }

    public String getShopid() {
        return this.shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    @Override
    public String toString() {
        return "BillingDaoDressStyleBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", codepy='" + codepy + '\'' +
                ", colorids='" + colorids + '\'' +
                ", sizeids='" + sizeids + '\'' +
                ", stdprice1='" + stdprice1 + '\'' +
                ", stdprice2='" + stdprice2 + '\'' +
                ", stdprice3='" + stdprice3 + '\'' +
                ", stdprice4='" + stdprice4 + '\'' +
                ", stdprice5='" + stdprice5 + '\'' +
                ", purprice='" + purprice + '\'' +
                ", discount='" + discount + '\'' +
                ", fileid='" + fileid + '\'' +
                ", epid='" + epid + '\'' +
                ", remark='" + remark + '\'' +
                ", optime='" + optime + '\'' +
                ", flag='" + flag + '\'' +
                ", unit='" + unit + '\'' +
                ", delflag='" + delflag + '\'' +
                ", dwid='" + dwid + '\'' +
                ", shopid='" + shopid + '\'' +
                '}';
    }
}
