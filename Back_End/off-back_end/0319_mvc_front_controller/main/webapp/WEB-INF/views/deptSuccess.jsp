<%@page import="com.ssafy.model.dto.Dept"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">등록에 성공하였습니다.</h2>
			<h2 class="text-center"> 등록하신 정보는 다음과 같습니다. </h2>
		</div>
		<div  class="row  text-center">

	<%
		Dept dept = (Dept)request.getAttribute("dept");
	%>
	<h3>
		<%=dept.getDeptno() %>,
		<%=dept.getDname() %>,
		<%=dept.getLoc() %>
		<%-- <%  out.println(dept.getDeptno()); %> --%>
	</h3>
	</div>
	</div>
</body>
</html>