package com.zb.servlet;

import com.zb.dao.ControllerDao;
import com.zb.dao.TechnicianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * //用户登入判断Servlet
 * Created by Administrator on 2016/7/4.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        String register_userName = request.getParameter("userName");
        String register_password = request.getParameter("password");
        String selectType = request.getParameter("selectType");
        System.out.println(selectType);
        if (selectType.equals("技术员")) {
            TechnicianDao technicianDao = new TechnicianDao(register_userName, register_password);
            boolean b = technicianDao.queryId();
            if (b) {
                final boolean b1 = technicianDao.queryPassword();
                if (b1) {
                    response.getWriter().print("1");
                } else {
                    response.getWriter().print("0");
                }
            } else {
                response.getWriter().print("0");
            }


        } else if (selectType.equals("管理员")) {
            ControllerDao controllerDao = new ControllerDao(register_userName, register_password, selectType);
            boolean b = controllerDao.queryControllerId();
            if (b) {
                System.out.println(b);
                boolean b1 = controllerDao.queryControllerPassword();
                if (b1) {
                    response.getWriter().print("1");
                } else {
                    response.getWriter().print("0");
                }
            } else {
                response.getWriter().print("0");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}


