package com.homework.servlet;

import com.alibaba.fastjson.JSONObject;
import com.homework.entity.HomeworkIsSubmitVo;
import com.homework.service.HomeworkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeworkCheckServlet")
public class HomeworkCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String homeworkMasterId = request.getParameter("homeworkMasterId");
        HomeworkService hs = new HomeworkService();
        List<HomeworkIsSubmitVo> homeworkIsSubmitVoList = hs.getIsSubmit(homeworkMasterId);
        String s = JSONObject.toJSONString(homeworkIsSubmitVoList);
        response.getWriter().append(s);
    }
}
