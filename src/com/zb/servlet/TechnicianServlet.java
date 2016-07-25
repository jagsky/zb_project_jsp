package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.dao.TechnicianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/7/18.
 */
@WebServlet(name = "TechnicianServlet")
public class TechnicianServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        TechnicianDao technicianDao = new TechnicianDao();
        try {
            Gson gson = new Gson();
            String jsonStr = gson.toJson(technicianDao.queryTechnicianName());
            response.getWriter().print(jsonStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
