<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
	<div class="container mt-3">
	  <h2>SSAFY 도서 등록</h2>
	  <form action="main" method="post">
	  	<input type="hidden" name="action" value="regist">
	    <div class="mb-3 mt-3">
	      <label for="isbn">도서 번호</label>
	      <input type="text" class="form-control" id="isbn" placeholder="Enter ISBN" name="isbn" required="required">
	    </div>
	    <div class="mb-3 mt-3">
	      <label for="title">제목</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title" required="required">
	    </div>
	    <div class="mb-3 mt-3">
	      <label for="author">저자</label>
	      <input type="text" class="form-control" id="author" placeholder="Enter Author" name="author" required="required">
	    </div>
	    <div class="mb-3">
	      <label for="price">가격</label>
	      <input type="text" class="form-control" id="price" placeholder="Enter Price" name="price" required="required">
	    </div>
	    <div class="mb-3">
	      <label for="desc">상세 설명</label>
	      <input type="text" class="form-control" id="desc" placeholder="Enter Description" name="desc">
	    </div>
	    <button type="submit" class="btn btn-primary">Submit</button>
	  </form>
	</div>
  </body>
</html>