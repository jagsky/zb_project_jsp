package com.zb.dao;

import com.zb.bean.ImportantBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 作用：重要信息数据库操作
 * Created by Administrator on 2016/7/29.
 */
public class ImportantDao {
    public void insertLineData(ImportantBean importantBean) {
        String userName = TechnicianDao.queryIdToUserName(importantBean.getUserName());
        Connection conn = SqlDataUtil.getConnection();
        String sql = "INSERT INTO IMPORTANT VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, importantBean.getDate());
            ps.setString(3, importantBean.getProvince());
            ps.setString(4, importantBean.getCity());
            ps.setString(5, importantBean.getCounty());
            ps.setString(6, importantBean.getTown());
            ps.setString(7, importantBean.getVillage());
            ps.setString(8, importantBean.getContenttype());
            ps.setString(9, importantBean.getContent());
            ps.setString(10, importantBean.getTitle());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
