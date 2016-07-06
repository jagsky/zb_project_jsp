package com.zb.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 2016/7/5.
 */
public class SqlDataUtil {
    //编写一个静态块，目的是为了导入驱动类
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //编写静态的方法，获得连接。
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "a275139314", "a6820483");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(PreparedStatement pst, Connection conn) {
        try {
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void close(ResultSet rs, PreparedStatement pst, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}