<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"
         trimDirectiveWhitespaces="true"
%>
<html>
<head>
    <title>내장 객체 - Response</title>
</head>
<body>
    <%
        String id = request.getParameter("user_id");
        String pwd = request.getParameter("user_pwd");
        if(id.equalsIgnoreCase("must") && pwd.equalsIgnoreCase("1234")){
            response.sendRedirect("responseWelcome.jsp");
        }
        else {
            request.getRequestDispatcher("responseMain.jsp?loginErr=1").forward(request, response);
        }
    %>
</body>
</html>
