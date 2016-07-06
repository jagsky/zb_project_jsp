package com.zb.dao;

import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/6.
 */
public class SeedDao {
    //1.判断数据库中是否已经存在这个地块号了
    public boolean queryDK(String DKnumber) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        String sql = "select DKNUMBER from SEED where DKNUMBER =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, DKnumber);
        ResultSet rs = ps.executeQuery();
        boolean s = rs.next();
        return s;
    }
    //如果返回的是false表示无此数据，则添加数据

    //如果返回的是true表示有数据，执行更新

}
