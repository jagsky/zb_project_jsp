package com.zb.servlet;

import com.zb.dao.FanGuiDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/23.
 */
@WebServlet(name = "FanGuiServlet")
public class FanGuiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String str1 = request.getParameter("str1");
        String str2 = request.getParameter("str2");
        FanGuiDao fanGuiDao = new FanGuiDao();

        fanGuiDao.inserFanGui(str1, str2);

        response.getWriter().print("OK");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
