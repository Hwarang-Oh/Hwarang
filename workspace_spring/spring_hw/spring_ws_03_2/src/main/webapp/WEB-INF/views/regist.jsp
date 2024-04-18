<%@ page language="java" contentType="text/html; charset=UTF-8"%> <%@ taglib prefix="c"
uri="jakarta.tags.core" %>
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
      crossorigin="anonymous" />
    <title>SSAFY 영화 관리</title>
  </head>
  <body>
    <div class="container mt-3">
      <h2>SSAFY 영화 등록</h2>
      <form action="${root}/regist" method="post">
        <!-- <input type="hidden" name="action" value="regist" /> -->
        <div class="mb-3 mt-3">
          <label for="title">제목</label>
          <input
            type="text"
            class="form-control"
            id="title"
            placeholder="Enter Title"
            name="title"
            required="required" />
        </div>
        <div class="mb-3 mt-3">
          <label for="author">감독</label>
          <input
            type="text"
            class="form-control"
            id="director"
            placeholder="Enter Director"
            name="director"
            required="required" />
        </div>
        <div class="mb-3">
          <label for="price">장르</label>
          <input
            type="text"
            class="form-control"
            id="genre"
            placeholder="Enter Genre"
            name="genre"
            required="required" />
        </div>
        <div class="mb-3">
          <label for="desc">상영 시간</label>
          <input
            type="text"
            class="form-control"
            id="runningTime"
            placeholder="Enter RunningTime"
            name="runningTime"
            required="required" />
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="button" class="btn btn-primary">Delete</button>
      </form>
    </div>
  </body>
</html>
