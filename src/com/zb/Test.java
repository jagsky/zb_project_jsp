package com.zb;

import com.zb.dao.GainDao;
import com.zb.dao.RogueDao;
import com.zb.dao.SeedDao;
import com.zb.sql.SqlDataUtil;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        GainDao rogueDao = new GainDao();
     boolean s =    rogueDao.queryDK("123");
        System.out.println(s+"sssdsssaaadd");
    }

}
