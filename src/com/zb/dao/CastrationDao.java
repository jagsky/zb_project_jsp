package com.zb.dao;

import com.zb.bean.CastrationBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/6.
 */
public class CastrationDao {
    //1.判断数据库中是否已经存在这个地块号了
    public boolean queryDK(String DKnumber) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        String sql = "select DKNUMBER from Castration where DKNUMBER =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, DKnumber);
        ResultSet rs = ps.executeQuery();
        boolean s = rs.next();
        SqlDataUtil.close(conn, ps, rs);
        return s;
    }

    public boolean insertCastration(CastrationBean castration) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        String sql = "INSERT INTO CASTRATION VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, castration.getUserId());
        ps.setString(2, castration.getFramarName());
        ps.setString(3, castration.getDKNumber());
        ps.setString(4, castration.getType());
        ps.setString(5, castration.getStartTime());
        ps.setString(6, castration.getMotherExtractTime());
        ps.setString(7, castration.getInspectTime());
        ps.setString(8, castration.getMotherNoCastration());
        ps.setString(9, castration.getMotherExtract());
        ps.setString(10, castration.getMotherLoose());
        ps.setString(11, castration.getFatherLoose());
        ps.setString(12, castration.getContent());
        boolean s = ps.execute();
        SqlDataUtil.close(conn, ps);
        return s;
    }
}
