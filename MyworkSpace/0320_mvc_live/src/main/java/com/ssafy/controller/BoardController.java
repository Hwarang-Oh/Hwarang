package com.ssafy.controller;

import java.io.IOException;

import com.ssafy.model.dto.BoardDto;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.service.BoardService;
import com.ssafy.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L; // Why? MainServlet이 아닐까
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		process(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String action = req.getParameter("action");
		PageInfo info = new PageInfo(false, "/index.jsp");
		
		try {
			if ("board/list".equals(action)) {
				info = boardList(req, resp);
			}
			else if ("board/view".equals(action)) {
				info = boardView(req, resp);
			}
			else if ("board/mvwrite".equals(action)) {
				info = boardmvWrite(req,resp);
			}
			else if ("board/write".equals(action)) {
				info = boardWrite(req, resp);
			}
			else if ("board/mvmodify".equals(action)) {
				
			}
			else if ("board/modify".equals(action)) {
				
			}
			else if ("board/delete".equals(action)) {
				
			}
			else {
			}
		} catch (Exception e) {
			e.printStackTrace();
//			req.setAttribute("exceptionMsg", e.getMessage());
//			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
//			return;
		}
	}
	
	protected PageInfo boardList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setAttribute("articles", boardService.getBoards());
		return new PageInfo(true, "/list.jsp");
	}
	
	protected PageInfo boardView(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int articleNo = Integer.parseInt(req.getParameter("articleno"));
		BoardDto board = boardService.getBoard(articleNo);
		req.setAttribute("article", board);
		return new PageInfo(true, "/view.jsp");
	}
	protected PageInfo boardmvWrite(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return new PageInfo(false, "/main?action=board/write");
	}
	
	protected PageInfo boardWrite(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String userId = req.getParameter("userid");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		BoardDto board = new BoardDto();
		board.setUserId(userId);
		board.setSubject(subject);
		board.setContent(content);
		boolean result = boardService.writeBoard(board);
		if (result) {
			return new PageInfo(true, "/list.jsp");
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/write.jsp");
			return new PageInfo(false, "/write.jsp");
		}
	}
}