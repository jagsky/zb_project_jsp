package com.zb.bean;

/**
 * Created by Administrator on 2016/7/5.
 */
public class CastrationBean {

    /**
     * UserId : da
     * content :
     * dKNumber : 16JZYXX0xxx
     * fatherLoose :
     * framarName : 张三0
     * type : 玉米
     * inspectTime : 2016-07-06
     * motherExtract : 555
     * motherExtractTime : 2016-07-06
     * motherLoose :
     * motherNoCastration : fff
     * startTime : 2016-07-06
     * id : 22
     */

    private String UserId;
    private String content;
    private String dKNumber;
    private String fatherLoose;
    private String framarName;
    private String type;
    private String inspectTime;
    private String motherExtract;
    private String motherExtractTime;
    private String motherLoose;
    private String motherNoCastration;
    private String startTime;
    private int id;

    public CastrationBean() {
    }

    public CastrationBean(String userId, String content, String dKNumber, String fatherLoose, String framarName, String type, String inspectTime, String motherExtract, String motherExtractTime, String motherLoose, String motherNoCastration, String startTime) {
        UserId = userId;
        this.content = content;
        this.dKNumber = dKNumber;
        this.fatherLoose = fatherLoose;
        this.framarName = framarName;
        this.type = type;
        this.inspectTime = inspectTime;
        this.motherExtract = motherExtract;
        this.motherExtractTime = motherExtractTime;
        this.motherLoose = motherLoose;
        this.motherNoCastration = motherNoCastration;
        this.startTime = startTime;
    }

    public CastrationBean(String userId, String content, String dKNumber, String fatherLoose, String framarName, String type, String inspectTime, String motherExtract, String motherExtractTime, String motherLoose, String motherNoCastration, String startTime, int id) {
        UserId = userId;

        this.content = content;
        this.dKNumber = dKNumber;
        this.fatherLoose = fatherLoose;
        this.framarName = framarName;
        this.type = type;
        this.inspectTime = inspectTime;
        this.motherExtract = motherExtract;
        this.motherExtractTime = motherExtractTime;
        this.motherLoose = motherLoose;
        this.motherNoCastration = motherNoCastration;
        this.startTime = startTime;
        this.id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDKNumber() {
        return dKNumber;
    }

    public void setDKNumber(String dKNumber) {
        this.dKNumber = dKNumber;
    }

    public String getFatherLoose() {
        return fatherLoose;
    }

    public void setFatherLoose(String fatherLoose) {
        this.fatherLoose = fatherLoose;
    }

    public String getFramarName() {
        return framarName;
    }

    public void setFramarName(String framarName) {
        this.framarName = framarName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInspectTime() {
        return inspectTime;
    }

    public void setInspectTime(String inspectTime) {
        this.inspectTime = inspectTime;
    }

    public String getMotherExtract() {
        return motherExtract;
    }

    public void setMotherExtract(String motherExtract) {
        this.motherExtract = motherExtract;
    }

    public String getMotherExtractTime() {
        return motherExtractTime;
    }

    public void setMotherExtractTime(String motherExtractTime) {
        this.motherExtractTime = motherExtractTime;
    }

    public String getMotherLoose() {
        return motherLoose;
    }

    public void setMotherLoose(String motherLoose) {
        this.motherLoose = motherLoose;
    }

    public String getMotherNoCastration() {
        return motherNoCastration;
    }

    public void setMotherNoCastration(String motherNoCastration) {
        this.motherNoCastration = motherNoCastration;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
