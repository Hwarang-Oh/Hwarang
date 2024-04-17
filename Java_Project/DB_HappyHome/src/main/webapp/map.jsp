<%@page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>최애의 지도</title>
    <script
      type="text/javascript"
      src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=3b0744fab3aecc6b20f2a1b03967b619&libraries=services"
    ></script>
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
    <link rel="stylesheet" href="./assets/css/main.css" />
  </head>
  <body>
    <!--Top Navigation Bar-->
    <%@ include file="header.jsp" %>
    <!-- 중앙 content start -->
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
