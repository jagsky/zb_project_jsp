package com.zb;

import com.zb.bean.Technician;
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
    public static void main(String[] args) {
        TechnicianDao technicianDao = new TechnicianDao();
        String s = technicianDao.queryUserId("常米1", "CYL");
        System.out.println(s);

    }

}
