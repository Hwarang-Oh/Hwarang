<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP</h1>
	<a href="<%= root %>/ssafy.jsp">Hello SSAFY</a>
    <a href="<%= root %>/parameter.jsp">Parameter Test</a>
</body>
</html>