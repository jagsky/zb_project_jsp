package com.zb.bean;

/**
 * Created by Administrator on 2016/7/5.
 */
public class FarmerBean {
    private String FarmerName;
    private String DKnumber;
    private String type;

    public FarmerBean() {
    }

    public FarmerBean(String farmerName, String DKnumber, String type) {
        FarmerName = farmerName;
        this.DKnumber = DKnumber;
        this.type = type;
    }

    public String getFarmerName() {
        return FarmerName;
    }

    public void setFarmerName(String farmerName) {
        FarmerName = farmerName;
    }

    public String getDKnumber() {
        return DKnumber;
    }

    public void setDKnumber(String DKnumber) {
        this.DKnumber = DKnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
