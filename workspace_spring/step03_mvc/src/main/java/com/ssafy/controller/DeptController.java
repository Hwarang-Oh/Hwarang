package com.ssafy.controller;

import java.util.List;

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

@RequestMapping("/dept")
@Controller
public class DeptController {

	private final DeptService deptService;

	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}

	/**
	 * @param : 0418_Interceptor_Part
	 *          예외처리 추가 !! (방법은 크게 2개) -> 원래는 각각 예외처리용 Method가 존재함
	 */

	// @RequestMapping(method=RequestMethod.GET)
	@GetMapping("/list") // Rest를 위해서 나옴 4.0부터!!
	protected String deptList(Model model) throws Exception { // 매개변수 다 없애도 된다!!
		// 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
		System.out.println(model.getAttribute("msg"));
		model.addAttribute("depts", deptService.getDepts());
		return "deptList";
	}

	// JSON 처리법
	@ResponseBody // REST로만 하는 Service면 RestController가 유리!!
	@GetMapping("rest/list")
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

	// @GetMapping("/registerForm") // Rest를 위해서 나옴 4.0부터!!
	// protected ModelAndView registerDeptForm() throws Exception { // 매개변수 다 없애도
	// 된다!!
	// // 부서정보 조회후 view 페이지에 전달하기 위한 데이터를 저장
	// ModelAndView mav = new ModelAndView();
	// mav.setViewName("deptRegister");
	// return mav;
	// }

	@GetMapping("/detail")
	public String getDeptDetail(@RequestParam("deptno") int deptno, Model model) throws Exception {
		// int deptno = Integer.parseInt(request.getParameter("deptno")); -> 필요 없어짐
		// Dept dept = deptService.getDept(deptno);
		model.addAttribute("dept", deptService.getDept(deptno));
		return "deptDetail";
	}

	// String -> 해당 Controller에 가는 것 -> 자동으로 Setter로 담길 준비가 되어 있다
	@PostMapping("/modify")
	private String modifyDept(Dept dept, RedirectAttributes redirectAttributes) throws Exception {
		deptService.modifyDept(dept);
		redirectAttributes.addFlashAttribute("msg", "수정에 성공하였습니다.");
		return "redirect:/dept/list";
	}

	@GetMapping("/remove")
	private String removeDept(@RequestParam("deptno") int deptno, RedirectAttributes redirectAttributes)
			throws Exception {
		deptService.removeDept(deptno);
		redirectAttributes.addFlashAttribute("msg", "삭제에 성공하였습니다.");
		return "redirect:/dept/list";
	}
}

// Session에 저장하기에는 부담이 조금 크다 -> Session에 FlashAttribute를 지원하고 있다. => 자동만료되는
// Session
// RedirectAttributes의 addAttribute는 Query String으로 붙여서 가는 속성!! => 문제가 존재!