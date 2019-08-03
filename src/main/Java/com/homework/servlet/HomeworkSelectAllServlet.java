package com.homework.servlet;

import com.homework.entity.HomeworkMaster;
import com.homework.service.HomeworkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "HomeworkSelectServlet")
public class HomeworkSelectAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HomeworkService hs = new HomeworkService();
        List<HomeworkMaster> homeworkMasterList =  hs.getAllHomeworkMaster();
        HttpSession session = request.getSession();
        session.setAttribute("homeworkMasterList",homeworkMasterList);
        response.sendRedirect("index3_1.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
