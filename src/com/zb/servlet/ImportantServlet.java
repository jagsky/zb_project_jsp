package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.bean.ImportantBean;
import com.zb.dao.ImportantDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Administrator on 2016/8/2.
 */
@WebServlet(name = "ImportantServlet")
public class ImportantServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");

        String jsonStr = readjsonString(request);
        System.out.println(jsonStr);
        Gson gson = new Gson();
        ImportantBean importantBean = gson.fromJson(jsonStr, ImportantBean.class);
        ImportantDao importantDao = new ImportantDao();
        importantDao.insertLineData(importantBean);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String readjsonString(HttpServletRequest request) {
        StringBuffer json = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json.toString();
    }
}
