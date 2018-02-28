package com.tutu.tallybook.bean;

/**
 * @author tutu
 * @time 2017/12/28
 */

public class ShowTypeBean {


    /**
     * iosversion : {"struts":"0","version":"1.2.0"}
     * indexUrl : http://xt.365yama.cn/mobile/jiekuan.htm
     * struts : 1.2.0
     */

    private IosversionBean iosversion;
    private String indexUrl;
    private String struts;

    private String sfsbJk;
    private String txlfhUrl;
    private String sfzfhUrl;
    private String dlwzfhUrl;
    private String dlwJk;
    private String txlJk;
    private String ymUrl;

    public String getSfsbJk() {
        return sfsbJk;
    }

    public void setSfsbJk(String sfsbJk) {
        this.sfsbJk = sfsbJk;
    }

    public String getTxlfhUrl() {
        return txlfhUrl;
    }

    public void setTxlfhUrl(String txlfhUrl) {
        this.txlfhUrl = txlfhUrl;
    }

    public String getSfzfhUrl() {
        return sfzfhUrl;
    }

    public void setSfzfhUrl(String sfzfhUrl) {
        this.sfzfhUrl = sfzfhUrl;
    }

    public String getDlwzfhUrl() {
        return dlwzfhUrl;
    }

    public void setDlwzfhUrl(String dlwzfhUrl) {
        this.dlwzfhUrl = dlwzfhUrl;
    }

    public String getDlwJk() {
        return dlwJk;
    }

    public void setDlwJk(String dlwJk) {
        this.dlwJk = dlwJk;
    }

    public String getTxlJk() {
        return txlJk;
    }

    public void setTxlJk(String txlJk) {
        this.txlJk = txlJk;
    }

    public String getYmUrl() {
        return ymUrl;
    }

    public void setYmUrl(String ymUrl) {
        this.ymUrl = ymUrl;
    }

    public IosversionBean getIosversion() {
        return iosversion;
    }

    public void setIosversion(IosversionBean iosversion) {
        this.iosversion = iosversion;
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }

    public String getStruts() {
        return struts;
    }

    public void setStruts(String struts) {
        this.struts = struts;
    }

    public static class IosversionBean {
        /**
         * struts : 0
         * version : 1.2.0
         */

        private String struts;
        private String version;

        public String getStruts() {
            return struts;
        }

        public void setStruts(String struts) {
            this.struts = struts;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
