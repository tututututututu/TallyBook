package com.hzecool.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by tutu on 2017/4/6.
 * 单位信息
 */

@Entity
public class BillingDaoScDwxxBean {

    @Unique
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 简拼
     */
    private String namepy;
    /**
     * 手机
     */
    private String phone;
    /**
     * 折扣
     */
    private String discount;
    /**
     * 10：客户 20：供应商
     */
    private String dwxzcode;
    /**
     * 整单备注
     */
    private String remark;
    /**
     * 最后修改时间
     */
    private String optime;
    /**
     * 价格类型：对应业务字典 sc_dict where typeid=402 and epid=账套id
     */
    private String pricetype;
    /**
     * 访问编码
     */
    private String accode;
    /**
     * 所属门店
     */
    private String invid;
    /**
     * 停用标记 0正常  1停用
     */
    private String delflag;
    /**
     * 是否联网（商圈关联）
     */
    private String linkflag;
    /**
     * 商圈标识
     */
    private String openid;
    /**
     * vip卡号
     */
    private String vipcode;
    @Generated(hash = 282082469)
    public BillingDaoScDwxxBean(String id, String name, String namepy, String phone,
            String discount, String dwxzcode, String remark, String optime,
            String pricetype, String accode, String invid, String delflag,
            String linkflag, String openid, String vipcode) {
        this.id = id;
        this.name = name;
        this.namepy = namepy;
        this.phone = phone;
        this.discount = discount;
        this.dwxzcode = dwxzcode;
        this.remark = remark;
        this.optime = optime;
        this.pricetype = pricetype;
        this.accode = accode;
        this.invid = invid;
        this.delflag = delflag;
        this.linkflag = linkflag;
        this.openid = openid;
        this.vipcode = vipcode;
    }
    @Generated(hash = 875694695)
    public BillingDaoScDwxxBean() {
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
    public String getNamepy() {
        return this.namepy;
    }
    public void setNamepy(String namepy) {
        this.namepy = namepy;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDiscount() {
        return this.discount;
    }
    public void setDiscount(String discount) {
        this.discount = discount;
    }
    public String getDwxzcode() {
        return this.dwxzcode;
    }
    public void setDwxzcode(String dwxzcode) {
        this.dwxzcode = dwxzcode;
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
    public String getPricetype() {
        return this.pricetype;
    }
    public void setPricetype(String pricetype) {
        this.pricetype = pricetype;
    }
    public String getAccode() {
        return this.accode;
    }
    public void setAccode(String accode) {
        this.accode = accode;
    }
    public String getInvid() {
        return this.invid;
    }
    public void setInvid(String invid) {
        this.invid = invid;
    }
    public String getDelflag() {
        return this.delflag;
    }
    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }
    public String getLinkflag() {
        return this.linkflag;
    }
    public void setLinkflag(String linkflag) {
        this.linkflag = linkflag;
    }
    public String getOpenid() {
        return this.openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
    public String getVipcode() {
        return this.vipcode;
    }
    public void setVipcode(String vipcode) {
        this.vipcode = vipcode;
    }

    @Override
    public String toString() {
        return "BillingDaoScDwxxBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", namepy='" + namepy + '\'' +
                ", phone='" + phone + '\'' +
                ", discount='" + discount + '\'' +
                ", dwxzcode='" + dwxzcode + '\'' +
                ", remark='" + remark + '\'' +
                ", optime='" + optime + '\'' +
                ", pricetype='" + pricetype + '\'' +
                ", accode='" + accode + '\'' +
                ", invid='" + invid + '\'' +
                ", delflag='" + delflag + '\'' +
                ", linkflag='" + linkflag + '\'' +
                ", openid='" + openid + '\'' +
                ", vipcode='" + vipcode + '\'' +
                '}';
    }
}
