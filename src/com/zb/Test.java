package com.zb;

import com.zb.dao.UserDao;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();
        String s = userDao.idQueryidCard("ssss");
        System.out.println(s);

    }

}
