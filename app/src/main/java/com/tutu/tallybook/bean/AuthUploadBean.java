package com.tutu.tallybook.bean;

/**
 * @author tutu
 * @time 2018/1/13
 */

public class AuthUploadBean {
    /**
     * type : 1
     * imgBase64 : xxxxxxxxxxxxxxx
     * extra : 这里放识别的信息
     */

    private String type;
    private String imgBase64;
    private String extra;

    public AuthUploadBean(String type, String imgBase64, String extra) {
        this.type = type;
        this.imgBase64 = imgBase64;
        this.extra = extra;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
