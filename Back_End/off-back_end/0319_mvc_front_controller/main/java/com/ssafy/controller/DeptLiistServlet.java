package com.ssafy.controller;

import java.io.IOException;

import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.DeptServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptLiistServlet
 */
public class DeptLiistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
			request.setAttribute("depts",deptService.getDepts());
			// request 유지하기 위해 포워딩!
			request.getRequestDispatcher("/WEB-INF/views/deptList.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exceptionMsg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return;
		}
	}

}















