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
    public List<City> queryTechnicianName() throws SQLException {
        List<City> list = new ArrayList<City>();
        Connection conn = SqlDataUtil.getConnection();
        String sql = "select USER_NAME,USER_BASENUMBER, USER_LETTER from TECHNICIAN";
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

}
