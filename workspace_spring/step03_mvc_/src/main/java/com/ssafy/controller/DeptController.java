package com.ssafy.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.DeptServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/dept")
@Controller
public class DeptController {

	private final DeptService deptService;

	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}

	// @RequestMapping(method=RequestMethod.GET)
	@GetMapping("/list") // Rest를 위해서 나옴 4.0부터!!
	protected ModelAndView deptList() throws Exception { // 매개변수 다 없애도 된다!!
		// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
		ModelAndView mav = new ModelAndView();
		mav.addObject("depts", deptService.getDepts());
		mav.setViewName("deptList");
		return mav;
	}

	// JSON 처리법
	@ResponseBody // REST로만 하는 Service면 RestController가 유리!!
	@GetMapping("rest/list")
	protected List<Dept> deptRestList() throws Exception {
		return deptService.getDepts();
	}
	
	@PostMapping("/register")
	private String registerDept(Dept dept) throws Exception { //@ModelAttribute -> 이거 안해도 저장됨
		deptService.registerDept(dept);
		return "redirect:/dept/list";
	}
	
//	@GetMapping("/registerForm") // Rest를 위해서 나옴 4.0부터!!
//	protected ModelAndView registerDeptForm() throws Exception { // 매개변수 다 없애도 된다!!
//		// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("deptRegister");
//		return mav;
//	}

	@GetMapping("/detail")
	public String getDeptDetail(@RequestParam("deptno") int deptno, Model model) throws Exception {
		// int deptno = Integer.parseInt(request.getParameter("deptno")); -> 필요 없어짐
		// Dept dept = deptService.getDept(deptno);
		model.addAttribute("dept", deptService.getDept(deptno));
		return "deptDetail";
	}

	// String -> 해당 Controller에 가는 것 -> 자동으로 Setter로 담길 준비가 되어 있다
	@PostMapping("/modify")
	private String modifyDept(Dept dept) throws Exception {
		deptService.modifyDept(dept);
		return "redirect:/dept/list";
	}
	
	@GetMapping("/remove")
	private String removeDept(@RequestParam("deptno") int deptno) throws Exception {
		deptService.removeDept(deptno);
		return "redirect:/dept/list";
	}
}
