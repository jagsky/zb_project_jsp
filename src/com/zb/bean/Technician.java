package com.zb.bean;

/**
 * Created by Administrator on 2016/8/16.
 */
public class Technician {
    private String userName;
    private String userid;
    private String pad;
    private String baseMunber;
    private String at;
    private String lt;

    public Technician() {
    }

    public Technician(String userName, String userid, String pad, String baseMunber, String at, String lt) {
        this.userName = userName;
        this.userid = userid;
        this.pad = pad;
        this.baseMunber = baseMunber;
        this.at = at;
        this.lt = lt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPad() {
        return pad;
    }

    public void setPad(String pad) {
        this.pad = pad;
    }

    public String getBaseMunber() {
        return baseMunber;
    }

    public void setBaseMunber(String baseMunber) {
        this.baseMunber = baseMunber;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }
}
