<%@page import="com.ssafy.model.dto.User"%> <%@page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%> <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>최애 SPACE</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="./assets/css/main.css" />
  </head>
  <body>
    <!--Top Navigation Bar Start -->
    <nav class="navbar navbar-expand-md bg-light navbar-light fixed-top">
      <div class="container-fluid">
        <a class="navbar-brand text-primary fw-bold" href="main?action=user/home">
          <img src="./assets/img/HosinoLogoTitle.png" width="300" alt="" />
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#collapsibleNavbar"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="#">원룸</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">빌라 투룸</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">오피스텔</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                >중개 사무소 및 광고 문의</a
              >
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#">중개 사무소 문의</a></li>
                <li><a class="dropdown-item" href="#">광고 문의</a></li>
              </ul>
            </li>
          </ul>

          <c:if test="${empty userInfo}">
            <ul class="navbar-nav ms-auto me-2" id="loggedFalse">
              <li class="nav-item">
                <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#logInModal"
                  >로그인</a
                >
              </li>
              <li class="nav-item">
                <a
                  class="nav-link"
                  href="#"
                  data-bs-toggle="modal"
                  data-bs-target="#makeAccountModal"
                  >회원가입</a
                >
              </li>
            </ul>
          </c:if>
          <c:if test="${not empty userInfo}">
            <ul class="navbar-nav ms-auto me-2" id="loggedTrue1">
              <li class="nav-item">
                <a class="nav-link" href="main?action=user/logout" id="trylogOut">로그아웃</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="main?action=user/myPage">마이페이지</a>
              </li>
            </ul>
          </c:if>
        </div>
      </div>
    </nav>
    <!--Top Navigation Bar End -->

    <!-- Mid content start -->
    <div class="container-fluid" id="WelcomeBar">
      <div style="height: 80px"></div>
      <!--Top Mid Contents Start -->
      <!--Second Navigation Bar Start -->
      <c:if test="${not empty userInfo}">
        <div class="row" id="loggedTrue2">
          <div class="col-lg-5" id="welcomeText">
            <!-- 숨긴 div 와 어느정도 거리 조절용 mt-3 -->
            <!-- 상단 navBar에 이미지가 붙어 있음 -->
            <p class="welcome">${userInfo.userName}님 안녕하세요!</p>
          </div>
          <div class="col-lg-7">
            <nav class="navbar navbar-expand-md">
              <div class="container-fluid">
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                  <ul class="navbar-nav ms-auto me-2">
                    <li class="nav-item">
                      <a class="nav-link" href="#">공지사항</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">오늘의 뉴스</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">자유글</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">관심지역 설정</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">관심지역 둘러보기</a>
                    </li>
                  </ul>
                </div>
              </div>
            </nav>
          </div>
        </div>
      </c:if>
      <!--Second Navigation Bar End -->
    </div>
    <!--Top Contents End -->
    <!--LogIN Modal-->
    <div
      class="modal fade"
      id="logInModal"
      data-bs-backdrop="static"
      data-bs-keyboard="false"
      tabindex="-1"
      aria-labelledby="staticBackdropLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">
              <i class="bi bi-chat-left-dots-fill">반가워요!</i>
            </h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>

          <div class="modal-body">
            <form action="main">
              <input type="hidden" name="action" value="user/login" />
              <div class="row g-3 align-items-center mb-3">
                <div class="col-auto">
                  <label for="inputRegistID" class="col-form-label">아이디</label>
                </div>
                <div class="col-6">
                  <input
                    type="text"
                    id="joinID"
                    name="userId"
                    class="form-control"
                    aria-describedby="IDHelpInline"
                  />
                </div>
                <div class="col-auto">
                  <span id="IDHelpInline" class="form-text"> Must be 8-20 characters long. </span>
                </div>
              </div>
              <div class="row g-3 align-items-center mb-3">
                <div class="col-auto">
                  <label for="inputRegistPassword" class="col-form-label">비밀번호</label>
                </div>
                <div class="col-6">
                  <input
                    type="password"
                    id="joinPWD"
                    name="userPwd"
                    class="form-control"
                    aria-describedby="IDHelpInline"
                  />
                </div>
                <div class="col-auto">
                  <span id="IDHelpInline" class="form-text"> Must be 8-20 characters long. </span>
                </div>
              </div>
              <button type="submit" id="trylogIn" class="btn btn-primary btn-sm">로그인</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!--LogIN Modal-->

    <!--MakeAccount Modal-->
    <div
      class="modal fade"
      id="makeAccountModal"
      data-bs-backdrop="static"
      data-bs-keyboard="false"
      tabindex="-1"
      aria-labelledby="staticBackdropLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">
              <i class="bi bi-chat-left-dots-fill">최애 공간을 만나러 가볼까요?</i>
            </h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>
          <div class="modal-body">
            <form action="main">
              <input type="hidden" name="action" value="user/register" />
              <div class="row g-3 align-items-center mb-3">
                <div class="col-auto">
                  <label for="inputRegistID" class="col-form-label">아이디</label>
                </div>
                <div class="col-6">
                  <input
                    type="text"
                    id="joinID"
                    name="userId"
                    class="form-control"
                    aria-describedby="IDHelpInline"
                  />
                </div>
                <div class="col-auto">
                  <span id="IDHelpInline" class="form-text"> Must be 8-20 characters long. </span>
                </div>
              </div>
              <div class="row g-3 align-items-center mb-3">
                <div class="col-auto">
                  <label for="inputRegistPassword" class="col-form-label">비밀번호</label>
                </div>
                <div class="col-6">
                  <input
                    type="password"
                    id="joinPWD"
                    name="userPwd"
                    class="form-control"
                    aria-describedby="IDHelpInline"
                  />
                </div>
                <div class="col-auto">
                  <span id="IDHelpInline" class="form-text"> Must be 8-20 characters long. </span>
                </div>
              </div>
              <div class="row g-3 align-items-center mb-3">
                <div class="col-auto">
                  <label for="inputRegistName" class="col-form-label">이름</label>
                </div>
                <div class="col-6">
                  <input
                    type="text"
                    id="joinName"
                    name="userName"
                    class="form-control"
                    aria-describedby="IDHelpInline"
                  />
                </div>
                <div class="col-auto">
                  <span id="IDHelpInline" class="form-text"> Must be 8-20 characters long. </span>
                </div>
              </div>
              <div class="row g-3 align-items-center mb-3">
                <div class="col-auto">
                  <label for="inputRegistAddr" class="col-form-label">주소</label>
                </div>
                <div class="col-6">
                  <input
                    type="text"
                    id="joinAddress"
                    name="userAddress"
                    class="form-control"
                    aria-describedby="IDHelpInline"
                  />
                </div>
                <div class="col-auto">
                  <span id="IDHelpInline" class="form-text"> Must be 8-20 characters long. </span>
                </div>
              </div>
              <div class="row g-3 align-items-center mb-3">
                <div class="col-auto">
                  <label for="inputRegistPhone" class="col-form-label">전화번호</label>
                </div>
                <div class="col-6">
                  <input
                    type="text"
                    id="joinPhone"
                    name="userPhone"
                    class="form-control"
                    aria-describedby="IDHelpInline"
                  />
                </div>
              </div>
              <button type="submit" id="tryJoin" class="btn btn-primary btn-sm">회원 가입</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <c:if test="${not empty ErrorMsg}">
      <script>
        alert('${ErrorMsg}');
      </script>
      <c:remove var="ErrorMsg" />
    </c:if>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
