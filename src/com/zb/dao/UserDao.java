package com.zb.dao;

import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 作用：从数据库中提取数据，判断技术员的ID 密码是否正确
 * Created by Administrator on 2016/7/8.
 */
public class UserDao {
    //查询此id是否存在？
    public boolean queryIdCard(String id) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        String sql = "SELECT USER_IDCARD FROM TECHNICIAN WHERE USER_IDCARD=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        boolean s = rs.next();
        SqlDataUtil.close(conn, ps, rs);
        return s;
    }

    //1.如果存在则在判断账户姓名与密码是否存在 如果存在则返回2，表示已注册
    //如何还没有生成账号，则返回1表示注册成功，反正返回0
    public boolean queryUserId(String userId) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        String sql = "SELECT  USER_ID FROM TECHNICIAN WHERE USER_ID=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, userId);
        ResultSet rs = ps.executeQuery();
        boolean s = rs.next();
        SqlDataUtil.close(conn, ps, rs);
        return s;
    }

    //如果没有数据，则更新这一行数据数据，添加用户 密码
    public int insertUserIdAndPassword(String userId, String password, String idCard) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        //update table1 set field1=value1 where 范围
        String sql = "UPDATE TECHNICIAN SET USER_ID=?,USER_PSD=? WHERE USER_IDCARD=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, userId);
        ps.setString(2, password);
        ps.setString(3, idCard);
        int i = ps.executeUpdate();
        return i;
    }

    //通过id查询idcard
    public String idQueryidCard(String Userid) throws SQLException {
        String idCard = null;
        Connection conn = SqlDataUtil.getConnection();
        String sql = "SELECT USER_IDCARD FROM TECHNICIAN WHERE USER_ID=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, Userid);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            idCard = rs.getString(1);
        }
        return idCard;
    }
}
