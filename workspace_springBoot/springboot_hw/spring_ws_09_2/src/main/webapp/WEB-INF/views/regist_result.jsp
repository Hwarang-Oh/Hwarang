<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- DTO를 참조하기 위해서 import 처리가 필요하다. -->
<%@ page import="com.ssafy.ws.model.dto.*"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 100px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="container">
		<h1>영화 등록 결과</h1>
		<c:if test="${!empty movie}">
			<table class="table">
				<thead>
					<tr>
						<th>항목</th>
						<th colspan="2">내용</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>영화 제목</td>
						<td>${movie.title }</td>
						<td rowspan="5"><img id="cover"
							src="${root}/resources/static/upload/${movie.img}"></td>
					</tr>
					<tr>
						<td>감독</td>
						<td>${movie.director }</td>
					</tr>
					<tr>
						<td>장르</td>
						<td>${movie.genre }</td>
					</tr>
					<tr>
						<td>상영 시간</td>
						<td>${movie.runningTime }</td>
					</tr>
					<tr>
						<td>이미지</td>
						<td>${movie.orgImg }</td>
					</tr>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty movie }">
			<p>등록된 영화가 없습니다.</p>
		</c:if>
		<a href="${root }/regist">[추가등록]</a> <a href="${root }/list">[목록보기]</a>
	</div>
</body>
</html>