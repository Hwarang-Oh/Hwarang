<%@page import="java.util.List"%> <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <script
      defer
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>

    <title>Insert title here</title>
  </head>
  <body>
    <div class="container">
      <div class="row mt-3">
        <h2 class="bg-primary text-light text-center">도서 목록</h2>
      </div>
      <div class="row">
        <table class="table table-striped table-hover">
          <thead>
            <tr>
              <tr class="text-center">
                <th scope="col">도서 번호</th>
                <th scope="col">ISBN</th>
                <th scope="col">저자</th>
                <th scope="col">가격</th>
              </tr>
            </tr>
          </thead>
          <tbody>
          <c:set var="counter" value="1"/>
          <c:forEach var="book" items="${Books}">
          	<tr class="text-center">
          	  <th scope="row">${counter}</th>
          	  <td class="text-start">
          	  	<a
          	  	  href="#"
          	  	  class="book-title link-sark"
          	  	  style="text-decoration: none"
          	  	> ${book.isbn}</a>
          	  </td>
          	  <td>${book.author}</td>
          	  <td>${book.price}</td>
          	</tr>
          	<c:set var="counter" value="${counter + 1}"/>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="row">
          <ul class="pagination justify-content-center">
            <li class="page-item">
              <a class="page-link" href="#">이전</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item active">
              <a class="page-link" href="#">2</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">다음</a></li>
          </ul>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>
    </div>
  </body>
</html>