package com.zb.servlet;

import com.zb.dao.ControllerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
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

        } else if (selectType.equals("管理员")) {
            ControllerDao controllerDao = new ControllerDao(register_userName, register_password, selectType);
            //1.查询这个id是否存在
            boolean IsId = controllerDao.queryControllerId();
            if (IsId) {
                //2.如果存在则判断这个密码是否存在
                boolean isPassword = controllerDao.queryControllerPassword();
                if (isPassword) {
                    //3.如果密码存在则判断密码是否一样
                  //  controllerDao.
                } else {
                    //4.如果不存在则将密码添加到数据库中
                }
            } else {
                response.getWriter().print("账号错误");
            }


        }
        System.out.println(register_password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}


