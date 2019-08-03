package com.homework.servlet;

import com.homework.entity.User;
import com.homework.service.HomeworkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomeworkService hs = new HomeworkService();
        String userName = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String status = request.getParameter("status");
        User user = new User(userName, pwd, status);
        HttpSession session =request.getSession();
            if(hs.login(user)){
            session.setAttribute("uname",userName);
            session.setAttribute("status",status);
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendRedirect("login.html");
        }
    }
}
