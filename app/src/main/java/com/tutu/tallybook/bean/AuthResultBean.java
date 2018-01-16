package com.tutu.tallybook.bean;

/**
 * @author tutu
 * @time 2018/1/15
 */

public class AuthResultBean {

    /**
     * msg : 保存成功
     * fh : 1
     */

    private String msg;
    private int fh;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getFh() {
        return fh;
    }

    public void setFh(int fh) {
        this.fh = fh;
    }

    public AuthResultBean(String msg, int fh) {
        this.msg = msg;
        this.fh = fh;
    }

    @Override
    public String toString() {
        return "AuthResultBean{" +
                "msg='" + msg + '\'' +
                ", fh=" + fh +
                '}';
    }
}
