package com.ssafy.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.controller.util.ControllerMapping;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.DeptServiceImpl;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptServiceImpl();
	private ControllerMapping controllerMapping = new ControllerMapping();
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ServletContext Application = getServletContext();
		Application.setAttribute("root", Application.getContextPath());
	}
	
	
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
		
		Controller controller = controllerMapping.getController(action);
		
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		try {
			Object info = controller.handleRequest(request, response);
			if (info != null) {
				if (info instanceof PageInfo) {
					PageInfo pInfo = (PageInfo) info;
					if(pInfo.isForward()) {
						request.getRequestDispatcher("/WEB-INF/views"+pInfo.getPath()).forward(request, response);
						return;
					} else {
						response.sendRedirect(request.getContextPath()+pInfo.getPath()); //  /0320_mvc_front_controller/xxxxx
					}
				}
			} else if (info instanceof DataInfo) {
				DataInfo dInfo = (DataInfo) info;
				response.setContentType(dInfo.getContentType());
				if (dInfo.getContentType().contains("json")) {
					ObjectMapper mapper = new ObjectMapper();
					response.getWriter().println(mapper.writeValueAsString(dInfo.getData()));
				}
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
	
	protected PageInfo deptModify(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
		
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		deptService.modifyDept(dept);
		return new PageInfo(false, "/main?action=dept/list");		
//		request.setAttribute("depts", deptService.getDepts());
//		return new PageInfo(true, "/deptList.jsp");
	}
	
	protected PageInfo deptDelete(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
		
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		deptService.removeDept(dept.getDeptno());
		return new PageInfo(false, "/main?action=dept/list");	
//		request.setAttribute("depts", deptService.getDepts());
//		return new PageInfo(true, "/deptList.jsp");
	}
}











