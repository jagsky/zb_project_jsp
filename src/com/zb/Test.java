package com.zb;

import com.zb.dao.TechnicianDao;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        TechnicianDao technicianDao = new TechnicianDao();
        System.out.println( technicianDao.queryTechnicianName().toString());
    }

}
