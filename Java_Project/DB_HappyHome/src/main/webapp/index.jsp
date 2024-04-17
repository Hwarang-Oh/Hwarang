<%@page import="com.ssafy.model.dto.User"%> <%@page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="jakarta.tags.core" %>

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
    <%@ include file="header.jsp" %>
    <!--Top Navigation Bar End -->

    <!-- Mid content start -->
    <div class="container-fluid mainImage">
      <div class="overLay"></div>
      <div class="image_Contents">
        <div class="mb-3"><p class="searchTitle">내 최애가 될 공간을 찾으러 가볼까요?</p></div>
        <div class="btn-group mb-4" role="group" aria-label="Basic radio toggle button group">
          <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" />
          <label class="btn btn-outline-dark" for="btnradio1">원룸</label>

          <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off" />
          <label class="btn btn-outline-dark" for="btnradio2">빌라 투룸</label>

          <input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off" />
          <label class="btn btn-outline-dark" for="btnradio3">오피스텔</label>
        </div>

        <div class="searchFunc">
          <div class="space"></div>
          <div class="col-lg" id="searchText">
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
              <hr />
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
              <hr />
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

    <!--footer Start-->
    <div class="container mt-5" style="max-width: 1800px">
      <div class="row" id="Contact">
        <div class="container mt-3 col-lg-2">
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
        <div class="container mt-6 col-lg-3"></div>
      </div>
    </div>
    <!--footer End-->
    <!-- Latest compiled JavaScript -->
  </body>
</html>
