package com.zb.servlet;

import com.zb.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/5.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String idCard = request.getParameter("idCard");
        UserDao userDao = new UserDao();
        try {

            boolean b = userDao.queryIdCard(idCard);
            if (b) {
                boolean isOk = userDao.queryUserId(userName);
                if (isOk) {
                    response.getWriter().print("0");
                } else {
                    int i = userDao.insertUserIdAndPassword(userName, password, idCard);
                    System.out.println(i);
                    response.getWriter().print("1");
                }
            } else {
                response.getWriter().print("2");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
  /*  private String readJSONString(HttpServletRequest request) {
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
    }*/
}
