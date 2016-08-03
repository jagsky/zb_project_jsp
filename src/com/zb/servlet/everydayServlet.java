package com.zb.servlet;

import com.zb.bean.EverydayBean;
import com.zb.dao.EverydayDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/25.
 */
@WebServlet(name = "EverydayServlet")
public class EverydayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String register_userName = request.getParameter("register_userName");
        String timeContent = request.getParameter("timeContent");
        String bobyContent = request.getParameter("bobyContent");
        EverydayBean everydayBean = new EverydayBean(register_userName, timeContent, bobyContent);
        EverydayDao everydayDao = new EverydayDao();
        System.out.println(everydayBean.toString());
        everydayDao.insertData(everydayBean);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
