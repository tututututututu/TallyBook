package com.hzecool.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by song on 2017/5/15.
 */

@Entity
public class MarkerDaoBean {
    @Id(autoincrement = true)
    private Long _id;
    @Unique
    private String id;
    private String name;
    private String rgb;
    @Generated(hash = 840112242)
    public MarkerDaoBean(Long _id, String id, String name, String rgb) {
        this._id = _id;
        this.id = id;
        this.name = name;
        this.rgb = rgb;
    }
    @Generated(hash = 552358004)
    public MarkerDaoBean() {
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
    public String getRgb() {
        return this.rgb;
    }
    public void setRgb(String rgb) {
        this.rgb = rgb;
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }

    
}
