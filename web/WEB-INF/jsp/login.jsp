<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8"/>
    <title></title>
</head>
<body>
<h1>用户登录</h1>

<form action="login" method="post" >
    用户名：<input type="text" name="userNae"><br>
    密码：<input type="password" name="password"><br>
    验证码：<input type="text" name="inputCode">
    <img src="validCode" width="60" height="22"><br>
    <input type="submit" value="登 录">
</form>


<h1>管理员登录</h1>
<form action="AdminLogin" method="post" >
    用户名：<input type="text" name="adminName"><br>
    密码：<input type="password" name="password"><br>
    验证码：<input type="text" name="inputCode">
    <img src="validCode" width="60" height="22"><br>
    <input type="submit" value="登 录">
</form>

</body>
</html>
