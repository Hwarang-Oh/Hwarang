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
    <h1>영화 등록 결과</h1>
    <table class="table">
      <thead>
        <tr>
          <th style="width: 10%">항목</th>
          <th style="width: 90%">내용</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>영화 제목</td>
          <td>${Movie.title}</td>
        </tr>
        <tr>
          <td>감독</td>
          <td>${Movie.director}</td>
        </tr>
        <tr>
          <td>장르</td>
          <td>${Movie.genre}</td>
        </tr>
        <tr>
          <td>상영 시간</td>
          <td>${Movie.runningTime}</td>
        </tr>
      </tbody>
    </table>
    <a href="#">추가 등록</a>
  </body>
</html>
