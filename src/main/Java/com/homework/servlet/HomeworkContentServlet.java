package com.homework.servlet;

import com.alibaba.fastjson.JSONObject;
import com.homework.entity.HomeworkContentVo;
import com.homework.service.HomeworkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeworkContentServlet")
public class HomeworkContentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String homeworkMasterId = request.getParameter("homeworkMasterId");
        HomeworkService hs = new HomeworkService();
        List<HomeworkContentVo> homeworkContentVoList = hs.getContentByMasterId(homeworkMasterId);
        String s = JSONObject.toJSONString(homeworkContentVoList);
        System.out.println(s);
        response.getWriter().append(s);

    }
}
