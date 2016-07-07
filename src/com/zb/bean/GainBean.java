package com.zb.bean;

/**
 * Created by Administrator on 2016/7/5.
 */
public class GainBean {

    /**
     * UserId : da
     * dKNumber : 16JZYXX0xxx
     * fatherExciseStart : 2016-07-06
     * fatherExciseStop : 2016-07-06
     * framarName : 张三0
     * gainOutput :
     * gainTime : 2016-07-06
     * type : 玉米
     * motherNO : 55
     * singlePlant :
     * thousand :
     * id : 21
     */
    private String beizhu;
    private String UserId;
    private String dKNumber;
    private String fatherExciseStart;
    private String fatherExciseStop;
    private String framarName;
    private String gainOutput;
    private String gainTime;
    private String type;
    private String motherNO;
    private String singlePlant;
    private String thousand;
    private int id;

    public GainBean() {
    }

    public GainBean(String beizhu, String userId, String dKNumber, String fatherExciseStart, String fatherExciseStop, String framarName, String gainOutput, String gainTime, String type, String motherNO, String singlePlant, String thousand) {
        this.beizhu = beizhu;
        UserId = userId;
        this.dKNumber = dKNumber;
        this.fatherExciseStart = fatherExciseStart;
        this.fatherExciseStop = fatherExciseStop;
        this.framarName = framarName;
        this.gainOutput = gainOutput;
        this.gainTime = gainTime;
        this.type = type;
        this.motherNO = motherNO;
        this.singlePlant = singlePlant;
        this.thousand = thousand;
    }

    public GainBean(String beizhu, String userId, String dKNumber, String fatherExciseStart, String fatherExciseStop, String framarName, String gainOutput, String gainTime, String type, String motherNO, String singlePlant, String thousand, int id) {
        this.beizhu = beizhu;
        UserId = userId;
        this.dKNumber = dKNumber;
        this.fatherExciseStart = fatherExciseStart;
        this.fatherExciseStop = fatherExciseStop;
        this.framarName = framarName;
        this.gainOutput = gainOutput;
        this.gainTime = gainTime;
        this.type = type;
        this.motherNO = motherNO;
        this.singlePlant = singlePlant;
        this.thousand = thousand;
        this.id = id;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getDKNumber() {
        return dKNumber;
    }

    public void setDKNumber(String dKNumber) {
        this.dKNumber = dKNumber;
    }

    public String getFatherExciseStart() {
        return fatherExciseStart;
    }

    public void setFatherExciseStart(String fatherExciseStart) {
        this.fatherExciseStart = fatherExciseStart;
    }

    public String getFatherExciseStop() {
        return fatherExciseStop;
    }

    public void setFatherExciseStop(String fatherExciseStop) {
        this.fatherExciseStop = fatherExciseStop;
    }

    public String getFramarName() {
        return framarName;
    }

    public void setFramarName(String framarName) {
        this.framarName = framarName;
    }

    public String getGainOutput() {
        return gainOutput;
    }

    public void setGainOutput(String gainOutput) {
        this.gainOutput = gainOutput;
    }

    public String getGainTime() {
        return gainTime;
    }

    public void setGainTime(String gainTime) {
        this.gainTime = gainTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMotherNO() {
        return motherNO;
    }

    public void setMotherNO(String motherNO) {
        this.motherNO = motherNO;
    }

    public String getSinglePlant() {
        return singlePlant;
    }

    public void setSinglePlant(String singlePlant) {
        this.singlePlant = singlePlant;
    }

    public String getThousand() {
        return thousand;
    }

    public void setThousand(String thousand) {
        this.thousand = thousand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GainBean{" +
                "beizhu='" + beizhu + '\'' +
                ", UserId='" + UserId + '\'' +
                ", dKNumber='" + dKNumber + '\'' +
                ", fatherExciseStart='" + fatherExciseStart + '\'' +
                ", fatherExciseStop='" + fatherExciseStop + '\'' +
                ", framarName='" + framarName + '\'' +
                ", gainOutput='" + gainOutput + '\'' +
                ", gainTime='" + gainTime + '\'' +
                ", type='" + type + '\'' +
                ", motherNO='" + motherNO + '\'' +
                ", singlePlant='" + singlePlant + '\'' +
                ", thousand='" + thousand + '\'' +
                ", id=" + id +
                '}';
    }
}
