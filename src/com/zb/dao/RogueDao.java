package com.zb.dao;

import com.zb.bean.CastrationBean;
import com.zb.bean.RogueBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * //去杂表 操作类
 * Created by Administrator on 2016/7/6.
 */
public class RogueDao {
    //1.判断数据库中是否已经存在这个地块号了
    public boolean queryDK(String DKnumber) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        String sql = "select DKNUMBER from Rogue where DKNUMBER =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, DKnumber);
        ResultSet rs = ps.executeQuery();
        boolean s = rs.next();
        SqlDataUtil.close(conn, ps, rs);
        return s;
    }

    //插入一行数据
    //如果返回的是false表示无此数据，则添加数据
    public boolean insertRogue(RogueBean rogue) throws SQLException {
        String userName = TechnicianDao.queryIdToUserName(rogue.getUserId());
        // insert into table1(field1,field2) values(value1,value2)
        Connection conn = SqlDataUtil.getConnection();
        //(USER_ID,FARMERNAME,DKNUMBER,TYPES,ROGUE_TIME,ROGUE_ROWFATHER,ROGUE_ROWMOTHERS,ROGUE_LINEWIDTH," +
        // "ROGUE_LINERATIO,ROGUE_COMEOUTFATHER,ROGUE_CONMEOUTMOTHER,ROGUE_IMPURTIES,ROGUE_FERTILITY,ROGUE_BEIZHU)
        String sql = "INSERT INTO ROGUE (USER_ID,FARMERNAME,DKNUMBER,TYPES,ROGUE_TIME,ROGUE_ROWFATHER,ROGUE_ROWMOTHERS,ROGUE_LINEWIDTH," +
                "ROGUE_LINERATIO,ROGUE_COMEOUTFATHER,ROGUE_CONMEOUTMOTHER,ROGUE_IMPURTIES,ROGUE_FERTILITY,ROGUE_BEIZHU) VALUES ('"
                + userName + "','" + rogue.getFramarName() + "','" + rogue.getdKNumber() + "','" + rogue.getType() + "','"
                + rogue.getTime() + "','" + rogue.getRowFather() + "','" + rogue.getRowMothers() + "','" + rogue.getLineWidth() + "','"
                + rogue.getLineRatio() + "','" + rogue.getComeOutFather() + "','" + rogue.getConmeOutMother() + "','" + rogue.getImpurties() + "','" +
                rogue.getFertility() + "','" + rogue.getBeiZhu() + "')";
        PreparedStatement ps = conn.prepareStatement(sql);
        boolean s = ps.execute();
        //关闭数据库链接
        SqlDataUtil.close(conn, ps);
        return s;
    }


    //如果返回的是true表示有数据。执行更新 如果返回1表示没有这一行，所以不成功，如果返回1则表示成功
    public int updateSeed(RogueBean rogue) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        //update table1 set field1=value1 where 范围
        String sql = "UPDATE ROGUE SET ROGUE_TIME=?,ROGUE_ROWFATHER=?,ROGUE_ROWMOTHERS=?,ROGUE_LINEWIDTH=?," +
                "ROGUE_LINERATIO=?,ROGUE_COMEOUTFATHER=?,ROGUE_CONMEOUTMOTHER=?,ROGUE_IMPURTIES=?, ROGUE_FERTILITY=?," +
                "ROGUE_BEIZHU=? WHERE DKNUMBER=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, rogue.getTime());
        ps.setString(2, rogue.getRowFather());
        ps.setString(3, rogue.getRowMothers());
        ps.setString(4, rogue.getLineWidth());
        ps.setString(5, rogue.getLineRatio());
        ps.setString(6, rogue.getComeOutFather());
        ps.setString(7, rogue.getConmeOutMother());
        ps.setString(8, rogue.getImpurties());
        ps.setString(9, rogue.getFertility());
        ps.setString(10, rogue.getBeiZhu());
        ps.setString(11, rogue.getdKNumber());
        int i = ps.executeUpdate();
        SqlDataUtil.close(conn, ps);
        return i;

    }

    public List<RogueBean> queryRogue(String userId) {
        List<RogueBean> rogueBeanList = new ArrayList<RogueBean>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ROGUE WHERE USER_ID=? ";
        conn = SqlDataUtil.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                RogueBean rogueBean = new RogueBean();
                rogueBean.setUserId(rs.getString(1));
                rogueBean.setFramarName(rs.getString(2));
                rogueBean.setdKNumber(rs.getString(3));
                rogueBean.setType(rs.getString(4));
                rogueBean.setTime(rs.getString(5));
                rogueBean.setRowFather(rs.getString(6));
                rogueBean.setRowMothers(rs.getString(7));
                rogueBean.setLineWidth(rs.getString(8));
                rogueBean.setLineRatio(rs.getString(9));
                rogueBean.setComeOutFather(rs.getString(10));
                rogueBean.setConmeOutMother(rs.getString(11));
                rogueBean.setImpurties(rs.getString(12));
                rogueBean.setFertility(rs.getString(13));
                rogueBean.setBeiZhu(rs.getString(14));
                rogueBeanList.add(rogueBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rogueBeanList;
    }
}
