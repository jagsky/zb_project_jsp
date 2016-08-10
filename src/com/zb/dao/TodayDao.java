package com.zb.dao;

import com.zb.bean.TodayBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * //作用：返回管理员要查询的对于日期的   日常信息
 * Created by Administrator on 2016/8/4.
 */
public class TodayDao {

    //获取特定日期的数据
    public List<TodayBean> queryTodayData(String date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = df.parse(date);
            System.out.println(parse.getTime() + "parse.getTime()");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TodayBean> beanList = new ArrayList<TodayBean>();
        Connection conn = SqlDataUtil.getConnection();
        //to_date(sysdate,'YYYY-MM-DAY')=to_date(updateTime,'YYYY-MM-DAY')
        // String sql = "SELECT * FROM TODAYDATA WHERE TODAYDATA_DATE=?";
        String sql = "SELECT * FROM TODAYDATA WHERE TODAYDATA_DATE=?";
        try {
            java.sql.Date date1 = new java.sql.Date(parse.getTime());
            ps = conn.prepareStatement(sql);
            ps.setDate(1, date1);
            rs = ps.executeQuery();
            System.out.println(rs.next());
            while (rs.next()) {
                TodayBean todayBean = new TodayBean();
                todayBean.setId(rs.getString(1));
                todayBean.setTime(rs.getString(2));
                todayBean.setContent(rs.getString(3));
                beanList.add(todayBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlDataUtil.close(conn, ps, rs);
        return beanList;
    }











   /* //获取特定日期的数据
    public List<TodayBean> queryTodayData(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateFormat.format(dateFormat);
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TodayBean> beanList = new ArrayList<TodayBean>();
        Connection conn = SqlDataUtil.getConnection();
        //to_date(sysdate,'YYYY-MM-DAY')=to_date(updateTime,'YYYY-MM-DAY')
        // String sql = "SELECT * FROM TODAYDATA WHERE TODAYDATA_DATE=?";
        String sql = "SELECT * FROM TODAYDATA WHERE TODAYDATA_DATE=?";
        //  "to_date(?,'YYYY-MM-DD')=to_date(TODAYDATA_DATE,'YYYY-MM-DD')";
        try {
            java.sql.Date date1 = new java.sql.Date(new Date().getTime());
            ps = conn.prepareStatement(sql);
            ps.setDate(1, );
            rs = ps.executeQuery();
            System.out.println(rs.next());
            while (rs.next()) {
                TodayBean todayBean = new TodayBean();
                todayBean.setUserName(rs.getString(1));
                todayBean.setTime(rs.getString(2));
                todayBean.setContent(rs.getString(3));
                todayBean.setDate(rs.getString(4));
                beanList.add(todayBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlDataUtil.close(conn, ps, rs);
        return beanList;
    }

    //获取特定日期的数据
    public List<TodayBean> queryT1odayData() {
        List<TodayBean> beanList = new ArrayList<TodayBean>();
        Connection conn = SqlDataUtil.getConnection();
        //to_date(sysdate,'YYYY-MM-DAY')=to_date(updateTime,'YYYY-MM-DAY')
        String sql = "SELECT * FROM TODAYDATA WHERE TODAYDATA_DATE=?";
        //ps.setDate(3, new java.sql.Date(new Date().getTime()));
        //  "to_date(?,'YYYY-MM-DD')=to_date(TODAYDATA_DATE,'YYYY-MM-DD')";
        try {
            java.sql.Date date = new java.sql.Date(new Date().getTime());
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            System.out.println(date.toString());
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return beanList;
    }*/
}
