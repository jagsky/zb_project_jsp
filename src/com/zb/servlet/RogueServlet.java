package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.bean.RogueBean;
import com.zb.dao.RogueDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/5.
 */
@WebServlet(name = "RogueServlet")
public class RogueServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        //1.获取json字符串
        String json = readJSONString(request);
        System.out.println(json);
        //2.通过Gson将数据保存到实例对象中
        Gson gson = new Gson();
        RogueBean rogueBean = new RogueBean();
        rogueBean = gson.fromJson(json, RogueBean.class);
        RogueDao rogueDao = new RogueDao();
        try {
            boolean isok = rogueDao.queryDK(rogueBean.getdKNumber());
            if (isok) {
                int i = rogueDao.updateSeed(rogueBean);
                System.out.println(i);
            } else {
                boolean s = rogueDao.insertRogue(rogueBean);
                System.out.println(s);
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
