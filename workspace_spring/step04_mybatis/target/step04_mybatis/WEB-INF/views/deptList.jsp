<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
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
			<h2 class="bg-primary text-light text-center">부서 목록</h2>
			<h4 class="text-center">${msg}</h4>
		</div>
		<!-- JSTL param?? => -->
		<div class="row mt-3">
            <form action="${root}/dept/listByCondition" method="post">
                <input type="text" placeholder="부서이름을 입력하세요" name="dname" value="${param.dname}"/> 
                <input type="text" placeholder="지역을 입력하세요" name="loc" value="${param.loc}"/> 
                <input type="submit"  value="검색" />
            </form>
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
				
				<%-- <c:if test="">
				</c:if> --%>
				
				<c:choose>	
					<c:when test="${not empty depts}">
						<c:forEach items="${depts}" var="dept" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${dept.deptno}</td>
								<td><a href="${root}/dept/detail?deptno=${dept.deptno}">${dept.dname}</a></td>
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






