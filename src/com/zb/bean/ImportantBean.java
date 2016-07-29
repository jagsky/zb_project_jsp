package com.zb.bean;

/**
 * 作用：重大信息上报
 * Created by Administrator on 2016/7/29.
 */
public class ImportantBean {
    private String id;
    private String userName;
    private String date;
    private String province;
    private String city;
    private String county;
    private String town;
    private String village;
    private String contenttype;
    private String theme;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ImportantBean() {

    }

    public ImportantBean(String id, String userName, String date, String province, String city, String county, String town, String village, String contenttype, String theme, String content) {

        this.id = id;
        this.userName = userName;
        this.date = date;
        this.province = province;
        this.city = city;
        this.county = county;
        this.town = town;
        this.village = village;
        this.contenttype = contenttype;
        this.theme = theme;
        this.content = content;
    }
}
