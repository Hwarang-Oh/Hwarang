package com.jpabook.jpashop;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "hello"; // 화면 이름 => .html이 자동으로 붙는 것임!
    }
}
// model이 data를 View에 넘겨준다.
// tyhmeleaf가 찾아서 잘 넣어줌
