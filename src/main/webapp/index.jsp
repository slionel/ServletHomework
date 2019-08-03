<%--
  Created by IntelliJ IDEA.
  User: zsj55
  Date: 2019/7/22
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="com.homework.service.HomeworkService" %>
<%@ page import="com.homework.entity.HomeworkMaster" %>
<%@ page import="java.util.Date"%>
<%@ page import="com.homework.entity.HomeworkDetail" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Bootstrap 是世界上最受欢迎的前端框架，用于构建响应式、移动设备优先的网站。快速了解 Bootstrap 、使用 BootCDN 以及熟悉初学者模板页面。">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.7.0">

    <title>作业管理系统</title>

    <!-- Bootstrap core CSS -->

    <style class="anchorjs"></style><link href="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/bootstrap.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <!-- Documentation extras -->

    <link href="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/docsearch.css" rel="stylesheet">

    <link href="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/docs.css" rel="stylesheet">

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="https://v4.bootcss.com/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="https://v4.bootcss.com/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="https://v4.bootcss.com/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="https://v4.bootcss.com/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="https://v4.bootcss.com/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
    <link rel="icon" href="https://v4.bootcss.com/favicon.ico">
    <meta name="msapplication-config" content="/assets/img/favicons/browserconfig.xml">
    <meta name="theme-color" content="#563d7c">


    <!-- Twitter -->
    <meta name="twitter:card" content="summary">
    <meta name="twitter:site" content="@getbootstrap">
    <meta name="twitter:creator" content="@getbootstrap">
    <meta name="twitter:title" content="简介">
    <meta name="twitter:description" content="Bootstrap 是世界上最受欢迎的前端框架，用于构建响应式、移动设备优先的网站。快速了解 Bootstrap 、使用 BootCDN 以及熟悉初学者模板页面。">
    <meta name="twitter:image" content="https://v4.bootcss.com/assets/brand/bootstrap-social-logo.png">

    <!-- Facebook -->
    <meta property="og:url" content="https://v4.bootcss.com/docs/4.0/getting-started/introduction/">
    <meta property="og:title" content="简介">
    <meta property="og:description" content="Bootstrap 是世界上最受欢迎的前端框架，用于构建响应式、移动设备优先的网站。快速了解 Bootstrap 、使用 BootCDN 以及熟悉初学者模板页面。">
    <meta property="og:type" content="website">
    <meta property="og:image" content="http://v4.bootcss.com/assets/brand/bootstrap-social.png">
    <meta property="og:image:secure_url" content="https://v4.bootcss.com/assets/brand/bootstrap-social.png">
    <meta property="og:image:type" content="image/png">
    <meta property="og:image:width" content="1200">
    <meta property="og:image:height" content="630">
</head>

<body>

<a id="skippy" class="sr-only sr-only-focusable" href="#content">
    <div class="container">
        <span class="skiplink-text">Skip to main content</span>
    </div>
</a>

<jsp:include page="topside.jsp"></jsp:include>



<div class="container-fluid">
    <div class="row flex-xl-nowrap">
        <jsp:include page="leftside.jsp"></jsp:include>
<main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content" role="main">
    <h1 class="bd-title">今日竞赛</h1>

    <p class="bd-lead">竞赛是每个人单独完成作业</p>
    <%
        HomeworkService hs = new HomeworkService();
        String type = "竞赛";
        Date today = new Date();
        List<HomeworkMaster> homeworkMasterList = hs.getHomeworkmasterByDateAndType(today.getTime(),type);
        for(int i = 0; i < homeworkMasterList.size(); i++){
            if(today.getHours() > 10){

    %>
    <!--一条作业主表记录的开始-->
    <h2 id="how-it-works"></h2>
    <p><%=homeworkMasterList.get(i).getTitle()%></p>
    <ul>
        <%
            List<HomeworkDetail> homeworkDetailList = hs.getHomeworkDetailByMasterId(homeworkMasterList.get(i).getId());
            for (int j = 0; j < homeworkDetailList.size(); j++){
        %>
        <li><%=homeworkDetailList.get(j).getContent() %></li>
        <% } %>
    </ul>
    <!--一条作业主表记录的结束-->
    <% } %>
    <% } %>

    <br>
    <br>


    <!--文件上传-->
    <div class="container mt-3">
        <h2>作业上传</h2>
        <form action="FileUpLoadServlet" enctype="multipart/form-data" method="post">
            <input type="file" id="myFile" name="filename2">
            <div class="mt-3">
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
        </form>
    </div>




    <%
        String username = (String) session.getAttribute("uname");
        if(username == null){
            response.sendRedirect("login.html");
        }
    %>
</main>


</div>
</div>

<script src="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/jquery.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>

<script src="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/popper.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script><script src="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/bootstrap.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><script src="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/docsearch.js"></script><script src="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/docs.js"></script>


</body>
</html>
