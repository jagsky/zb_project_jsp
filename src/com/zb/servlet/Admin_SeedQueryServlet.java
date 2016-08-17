package com.zb.servlet;

import com.zb.dao.TechnicianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/17.
 */
@WebServlet(name = "Admin_SeedQueryServlet")
public class Admin_SeedQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        //获取返回的技术员姓名以及基地号 去查询对应的UserId;
        String technician = request.getParameter("city1");
        String baseNumber = request.getParameter("city2");
        TechnicianDao technicianDao = new TechnicianDao();
        String userId = technicianDao.queryUserId(technician, baseNumber);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
