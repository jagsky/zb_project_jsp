package com.zb.servlet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zb.bean.GainBean;
import com.zb.bean.RogueBean;
import com.zb.dao.GainDao;
import com.zb.dao.TechnicianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/18.
 */
@WebServlet(name = "Admin_GainQueryServlet")
public class Admin_GainQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        //获取返回的技术员姓名以及基地号 去查询对应的UserId;
        String technician = request.getParameter("city1");
        String baseNumber = request.getParameter("city2");
        TechnicianDao technicianDao = new TechnicianDao();
        String userId = technicianDao.queryUserId(technician, baseNumber);

        GainDao gainDao = new GainDao();
        List<GainBean> gainBeanList = gainDao.queryGain(userId);
        Gson gson = new Gson();
        Type listType = new TypeToken<LinkedList<RogueBean>>() {
        }.getType();
        String json = gson.toJson(gainBeanList, listType);
        response.getWriter().print(json);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
