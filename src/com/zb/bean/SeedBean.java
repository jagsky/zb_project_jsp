package com.zb.bean;

/**
 * Created by Administrator on 2016/7/5.
 */
public class SeedBean {

    /**
     * beizhu :
     * dKNumber : 16JZYXX12xxx
     * father1 : 2016-07-06
     * father2 : 2016-07-06
     * fatherUse : hjjj
     * framarName : 张三12
     * mother : 2016-07-06
     * motherUse :
     * seedDate : 2016-07-06
     * userId : da
     * type : 玉米
     * seed_id : 33
     */

    private String beizhu;
    private String dKNumber;
    private String father1;
    private String father2;
    private String fatherUse;
    private String framarName;
    private String mother;
    private String motherUse;
    private String seedDate;
    private String userId;
    private String type;
    private int seed_id;

    public SeedBean() {
    }

    public SeedBean(String beizhu, String dKNumber, String father1, String father2, String fatherUse, String framarName, String mother, String motherUse, String seedDate, String userId, String type) {
        this.beizhu = beizhu;
        this.dKNumber = dKNumber;
        this.father1 = father1;
        this.father2 = father2;
        this.fatherUse = fatherUse;
        this.framarName = framarName;
        this.mother = mother;
        this.motherUse = motherUse;
        this.seedDate = seedDate;
        this.userId = userId;
        this.type = type;
    }

    public SeedBean(String beizhu, String dKNumber, String father1, String father2, String fatherUse, String framarName, String mother, String motherUse, String seedDate, String userId, String type, int seed_id) {
        this.beizhu = beizhu;
        this.dKNumber = dKNumber;
        this.father1 = father1;
        this.father2 = father2;
        this.fatherUse = fatherUse;
        this.framarName = framarName;
        this.mother = mother;
        this.motherUse = motherUse;
        this.seedDate = seedDate;
        this.userId = userId;
        this.type = type;
        this.seed_id = seed_id;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getDKNumber() {
        return dKNumber;
    }

    public void setDKNumber(String dKNumber) {
        this.dKNumber = dKNumber;
    }

    public String getFather1() {
        return father1;
    }

    public void setFather1(String father1) {
        this.father1 = father1;
    }

    public String getFather2() {
        return father2;
    }

    public void setFather2(String father2) {
        this.father2 = father2;
    }

    public String getFatherUse() {
        return fatherUse;
    }

    public void setFatherUse(String fatherUse) {
        this.fatherUse = fatherUse;
    }

    public String getFramarName() {
        return framarName;
    }

    public void setFramarName(String framarName) {
        this.framarName = framarName;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getMotherUse() {
        return motherUse;
    }

    public void setMotherUse(String motherUse) {
        this.motherUse = motherUse;
    }

    public String getSeedDate() {
        return seedDate;
    }

    public void setSeedDate(String seedDate) {
        this.seedDate = seedDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeed_id() {
        return seed_id;
    }

    public void setSeed_id(int seed_id) {
        this.seed_id = seed_id;
    }

    @Override
    public String toString() {
        return "SeedBean{" +
                "beizhu='" + beizhu + '\'' +
                ", dKNumber='" + dKNumber + '\'' +
                ", father1='" + father1 + '\'' +
                ", father2='" + father2 + '\'' +
                ", fatherUse='" + fatherUse + '\'' +
                ", framarName='" + framarName + '\'' +
                ", mother='" + mother + '\'' +
                ", motherUse='" + motherUse + '\'' +
                ", seedDate='" + seedDate + '\'' +
                ", userId='" + userId + '\'' +
                ", type='" + type + '\'' +
                ", seed_id=" + seed_id +
                '}';
    }
}
