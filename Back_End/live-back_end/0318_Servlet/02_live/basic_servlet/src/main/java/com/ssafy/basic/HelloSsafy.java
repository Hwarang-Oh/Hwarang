package com.ssafy.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloSsafy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloSsafy() {
        super();
        System.out.println("Hello SSAFY 생성자 호출!!");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("		<h1>Hello SSSAFY !!!</h1>");
		out.println("		<h1>안녕 싸피 !!!</h1>");
		out.println("	</body>");
		out.println("</html>");
		
		
	}

}
