<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
<div class="container mt-3">
  <h2>SSAFY 도서 등록</h2>
  <form action="main" method="post">
  	<input type="hidden" name="action" value="regist">
    <div class="mb-3 mt-3">
      <label for="isbn">도서 번호</label>
      <input type="text" class="form-control" id="isbn" placeholder="Enter ISBN" name="isbn">
    </div>
    <div class="mb-3 mt-3">
      <label for="title">제목</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title">
    </div>
    <div class="mb-3 mt-3">
      <label for="author">저자</label>
      <input type="text" class="form-control" id="author" placeholder="Enter Author" name="author">
    </div>
    <div class="mb-3">
      <label for="price">가격</label>
      <input type="text" class="form-control" id="price" placeholder="Enter Price" name="price">
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