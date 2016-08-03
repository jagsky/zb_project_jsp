package com.zb.bean;

/**
 * Created by Administrator on 2016/7/25.
 */
public class EverydayBean {
    private String userName;
    private String time;
    private String content;

    public EverydayBean() {
    }

    public EverydayBean(String userName, String time, String content) {
        this.userName = userName;
        this.time = time;
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return "EverydayBean{" +
                "userName='" + userName + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
