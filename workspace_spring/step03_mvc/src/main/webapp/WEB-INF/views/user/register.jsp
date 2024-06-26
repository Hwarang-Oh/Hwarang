<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>

    <div class="container">
      <div class="row mt-3">
        <h2 class="bg-primary text-light text-center">회원 가입</h2>
      </div>
      <form method="post" action="${root}/user/register">
        <table class="table">
          <tbody>
            <tr>
              <th><label for="userId">아이디</label></th>
              <td><input type="text" name="userId" id="userId" /></td>
            </tr>
            <tr>
              <th><label for="password">비밀번호</label></th>
              <td><input type="text" name="password" id="password" /></td>
            </tr>
            <tr>
              <th><label for="name">이름</label></th>
              <td><input type="text" name="name" id="name" /></td>
            </tr>
            <tr>
              <th><label for="email">이메일</label></th>
              <td><input type="text" name="email" id="email" /></td>
            </tr>
          </tbody>
          <tfoot>
            <tr>
              <td colspan="2">
                <input type="submit" value="가입" />
                <input type="reset" value="취소" />
              </td>
            </tr>
          </tfoot>
        </table>
      </form>
    </div>
  </body>
</html>
