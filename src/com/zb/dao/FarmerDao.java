package com.zb.dao;

import com.zb.bean.FarmerBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/5.
 */
public class FarmerDao {
    //通过UserID查询，返回农户的基本信息
    public List queryDK(String userId) throws SQLException {
        List<FarmerBean> list = new ArrayList<FarmerBean>();
        Connection conn = SqlDataUtil.getConnection();
        String sql = "select * from Farmer where USER_ID =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            FarmerBean farmerBean = new FarmerBean();
            farmerBean.setFarmerName(rs.getString(1));
            farmerBean.setDKnumber(rs.getString(2));
            farmerBean.setType(rs.getString(3));
            list.add(farmerBean);
        }

        SqlDataUtil.close(conn, ps, rs);
        return list;
    }


}
