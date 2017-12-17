package com.hzecool.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Discribe:
 * Created by tutu on 2017/3/28.
 */

@Entity
public class DressDaoDressStyleInfoBean {

    @Unique
    private String id;
    /**
     * 发布时时间
     */
    private String publicTime;
    /**
     * 主题
     */
    private String topic;
    /**
     * 颜色
     */
    private String colorName;
    /**
     * 尺寸
     */
    private String sizeName;
    /**
     * 编码
     */
    private String code;
    /**
     * 名字
     */
    private String name;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 分享状态
     */
    private String shareStateName;
    /**
     * 价格
     */
    private String price;
    /**
     * 图片地址  用,分割
     */
    private String pictureUrl;
    /**
     * 店铺url
     */
    private String shopUrl;
    @Generated(hash = 1111891622)
    public DressDaoDressStyleInfoBean(String id, String publicTime, String topic,
            String colorName, String sizeName, String code, String name,
            String shopName, String shareStateName, String price, String pictureUrl,
            String shopUrl) {
        this.id = id;
        this.publicTime = publicTime;
        this.topic = topic;
        this.colorName = colorName;
        this.sizeName = sizeName;
        this.code = code;
        this.name = name;
        this.shopName = shopName;
        this.shareStateName = shareStateName;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.shopUrl = shopUrl;
    }
    @Generated(hash = 1422818252)
    public DressDaoDressStyleInfoBean() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPublicTime() {
        return this.publicTime;
    }
    public void setPublicTime(String publicTime) {
        this.publicTime = publicTime;
    }
    public String getTopic() {
        return this.topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getColorName() {
        return this.colorName;
    }
    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
    public String getSizeName() {
        return this.sizeName;
    }
    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShopName() {
        return this.shopName;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    public String getShareStateName() {
        return this.shareStateName;
    }
    public void setShareStateName(String shareStateName) {
        this.shareStateName = shareStateName;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getPictureUrl() {
        return this.pictureUrl;
    }
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
    public String getShopUrl() {
        return this.shopUrl;
    }
    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    @Override
    public String toString() {
        return "DressDaoDressStyleInfoBean{" +
                "id='" + id + '\'' +
                ", publicTime='" + publicTime + '\'' +
                ", topic='" + topic + '\'' +
                ", colorName='" + colorName + '\'' +
                ", sizeName='" + sizeName + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shareStateName='" + shareStateName + '\'' +
                ", price='" + price + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", shopUrl='" + shopUrl + '\'' +
                '}';
    }
}
