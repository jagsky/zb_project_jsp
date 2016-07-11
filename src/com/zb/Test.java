package com.zb;

import com.zb.bean.SeedBean;
import com.zb.dao.SeedDao;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        SeedBean seedBean = new SeedBean("这是我新添加的", "16JZYXX0xxx", "父亲1", "父亲2", "发本情况", "农户姓名", "ss", "sss", "aaa", "a", "d");
        SeedDao seedDao = new SeedDao();
        int i = seedDao.updateSeed(seedBean);
        System.out.println(i);

    }

}
