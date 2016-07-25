package com.zb.dao;

import com.zb.bean.EverydayBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/25.
 */
public class EverydayDao {
    //插入数据
    public int insertData(EverydayBean everydayBean) {
        everydayBean = new EverydayBean();
        Connection conn = SqlDataUtil.getConnection();
        String sql = "INSERT INTO TODAYDATA VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, everydayBean.getUserName());
            ps.setString(2, everydayBean.getTime());
            ps.setString(3, everydayBean.getContent());
            boolean execute = ps.execute();
            SqlDataUtil.close(conn, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1;
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
