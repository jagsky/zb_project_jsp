package com.zb.bean;

/**
 * Created by Administrator on 2016/8/4.
 */
public class TodayBean {
    private String userName;
    private String time;
    private String content;
    private String date;

    public TodayBean() {
    }

    public TodayBean(String userName, String time, String content, String date) {
        this.userName = userName;
        this.time = time;
        this.content = content;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TodayBean{" +
                "userName='" + userName + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
