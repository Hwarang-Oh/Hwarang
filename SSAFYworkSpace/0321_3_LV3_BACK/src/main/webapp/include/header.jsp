<%@page import="com.ssafy.ws.step3.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% User user = (User) session.getAttribute("userInfo"); %>
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
    <div class="container d-flex justify-content-center align-items-center flex-column">
      <h2 class="mb-4">SSAFY 도서 관리</h2>
      <div class="align-self-end">
      <% if(user == null){ %>
        <form class="container d-flex justify-content-center align-items-center"
        action="main" method="post">
        <input type="hidden" name="action" value="login">
          <div class="m-3">
            <input
              type="id"
              class="form-control"
              placeholder="아이디"
              id="inputId"
              name="inputId"
            />
          </div>
          <div class="m-3">
            <input
              type="password"
              class="form-control"
              placeholder="비밀번호"
              id="inputPwd"
              name="inputPwd"
            />
          </div>
          <button type="submit" class="btn btn-primary">로그인</button>
        </form>
        <% } else { %>
        <p><%=user.getName() %>님 반갑습니다.</p>
        <a href="main?action=logout">로그아웃</a>
        <%} %>
      </div>
    </div>
    <hr>
    <%
        String errorMessage = (String)session.getAttribute("logInErrorMsg");
        if (errorMessage != null) {
    %>
        <script>
            alert("<%= errorMessage %>");
        </script>
    <% session.removeAttribute("logInErrorMsg");
    } %>
  </body>
</html>