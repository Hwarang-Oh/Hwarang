package com.ssafy.ws.step3.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step3.dto.Book;
import com.ssafy.ws.step3.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		
		if (action.equals("login")) {
			login(req, resp);
		} else if (action.equals("logout")) {
			logout(req, resp);
		} else if (action.equals("regist")) {
			regist(req, resp);
		} else if (action.equals("list")){
			list(req, resp);
		}else {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
	
	protected void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("inputId");
		String pwd = req.getParameter("inputPwd");
		if (id.equals("ssafy") && pwd.equals("1234")) {
			User user = new User(id, pwd, "김싸피");
			HttpSession session = req.getSession();
			session.setAttribute("userInfo", user);
			
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("logInErrorMsg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요.");
		}
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}
	
	protected void logout(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("userInfo");
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}
	
	protected void regist(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Book book = new Book();
		try {
			book.setIsbn(req.getParameter("isbn"));
			book.setTitle(req.getParameter("title"));
			book.setAuthor(req.getParameter("author"));
			book.setPrice(Integer.parseInt(req.getParameter("price")));
			book.setDesc(req.getParameter("desc"));
			req.setAttribute("Book", book);
			req.getRequestDispatcher("/regist_result.jsp").forward(req, resp);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Book> books = new ArrayList<>();
		books.add(new Book("111-222-333", "자바 프로그래밍", "조용준", 25000, "좋은 Java 책"));
		books.add(new Book("111-222-444", "HTML5 API", "조용준", 30000, "좋은 HTML 책"));
		books.add(new Book("111-222-555", "Spring Framework", "홍길동", 45000, "좋은 Spring 책")); 
		books.add(new Book("111-222-666", "Vue", "임꺽정", 35000, "좋은 Vue 책")); 
		req.setAttribute("Books", books);
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}

}
