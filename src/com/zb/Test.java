package com.zb;

import com.zb.bean.TodayBean;
import com.zb.dao.TechnicianDao;
import com.zb.dao.TodayDao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
      /*  TodayDao todayDao = new TodayDao();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.format(date);
        System.out.println(dateFormat.toString());
        List<TodayBean> beanList = todayDao.queryTodayData(dateFormat.toString());
        System.out.println(beanList.toString());*/
        TodayDao todayDao = new TodayDao();
        List<TodayBean> beanList = todayDao.queryTodayData("2016-08-05");
        System.out.println(beanList.toString());
    }

}
