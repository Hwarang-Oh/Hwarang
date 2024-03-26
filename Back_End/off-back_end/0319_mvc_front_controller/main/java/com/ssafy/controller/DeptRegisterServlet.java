package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.ssafy.model.dao.DeptDAO;
import com.ssafy.model.dao.DeptDAOImpl;
import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.DeptServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/dept/register","/dept/reg"},loadOnStartup = 1)
public class DeptRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeptRegisterServlet doPost()....");
		
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");

		try {
			Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
			boolean result = deptService.registerDept(dept);
			if(result) {
				request.setAttribute("dept", dept); // request를 다음 view에게 전달
//				  / : 자신의 app root
//				request.getRequestDispatcher("../WEB-INF/views/deptSuccess.jsp").forward(request, response);
				getServletContext().getRequestDispatcher("/WEB-INF/views/deptSuccess.jsp").forward(request, response);
				
				return;
			}else {
//				request.setAttribute("errorMsg", "부서등록시 문제가 발생하였습니다.");
//				request.getRequestDispatcher("/deptRegister.jsp").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/deptRegister.jsp");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exceptionMsg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
		} 

		
	}

}












