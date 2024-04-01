<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>다음 지도 API</title>
    <script type="text/javascript" src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=3b0744fab3aecc6b20f2a1b03967b619&libraries=services">
    </script>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />
    <link rel="stylesheet" href="./assets/css/map.css" />
  </head>
  <body>
    <!-- Eng : Montserrat, KR : Noto Sans KR; -->
    <!--Top Navigation Bar-->
    <nav class="navbar navbar-expand-md bg-light navbar-light fixed-top">
      <div class="container-fluid">
        <a class="navbar-brand text-primary fw-bold" href="#">
          <!-- height 삭제 : 자동 비율 맞춤 고려 -->
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
          </ul>

          <ul class="navbar-nav">
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

          <!-- navbar-nav ms-auto me-2 : end로부터 Margin 2, start로부터 Margin auto 화면의 변화에 따라 맞게!-->
          <ul class="navbar-nav ms-auto me-2" id="loggedFalse">
            <li class="nav-item">
              <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#logInModal"
                >로그인</a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#makeAccountModal"
                >회원가입</a
              >
            </li>
          </ul>

          <ul class="navbar-nav ms-auto me-2 d-none" id="loggedTrue1">
            <li class="nav-item">
              <a class="nav-link" href="#" id="trylogOut">로그아웃</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">마이페이지</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!--Top Navigation Bar End -->

    <!-- 중앙 content start -->
    <div class="container-fluid shadow">
      <div style="height: 80px"></div>
      <!--Top Contents Start -->
      <!--Second Navigation Bar Start -->
      <div class="row" id="loggedTrue2">
        <div class="col-lg-5">
          <p class="welcome">최애의 공간을 찾아보세요!</p>
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
    </div>
    <div class="container-fluid">
      <div class="row mt-3">
        <div class="col-lg-3">
          <table class="table table-hover text-center" style="display: none">
            <tr id="aptHeader">
              <th>아파트이름</th>
              <th>층</th>
              <th>면적</th>
              <th>최근거래금액</th>
            </tr>
            <tbody id="aptlist"></tbody>
          </table>
        </div>

        <div class="col-lg-9" id="mapBox">
          <div class="mt-3 d-flex justify-content-center align-self-center" id="mapContainer">
            <div class="mt-3" id="map" style="width: 70%; height: 1000px"></div>
          </div>
        </div>
      </div>
    </div>
        <script src="./assets/js/map.js"></script>
  </body>
</html>
