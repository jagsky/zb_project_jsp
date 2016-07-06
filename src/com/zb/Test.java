package com.zb;

import com.zb.bean.RogueBean;
import com.zb.dao.RogueDao;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Test {
    public static void main(String[] args) throws SQLException {

        RogueDao rogueDao = new RogueDao();
        RogueBean rogueBean = new RogueBean("userid", "备注", "出苗父", "出苗母", "地块号",
                "可育株率调查", "农户行吗", "种类", "杂铸铝", "行比",
                "行距", "株距父", "株距母", "去杂开始时间", 1);
        boolean b = rogueDao.inertData(rogueBean);
        System.out.println(b);

    }

}
