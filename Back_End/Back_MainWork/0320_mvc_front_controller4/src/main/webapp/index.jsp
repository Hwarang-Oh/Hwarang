<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
	<ul>
		<li><a href="${root}/main?action=dept/registerForm">부서 등록</a></li>
		<li><a href="${root}/main?action=dept/list">부서 목록</a></li>
		<li><a href="${root}/main?action=dept/rest/list">부서 목록 - Rest</a></li>
	</ul>
</body>
</html>