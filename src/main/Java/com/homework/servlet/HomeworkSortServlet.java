package com.homework.servlet;

import com.alibaba.fastjson.JSONObject;
import com.homework.entity.HomeworkSortVo;
import com.homework.service.HomeworkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeworkSortServlet")
public class HomeworkSortServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String type = request.getParameter("type");
        HomeworkService hs = new HomeworkService();
        List<HomeworkSortVo> homeworkSortVoList = hs.sort(type);
        HttpSession session = request.getSession();
        session.setAttribute("homeworkSortVoList",homeworkSortVoList);
        response.sendRedirect("index5.jsp");





        /*String s = JSONObject.toJSONString(homeworkSortVoList);
        response.getWriter().append(s);*/

    }
}
