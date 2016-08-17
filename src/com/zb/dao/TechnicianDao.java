package com.zb.dao;

import com.zb.bean.City;
import com.zb.bean.Technician;
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
    private String id;
    private String password;

    public TechnicianDao() {
    }

    public TechnicianDao(String id, String password) {
        this.id = id;
        this.password = password;
    }

    //查询所有技术员 USER_NAME,USER_BASENUMBER, USER_LETTER这三列数据数据
    public List<City> queryTechnicianName() throws SQLException {
        List<City> list = new ArrayList<City>();
        Connection conn = SqlDataUtil.getConnection();
        String sql = "select USER_NAME,USER_BASENUMBER, USER_LETTER from TECHNICIAN ORDER BY NLSSORT(USER_LETTER,'NLS_SORT = SCHINESE_PINYIN_M')";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            City technicianBean = new City();
            technicianBean.setCityName(rs.getString(1) + "[" + rs.getString(2) + "]");
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


    //1.查询此ID是否存在
    public boolean queryId() {
        boolean next = false;
        Connection conn = SqlDataUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT USER_ID FROM TECHNICIAN WHERE USER_ID=? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            next = rs.next();
            System.out.println("next" + next);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlDataUtil.close(conn, ps, rs);
        return next;
    }

    //2.如果id存在则判断密码
    public boolean queryPassword() {
        boolean ispassword = false;
        Connection conn = SqlDataUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT USER_PSD FROM TECHNICIAN WHERE USER_ID=? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            boolean next = rs.next();

            if (next) {

                String password1 = rs.getString(1);
                System.out.println(password1);
                //如果返回的数据为空
                if (password1 == null) {
                    System.out.println("密码添加成功");
                    insertPassword();
                    ispassword = true;

                } else {
                    boolean equals = password.equals(password1);
                    if (equals) {
                        System.out.println("密码正确");
                        ispassword = true;
                    } else {
                        System.out.println("密码错误");
                        ispassword = false;
                        System.out.println("");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlDataUtil.close(conn, ps, rs);
        return ispassword;
    }

    private void insertPassword() {
        Connection conn = SqlDataUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE TECHNICIAN SET USER_PSD=? WHERE USER_ID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, id);
            ps.execute();
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(Technician technician) {
        Connection conn = SqlDataUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO TECHNICIAN VALUES(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, technician.getUserName());
            ps.setString(2, technician.getUserid());
            ps.setString(3, technician.getPad());
            ps.setString(4, technician.getBaseMunber());
            ps.setString(5, technician.getAt());
            ps.setString(6, technician.getLt());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlDataUtil.close(conn, ps);
    }

    //通过对应的技术员姓名与基地号查询对应的UserId
    public String queryUserId(String userName, String baseNumber) {

        String userId = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //SELECT USER_PSD FROM TECHNICIAN WHERE
        String sql = "SELECT USER_ID FROM TECHNICIAN WHERE USER_NAME=? AND USER_BASENUMBER=?";
        conn = SqlDataUtil.getConnection();
        try {
            ps = conn.prepareCall(sql);
            ps.setString(1, userName);
            ps.setString(2, baseNumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                userId = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlDataUtil.close(conn,ps,rs);
        return userId;
    }
}
