
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">부서 목록</h2>
		</div>
		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>부서번호</th>
						<th>부서이름</th>
					</tr>			
				</thead>
				<tbody>
				<c:choose>
					<c:when test="${not empty depts}">
					 <c:forEach items="${depts}" var="dept" varStatus="status">  
					 		<tr>
								<td>${status.count}</td>
								<td>${dept.deptno}</td>
								<td><a href="main?action=dept/detail&deptno=${dept.deptno}"> ${dept.dname}</a></td>
							</tr>
					 </c:forEach>
					 </c:when>
					<c:otherwise>
						<tr><td colspan="3">등록된 부서정보가 없습니다</td></tr>	
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>