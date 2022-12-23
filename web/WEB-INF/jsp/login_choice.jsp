<%--
  Created by IntelliJ IDEA.
  User: 20698
  Date: 2022/12/12
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <title>登录选择</title>
    <link rel="stylesheet" href="static/css/login_choice.css">
</head>
<body>
<div class="container">
    <div class="header">
        <h2>登陆跳转</h2>
    </div>
    <div class="content">
        <button>
            <a href="admin_login.do">管理员登陆（内部人员）</a>
        </button>
        <br><br>
        <button>
            <a href="user_login.do">普通用户登陆注册</a>
        </button>
    </div>
</div>
</body>
</html>
