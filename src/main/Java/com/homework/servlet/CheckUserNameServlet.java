package com.homework.servlet;

import com.alibaba.fastjson.JSONObject;
import com.homework.service.HomeworkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Map map = new HashMap();
        String name = request.getParameter("uname");
        HomeworkService hs = new HomeworkService();
        boolean rs = hs.findByName(name);
        map.put("result",rs);
        String s = JSONObject.toJSONString(map);
        response.getWriter().append(s);
    }
}
