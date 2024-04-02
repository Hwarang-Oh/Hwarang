<%@ page language="java" contentType="text/html"
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
			<h2 class="bg-primary text-light text-center">등록에 성공하였습니다.</h2>
			<h2 class="text-center"> 등록하신 정보는 다음과 같습니다. </h2>
		</div>
		<div  class="row  text-center">
	<h3>
		${dept.deptno},${dept.dname},${dept.loc }
		<%-- <%  out.println(dept.getDeptno()); %> --%>
	</h3>
	</div>
	</div>
</body>
</html>