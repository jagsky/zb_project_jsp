package com.zb.dao;

import com.zb.bean.SeedBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * //操作Seed表的工具类
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
        SqlDataUtil.close(conn, ps, rs);
        return s;

    }

    //如果返回的是false表示无此数据，则添加数据
    public boolean insertSeed(SeedBean seed) throws SQLException {
        // insert into table1(field1,field2) values(value1,value2)
        Connection conn = SqlDataUtil.getConnection();
        String userName = TechnicianDao.queryIdToUserName(seed.getUserId());
        String sql = "INSERT INTO SEED(USER_ID,FARMERNAME,DKNUMBER,TYPES,SEED_TIME,SEED_FATHER1,SEED_FATHER2,SEED_MOTHER," +
                "SEED_FATHERUSE,SEED_MOTHERUSE,SEED_BEUZHU) VALUES ('" +
                userName + "','" + seed.getFramarName() + "','" + seed.getDKNumber() + "','" + seed.getType() + "','"
                + seed.getSeedDate() + "','" + seed.getFather1() + "','" + seed.getFather2() + "','" + seed.getMother() + "','"
                + seed.getFatherUse() + "','" + seed.getMotherUse() + "','" + seed.getBeizhu() + "')";
        PreparedStatement ps = conn.prepareStatement(sql);
        boolean s = ps.execute();
        //关闭数据库链接
        SqlDataUtil.close(conn, ps);
        return s;
    }

    //如果返回的是true表示有数据。执行更新 如果返回0表示没有这一行，所以不成功，如果返回1则表示成功
    public int updateSeed(SeedBean seed) throws SQLException {
        Connection conn = SqlDataUtil.getConnection();
        //update table1 set field1=value1 where 范围
        String sql = "UPDATE SEED SET SEED_TIME=?,SEED_FATHER1=?,SEED_FATHER2=?,SEED_MOTHER=?," +
                "SEED_FATHERUSE=?,SEED_MOTHERUSE=?,SEED_BEUZHU=? WHERE DKNUMBER=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, seed.getSeedDate());
        ps.setString(2, seed.getFather1());
        ps.setString(3, seed.getFather2());
        ps.setString(4, seed.getMother());
        ps.setString(5, seed.getFatherUse());
        ps.setString(6, seed.getMotherUse());
        ps.setString(7, seed.getBeizhu());
        ps.setString(8, seed.getDKNumber());
        int i = ps.executeUpdate();
        SqlDataUtil.close(conn, ps);
        return i;

    }

    //通过UserId查询此技术员应有的记录
    public List<SeedBean> querySeed(String userId) {
        List<SeedBean> seedBeanList = new ArrayList<SeedBean>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM SEED WHERE USER_ID=? ";
        conn = SqlDataUtil.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                SeedBean seed = new SeedBean();
                seed.setUserId(rs.getString(1));
                seed.setFramarName(rs.getString(2));
                seed.setDKNumber(rs.getString(3));
                seed.setType(rs.getString(4));
                seed.setSeedDate(rs.getString(5));
                seed.setFather1(rs.getString(6));
                seed.setFather2(rs.getString(7));
                seed.setMother(rs.getString(8));
                seed.setFatherUse(rs.getString(9));
                seed.setMotherUse(rs.getString(10));
                seed.setBeizhu(rs.getString(11));
                seedBeanList.add(seed);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seedBeanList;
    }


}
