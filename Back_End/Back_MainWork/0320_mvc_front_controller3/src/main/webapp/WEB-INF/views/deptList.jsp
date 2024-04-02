<%@page import="com.ssafy.model.dto.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c %>

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
				<tbody> <!-- 반복문 조건문은 EL JSTL로 처리할 수 없다. --><!-- 하나씩 꼬ㅓ내서 머할 때 itmes. dept -> 요거 지역변수 아닌다. => 응답으론 다 가는데, data는 옮겨가 있는 현상 발생-->
				<c:choose>
					<c:when test="${not empty depts}"> 
					<c:forEach items="${depts}"  var="dept", valStatus="status">
						<tr>
									<td>${status.count}</td>
									<td>${dept.deptno}</td>
									<td><a href="main?action=dept/detail&deptno=${dept.deptno} "> ${dept.deptno}</a></td>
								</tr>
					</c:forEach>
					
						</c:when>
						<c:otherwise>
							<tr><td colspan="3">등록된 부서 정보가 없습니다.</td></tr>
							</c:otherwise>
							</c:choose>
				
				<%
					// 컨트롤러로부터 전달반은 데이터 꺼내기!
					List<Dept> depts = (List<Dept>)request.getAttribute("depts");
					if(depts != null && depts.size()>0){
						for(int i=0,size =  depts.size(); i<size; ++i ){
							Dept dept = depts.get(i);%>
							<tr>
								<td><%=i+1 %></td>
								<td><%=dept.getDeptno() %></td>
								<td><a href="main?action=dept/detail&deptno=<%=dept.getDeptno() %>"><%=dept.getDname() %></a></td>
							</tr>
				<%	} // end for
					}else{
				%>
					<tr><td colspan="3">등록된 부서정보가 없습니다</td></tr>
				<%} %>
				
				
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>






