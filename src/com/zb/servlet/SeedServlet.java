package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.bean.SeedBean;
import com.zb.dao.SeedDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/6.
 */
@WebServlet(name = "SeedServlet")
public class SeedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        //1.获取json字符串
        String json = readJSONString(request);
        System.out.println(json);
        //2.通过Gson将数据保存到实例对象中
        Gson gson = new Gson();
        SeedBean seedBean = new SeedBean();
        seedBean = gson.fromJson(json, SeedBean.class);
        //首先查询数据库中是否存在这个地块号了
        SeedDao seedDao = new SeedDao();
        try {
            boolean isOK = seedDao.queryDK(seedBean.getDKNumber());
            if (isOK) {
                //如果返回true，表示有这一行数据，则执行更新、
                int i = seedDao.updateSeed(seedBean);
            } else {
                Boolean s = seedDao.insertSeed(seedBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String readJSONString(HttpServletRequest request) {
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }
}
