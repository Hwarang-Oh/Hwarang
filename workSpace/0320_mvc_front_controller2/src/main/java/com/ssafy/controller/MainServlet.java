package com.ssafy.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.DeptServiceImpl;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptService deptService = new DeptServiceImpl(); // 한 개만 쓴다면, SingleTon => 하지만 막을수 없다, 다른 곳에서 선언하는 것을

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8"); // Post 해당
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 어떤 요청 처리인지 구분해야 한다 ( 방법 1 : 구분하기 위한 파라미터를 사용 => action = list,  action = register)
		// 어떤 요청 처리인지 구분 ( 방법 2 : URL을 고유하게 관리하는 방법을 이용 - /dept/list.do, /dept/register.do 
		
		String action = request.getParameter("action");
		System.out.println(action);
		PageInfo info = new PageInfo(false, "/index.jsp");
//		if ("/dept/list".equals(action)) {
//			// 부서 목록 조회 요청 처리
//			
//		} else if ("/dept/register".equals(action)) {
//			// 부서 등록 요청 처리
//			
//		} else {
//			// index 페이지로 이동
//			System.out.println();
//		}
		
		try {
			if ("dept/list".equals(action)) {
				// 부서 목록 조회 요청 처리
				info = deptList(request,response);
				
				
			} else if ("dept/register".equals(action)) {
				info = registerDept(request, response); 
				// 부서 등록 요청 처리
				
			} else if ("dept/registerForm".equals(action)) {
				info = registerDeptForm(request, response);
				// 부서 상세 조회  요청 처리
			} else if ("dept/register".equals(action)) {
				info = getDeptDetail(request, response);
				// 부서 상세 조회  요청 처리
			} 
			else {
				// index 페이지로 이동
			}
			
			
			System.out.println(info);
			if (info.isForward()) {
				request.getRequestDispatcher("/WEB-INF/views" + info.getPath()).forward(request, response); // 나중에 View File 위치를 옮기면 여기만 고쳐주면 끝!!
				return;
			} else {
				// Forwarding이 아니기에, Redirection!!
				// /의 경로를 체크하는 것이 매우 중요!! (처음에 있는 /는 Sever Root!!) -> //http://localhost:8080/0320_mvc_front_contorller/main ( 두번째 /은 app의 최상단 요소 )
				// 반 상대경로 반 절대 경로 
				// + Forwarding 할 때 Context Text 는 안준다!!
				response.sendRedirect(request.getContextPath() + info.getPath());
				// //http://localhost:8080      /0320_mvc_front_contorller 이걸 따와야 한다!! (request.getContextPath()) ( 뒤쪽은 경우는 남겨두고, 앞쪽은 나머지 주소로 채워주고 있다 )
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exceptionMsg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
			return;
		}
	}
	
	
	protected PageInfo deptList(HttpServletRequest request, HttpServletResponse response) throws Exception {
			request.setAttribute("depts", deptService.getDepts());
//			request.getRequestDispatcher("/WEB-INF/views/deptList.jsp").forward(request, response);
			return new PageInfo(true,"/deptList.jsp"); // forwarding 하고 싶다! true
	}
	
	protected PageInfo registerDept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		boolean result = deptService.registerDept(dept);
		if (result) { // 등록 성공
			request.setAttribute("dept", dept); // request를 다음 view에게 전달해야 한다.
//			request.getRequestDispatcher("/WEB-INF/views/deptSuccess.jsp").forward(request, response);
//			response.sendRedirect("/WEB-INF/views/deptSuccess.jsp"); => 불가한 ㅏㅇ태 
			// / -> 자신의 App Root (Web App)
			return new PageInfo(true, "/deptSuccess.jsp"); // 다음 페이지로 가게 되면, 끝 (페이지 이동 명시 )

		} else {
//			request.setAttribute("errorMsg", "부서등록시 문제가 발생하였습니다.");
//			request.getRequestDispatcher("/deptRegister.jsp").forward(request, response); //-> forwarding
//			response.sendRedirect(request.getContextPath() + "/deptRegister.jsp"); // redirection 특징 (절대경로)
			return new PageInfo(false, "/deptRegister.jsp");
		}	
	}
	
	protected PageInfo registerDeptForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
			return new PageInfo(true, "/deptRegister.jsp");	
	}
	
	protected PageInfo getDeptDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		Dept dept = deptService.getDept(deptno);
		request.setAttribute("dept", dept); // request에 뭐 저장했음 forwarding , 굳이 forwarding을 하고싶으면 forwarding
		return new PageInfo(true, "/deptDetail.jsp");
	}
}
