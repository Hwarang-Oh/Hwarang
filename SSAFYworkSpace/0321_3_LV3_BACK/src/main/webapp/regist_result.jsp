<%@page import="com.ssafy.ws.step3.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	Book book = (Book) request.getAttribute("Book");
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
    <title>SSAFY 도서 관리</title>
  </head>
  <body>
    <%@ include file="include/header.jsp" %>
	<h1>도서 등록 결과</h1>
	<table class="table">
	    <thead>
	      <tr>
	        <th style="width: 10%;">항목</th>
	        <th style="width: 90%;">내용</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>도서번호</td>
	        <td><%=book.getIsbn() %></td>
	      </tr>
	      <tr>
	        <td>도서명</td>
	        <td><%=book.getTitle() %></td>
	      </tr>
	      <tr>
	      	<td>저자</td>
	      	<td><%=book.getAuthor() %></td>
	      </tr>
	      <tr>
	      	<td>가격</td>
	      	<td><%=book.getPrice() %></td>
	      </tr>
	      <tr>
	      	<td>설명</td>
	      	<td><%=book.getDesc() %></td>
	      </tr>
	    </tbody>
	</table>
	<a href="#">추가 등록</a>
  </body>
</html>