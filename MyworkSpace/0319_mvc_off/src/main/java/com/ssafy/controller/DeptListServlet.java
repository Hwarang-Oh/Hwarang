package com.ssafy.controller;

import java.io.IOException;

import com.ssafy.service.DeptService;
import com.ssafy.service.DeptServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// HttpServlet을 Extends하는 Method가 가장 편함
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptServiceImpl();
	
	// Why doGet으로 했을까? deptList를 불러오는 요청은 Get 방식 ( by url Moving )
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 부서 정보를 조회하고, view Page에 전달하기 위한 Data를 저장
			req.setAttribute("depts", deptService.getDepts());
			
			// request를 유지하기 위한 Forwarding 기법
			req.getRequestDispatcher("/WEB-INF/views/deptList.jsp").forward(req, resp);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("exceptionMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			return;
		}
	}
}
