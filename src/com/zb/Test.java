package com.zb;

import com.zb.bean.FarmerBean;
import com.zb.dao.FarmerDao;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        for (int i = 0; i < 5; i++) {
            FarmerBean farmerBean = new FarmerBean("430421199208245758", "常米", "16CYL0100" + i, "玉米", "甘肃", "18173470825", "43042111111", "sss", "sddd", "ddd", "zzz", "xxx", "ccc");
            FarmerDao farmerDao = new FarmerDao();
            farmerDao.insertFarmer(farmerBean, farmerBean.getUserIdCard());
        }


    }

}
