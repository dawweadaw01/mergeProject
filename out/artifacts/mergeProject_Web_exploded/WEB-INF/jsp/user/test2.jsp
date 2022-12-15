<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myfn" uri="http://cdu/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
userName: ${user.userName}
头像: <img alt="" width="80" height="80" src="${pageContext.request.contextPath}${user.avatar}"/>
email: ${user.email}
phone: ${user.phone}
createTime: ${myfn:formatDate(user.createTime)}
collection:
<c:forEach items="${user.collection}" var="collection">
    ${collection} /
</c:forEach>
history:
<c:forEach items="${user.history}" var="history">
    ${history} /
</c:forEach>

注销: <a href="${pageContext.request.contextPath}/user/logout">注销</a>
</body>
</html>
