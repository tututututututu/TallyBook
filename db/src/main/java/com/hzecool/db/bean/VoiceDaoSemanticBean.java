package com.hzecool.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 语音语义信息实体类
 * Created by song on 2017/6/8.
 */

@Entity
public class VoiceDaoSemanticBean {
    @Unique
    private String id;
    private String code;
    private String name;
    private String optime;
    @Generated(hash = 473810176)
    public VoiceDaoSemanticBean(String id, String code, String name,
            String optime) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.optime = optime;
    }
    @Generated(hash = 404103144)
    public VoiceDaoSemanticBean() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
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
    public String getOptime() {
        return this.optime;
    }
    public void setOptime(String optime) {
        this.optime = optime;
    }
}
