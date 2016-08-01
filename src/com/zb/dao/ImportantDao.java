package com.zb.dao;

import com.zb.bean.ImportantBean;
import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 作用：重要信息数据库操作
 * Created by Administrator on 2016/7/29.
 */
public class ImportantDao {
    private void selectAllData() {
        ImportantBean importantBean = new ImportantBean();
        Connection conn = SqlDataUtil.getConnection();
        String sql = "";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
