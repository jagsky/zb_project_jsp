package com.zb.dao;

import com.zb.sql.SqlDataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 作用：在数据库中查询管理员的ID 密码是否正确
 * Created by Administrator on 2016/8/8.
 */
public class ControllerDao {
    private String id;
    private String password;
    private String selectType;

    public ControllerDao(String id, String password, String selectType) {
        this.id = id;
        this.password = password;
        this.selectType = selectType;
    }

    //查询管理员这个ID是否存在
    public boolean queryControllerId() {
        boolean isId = false;
        Connection conn = SqlDataUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //通过id查询这个密码
        String sql = "SELECT CONTROLLER_ID FROM  CONTROLLER WHERE CONTROLLER_ID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            isId = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlDataUtil.close(conn, ps, rs);

        return isId;
    }

    //2.如果存在则开始下一步，查询密码是否存在，如果不存在则将密码添加到数据中，如果存在则判断是否一样
    public boolean queryControllerPassword() {
        boolean ispassword = false;
        String password1 = null;
        Connection conn = SqlDataUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT CONTROLLER_PASSWORD FROM CONTROLLER WHERE CONTROLLER_ID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            boolean next = rs.next();
            System.out.println("next" + next);
            //如果存在则将记录上移一位，重新获取数据
            if (next) {
                password1 = rs.getString(1);
                System.out.println(password1);
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
                    }
                    //如果不存在则添加数据到数据库
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        SqlDataUtil.close(conn, ps, rs);
        return ispassword;
    }

    //3.如果密码不存在则插入密码
    public void insertPassword() {
        Connection conn = SqlDataUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE CONTROLLER SET CONTROLLER_PASSWORD=? WHERE CONTROLLER_ID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /*   //4.如果密码存在则判断密码是否准确
    public boolean queryisOkPassword() {
        boolean ispassword = false;
        Connection conn = SqlDataUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String password1 = null;
        String sql = "SELECT CONTROLLER_PASSWORD FROM CONTROLLER WHERE CONTROLLER_PASSWORD=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                password1 = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean equals = password.equals(password1);

        SqlDataUtil.close(conn, ps, rs);
        return equals;
    }*/

}
