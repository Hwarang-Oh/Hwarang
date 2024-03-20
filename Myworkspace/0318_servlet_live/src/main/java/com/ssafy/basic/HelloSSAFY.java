package com.ssafy.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloSSAFY
 */
public class HelloSSAFY extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloSSAFY() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 1. data 얻어내기
	 * 2. Logic 처리
	 * 3. 응답 Page to (html) 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setCharacterEncoding("utf-8"); -> 이게 조금 더 맞는 방법
		response.setContentType("text/html; charset-utf-8"); // 이거는 한방에 가능한 것!!
		PrintWriter out = response.getWriter(); // Client와 연결성 => html in Java
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello SSAFY!!! </h1>");
		out.println("<h1>안녕 싸피!!!</h1>"); // 한글 깨짐!! 
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
