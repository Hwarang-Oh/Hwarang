package com.ssafy.controller.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @param : 0418_Interceptor_Part
 *          Exception 처리
 */

@ControllerAdvice // AOP의 특성을 담고 있음
public class GlobalExceptionAdvice {

    // (smth like catch in try ~ catch)
    @ExceptionHandler(Exception.class) // 마치 AOP의 After Throwing 처럼 예외를 Catch하는 효과가 있다.
    public String handleException(Exception e, Model model) {
        e.printStackTrace();
        model.addAttribute("exceptionMsg", e.getMessage());
        return "error"; // Error Page로 forwarding 하면 됨
    }
}
// 이걸 Dept Controller 안에 넣게 되면 => Dept Controller만의 예외 처리가 되는 것이고, 나머지는 여기로 오게 될
// 것이다!
