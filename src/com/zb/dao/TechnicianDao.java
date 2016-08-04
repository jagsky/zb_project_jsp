package com.zb.dao;

import com.zb.bean.City;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/18.
 */
public class TechnicianDao {
    //查询所有技术员的数据
    public List<City> queryTechnicianName() throws SQLException {
        List<City> list = new ArrayList<City>();
        Connection conn = SqlDataUtil.getConnection();
        String sql = "select USER_NAME,USER_BASENUMBER, USER_LETTER from TECHNICIAN ORDER BY NLSSORT(USER_LETTER,'NLS_SORT = SCHINESE_PINYIN_M')";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            City technicianBean = new City();
            technicianBean.setCityName(rs.getString(1) + "(" + rs.getString(2) + ")");
            technicianBean.setFirstLetter(rs.getString(3));
            list.add(technicianBean);
        }
        SqlDataUtil.close(conn, ps, rs);
        return list;

    }

    //通过ID查询技术员的姓名
    public static String queryIdToUserName(String id) {
        String userName = null;
        Connection conn = SqlDataUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT USER_NAME FROM TECHNICIAN WHERE USER_ID = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                userName = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userName;
    }

}
