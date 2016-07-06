package com.zb.bean;

/**
 * Created by Administrator on 2016/7/5.
 */
public class RogueBean {

    /**
     * UserId : da
     * beiZhu :
     * comeOutFather :
     * conmeOutMother :
     * dKNumber : 16JZYXX1xxx
     * fertility :
     * framarName : 张三1
     * type : 玉米
     * impurties :
     * lineRatio : 555
     * lineWidth : 55
     * rowFather : 555
     * rowMothers : 55
     * time : 2016-07-06
     * id : 22
     */

    private String UserId;
    private String beiZhu;
    private String comeOutFather;
    private String conmeOutMother;
    private String dKNumber;
    private String fertility;
    private String framarName;
    private String type;
    private String impurties;
    private String lineRatio;
    private String lineWidth;
    private String rowFather;
    private String rowMothers;
    private String time;
    private int id;

    public RogueBean() {
    }

    public RogueBean(String userId, String beiZhu, String comeOutFather, String conmeOutMother, String dKNumber, String fertility, String framarName, String type, String impurties, String lineRatio, String lineWidth, String rowFather, String rowMothers, String time, int id) {
        UserId = userId;
        this.beiZhu = beiZhu;
        this.comeOutFather = comeOutFather;
        this.conmeOutMother = conmeOutMother;
        this.dKNumber = dKNumber;
        this.fertility = fertility;
        this.framarName = framarName;
        this.type = type;
        this.impurties = impurties;
        this.lineRatio = lineRatio;
        this.lineWidth = lineWidth;
        this.rowFather = rowFather;
        this.rowMothers = rowMothers;
        this.time = time;
        this.id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getBeiZhu() {
        return beiZhu;
    }

    public void setBeiZhu(String beiZhu) {
        this.beiZhu = beiZhu;
    }

    public String getComeOutFather() {
        return comeOutFather;
    }

    public void setComeOutFather(String comeOutFather) {
        this.comeOutFather = comeOutFather;
    }

    public String getConmeOutMother() {
        return conmeOutMother;
    }

    public void setConmeOutMother(String conmeOutMother) {
        this.conmeOutMother = conmeOutMother;
    }

    public String getdKNumber() {
        return dKNumber;
    }

    public void setdKNumber(String dKNumber) {
        this.dKNumber = dKNumber;
    }

    public String getFertility() {
        return fertility;
    }

    public void setFertility(String fertility) {
        this.fertility = fertility;
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

    public String getImpurties() {
        return impurties;
    }

    public void setImpurties(String impurties) {
        this.impurties = impurties;
    }

    public String getLineRatio() {
        return lineRatio;
    }

    public void setLineRatio(String lineRatio) {
        this.lineRatio = lineRatio;
    }

    public String getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(String lineWidth) {
        this.lineWidth = lineWidth;
    }

    public String getRowFather() {
        return rowFather;
    }

    public void setRowFather(String rowFather) {
        this.rowFather = rowFather;
    }

    public String getRowMothers() {
        return rowMothers;
    }

    public void setRowMothers(String rowMothers) {
        this.rowMothers = rowMothers;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RogueBean{" +
                "comeOutFather='" + comeOutFather + '\'' +
                ", conmeOutMother='" + conmeOutMother + '\'' +
                ", dKNumber='" + dKNumber + '\'' +
                ", fertility='" + fertility + '\'' +
                ", framarName='" + framarName + '\'' +
                ", type='" + type + '\'' +
                ", impurties='" + impurties + '\'' +
                ", lineRatio='" + lineRatio + '\'' +
                ", lineWidth='" + lineWidth + '\'' +
                ", rowFather='" + rowFather + '\'' +
                ", rowMothers='" + rowMothers + '\'' +
                ", time='" + time + '\'' +
                ", id=" + id +
                ", beiZhu='" + beiZhu + '\'' +
                ", UserId='" + UserId + '\'' +
                '}';
    }
}
