package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.bean.FarmerBean;
import com.zb.dao.FarmerDao;
import com.zb.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/13.
 */
@WebServlet(name = "LoginFarmerServlet")
public class LoginFarmerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        System.out.println("登入请求收到的数据：" + userName);
        String userIdcard;
        Gson gson = new Gson();
        FarmerDao farmerDao = new FarmerDao();
        UserDao userDao = new UserDao();
        try {
            userIdcard = userDao.idQueryidCard(userName);

            List<FarmerBean> list = farmerDao.queryDK(userIdcard);
            String jsonStr = gson.toJson(list);
            response.getWriter().print(jsonStr);
            System.out.println(jsonStr);
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
