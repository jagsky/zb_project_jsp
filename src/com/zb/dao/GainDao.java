package com.zb.dao;

import com.zb.bean.GainBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/6.
 */
public class GainDao {
    //1.判断数据库中是否已经存在这个地块号了
    public boolean queryDK(String DKnumber) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        String sql = "select DKNUMBER from Gain where DKNUMBER =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, DKnumber);
        ResultSet rs = ps.executeQuery();
        boolean s = rs.next();
        SqlDataUtil.close(conn, ps, rs);
        return s;
    }
    public boolean insertGain(GainBean gain) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        String sql = "INSERT INTO GAIN VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, gain.getUserId());
        ps.setString(2, gain.getFramarName());
        ps.setString(3, gain.getDKNumber());
        ps.setString(4, gain.getType());
        ps.setString(5, gain.getMotherNO());
        ps.setString(6, gain.getSinglePlant());
        ps.setString(7, gain.getThousand());
        ps.setString(8, gain.getFatherExciseStart());
        ps.setString(9, gain.getFatherExciseStop());
        ps.setString(10, gain.getGainTime());
        ps.setString(11, gain.getGainOutput());
        ps.setString(12, gain.getBeizhu());
        boolean s = ps.execute();
        SqlDataUtil.close(conn, ps);
        return s;
    }
}
