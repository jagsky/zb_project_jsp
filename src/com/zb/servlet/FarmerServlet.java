package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.bean.FarmerBean;
import com.zb.dao.FarmerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * //作用：用于技术员登入后，后台访问此服务，返回farmer数据
 * Created by Administrator on 2016/7/12.
 */
@WebServlet(name = "FarmerServlet")
public class FarmerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("userName");
        System.out.println(userName);
        Gson gson = new Gson();
        FarmerDao farmerDao = new FarmerDao();
        try {
            List<FarmerBean> list = farmerDao.queryDK(userName);
            String jsonStr = gson.toJson(list);
            System.out.println("技术员要接收农户的基本信息为：" + jsonStr);
            response.getWriter().print(jsonStr);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
