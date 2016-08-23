package com.zb.dao;

import com.zb.bean.ImportantBean;
import com.zb.bean.ImportantTitleBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作用：重要信息数据库操作
 * Created by Administrator on 2016/7/29.
 */
public class ImportantDao {
    public void insertLineData(ImportantBean importantBean) {
        String userName = TechnicianDao.queryIdToUserName(importantBean.getUserName());
        Connection conn = SqlDataUtil.getConnection();
        String sql = "INSERT INTO IMPORTANT VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, importantBean.getDate());
            ps.setString(3, importantBean.getProvince());
            ps.setString(4, importantBean.getCity());
            ps.setString(5, importantBean.getCounty());
            ps.setString(6, importantBean.getTown());
            ps.setString(7, importantBean.getVillage());
            ps.setString(8, importantBean.getContenttype());
            ps.setString(9, importantBean.getContent());
            ps.setString(10, importantBean.getTitle());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SqlDataUtil.close(conn, ps);
    }


    public List<ImportantTitleBean> queryImportantTitle() {
        List<ImportantTitleBean> importantBeanList = new ArrayList<ImportantTitleBean>();
        ImportantTitleBean importantBean = null;
        Connection conn = SqlDataUtil.getConnection();
        String sql = "SELECT  IMPORTANT_USERNAME,IMPORTANT_DATE,IMPORTANT_TITLE  FROM IMPORTANT";
        //select top (10) * from table1 where 1=1
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                importantBean = new ImportantTitleBean();
                String str = rs.getString(1);
                importantBean.setUserId(str);
                importantBean.setUserName(TechnicianDao.queryIdToUserName(str));
                importantBean.setDate(rs.getString(2));
                importantBean.setTitle(rs.getString(3));
                importantBeanList.add(importantBean);
            }
            SqlDataUtil.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return importantBeanList;
    }


    public List<ImportantBean> queryImportant() {
        List<ImportantBean> importantBeanList = new ArrayList<ImportantBean>();
        ImportantBean importantBean = null;
        Connection conn = SqlDataUtil.getConnection();
        String sql = "SELECT  *  FROM IMPORTANT";
        //select top (10) * from table1 where 1=1
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                importantBean = new ImportantBean();
                importantBean.setUserName(TechnicianDao.queryIdToUserName(rs.getString(1)));
                importantBean.setDate(rs.getString(2));
                importantBean.setProvince(rs.getString(3));
                importantBean.setCity(rs.getString(4));
                importantBean.setCounty(rs.getString(5));
                importantBean.setTown(rs.getString(6));
                importantBean.setVillage(rs.getString(7));
                importantBean.setContenttype(rs.getString(8));
                importantBean.setContent(rs.getString(9));
                importantBean.setTitle(rs.getString(10));
                importantBeanList.add(importantBean);
            }
            SqlDataUtil.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return importantBeanList;
    }

}
