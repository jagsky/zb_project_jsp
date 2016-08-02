package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.bean.GainBean;
import com.zb.dao.GainDao;

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
@WebServlet(name = "GainServlet")
public class GainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        //1.获取json字符串
        String json = readJSONString(request);
        System.out.println(json);
        //2.通过Gson将数据保存到实例对象中
        Gson gson = new Gson();
        GainBean gainBean = new GainBean();
        gainBean = gson.fromJson(json, GainBean.class);
        GainDao gainDao = new GainDao();
        try {
            boolean isOk = gainDao.queryDK(gainBean.getDKNumber());
            if (isOk) {
                int i = gainDao.updateGain(gainBean);
                System.out.println(i);
            } else {
                boolean s = gainDao.insertGain(gainBean);
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
            e.printStackTrace();
        }
        return json.toString();
    }
}
