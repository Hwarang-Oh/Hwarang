package com.ssafy.controller;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeptRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeptRegisterServlet() {
    	System.out.println("DeptRegisterServlet()........................");
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("DeptRegisterServlet init()....");
    }
    @Override
    public void destroy() {
    	System.out.println("DeptRegisterServlet destroy()....");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("DeptRegisterServlet doGet()....");
		response.getWriter().append("Served at: ").append(new Date().toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeptRegisterServlet doPost()....");
		
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");

		System.out.println(deptno+"//"+dname+"//"+loc);
		
		
	}

}












