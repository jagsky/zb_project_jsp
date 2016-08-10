package com.zb.dao;

import com.zb.bean.EverydayBean;
import com.zb.bean.TodayBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * 作用：添加  技术员发送过来的日常信息  保存到数据库中
 * Created by Administrator on 2016/7/25.
 */
public class EverydayDao {
    //插入数据
    public int insertData(EverydayBean everydayBean) {
        Connection conn = SqlDataUtil.getConnection();
        //通过ID去 Technician表中查询对应的技术员姓名 保存到 日常信息 这样表中
        String userName = TechnicianDao.queryIdToUserName(everydayBean.getUserName());
        String sql = "INSERT INTO TODAYDATA VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println(everydayBean.getUserName());
            ps.setString(1, userName);
            ps.setString(2, everydayBean.getTime());
            ps.setString(3, everydayBean.getContent());
            ps.setDate(4, new java.sql.Date(new Date().getTime()));
            boolean execute = ps.execute();
            SqlDataUtil.close(conn, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1;
    }

    //添加技术员发过来的每日信息，记得把发过来的ID去技术员表中修改成名字添加进去
    public void insertTodayData(EverydayBean everydayBean) {
        String userName = TechnicianDao.queryIdToUserName(everydayBean.getUserName());
        Connection conn = SqlDataUtil.getConnection();
        PreparedStatement ps;
        String sql = "INSERT INTO TODAYDATA VALUES (?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, everydayBean.getTime());
            ps.setString(3, everydayBean.getContent());
            ps.setDate(4, new java.sql.Date(new Date().getTime()));
            ps.execute();
            SqlDataUtil.close(conn, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void queryTodayData() {
        EverydayBean everydayBean = new EverydayBean();
        Connection conn = SqlDataUtil.getConnection();
        String sql = "";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
