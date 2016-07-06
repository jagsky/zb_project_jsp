package com.zb.bean;

/**
 * Created by Administrator on 2016/7/5.
 */
public class NDKBean {
    private String farmerName;
    private String dKNumber;
    private String type;

    public NDKBean() {
    }

    public NDKBean(String farmerName, String dKNumber, String type) {
        this.farmerName = farmerName;
        this.dKNumber = dKNumber;
        this.type = type;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getdKNumber() {
        return dKNumber;
    }

    public void setdKNumber(String dKNumber) {
        this.dKNumber = dKNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NDKBean{" +
                "farmerName='" + farmerName + '\'' +
                ", dKNumber='" + dKNumber + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
