package com.ssafy.ws.step3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ssafy.ws.step3.dto.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if (action != null && action.equals("regist")) {
			String isbn = req.getParameter("isbn");
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			int price = Integer.parseInt(req.getParameter("price"));
			String desc = req.getParameter("desc");
			
			try {
				Book book = new Book(isbn, title, author, price, desc);
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<html><body>");
				out.println("<h2>입력 내용</h2>");
				out.println(book.toString());
				out.println("</body></html>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
