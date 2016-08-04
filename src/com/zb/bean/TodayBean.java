package com.zb.bean;

/**
 * Created by Administrator on 2016/8/4.
 */
public class TodayBean {
    private String id;
    private String time;
    private String content;
    private String date;

    public TodayBean() {
    }

    public TodayBean(String id, String time, String content, String date) {
        this.id = id;
        this.time = time;
        this.content = content;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
