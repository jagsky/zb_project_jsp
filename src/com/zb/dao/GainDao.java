package com.zb.dao;

import com.zb.bean.CastrationBean;
import com.zb.bean.GainBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String userName = TechnicianDao.queryIdToUserName(gain.getUserId());
        String sql = "INSERT INTO GAIN VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
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

    public int updateGain(GainBean gain) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        //update table1 set field1=value1 where 范围
        String sql = "UPDATE GAIN SET GAIN_MOTHERNO=?,GIAN_SINGLEPLANT=?,GAIN_THOUSAND=?,GAIN_FATHEREXCISESTART=?," +
                "GAIN_FATHEREXCISESTOP=?,GAIN_GAINTIME=?,GAIN_GAINOUTPUT=?,GAIN_BEIZHU=? WHERE DKNUMBER=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, gain.getMotherNO());
        ps.setString(2, gain.getSinglePlant());
        ps.setString(3, gain.getThousand());
        ps.setString(4, gain.getFatherExciseStart());
        ps.setString(5, gain.getFatherExciseStop());
        ps.setString(6, gain.getGainTime());
        ps.setString(7, gain.getGainOutput());
        ps.setString(8, gain.getBeizhu());
        ps.setString(9, gain.getDKNumber());
        int i = ps.executeUpdate();
        SqlDataUtil.close(conn, ps);
        return i;
    }

    public List<GainBean> queryGain(String userId) {
        List<GainBean> gainBeanList = new ArrayList<GainBean>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM GAIN WHERE USER_ID=? ";
        conn = SqlDataUtil.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                GainBean gainBean = new GainBean();
                gainBean.setUserId(rs.getString(1));
                gainBean.setFramarName(rs.getString(2));
                gainBean.setDKNumber(rs.getString(3));
                gainBean.setType(rs.getString(4));
                gainBean.setMotherNO(rs.getString(5));
                gainBean.setSinglePlant(rs.getString(6));
                gainBean.setThousand(rs.getString(7));
                gainBean.setFatherExciseStart(rs.getString(8));
                gainBean.setFatherExciseStop(rs.getString(9));
                gainBean.setGainTime(rs.getString(10));
                gainBean.setGainOutput(rs.getString(11));
                gainBean.setBeizhu(rs.getString(12));
                gainBeanList.add(gainBean);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlDataUtil.close(conn, ps, rs);
        return gainBeanList;
    }


}
