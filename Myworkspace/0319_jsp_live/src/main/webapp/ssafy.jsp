<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.Date, java.sql.*" 
    import ="java.text.*" session="false"
    %> 
    <!-- 세미콜론 X -->
    <!-- 속성 사이는 항상 white Space가 있어야 한다!! -->
<%
  String name = "오화랑";
  Date date = new Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Hello SSAFY JSP!!</h1>
<h1>안녕 싸피 제이에스피!</h1>
<h3><%out.print(name + "님 안녕"); %></h3>
<h3><%=name %>님 안녕</h3>
<div>오늘은 <%= date %></div>
</body>
</html>