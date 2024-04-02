package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int id = 1;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if (action != null && action.equals("regist")) {
			try {
				String title = req.getParameter("title");
				String director = req.getParameter("director");
				String genre = req.getParameter("genre");
				int runningTime = Integer.parseInt(req.getParameter("runningTime"));
				Movie movie = new Movie(id++, title, director, genre, runningTime);
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<html><body><h2>영화 정보</h2>");
				out.println(movie.toString());
				out.println("</body></html>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
