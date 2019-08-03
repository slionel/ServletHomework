<%@ page import="com.homework.entity.HomeworkMaster" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zsj55
  Date: 2019/7/29
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
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
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

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
    <h1 class="bd-title">查看作业</h1>

    <form class="form-inline" method="get" action="HomeworkSelectServlet">
        <label>日期</label>&nbsp;&nbsp;
        <input type="date" class="form-control" name = "seldate">


        &nbsp;&nbsp;<label>作业类型:</label>&nbsp;&nbsp;
        <select class="form-control" name="type">
            <option value="竞赛">竞赛</option>
            <option value="结对">结对</option>
        </select>

        &nbsp;&nbsp;<button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <br><br>
        <form method="post" action="HomeworkSelectAllServlet">
            <div class="container">
                <h2>作业提交情况</h2>
                <button type="submit" class="btn btn-primary">查询</button>
                <br>
                <div class="table-responsive table-striped table-bordered">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>作业id</th>
                            <th>作业题目</th>
                            <th>作业类型</th>
                            <th>开放时间</th>
                            <th>提交情况</th>
                            <th>作业详情</th>
                        </tr>
                        </thead>

                        <tbody>
                            <%
                                List<HomeworkMaster> homeworkMasterList = (List<HomeworkMaster>) session.getAttribute("homeworkMasterList");
                                if(homeworkMasterList == null){
                                    homeworkMasterList = new ArrayList<HomeworkMaster>();
                                }
                                for(int i = 0; i < homeworkMasterList.size(); i++){


                            %>
                        <tr>
                            <td><%=homeworkMasterList.get(i).getId()%></td>
                            <td><%=homeworkMasterList.get(i).getTitle()%></td>
                            <td><%=homeworkMasterList.get(i).getType()%></td>
                            <td><%=homeworkMasterList.get(i).getOpwen_date()%></td>
                            <td>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" name="modalbtn" id="<%=homeworkMasterList.get(i).getId()%>">
                                    查看
                                </button>
                            </td>

                            <td>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#contentModal" name="contentbtn" id="<%=homeworkMasterList.get(i).getId()%>">
                                    作业详情
                                </button>
                            </td>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </form>

    </div>
</main>
</div>
</div>




<!-- 模态框 -->
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">提交情况</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <table class="table">



                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>作业提交情况</th>
                    </tr>
                    </thead>

                    <tbody id="tbody">
                    <tr>    <td></td>   </tr>

                    </tbody>
                </table>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>

        </div>
    </div>
</div>






<script src="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/popper.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/bootstrap.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/docsearch.js"></script>
<script src="%E7%AE%80%E4%BB%8B%20%C2%B7%20Bootstrap_files/docs.js"></script>

<script>
    $(document).ready(function(){
        $("button[name='modalbtn']").click(function(){
            var homeworkMasterId = this.id;
            $.getJSON("HomeworkCheckServlet", { homeworkMasterId: homeworkMasterId}, function(json){
                console.log(json);
                $("#tbody").empty();
                for(var i = 0; i < json.length; i++){
                    if(json[i].status == "学生"){
                        $("#tbody").append("<tr>"+
                            "<td>"+
                            json[i].userName+
                            "</td>"+
                            "<td>"+
                            json[i].isSubmit+
                            "</td>"+
                            "</tr>");
                    }
                }
            });
            $("#myModal").modal("show");
        });
    });
</script>













<!-- 模态框2 -->
<div class="modal fade" id="contentModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">作业详情</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <table class="table">



                    <thead>
                    <tr>
                        <th>作业内容</th>
                        <th>作业更新时间</th>
                    </tr>
                    </thead>

                    <tbody id="contentBody">
                    <tr>    <td></td>   </tr>

                    </tbody>
                </table>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>

        </div>
    </div>
</div>




<script>
    $(document).ready(function(){
        $("button[name='contentbtn']").click(function(){
            var homeworkMasterId = this.id;
            $.getJSON("HomeworkContentServlet", { homeworkMasterId: homeworkMasterId}, function(json){
                console.log(json);
                $("#contentBody").empty();
                for(var i = 0; i < json.length; i++){
                    $("#contentBody").append("<tr>"+
                        "<td>"+
                        json[i].content+
                        "</td>"+
                        "<td>"+
                        new Date(json[i].updateTime ).toLocaleString()+
                        "</td>"+
                        "</tr>");
                }
            });
            $("#contentModal").modal("show");
        });
    });
</script>





</body>
</html>
