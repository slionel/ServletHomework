package com.homework.servlet;

import com.homework.entity.User;
import com.homework.service.HomeworkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String userName = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String status = request.getParameter("status");
        User user = new User(userName, pwd, status);
        user.setSex(sex);
        HomeworkService hs = new HomeworkService();
        if(hs.register(user)){
            response.sendRedirect("login.html");
        }
        else{
            response.sendRedirect("register.html");
        }
    }
}
