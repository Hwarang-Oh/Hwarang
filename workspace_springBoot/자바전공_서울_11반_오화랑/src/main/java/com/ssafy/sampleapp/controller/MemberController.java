package com.ssafy.sampleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.sampleapp.model.dto.Member;
import com.ssafy.sampleapp.model.service.MemberService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/member")
@Controller
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        super();
        this.memberService = memberService;
    }

    @PostMapping("/logIn")
    protected String logIn(String member_id, String password,
            HttpSession session, Model model) throws Exception {
        Member member = memberService.logIn(member_id, password);
        if (member != null) {
            // 로그인 성공
            session.setAttribute("memberName", member.getMember_name());
            session.setAttribute("memberId", member.getMember_id());
            session.setAttribute("isAdmin", member.getIs_admin());
            return "redirect:/";
        } else {
            // 로그인 실패
            model.addAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    protected String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(Member Member) throws Exception {
        memberService.register(Member);
        return "redirect:/";
    }

    @PostMapping("/modify")
    public String modify(Member Member) throws Exception {
        memberService.modify(Member);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String getDetail(HttpSession session, Model model) {
        String memberId = (String) session.getAttribute("memberId");
        System.out.println(memberId);
        Member member = memberService.getDetail(memberId);
        model.addAttribute("member", member);
        return "view";
    }

}
