package com.zb.dao;

import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/8/4.
 */
public class TodayDao {


    //获取特定日期的数据
    public void getTodayData(String date) {
        Connection conn = SqlDataUtil.getConnection();
        String sql = "SELECT * FROM TODAYDATA WHERE TODAYDATA_DATE =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
