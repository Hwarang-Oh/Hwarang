package com.ssafy.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.controller.util.ControllerMapping;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.PageInfo;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ControllerMapping controllerMapping = new ControllerMapping();
	
	@Override
	public void init() throws ServletException {
		ServletContext application = getServletContext();
		application.setAttribute("root" , application.getContextPath());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		
		Controller controller = controllerMapping.getController(action);
		if(controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		try {
			Object info = controller.handleRequest(request, response);
			if(info != null) {
				if(info instanceof PageInfo) {	
					PageInfo pInfo = (PageInfo) info;
					if(pInfo.isForward()) {
						request.getRequestDispatcher(pInfo.getPath()).forward(request, response);
						return;
					}else {
						response.sendRedirect(request.getContextPath()+pInfo.getPath()); //  /0320_mvc_front_controller/xxxxx
					}
				} else if (info instanceof DataInfo) {
					DataInfo dInfo = (DataInfo) info;
					response.setContentType(dInfo.getContentType());
					
					if(dInfo.getContentType().contains("json")) {
						ObjectMapper mapper = new ObjectMapper();
						response.getWriter().println(mapper.writeValueAsString(dInfo.getData()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exceptionMsg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return;
		}
	}
}


<%@page import="com.ssafy.model.dto.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">부서 목록</h2>
		</div>
		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>부서번호</th>
						<th>부서이름</th>
					</tr>			
				</thead>
				<tbody> <!-- 반복문 조건문은 EL JSTL로 처리할 수 없다. --><!-- 하나씩 꼬ㅓ내서 머할 때 itmes. dept -> 요거 지역변수 아닌다. => 응답으론 다 가는데, data는 옮겨가 있는 현상 발생-->
				<c:choose>
					<c:when test="${not empty depts}"> 
					<c:forEach items="${depts}"  var="dept", valStatus="status">
						<tr>
									<td>${status.count}</td>
									<td>${dept.deptno}</td>
									<td><a href="main?action=dept/detail&deptno=${dept.deptno} "> ${dept.deptno}</a></td>
								</tr>
					</c:forEach>
					
						</c:when>
						<c:otherwise>
							<tr><td colspan="3">등록된 부서 정보가 없습니다.</td></tr>
							</c:otherwise>
							</c:choose>
				
				<%
					// 컨트롤러로부터 전달반은 데이터 꺼내기!
					List<Dept> depts = (List<Dept>)request.getAttribute("depts");
					if(depts != null && depts.size()>0){
						for(int i=0,size =  depts.size(); i<size; ++i ){
							Dept dept = depts.get(i);%>
							<tr>
								<td><%=i+1 %></td>
								<td><%=dept.getDeptno() %></td>
								<td><a href="main?action=dept/detail&deptno=<%=dept.getDeptno() %>"><%=dept.getDname() %></a></td>
							</tr>
				<%	} // end for
					}else{
				%>
					<tr><td colspan="3">등록된 부서정보가 없습니다</td></tr>
				<%} %>
				
				
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>