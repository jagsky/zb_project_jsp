package com.zb.bean;

/**
 * Created by Administrator on 2016/7/5.
 */
public class FarmerBean {
    private String userIdCard;
    private String farmerName;
    private String dKnumber;
    private String type;
    private String baseName;
    private String house;
    private String idcard;
    private String temperature;
    private String farmer_voyages;
    private String farmer_manure;
    private String farmer_troopsname;
    private String farmer_yield;
    private String farmer_area;

    public FarmerBean() {
    }

    public FarmerBean(String userIdCard, String farmerName, String dKnumber, String type, String baseName, String house, String idcard, String temperature, String farmer_voyages, String farmer_manure, String farmer_troopsname, String farmer_yield, String farmer_area) {
        this.userIdCard = userIdCard;
        this.farmerName = farmerName;
        this.dKnumber = dKnumber;
        this.type = type;
        this.baseName = baseName;
        this.house = house;
        this.idcard = idcard;
        this.temperature = temperature;
        this.farmer_voyages = farmer_voyages;
        this.farmer_manure = farmer_manure;
        this.farmer_troopsname = farmer_troopsname;
        this.farmer_yield = farmer_yield;
        this.farmer_area = farmer_area;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getFarmer_voyages() {
        return farmer_voyages;
    }

    public void setFarmer_voyages(String farmer_voyages) {
        this.farmer_voyages = farmer_voyages;
    }

    public String getFarmer_manure() {
        return farmer_manure;
    }

    public void setFarmer_manure(String farmer_manure) {
        this.farmer_manure = farmer_manure;
    }

    public String getFarmer_troopsname() {
        return farmer_troopsname;
    }

    public void setFarmer_troopsname(String farmer_troopsname) {
        this.farmer_troopsname = farmer_troopsname;
    }

    public String getFarmer_yield() {
        return farmer_yield;
    }

    public void setFarmer_yield(String farmer_yield) {
        this.farmer_yield = farmer_yield;
    }

    public String getFarmer_area() {
        return farmer_area;
    }

    public void setFarmer_area(String farmer_area) {
        this.farmer_area = farmer_area;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getdKnumber() {
        return dKnumber;
    }

    public void setdKnumber(String dKnumber) {
        this.dKnumber = dKnumber;
    }

    @Override
    public String toString() {
        return "FarmerBean{" +
                "userIdCard='" + userIdCard + '\'' +
                ", FarmerName='" + farmerName + '\'' +
                ", DKnumber='" + dKnumber + '\'' +
                ", type='" + type + '\'' +
                ", baseName='" + baseName + '\'' +
                ", house='" + house + '\'' +
                ", idcard='" + idcard + '\'' +
                ", temperature='" + temperature + '\'' +
                ", farmer_voyages='" + farmer_voyages + '\'' +
                ", farmer_manure='" + farmer_manure + '\'' +
                ", farmer_troopsname='" + farmer_troopsname + '\'' +
                ", farmer_yield='" + farmer_yield + '\'' +
                ", farmer_area='" + farmer_area + '\'' +
                '}';
    }
}
