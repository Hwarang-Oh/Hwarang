<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c %>
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
    <div class="container d-flex justify-content-start flex-column">
    
    <c:if test = "${not empty user}">
    	<a href="regist.jsp">도서 등록</a>
    	<a href="main?action=list">도서 목록</a>
    </c:if>
    </div>
  </body>
</html>