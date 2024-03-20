package com.ssafy.basic;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/life")
public class LifeCylce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCylce() {
        super();
        System.out.println("생성자 호출!");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init 호출!!");
	}

	public void destroy() { 
		System.out.println("Destory 호출!!");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Service 호출!!");
	}
}
