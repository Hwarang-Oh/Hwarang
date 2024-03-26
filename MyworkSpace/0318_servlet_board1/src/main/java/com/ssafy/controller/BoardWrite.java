package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.ssafy.model.dao.BoardDao;
import com.ssafy.model.dao.BoardDaoImpl;
import com.ssafy.model.dto.BoardDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class BoardWrite extends HttpServlet { // Write의 요청은 Post 형식으로 들어온다
	private static final long serialVersionUID = 1L;
	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userid");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		try {
			BoardDto boardDto = new BoardDto();
			boardDto.setUserId(userId);
			boardDto.setSubject(subject);
			boardDto.setContent(content);
			int cnt = boardDao.InsertArticle(boardDto);
			System.out.println("글 작성 결과 : " + cnt);
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"ko\">");
			out.println("  <head>");
			out.println("    <meta charset=\"UTF-8\" />");
			out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
			out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
			out.println("    <link");
			out.println("      href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"");
			out.println("      rel=\"stylesheet\"");
			out.println("      integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"");
			out.println("      crossorigin=\"anonymous\"");
			out.println("    />");
			out.println("    <link href=\"../assets/css/app.css\" rel=\"stylesheet\" />");
			out.println("    <title>SSAFY</title>");
			out.println("  </head>");
			out.println("  <body>");
			out.println("    <div class=\"container\">");
			out.println("      <div class=\"row justify-content-center\">");
			out.println("        <div class=\"col-lg-8 col-md-10 col-sm-12\">");
			out.println("          <h2 class=\"my-3 py-3 shadow-sm bg-light text-center\">");
			out.println("            <mark class=\"sky\">글쓰기 결과</mark>");
			out.println("          </h2>");
			out.println("        </div>");
			out.println("        <div class=\"col-lg-8 col-md-10 col-sm-12\">");
			if (cnt != 0) {
				out.println("          <div class=\"card text-center bg-light\">");
				out.println("            <h2 class=\"fw-bold text-primary pt-3\">등록 완료!!!</h2>");
				out.println("            <div class=\"card-body\">");
				out.println("              <p class=\"card-text\">글작성이 완료되었습니다.</p>");
				out.println("              <button type=\"button\" id=\"btn-list\" class=\"btn btn-outline-primary\">");
				out.println("                글목록 페이지 이동...");
				out.println("              </button>");
				out.println("            </div>");
				out.println("          </div>");
			} else {
				out.println("          <div class=\"card text-center bg-light\">");
				out.println("            <h2 class=\"fw-bold text-danger pt-3\">등록 실패T.T</h2>");
				out.println("            <div class=\"card-body\">");
				out.println("              <p class=\"card-text\">");
				out.println("                글작성에 문제가 있습니다. <br />");
				out.println("                잠시 후 시도해주세요.");
				out.println("              </p>");
				out.println("              <button type=\"button\" id=\"btn-list\" class=\"btn btn-outline-danger\">");
				out.println("                글목록 페이지 이동...");
				out.println("              </button>");
				out.println("            </div>");
				out.println("          </div>");
			}

			out.println("        </div>");
			out.println("      </div>");
			out.println("    </div>");
			out.println("    <script");
			out.println("      src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"");
			out.println("      integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\"");
			out.println("      crossorigin=\"anonymous\"");
			out.println("    ></script>");
			out.println("    <script>");
			out.println("      document.querySelector(\"#btn-list\").addEventListener(\"click\", function () {");
			out.println("        location.href = \"/0318_servlet_board1/list\";");
			out.println("      });");
			out.println("    </script>");
			out.println("  </body>");
			out.println("</html>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
