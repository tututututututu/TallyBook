package com.tutu.tallybook.bean;

/**
 * @author tutu
 * @time 2017/12/28
 */

public class ShowTypeBean {

    /**
     * iosversion : {"struts":"1","version":"1.0.0"}
     * struts : 1.0.0
     */

    private IosversionBean iosversion;
    private String struts;

    public IosversionBean getIosversion() {
        return iosversion;
    }

    public void setIosversion(IosversionBean iosversion) {
        this.iosversion = iosversion;
    }

    public String getStruts() {
        return struts;
    }

    public void setStruts(String struts) {
        this.struts = struts;
    }

    public static class IosversionBean {
        /**
         * struts : 1
         * version : 1.0.0
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
