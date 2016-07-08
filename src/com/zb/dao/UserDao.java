package com.zb.dao;

import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/8.
 */
public class UserDao {
    //查询身份证是否存在
    public boolean queryIdCard(String idCard) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        String sql = "";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, idCard);
        ResultSet rs = ps.executeQuery();
        boolean s = rs.next();
        return s;
    }
}
