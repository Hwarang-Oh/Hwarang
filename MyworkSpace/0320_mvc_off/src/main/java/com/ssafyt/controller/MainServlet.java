package com.ssafyt.controller;

import java.io.IOException;

import com.ssafy.dto.Dept;
import com.ssafy.dto.PageInfo;
import com.ssafy.service.DeptService;
import com.ssafy.service.DeptServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet { // 해당 Controller는 request에 따라, 알맞는 model (service)에 교통정리를 해줘야 한다..!
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptServiceImpl();
	
	public MainServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 모든 요청은 MainServlet에게 들어온다 => 여기서 Get / Post 방식의 요청 처리를 구분해야 한다 => 구분하고 해당 Service / Model에 전달
		// 요청 처리를 구분하는 방법은 2가지 존재 
		// => 구분하기 위한 Parameter를 사용 -> action = list, register ...
		// => 각각 URL을 고유하기 관리하는 Method -> /dept/list.do, /dept/register.do
		
		String action = req.getParameter("action");
		System.out.println(action);
		PageInfo info = new PageInfo(false, "/index.jsp");
		
		try {
			if ("dept/list".equals(action))
				info = deptList(req,resp);
			else if ("dept/register".equals(action))
				info = registerDept(req, resp);
			else if ("dept/registerDeptForm".equals(action))
				info = registerDeptForm(req, resp);
			else if ("dept/detail".equals(action))
				info = getDeptDetail(req, resp);
			else if ("dept/modify".equals(action))
				info = modifyDept(req, resp);
			else if ("dept/remove".equals(action))
				info = removeDept(req, resp);                          
		
			if (info.isForward())
				req.getRequestDispatcher("/WEB-INF/views" + info.getPath()).forward(req, resp);
			else
				resp.sendRedirect(req.getContextPath() + info.getPath());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("exceptionMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			return;	
		}
	}
	// Why Forwarding? Why Redirecting?
	
	protected PageInfo deptList(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 부서 조회 후 데이터 저장 -> forwarding 처리
		req.setAttribute("depts", deptService.getDepts());
		return new PageInfo(true, "/deptList.jsp");
	}
	
	protected PageInfo registerDept(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("등록");
		String deptno = req.getParameter("deptno");
		String dname = req.getParameter("dname");
		String loc = req.getParameter("loc");
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		boolean result = deptService.registerDept(dept);
		if(result) {
			req.setAttribute("dept", dept); // request를 다음 view 에게 전달
			return new PageInfo(true, "/deptSuccess.jsp");
		}
		else {
			resp.sendRedirect(req.getContextPath()+"/deptRegister.jsp");
			return new PageInfo(false, "/deptRegister.jsp");	
		}
	}
	
	protected PageInfo registerDeptForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return new PageInfo(true, "/deptRegister.jsp");
	}
	
	protected PageInfo getDeptDetail(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int deptno = Integer.parseInt(req.getParameter("detpno"));
		Dept dept = deptService.getDept(deptno);
		req.setAttribute("dept", dept);
		return new PageInfo(true, "/deptDetail.jsp");
	}
	
	protected PageInfo modifyDept(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String deptno = req.getParameter("deptno");
		String dname = req.getParameter("dname");
		String loc = req.getParameter("loc");
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		deptService.modifyDept(dept);
		req.setAttribute("dept", dept);
		return new PageInfo(false, "/main?action=dept/list");
	}
	
	protected PageInfo removeDept(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int deptno = Integer.parseInt(req.getParameter("deptno"));
		deptService.removeDept(deptno);
		return new PageInfo(false, "/main?action=dept/list");
	}
}