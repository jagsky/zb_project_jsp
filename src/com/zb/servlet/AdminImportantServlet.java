package com.zb.servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zb.bean.ImportantBean;
import com.zb.bean.ImportantTitleBean;
import com.zb.dao.ImportantDao;

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
 * 作用：返回重要事情上报
 * Created by Administrator on 2016/8/5.
 */
@WebServlet(name = "AdminImportantServlet")
public class AdminImportantServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        ImportantBean importantBean = new ImportantBean();
        ImportantDao importantDao = new ImportantDao();
        List<ImportantBean> importantBeen = importantDao.queryImportant();
        Gson gson = new Gson();
        Type type = new TypeToken<LinkedList<ImportantBean>>() {
        }.getType();
        String s = gson.toJson(importantBeen, type);
        response.getWriter().print(s);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
