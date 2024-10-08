<%@page import="com.ssafy.model.dto.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<%
				List<Dept> depts = (List<Dept>) request.getAttribute("depts");
				if (depts != null & depts.size() > 0) {
					for (int i = 0 ; i < depts.size() ; i++) { 
						Dept dept = depts.get(i);%>
						<tr>
							<td><%=i + 1 %></td>
							<td><%=dept.getDeptno() %></td>
							<td><%=dept.getDname() %></td>
						</tr>
				<%	}
				} else {
				%>
						<tr><td colspan="3">등록된 부서 정보가 없습니다</td></tr>
				<%}
				%>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>