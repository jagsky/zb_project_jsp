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

    //添加农夫数据
    public void insertFarmer(FarmerBean farmerBean, String userIdCard) {
        boolean b = true;
        Connection conn = SqlDataUtil.getConnection();
        try {
            //insert into table1(field1,field2) values(value1,value2)
            String sql = "INSERT INTO FARMER VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userIdCard);
            ps.setString(2, farmerBean.getFarmerName());
            ps.setString(3, farmerBean.getDKnumber());
            ps.setString(4, farmerBean.getType());
            ps.setString(5, farmerBean.getBaseName());
            ps.setString(6, farmerBean.getHouse());
            ps.setString(7, farmerBean.getIdcard());
            ps.setString(8, farmerBean.getTemperature());
            ps.setString(9, farmerBean.getFarmer_voyages());
            ps.setString(10, farmerBean.getFarmer_manure());
            ps.setString(11, farmerBean.getFarmer_troopsname());
            ps.setString(12, farmerBean.getFarmer_yield());
            ps.setString(13, farmerBean.getFarmer_area());
            b = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(b);

    }


}
