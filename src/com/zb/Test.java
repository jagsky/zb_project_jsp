package com.zb;

import com.zb.bean.CastrationBean;
import com.zb.bean.GainBean;
import com.zb.bean.SeedBean;
import com.zb.dao.CastrationDao;
import com.zb.dao.GainDao;
import com.zb.dao.SeedDao;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        SeedBean seedBean = new SeedBean("备注", "sss", "父亲1", "父亲2", "发本情况", "农户姓名", "ss", "sss", "aaa", "a", "d");
        SeedDao seedDao = new SeedDao();
        int i = seedDao.updateSeed(seedBean);
        System.out.println(i);

    }

}
