package com.ssafy.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

// /dept 로 시작하는 모든 요청들은 로그인해야만 사용할수 있도록 인터셉터 처리하자!!
// 인터셉터에서는 로그인여부 체크해서 로그인 되었으면 계속해서 진행
//								 안되어있으면 로그인화면으로...

@RequestMapping("/dept")
@Controller
public class DeptController {
	private final DeptService deptService;

	public DeptController(DeptService deptService) {
		super();
		this.deptService = deptService;
	}

	@GetMapping("/list")
	public String deptList(Model model) throws Exception {
		System.out.println(model.getAttribute("msg"));
		// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
		model.addAttribute("depts", deptService.getDepts());
		return "deptList";
	}

	@ResponseBody
	@GetMapping("/rest/list")
	protected List<Dept> deptRestList() throws Exception {
		return deptService.getDepts();
	}

	@PostMapping("/register")
	protected String registerDept(Dept dept, Model model)
			throws Exception {
		boolean result = deptService.registerDept(dept);
		if (result) {
			model.addAttribute("dept", dept);
			return "deptSuccess";
		} else {
			return "redirect:/dept/registerForm";
		}
	}

	@GetMapping("/detail")
	public String getDeptDetail(@RequestParam(name = "deptno") int deptno, Model model)
			throws Exception {
		model.addAttribute("dept", deptService.getDept(deptno));
		return "deptDetail";
	}

	@PostMapping("/modify")
	public String modifyDept(Dept dept, RedirectAttributes redirectAttrs) throws Exception {
		deptService.modifyDept(dept);
		redirectAttrs.addFlashAttribute("msg", "수정에 성공하였습니다.");
		return "redirect:/dept/list";
	}

	@GetMapping("/remove")
	public String removeDept(@RequestParam("deptno") int deptno, RedirectAttributes redirectAttrs)
			throws Exception {
		deptService.removeDept(deptno);
		redirectAttrs.addFlashAttribute("msg", "삭제에 성공하였습니다.");
		return "redirect:/dept/list";
	}

	@PostMapping("/listByCondition")
	public String deptListByMultiCondition(Model model, @RequestParam Map<String, Object> condition) throws Exception {
		model.addAttribute("depts", deptService.getDeptsByMultiContition(condition));
		// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
		return "deptList";
	}
	// Dto에 담기 어려운 상황이면 보통 Map에 담으면 된다.

}
