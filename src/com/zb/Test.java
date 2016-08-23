package com.zb;

import com.zb.bean.ImportantBean;
import com.zb.bean.ImportantTitleBean;
import com.zb.bean.Technician;
import com.zb.bean.TodayBean;
import com.zb.dao.ControllerDao;
import com.zb.dao.ImportantDao;
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
        ImportantDao importantDao = new ImportantDao();

        List<ImportantBean> importantBeen = importantDao.queryImportant();
        System.out.println(importantBeen.toString());
    }

}
