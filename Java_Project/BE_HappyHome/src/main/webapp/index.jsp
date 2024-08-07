<%@page import="com.ssafy.model.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%
String root = request.getContextPath();
User user = (User)session.getAttribute("userinfo");
%>
   
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>최애 SPACE</title>
    <!-- Latest compiled and minified CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="./assets/css/main.css" />
  </head>
  <body>
  	<!--Top Navigation Bar Start -->
    <nav class="navbar navbar-expand-md bg-light navbar-light fixed-top">
      <div class="container-fluid">
        <a class="navbar-brand text-primary fw-bold" href="#">
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
          
          
          <% if(user == null) { %>
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
          <%} else { %>

          <ul class="navbar-nav ms-auto me-2" id="loggedTrue1">
            <li class="nav-item">
              <a class="nav-link" href="main?action=user/logout" id="trylogOut">로그아웃</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="main?action=user/myPage">마이페이지</a>
            </li>
          </ul>
          <% } %>
          
          
        </div>
      </div>
    </nav>
    <!--Top Navigation Bar End -->

    <!-- Mid content start -->
    <div class="container-fluid" id="WelcomeBar">
      <div style="height: 80px"></div>
      <!--Top Mid Contents Start -->
      <!--Second Navigation Bar Start -->
      
      <% if(user != null) { %>
      <div class="row" id="loggedTrue2">
        <div class="col-lg-5" id="welcomeText">
          <!-- 숨긴 div 와 어느정도 거리 조절용 mt-3 -->
          <!-- 상단 navBar에 이미지가 붙어 있음 -->
          <p class="welcome"><%=user.getUserName() %>님 안녕하세요!</p>
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
        <%} %>
        
        
      </div>
      <!--Second Navigation Bar End -->
      <div>
        <div class="mainImage">
          <div class="overLay"></div>
          <div class="image_Contents">
            <div class="mb-5"><p class="searchTitle">내 최애가 될 공간을 찾으러 가볼까요?</p></div>
            <div class="btn-group mb-4" role="group" aria-label="Basic radio toggle button group">
              <input
                type="radio"
                class="btn-check"
                name="btnradio"
                id="btnradio1"
                autocomplete="off"
              />
              <label class="btn btn-outline-dark" for="btnradio1">원룸</label>

              <input
                type="radio"
                class="btn-check"
                name="btnradio"
                id="btnradio2"
                autocomplete="off"
              />
              <label class="btn btn-outline-dark" for="btnradio2">빌라 투룸</label>

              <input
                type="radio"
                class="btn-check"
                name="btnradio"
                id="btnradio3"
                autocomplete="off"
              />
              <label class="btn btn-outline-dark" for="btnradio3">오피스텔</label>
            </div>

            <div class="searchFunc">
              <div class="col-lg-10" id="searchText">
                <input
                  type="text"
                  placeholder="원하시는 지역명, 지하철역, 단지명(아파트명)을 입력해주세요"
                  autocomplete="off"
                  class="inputText"
                />
              </div>
              <div class="col-lg-2" id="searchImg" tabindex="0">
                <a href="./map.jsp"
                  ><img src="./assets/img/ic_search.png" alt="찾아보기" class="inputImg"
                /></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--Top Contents End -->

    <!--Mid Contents Start-->
    <div class="container" id="MidContent" style="max-width: 1800px">
      <div class="row mt-5">
        <div class="container mt-3 col-lg-3">
          <div class="postTable">
            <p>최애 추천정보</p>
          </div>
          <hr />
          <img class="" src="./assets/img/advertise.png" width="100%" alt="" />
        </div>
        <div class="container mt-3 col-lg-3">
          <div class="postTable">
            <p>오늘의 뉴스</p>
            <button type="button">더 보기</button>
          </div>
          <table class="table table-hover table-borderless">
            <thead>
              <hr/>
            </thead>
            <tbody>
              <tr>
                <td>
                  <a href="#" class="eachPost">중개사 전세사기 책임보장…직방, '지킴중개' 론칭</a>
                </td>
              </tr>
              <tr>
                <td><a href="#" class="eachPost">2월 아파트 매매 거래 중 43%는 상승거래</a></td>
              </tr>
              <tr>
                <td><a href="#" class="eachPost">VR로 집구경 미리 해보고 산다</a></td>
              </tr>
              <tr>
                <td><a href="#" class="eachPost">'방 3개짜리 원룸' 나온다</a></td>
              </tr>
              <tr>
                <td><a href="#" class="eachPost">나의 공간을 내 취향대로</a></td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="container mt-3 col-lg-3">
          <div class="postTable">
            <p>공지사항</p>
            <button type="button">더 보기</button>
          </div>
          <table class="table table-hover table-borderless">
            <thead>
              <hr/>
            </thead>
            <tbody>
              <tr>
                <td>
                  <a href="#" class="eachPost"
                    >[공지] 최애 SPACE 개인정보처리방침 (2024/01/12) 개정안내</a
                  >
                </td>
              </tr>
              <tr>
                <td>
                  <a href="#" class="eachPost"
                    >[공지] 최애 SPACE 개인정보처리방침 (2023/09/21) 개정안내</a
                  >
                </td>
              </tr>
              <tr>
                <td>
                  <a href="#" class="eachPost"
                    >[공지] 최애 SPACE 위치기반서비스 이용약관 (2023/09/21) 개정안내</a
                  >
                </td>
              </tr>
              <tr>
                <td>
                  <a href="#" class="eachPost"
                    >[공지] 최애 SPACE 개인정보처리방침 (2023/06/01) 개정안내</a
                  >
                </td>
              </tr>
              <tr>
                <td><a href="#" class="eachPost">[공지] 최애 SPACE 서비스 정상화 안내</a></td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <!--Mid Contents End-->
    <!--End Contents Start-->
    <!--End Contents End-->

    <!--footer Start-->
    <footer>
      <div class="container mt-5" style="max-width: 1800px">
        <div class="row" id="Contact">
          <div class="container col-lg-4">
            <img src="./assets/img/HosinoSpaceLogo.png" alt="" />
          </div>
          <div class="container col-lg-4" id="ContactInfo">
            <p class="title">Contact Us</p>
            <hr />
            <div>
              <p>(SSAFY) 서울시 강남구 테헤란로 멀티스퀘어 501호</p>
            </div>
            <div>
              <p>1544-9001</p>
            </div>
            <div>
              <a href="https://github.com/Hwarang-Oh/Hwarang">HosinoSpace@Hosino.com</a>
            </div>
          </div>
          <div class="container col-lg"></div>
        </div>
      </div>
    </footer>
    <!--footer End-->

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
          <input type="hidden" name="action" value="user/login"/>
          <div class="row g-3 align-items-center mb-3">
            <div class="col-auto">
              <label for="inputRegistID" class="col-form-label">아이디</label>
            </div>
            <div class="col-6">
              <input type="text" id="joinID" name="userId" class="form-control" aria-describedby="IDHelpInline" />
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
        <input type="hidden" name="action" value="user/register"/>
          <div class="row g-3 align-items-center mb-3">
            <div class="col-auto">
              <label for="inputRegistID" class="col-form-label">아이디</label>
            </div>
            <div class="col-6">
              <input type="text" id="joinID" name="userId" class="form-control" aria-describedby="IDHelpInline" />
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
	<%
        String errorMessage = (String)request.getAttribute("logInErrorMsg");
        if (errorMessage != null && !errorMessage.isEmpty()) {
    %>
        <script>
            alert("<%= errorMessage %>");
        </script>
    <% } %>
    
    
    
    
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>