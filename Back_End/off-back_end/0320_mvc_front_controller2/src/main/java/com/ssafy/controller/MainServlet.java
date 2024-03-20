package com.ssafy.controller;

import java.io.IOException;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.DeptServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 어떤 요청처리인지 구분(방법1: 구분하기 위한 파라미터를 이용 -  action=list, action=register)
			// 어떤 요청처리인지 구분(방법2: url을 고유하게 관리하는 방법이용 -  /dept/list.do, /dept/register.do)
		String action = request.getParameter("action");
		System.out.println(action);
		PageInfo info = new PageInfo(false,"/index.jsp");
		
		try {
			if("dept/list".equals(action)) {
				// 부서 목록 조회 요청 처리
				info = deptList(request,response);
			}else if("dept/register".equals(action)) {
				// 부서 등록 요청 처리
				info = registerDept(request, response);
			}else if("dept/registerForm".equals(action)) {
				// 부서 등록 요청 처리
				info = registerDeptForm(request, response);
			}else if("dept/detail".equals(action)) {
				// 부서상세조회 요청 처리
				info = getDeptDetail(request, response);
			}
			//    http://localhost:8080/0320_mvc_front_controller/main
			
			if(info.isForward()) {
				request.getRequestDispatcher("/WEB-INF/views"+info.getPath()).forward(request, response);
				return;
			}else {
				response.sendRedirect(request.getContextPath()+info.getPath()); //  /0320_mvc_front_controller/xxxxx
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exceptionMsg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return;
		}
		
		
		
	}
	
	
	
	protected PageInfo deptList(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
			request.setAttribute("depts",deptService.getDepts());
			return new PageInfo(true, "/deptList.jsp");
	}
	
	protected PageInfo registerDept(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		boolean result = deptService.registerDept(dept);
		if(result) {
			request.setAttribute("dept", dept); // request를 다음 view에게 전달
			return new PageInfo(true, "/deptSuccess.jsp");
		}else {
			return new PageInfo(false, "/deptRegister.jsp");
		}
	}
	protected PageInfo registerDeptForm(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		return new PageInfo(true, "/deptRegister.jsp");
	}
	
	private PageInfo getDeptDetail(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		Dept dept = deptService.getDept(deptno);
		request.setAttribute("dept", dept);
		return new PageInfo(true, "/deptDetail.jsp");
	}
}











