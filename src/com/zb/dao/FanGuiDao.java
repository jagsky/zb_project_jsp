package com.zb.dao;

import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/8/23.
 */
public class FanGuiDao {
    public void inserFanGui(String str1, String str2) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO FANGUI VALUES (?,?)";
        //INSERT INTO GAIN VALUES (?,?,?,?,?,?,?,?,?,?,?,?)
        conn = SqlDataUtil.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, str1);
            ps.setString(2, str2);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlDataUtil.close(conn, ps);

    }
}
