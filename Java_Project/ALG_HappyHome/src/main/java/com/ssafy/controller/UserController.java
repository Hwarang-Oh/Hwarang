package com.ssafy.controller;

import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.dto.User;
import com.ssafy.model.service.UserService;
import com.ssafy.model.service.UserServiceImpl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserController implements Controller{
	
	private UserService userService = new UserServiceImpl();

	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if ("user/myPage".equals(action)) {
			return userDetail(request, response);
		} else if ("user/home".equals(action)) {
			return userHome(request, response);
		} else if ("user/register".equals(action)) {
			return userRegister(request, response);
		} else if ("user/modify".equals(action)) {
			return userModify(request, response);
		} else if ("user/remove".equals(action)) {
			return userRemove(request, response);
		} else if ("user/login".equals(action)) {
			return userLogin(request, response);
		} else if ("user/logout".equals(action)) {
			return userLogout(request, response);
		}
		return null;
	}
	
	protected PageInfo userDetail(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");
		user = userService.getUser(user.getUserId());
		request.setAttribute("user", user);
		return new PageInfo(true, "/user/detail.jsp");
	}
	
	protected PageInfo userHome(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(false, "/index.jsp");
	}
	
	
	protected PageInfo userRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User();
		try {
			user.setUserId(request.getParameter("userId"));
			user.setUserPwd(request.getParameter("userPwd"));
			user.setUserName(request.getParameter("userName"));
			user.setAddress(request.getParameter("userAddress"));
			user.setPhoneNum(request.getParameter("userPhone"));
			userService.registerUser(user);
			return new PageInfo(true, "/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected PageInfo userModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User();
		try {
			user.setUserId(request.getParameter("userId"));
			user.setUserPwd(request.getParameter("userPwd"));
			user.setUserName(request.getParameter("userName"));
			user.setAddress(request.getParameter("userAddress"));
			user.setPhoneNum(request.getParameter("userPhone"));
			userService.modifyUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", user);
			return new PageInfo(false, "/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected PageInfo userRemove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId;
		try {
			userId = request.getParameter("userId");
			userService.removeUser(userId);
			HttpSession session = request.getSession();
			session.removeAttribute("userInfo");
			return new PageInfo(false, "/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected PageInfo userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		try {
			User user = userService.validateUser(userId, userPwd);
			HttpSession session = request.getSession();
			if(user != null) {
				session.setAttribute("userInfo", user);
				return new PageInfo(false, "/index.jsp");
			} else {
				session.setAttribute("ErrorMsg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요.");
				return new PageInfo(false,"/index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();	
			return null;
		}
	}
	
	protected PageInfo userLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");
		return new PageInfo(false, "/index.jsp");
    }
}
