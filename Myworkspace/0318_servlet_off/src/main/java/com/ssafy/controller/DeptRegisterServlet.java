package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import com.ssafy.model.dao.DeptDAO;
import com.ssafy.model.dto.Dept;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeptRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeptRegisterServlet() {
    	System.out.println("DeptRegisterServlet()........................");
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("DeptRegisterServlet init()....");
    }
    @Override
    public void destroy() {
    	System.out.println("DeptRegisterServlet destroy()....");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("DeptRegisterServlet doGet()....");
		response.getWriter().append("Served at: ").append(new Date().toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeptRegisterServlet doPost()....");
		
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");

		System.out.println(deptno+"//"+dname+"//"+loc);
		
		response.setContentType("text/html;charset=utf-8"); // application/json , text/xml
		PrintWriter out = response.getWriter(); // 파일 형태는 getOutPutStream(0
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("</head>");
		out.println("<body>");
		
		DeptDAO deptDAO = new DeptDAO();
		try {
			int result = deptDAO.insertDept(new Dept(Integer.parseInt(deptno), dname, loc));
			if (result > 0) { // 등록 성공
				out.println("<h1> 등록에 성공했습니다 </h1>");
				out.println("<h2> 등록하신 정보는 다음과 같습니다. </h2>");
				out.println("<h3>" + deptno +"," + dname + "," + loc + "</h3>");
			} else {
				out.println("<h1> 등록에 실패했습니다.</h1>");
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("<h1> 처리 중 문제가 발생했습니다. </h1>");
		} 
		
		out.println("</body>");
		out.println("</html>");
	}

}












