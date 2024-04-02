package com.ssafy.controller;

import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.DeptServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeptController implements Controller{
	
	private DeptService deptService = new DeptServiceImpl();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String action = request.getParameter("action");

		if("dept/list".equals(action)) {
			// 부서 목록 조회 요청 처리
			return deptList(request,response);
		}else if("dept/rest/register".equals(action)) {
			// 부서 목록 데이터 조회 요청 (rest)
			return deptRestList(request, response);
		}else if("dept/register".equals(action)) {
			// 부서 등록 요청 처리
			return registerDept(request, response);
		}else if("dept/modify".equals(action)) {
			return deptModify(request, response);
		}
		else if("dept/registerForm".equals(action)) {
			// 부서 등록 요청 처리
			return registerDeptForm(request, response);
		}else if("dept/remove".equals(action)) {
			return deptDelete(request, response);
		}
		else if("dept/detail".equals(action)) {
			// 부서상세조회 요청 처리
			return getDeptDetail(request, response);
		}

		return null;
	}
	
	protected PageInfo deptList(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
			request.setAttribute("depts",deptService.getDepts());
			return new PageInfo(true, "/deptList.jsp");
	}
	
	protected DataInfo deptRestList(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
			return new DataInfo("application/json", deptService.getDepts());
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
			return new PageInfo(false, "/main?action=dept.registerForm");
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
