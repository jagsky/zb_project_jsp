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
 * Created by Administrator on 2016/7/12.
 */
@WebServlet(name = "FarmerServlet")
public class FarmerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String userIdCard = request.getParameter("idCard");
        System.out.println(userIdCard);
        Gson gson = new Gson();
        FarmerDao farmerDao = new FarmerDao();
        try {
            List<FarmerBean> list = farmerDao.queryDK(userIdCard);
            String jsonStr = gson.toJson(list);
            response.getWriter().print(jsonStr);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
