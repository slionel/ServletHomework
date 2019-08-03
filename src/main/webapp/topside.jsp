<%--
  Created by IntelliJ IDEA.
  User: zsj55
  Date: 2019/7/28
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String username = (String)session.getAttribute("uname");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar">
    <a class="navbar-brand mr-0 mr-md-2" href="https://v4.bootcss.com/" aria-label="Bootstrap"><svg class="d-block" width="36" height="36" viewBox="0 0 612 612" xmlns="http://www.w3.org/2000/svg" focusable="false"><title>Bootstrap</title><path fill="currentColor" d="M510 8a94.3 94.3 0 0 1 94 94v408a94.3 94.3 0 0 1-94 94H102a94.3 94.3 0 0 1-94-94V102a94.3 94.3 0 0 1 94-94h408m0-8H102C45.9 0 0 45.9 0 102v408c0 56.1 45.9 102 102 102h408c56.1 0 102-45.9 102-102V102C612 45.9 566.1 0 510 0z"></path><path fill="currentColor" d="M196.77 471.5V154.43h124.15c54.27 0 91 31.64 91 79.1 0 33-24.17 63.72-54.71 69.21v1.76c43.07 5.49 70.75 35.82 70.75 78 0 55.81-40 89-107.45 89zm39.55-180.4h63.28c46.8 0 72.29-18.68 72.29-53 0-31.42-21.53-48.78-60-48.78h-75.57zm78.22 145.46c47.68 0 72.73-19.34 72.73-56s-25.93-55.37-76.46-55.37h-74.49v111.4z"></path></svg>
    </a>

    <div class="navbar-nav-scroll">
        <ul class="navbar-nav bd-navbar-nav flex-row">
            <li class="nav-item">
                <a class="nav-link " href="index.jsp" onclick="ga('send', 'event', 'Navbar', 'Community links', 'Bootstrap');">首页</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="index5.jsp" onclick="ga('send', 'event', 'Navbar', 'Community links', 'Docs');">积分排行</a>
            </li>
            <%--<li class="nav-item">
                <a class="nav-link " href="https://v4.bootcss.com/docs/4.0/examples/" onclick="ga('send', 'event', 'Navbar', 'Community links', 'Examples');">实例</a>
            </li>--%>
            <!-- <li class="nav-item">
              <a class="nav-link" href="https://themes.getbootstrap.com" onclick="ga('send', 'event', 'Navbar', 'Community links', 'Themes');" target="_blank" rel="noopener">Themes</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="https://jobs.getbootstrap.com" onclick="ga('send', 'event', 'Navbar', 'Community links', 'Jobs');" target="_blank" rel="noopener">Jobs</a>
            </li> -->
           <%-- <li class="nav-item">
                <a class="nav-link" href="http://www.youzhan.org/" onclick="ga('send', 'event', 'Navbar', 'Community links', 'Expo');" target="_blank" rel="noopener">优站精选</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="https://blog.getbootstrap.com/" onclick="ga('send', 'event', 'Navbar', 'Community links', 'Blog');" target="_blank" rel="noopener">Blog</a>
            </li>--%>
        </ul>
    </div>

    <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
        <li class="nav-item">
            <p class="navbar-brand">欢迎<%=username%></p>
        </li>
    </ul>

    <a class="btn btn-bd-download d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="login.html">退出</a>
</header>
</body>
</html>
