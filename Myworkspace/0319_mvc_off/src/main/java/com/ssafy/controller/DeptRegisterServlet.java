package com.ssafy.controller;

import java.io.IOException;

import com.ssafy.dto.Dept;
import com.ssafy.service.DeptService;
import com.ssafy.service.DeptServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeptRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptServiceImpl();
	
	// Why doPost로 했을까? dept/register은 Post방식!!
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DeptRegisterServlet doPost()...");
		String deptno = req.getParameter("deptno");
		String dname = req.getParameter("dname");
		String loc = req.getParameter("loc");
		
		try {
			Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
			boolean result = deptService.registerDept(dept);
			if (result) {
				req.setAttribute("dept", dept);
				getServletContext().getRequestDispatcher("/WEB-INF/views/deptSuccess.jsp").forward(req, resp);
				return;
			} else {
				resp.sendRedirect(req.getContextPath() + "/deptRegister.jsp");
				return;
			}
		} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("exceptionMsg", e.getMessage());
				req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
		}
	}
}
