package com.zb;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zb.bean.FarmerBean;
import com.zb.dao.FarmerDao;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        FarmerDao farmerDao = new FarmerDao();
        List<FarmerBean> farmerBeanList = farmerDao.queryDK("430421199208245758");
        Gson gson = new Gson();
        String s = gson.toJson(farmerBeanList);
        System.out.println(s);
        Type type = new TypeToken<LinkedList<FarmerBean>>() {
        }.getType();

        List<FarmerBean> farmerBeanList1 = gson.fromJson(s, type);
        System.out.println(farmerBeanList1.toString());




    }

}
