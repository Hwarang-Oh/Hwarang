<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="/WEB-INF/views/common/menu.jsp"/>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">에러 발생</h2>
		</div>
		<div  class="row  text-center">
			<h3>처리 중 문제가 발생하였습니다. - ${exceptionMsg}</h3>
		</div>
	</div>
</body>
</html>