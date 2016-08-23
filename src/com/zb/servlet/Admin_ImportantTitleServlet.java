package com.zb.servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
 * Created by Administrator on 2016/8/23.
 */
@WebServlet(name = "Admin_ImportantTitleServlet")
public class Admin_ImportantTitleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        ImportantDao importantDao = new ImportantDao();
        List<ImportantTitleBean> importantBeen = importantDao.queryImportantTitle();
        // System.out.println(importantBeen.toString());
        Gson gson = new Gson();
        Type type = new TypeToken<LinkedList<ImportantTitleBean>>() {
        }.getType();
        String jsonStr = gson.toJson(importantBeen, type);
        response.getWriter().print(jsonStr);
        System.out.println(jsonStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
