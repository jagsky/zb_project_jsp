package com.zb.dao;

import com.zb.bean.TechnicianBean;
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
    public List<TechnicianBean> queryTechnicianName() throws SQLException {
        List<TechnicianBean> list = new ArrayList<TechnicianBean>();
        Connection conn = SqlDataUtil.getConnection();
        String sql = "select USER_NAME,USER_BASENUMBER, USER_LETTER from TECHNICIAN";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            TechnicianBean technicianBean = new TechnicianBean();
            technicianBean.setTechnicianName(rs.getString(1) + "(" + rs.getString(2) + ")");
            technicianBean.setTechnicianLetter(rs.getString(3));
            list.add(technicianBean);
        }
        SqlDataUtil.close(conn, ps, rs);
        return list;

    }

}
