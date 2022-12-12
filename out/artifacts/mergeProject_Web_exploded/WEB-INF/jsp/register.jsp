<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <base href="http://${header.host}${pageContext.request.contextPath}/"/>
    <meta charset="utf-8"/>
    <title>用户注册</title>
</head>
<body>
<h1>用户注册</h1>

<form action="register" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
    用户名：<input type="text" name="userNae"><br>
    密码：<input type="password" name="password"><br>
    <td>照片：</td>
    <td><input type="file" name="photo" /></td>
    email   <input type="text" name="email"><br>
    phone   <input type="text" name="phone"><br>
    <input type="submit" value="注 册">
    <input type="reset" value="重 置">
</form>
</body>
</html>
