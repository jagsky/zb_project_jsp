package com.zb.dao;

import com.zb.bean.SeedBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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


}
