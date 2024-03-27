<%@page import="com.ssafy.model.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous"/>
    <link href="<%= root %>/assets/css/app.css" rel="stylesheet"/>
    <title>SSAFY</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
            <h2 class="my-3 py-3 shadow-sm bg-light text-center">
                <mark class="orange">마이페이지</mark>
            </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
            <form id="form-Modify" method="POST" action="main?action=user/modify">
                <div class="mb-3">
                    <label for="userid" class="form-label">아이디:</label>
                    <input type="text" class="form-control" id="userId" name="userId" value="<%=user.getUserId() %>"
                           readonly/>
                </div>
                <div class="mb-3">
                    <label for="userpwd" class="form-label">비밀번호:</label>
                    <input type="text" class="form-control" id="userPwd" name="userPwd"
                           value="<%=user.getUserPwd() %>"/>
                </div>
                <div class="mb-3">
                    <label for="username" class="form-label">이름:</label>
                    <input type="text" class="form-control" id="userName" name="userName"
                           value="<%=user.getUserName() %>"/>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">주소:</label>
                    <input type="text" class="form-control" id="userAddress" name="userAddress"
                           value="<%=user.getAddress() %>"/>
                </div>
                <div class="mb-3">
                    <label for="phoneNum" class="form-label">전화번호:</label>
                    <input type="text" class="form-control" id="userPhone" name="userPhone"
                           value="<%=user.getPhoneNum() %>"/>
                </div>
                <button type="button" class="btn btn-outline-success mb-3" id="btn-modify">정보수정</button>
            </form>
            <form id="form-Delete" method="POST" action="main?action=user/remove">
                <input type="hidden" name="userId" value="<%=user.getUserId() %>">
                <button type="submit" class="btn btn-outline-danger mb-3" id="btn-remove">탈퇴하기</button>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<script>
    document.getElementById('btn-modify').addEventListener('click', function () {
        if (!document.getElementById('userName').value.trim() ||
            !document.getElementById('userPwd').value.trim() ||
            !document.getElementById('userAddress').value.trim() ||
            !document.getElementById('userPhone').value.trim()) {
            alert('모든 필드를 입력하세요.');
            return;
        }
        document.getElementById('form-Modify').submit();
    });
</script>
</body>
</html>
