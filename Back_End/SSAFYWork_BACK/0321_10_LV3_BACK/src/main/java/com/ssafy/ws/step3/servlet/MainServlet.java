package com.ssafy.ws.step3.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step3.dao.BookDao;
import com.ssafy.ws.step3.dao.BookDaoImpl;
import com.ssafy.ws.step3.dao.UserDao;
import com.ssafy.ws.step3.dao.UserDaoImpl;
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
	private BookDao bookDao = new BookDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	
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
		
		if (action == null) {
	        // If action parameter is not provided, handle it as a 404 error
	        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	        return;
	    }
		
		if (action.equals("login")) {
			login(req, resp);
		} else if (action.equals("logout")) {
			logout(req, resp);
		} else if (action.equals("regist")) {
			regist(req, resp);
		} else if (action.equals("list")){
			list(req, resp);
		} else {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
	
	protected void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("inputId");
		String pwd = req.getParameter("inputPwd");
		try {
			if (userDao.selectUser(id, pwd) == null) {
				HttpSession session = req.getSession();
				session.setAttribute("ErrorMsg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요.");
			}
			else {
				User user = userDao.selectUser(id, pwd);
				HttpSession session = req.getSession();
				session.setAttribute("userInfo", user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String price = req.getParameter("price");
		String desc = req.getParameter("desc");
		try {
			if (bookDao.selectBook(req.getParameter("isbn")) != null ) {
				HttpSession session = req.getSession();
				String ErrorMsg = "도서 등록 실패 : ".concat(req.getParameter("isbn")).concat("은 이미 사용중");
				session.setAttribute("ErrorMsg", ErrorMsg);
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
				return;
			}
			Book book = new Book(isbn, title, author, Integer.parseInt(price), desc);
			bookDao.insertBook(book);

			req.setAttribute("Book", book);
			req.getRequestDispatcher("/regist_result.jsp").forward(req, resp);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath() + "/error/500.jsp");
			return;
		}
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			req.setAttribute("Books", bookDao.selectBooks());
			req.getRequestDispatcher("/list.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
