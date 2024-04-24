package com.ssafy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.model.dto.User;
import com.ssafy.model.service.UserService;

import jakarta.servlet.http.HttpSession;

//@SessionAttributes({"a","b"})
@RequestMapping("/user")
@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/login")
	protected String login(User user,
			HttpSession session, Model model) throws Exception {

		String name = userService.login(user);
		if (name != null) {

			// 로그인 성공
			session.setAttribute("userName", name);
			session.setAttribute("userId", user.getUserId());

			return "redirect:/";
		} else {
			// 로그인 실패
			model.addAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "user/login";
		}

	}

	@GetMapping("/logout")
	protected String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping("/register")
	public String register(User user) throws Exception {
		boolean flag = userService.register(user);
		if (flag) {
			return "redirect:/user/loginForm";
		} else {
			return "redirect:/user/registerForm";
		}
	}
}
