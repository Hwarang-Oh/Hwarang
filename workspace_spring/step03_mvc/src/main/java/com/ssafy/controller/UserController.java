package com.ssafy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

/**
 * @param : 0418_Interceptor_Part
 */
@Controller
public class UserController {

    // Servlet이 결국 부르는 것 -> Method의 선언부를 보면 Session이 필요한 것을 알 수 있음 => Session을 넘겨 줄
    // 것이다.
    @PostMapping("/login")
    public String login(@RequestParam("userId") String userId, @RequestParam("password") String password,
            HttpSession session) {
        // Service 연동 로그인 시도
        // Login에 성공하면 Session에 ID와 Name 저장
        // Login에 실패하면, Login화면으로 이동
        //
        return null;
    }

    // SessionAttributes Annotation -> 이 Controller 안에서 Model에 저장된 Data 중에 이 Key에 있는
    // 것들은 Session에도 저장되어라 => Session에 접근을 하지 않고 Session 처리
    // Logout -> session에 저장된 것을 지우는 것이 아닌, Session이 소멸되어야 하는 것이기 때문에, 그냥 API를 가져와야
    // 한다.
    public String logout(HttpSession session) {
        return null;
    }

    /**
     * @apiNote => 왜 현재 상황에서는 이 기능을 활용할 수 없을까?
     *          public String register(RedirectAttributes redirectAttributes) {
     *          // 가입에 성공하면 자동로그인 => return "/uesr/login" -> Internal View Resolver
     *          로 인해 설계상의 문제가 생김 -> .jsp가 붙어서 Controller에 가지 못하게 함
     *          // redirect로 처리해서 새로운 요청으로 만들어서 보내면, Controller에 갈 수 있음 => Request를
     *          못 보냄 -=> Spring의 특별한 기능이 존재
     *          // Redirection을 해야 하는데, 뒤쪽에 정보를 전달할 수 없음 -> Session에 저장을 해야 하는데,
     *          Spring이 자동으로 해줄 수 있게 해주는 기능
     *          // 그 Page까지만 넘겨주고, 지우고 싶으면 addFlashAttribute로 저장이 가능하다.
     *          redirectAttributes.addFlashAttribute("key", "value");
     *          return "redirect:/user/login";
     *          }
     */
}
