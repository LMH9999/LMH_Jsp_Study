<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>내장 객체 - application</title>
</head>
<body>
    <h2>web.xml에 설정한 내용 읽어오기</h2>
    초기화 매개변수 : <%= application.getInitParameter("INIT_PARAM")%>
</body>
</html>
