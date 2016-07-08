package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.bean.CastrationBean;
import com.zb.dao.CastrationDao;

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
@WebServlet(name = "CastrationServlet")
public class CastrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        //1.获取json字符串
        String json = readJSONString(request);
        System.out.println(json);
        //2.通过Gson将数据保存到实例对象中
        Gson gson = new Gson();
        CastrationBean castrationBean = new CastrationBean();
        castrationBean = gson.fromJson(json, CastrationBean.class);
        CastrationDao castrationDao = new CastrationDao();
        try {
            boolean isOk = castrationDao.queryDK(castrationBean.getDKNumber());
            if (isOk) {
                int i = castrationDao.updateCastration(castrationBean);
                System.out.println(i);
            } else {
                boolean s = castrationDao.insertCastration(castrationBean);
                System.out.println(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("xxxxoooo");
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
