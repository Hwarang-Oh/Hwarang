<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
			<h1> 등록에 성공하였습니다.</h1>;
			<h2> 등록하신 정보는 다음과 같습니다. </h2>;	
			<!-- translate되는 자바 source 생각 : request, response -->
			<h3>
				${dept.deptno}, ${dept.dname}, ${dept.loc}
			</h3>
	</body>
</html>