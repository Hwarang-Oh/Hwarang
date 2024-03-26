package Hwarang.hellospring.controller;

import Hwarang.hellospring.domain.Member;
import Hwarang.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        // 이것만 하면 빨간불이 뜨는 상태 -> Spring이 연결을 시켜준다.
        // MemberService는 그냥 순수한 java Class Spring이 미리 알 방도가 없으며, 관리하지 않고 있음
        // 일단 정형화된 Annotation Pattern을 적용해보자 ( -> service , raepositorty )
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
// 아무것도 하는 거 없이 Annot
// Member Controller를 Spring Container의 빈이 관리되고 있음 (보관중? )
// Spring Container가 관리를 하고, 거기서 받아와야 한다!
