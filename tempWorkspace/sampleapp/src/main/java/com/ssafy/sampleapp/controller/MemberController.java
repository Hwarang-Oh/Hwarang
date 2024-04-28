package com.ssafy.sampleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.sampleapp.model.dto.Member;
import com.ssafy.sampleapp.model.service.MemberService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/member")
@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/login")
    protected String MemberLogIn(String id, String password, HttpSession session, Model model) throws Exception {
        Member member = memberService.logIn(id, password);
        if (member != null) {
            session.setAttribute("memberName", member.getName());
            session.setAttribute("memberId", id);
            return "redirect:/";
        } else {
            model.addAttribute("errorMsg", "ID or Password Invalid");
            return "member/login";
        }
    }

    @GetMapping("/logout")
    protected String MemberLogOut(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(Member member) throws Exception {
        boolean flag = memberService.register(member);
        if (flag) {
            return "redirect:/member/loginForm";
        } else {
            return "redirect:/member/registForm";
        }
    }
}
