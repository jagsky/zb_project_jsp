package com.zb.bean;

/**
 * Created by Administrator on 2016/7/25.
 */
public class EverydayBean {
    private String Userid;
    private String time;
    private String content;

    public EverydayBean() {
    }

    public EverydayBean(String userid, String time, String content) {
        Userid = userid;
        this.time = time;
        this.content = content;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
