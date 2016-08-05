package com.zb.servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zb.bean.TodayBean;
import com.zb.dao.TodayDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * 作用：管理员每日查看
 * Created by Administrator on 2016/8/5.
 */
@WebServlet(name = "AdminTodayServlet")
public class AdminTodayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String parameter = request.getParameter("time");
        System.out.println(parameter+"parameter");
        Type type = new TypeToken<LinkedList<TodayBean>>() {
        }.getType();
        Gson gson = new Gson();
        TodayDao todayDao = new TodayDao();
        List<TodayBean> beanList = todayDao.queryTodayData(parameter);
        String json = gson.toJson(beanList, type);
        response.getWriter().print(json);
        System.out.println(json);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
