package com.zb.dao;

import com.zb.bean.CastrationBean;
import com.zb.bean.SeedBean;
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
        String userName = TechnicianDao.queryIdToUserName(castration.getUserId());
        Connection conn = SqlDataUtil.getConnection();
        String sql = "INSERT INTO CASTRATION VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
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

    public int updateCastration(CastrationBean castration) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        //update table1 set field1=value1 where 范围
        String sql = "UPDATE CASTRATION SET CASTRATION_STARTTIME=?,CASTRATION_MOTHEREXTRACTTIME=?,CASTRATION_INSPECTTIME=?,CASTRATION_MOTHERNOCASTRATION=?," +
                "CASTRATION_MOTHEREXTRACT=?,CASTRATION_MOTHERLOOSE=?,CASTRATION_FATHERLOOSE=?,CASTRATION_BEIZHU=? WHERE DKNUMBER=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, castration.getStartTime());
        ps.setString(2, castration.getMotherExtractTime());
        ps.setString(3, castration.getInspectTime());
        ps.setString(4, castration.getMotherNoCastration());
        ps.setString(5, castration.getMotherExtract());
        ps.setString(6, castration.getMotherLoose());
        ps.setString(7, castration.getFatherLoose());
        ps.setString(8, castration.getContent());
        ps.setString(9, castration.getDKNumber());
        int i = ps.executeUpdate();
        SqlDataUtil.close(conn, ps);
        return i;
    }

    //通过Userid去查询对应表中的情况
    public   List<CastrationBean> queryCastration(String userId) {
        List<CastrationBean> castrationBeanList = new ArrayList<CastrationBean>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM CASTRATION WHERE USER_ID=? ";
        conn = SqlDataUtil.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                CastrationBean castrationBean = new CastrationBean();
                castrationBean.setUserId(rs.getString(1));
                castrationBean.setFramarName(rs.getString(2));
                castrationBean.setDKNumber(rs.getString(3));
                castrationBean.setType(rs.getString(4));
                castrationBean.setStartTime(rs.getString(5));
                castrationBean.setMotherExtractTime(rs.getString(6));
                castrationBean.setInspectTime(rs.getString(7));
                castrationBean.setMotherNoCastration(rs.getString(8));
                castrationBean.setMotherExtract(rs.getString(9));
                castrationBean.setMotherLoose(rs.getString(10));
                castrationBean.setFatherLoose(rs.getString(11));
                castrationBean.setContent(rs.getString(12));
                castrationBeanList.add(castrationBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlDataUtil.close(conn, ps, rs);

        return castrationBeanList;
    }
}
