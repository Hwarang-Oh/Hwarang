<%@page import="com.ssafy.model.dto.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 등록에 성공했습니다 </h1>
	<h2> 등록하신 정보는 다음과 같습니다. </h2>
	<%
	Dept dept = (Dept)request.getAttribute("dept");
	%>
	<h3>
		<%=dept.getDeptno() %>
		<%=dept.getDname() %>
		<%=dept.getLoc() %>
	</h3>
</body>

</html>
<%-- 수정 삭제 조회 등록 모두 성공하면 이쪽으로 옴
deptno, dname, loc => Controller가 아는 요소들임 
String response = null => 안된다 -> 변환된 Servlet을 생각하자!! => 이미 내장된 객체다
JSP 내장객체의8가지의 타입과 역할 정도는 알고 있어야 한다.

--%>