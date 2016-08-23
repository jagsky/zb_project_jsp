package com.zb.bean;

/**
 * Created by Administrator on 2016/8/1.
 */
public class ImportantTitleBean {
    private String userId;

    @Override
    public String toString() {
        return "ImportantTitleBean{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userName;
    private String title;
    private String date;

    public ImportantTitleBean() {
    }

    public ImportantTitleBean(String userName, String title, String date) {
        this.userName = userName;
        this.title = title;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
