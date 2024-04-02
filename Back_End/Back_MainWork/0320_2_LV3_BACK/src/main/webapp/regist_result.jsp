<%@page import="com.ssafy.ws.step3.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% Book book = (Book) request.getAttribute("Book"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>SSAFY 도서 등록</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
  <h2>입력 내용</h2>
  <%=book.toString() %>
</body>
</html>