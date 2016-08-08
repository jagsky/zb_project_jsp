package com.zb;

import com.zb.bean.TodayBean;
import com.zb.dao.ControllerDao;
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
       /* TechnicianDao technicianDao = new TechnicianDao("123123","aqeq1w");
        boolean b = technicianDao.queryId();*/
        ControllerDao controllerDao =  new ControllerDao("13875630138","12312312312312","sssss");
        controllerDao.queryControllerPassword();
    }

}
