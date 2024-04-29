package com.ssafy.sampleapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
=======
>>>>>>> ff04bcea937c4e1a9645d2bb90070137e914f1e0
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.sampleapp.model.dto.Member;
import com.ssafy.sampleapp.model.service.MemberService;

import jakarta.servlet.http.HttpSession;

<<<<<<< HEAD
@RequestMapping("/member")
@Controller
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        super();
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/member")
@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
>>>>>>> ff04bcea937c4e1a9645d2bb90070137e914f1e0
        this.memberService = memberService;
    }

    @PostMapping("/login")
<<<<<<< HEAD
    protected String login(String member_id, String password,
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
=======
    protected String MemberLogIn(String id, String password, HttpSession session, Model model) throws Exception {
        Member member = memberService.logIn(id, password);
        if (member != null) {
            session.setAttribute("memberName", member.getName());
            session.setAttribute("memberId", id);
            return "redirect:/";
        } else {
            model.addAttribute("errorMsg", "ID or Password Invalid");
            return "member/login";
>>>>>>> ff04bcea937c4e1a9645d2bb90070137e914f1e0
        }
    }

    @GetMapping("/logout")
<<<<<<< HEAD
    protected String logout(HttpSession session) throws Exception {
=======
    protected String MemberLogOut(HttpSession session) throws Exception {
>>>>>>> ff04bcea937c4e1a9645d2bb90070137e914f1e0
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/register")
<<<<<<< HEAD
    public String register(Member Member) throws Exception {
        boolean flag = memberService.register(Member);
        if (flag) {
            return "redirect:/";
        } else {
            return "redirect:/member/join";
=======
    public String register(Member member) throws Exception {
        boolean flag = memberService.register(member);
        if (flag) {
            return "redirect:/member/loginForm";
        } else {
            return "redirect:/member/registForm";
>>>>>>> ff04bcea937c4e1a9645d2bb90070137e914f1e0
        }
    }
}
