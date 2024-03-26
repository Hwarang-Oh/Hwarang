package com.ssafy.basic;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/life")
public class LifeCylce extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LifeCylce() {
		System.out.println("Construct!!");
	}
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init!!");
	}
	
	public void destroy() {
		System.out.println("Destroy!!");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("Service!!");
	}
}
