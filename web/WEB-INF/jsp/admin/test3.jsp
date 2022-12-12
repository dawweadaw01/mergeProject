<%--
  Created by IntelliJ IDEA.
  User: j
  Date: 2022-12-06
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>这是管理员页面</h1>
    <a href="addadmin.do">测试</a>
    adminName   : ${admin.adminName}
   管理员头像: <img alt="" width="80" height="80" src="${pageContext.request.contextPath}${admin.default_avatar}"/>
</body>
</html>
