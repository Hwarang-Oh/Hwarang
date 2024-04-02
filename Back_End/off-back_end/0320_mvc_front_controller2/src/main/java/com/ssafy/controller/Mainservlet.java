package com.ssafy.controller;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.DeptServiceImpl;

/**
 * Servlet implementation class Mainservlet
 */
public class Mainservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mainservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 없어도 됨
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 어떤 처리를 해야될까요? 
		// 1. 파라미터 이용 - action = list, action = register
		// 2. URL 고유하게 관리하는 방법 이용 - /dept/list.do, /dept/register.do  : Spring에서 관리
		String action = request.getParameter("action"); //우선 action을 받는다
		PageInfo info = new PageInfo(false, "/index.jsp");
		
		try {
			if("dept/list".equals(action)) {
				// 부서 목록 조회 요청 처리
				info = deptList(request, response);
				
			}else if("dept/register".equals(action)) {
				// 부서 등록 요청 처리
				info = registerDept(request, response);
			}else if("dept/registerForm".equals(action)) {
				// 부서 등록 요청 처리
				info = registerDeptForm(request, response);
			}else if("dept/detail".equals(action)) {
				// 상세 조회
				info = getDeptDetail(request,response);				
			}else if("dept/modify".equals(action)){
				info = modifyDept(request,response);		
			}else if("dept/remove".equals(action)) {
				info = removeDept(request, response);
				
			}
			
			// http://localhost:8080/0320_mvc_front_controller/main
			// server root          /app root                
			if(info.isForward()) {
				// forwarding 처리
				//dispatch 알고 forwarding
				
				request.getRequestDispatcher("/WEB-INF/views"+ info.getPath()).forward(request, response);
			}
			else {
				// redirecting 처리
				// "/"은 server root 까지만 처리
				// 즉 0320_mvc_front_controller를 갖고와야한다
				response.sendRedirect(request.getContextPath() + info.getPath());
				
			}
		
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exceptionMsg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return;
		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	protected PageInfo registerDeptForm(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return new PageInfo(true, "/deptRegister.jsp");
	}

	protected PageInfo deptList(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// 부서 조회 후 데이터 저장
			// forwarding 처리만 해주면 된다.
			
			request.setAttribute("depts", deptService.getDepts());
			return new PageInfo(true, "/deptList.jsp");
	}
	
	
	protected PageInfo registerDept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("등록");
		
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		boolean result = deptService.registerDept(dept);
		if(result) {
			request.setAttribute("dept", dept); // request를 다음 view 에게 전달
			return new PageInfo(true, "/deptSuccess.jsp");
			
		}
		else {
			response.sendRedirect(request.getContextPath()+"/deptRegister.jsp");
			return new PageInfo(false, "/deptRegister.jsp");	
		}
	}
	
	private PageInfo getDeptDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		Dept dept = deptService.getDept(deptno);
		request.setAttribute("dept", dept);
		return new PageInfo(true, "/deptDetail.jsp");
	}
	
	private PageInfo modifyDept(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// request 요청을 받아가지고 new dept를 만든다
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		deptService.modifyDept(dept);
		request.setAttribute("dept", dept);
		return new PageInfo(false, "/main?action=dept/list");
	}
	
	private PageInfo removeDept (HttpServletRequest request, HttpServletResponse response) throws Exception{
		int deptno = Integer.parseInt(request.getParameter("deptno")); // request의 deptnumber를 찾는다
		deptService.removeDept(deptno);
		return new PageInfo(false, "/main?action=dept/list");
	}
}
