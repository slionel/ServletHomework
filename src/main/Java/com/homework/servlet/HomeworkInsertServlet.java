package com.homework.servlet;

import com.homework.Keyutils;
import com.homework.service.HomeworkService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "HomeworkInsertServlet")
public class HomeworkInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String requirement = request.getParameter("requirement");
        String type = request.getParameter("type");
        String date = request.getParameter("opendate");

        System.out.println(title+"\n"+requirement+"\n"+type+"\n"+date);


        try {
            String homeworkMasterId = Keyutils.genUniqueKey();
            Date openDate=new Date((new SimpleDateFormat("yyyy-MM-dd").parse(date)).getTime());
            Thread.sleep(2000);
            String homeworkDetailId = Keyutils.genUniqueKey();
            HomeworkService hs = new HomeworkService();
            hs.insertToHomeworkDetail(homeworkDetailId,homeworkMasterId,requirement);
            hs.insertToHomeworkMaster(homeworkMasterId,title,type,openDate);
            if("竞赛".equals(type)){
                response.sendRedirect("index.jsp");
            }
            else if("结对".equals(type)){
                response.sendRedirect("index2.jsp");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
