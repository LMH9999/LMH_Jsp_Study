<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: peter
  Date: 2023-12-13
  Time: PM 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Login</title>
</head>
<body>
<c:if test="${param.result == 'error'}">
    <h1> 로그인 에러 </h1>
</c:if>
    <form action="/login" method="post">
        <input type="text" name="mid">
        <input type="text" name="mpw">
        <input type="checkbox" name="auto">
        <button type="submit">LOGIN</button>
        <%--LOGIN 버튼을 누르면 POST 방식으로 처리됨--%>
    </form>
</body>
</html>
