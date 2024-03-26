package com.ssafy.basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class ParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		
		String name = req.getParameter("username");
		String pwd = req.getParameter("userpwd");
		String[] fruit = req.getParameterValues("fruit");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body><h1>과일 선호도 조사</h1>" + name + "(" + pwd + ")님이 가장 좋아하는 과일은?");
		if (fruit != null) {
			for (int i = 0 ; i < fruit.length ; i++) {
				out.println(fruit[i]);
				if (i != fruit.length - 1) out.print(", ");
			}
			out.println("입니다!");
		} else out.println("없습니다.");
		out.println("</body></html>");
	}
}