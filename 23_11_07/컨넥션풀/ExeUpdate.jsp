<%@ page import="common.JDBConnect" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JDBC</title>
</head>
<body>
  <h2>회원 추가 테스트(executeUpdate() 사용)</h2>
<%
  JDBConnect jdbc = new JDBConnect();

  String id = "test1";
  String pass = "1111";
  String name = "테스트1회원";

  String sql = "insert into member values (?,?,?,(current_date))";
  PreparedStatement psmt = jdbc.con.prepareStatement(sql);
  psmt.setString(1,id);
  psmt.setString(2,pass);
  psmt.setString(3, name);

  int inResult = psmt.executeUpdate();
  out.println(inResult + "행이 입력되었습니다.");

  jdbc.close();
%>
</body>
</html>
