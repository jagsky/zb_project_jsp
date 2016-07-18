package com.zb.bean;

/**
 * Created by Administrator on 2016/7/18.
 */
public class TechnicianBean {
    private String TechnicianName;
    private String TechnicianLetter;

    public TechnicianBean(String technicianName, String technicianLetter) {
        TechnicianName = technicianName;
        TechnicianLetter = technicianLetter;
    }

    public TechnicianBean() {
    }

    public String getTechnicianName() {
        return TechnicianName;
    }

    public void setTechnicianName(String technicianName) {
        TechnicianName = technicianName;
    }

    public String getTechnicianLetter() {
        return TechnicianLetter;
    }

    public void setTechnicianLetter(String technicianLetter) {
        TechnicianLetter = technicianLetter;
    }

    @Override
    public String toString() {
        return "TechnicianBean{" +
                "TechnicianName='" + TechnicianName + '\'' +
                ", TechnicianLetter='" + TechnicianLetter + '\'' +
                '}';
    }
}
