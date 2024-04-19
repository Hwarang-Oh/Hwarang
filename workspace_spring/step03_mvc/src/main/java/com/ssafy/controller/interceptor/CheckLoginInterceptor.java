package com.ssafy.controller.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CheckLoginInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(CheckLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession();
        if (session.getAttribute("userId") == null) {
            // System.out.println("CheckLoginInterceptor : 로그인 안된 상태!! ");
            log.info("로그인 안된 상태");
            response.sendRedirect(request.getContextPath() + "/user/loginForm"); // ServerRoot를 시작으로 보기 때문에, 반절대 경로 느낌으로
                                                                                 // Path를 붙여줘야 한다.
            return false; // ? 정확하게 무슨 의미지?
        } else {
            // System.out.println("CheckLoginInterceptor : 로그인 유지 !! ");
            log.info("로그인 유지");
        }
        return true;
    }
}
// Container 관련 -> Servlet Context 가서 수정!

// ViewPage로 바로 갈 수 있게 해두면, Controller를 통해 하는 Interceptor를 통한 처리가 불가능해짐.
// Login이 되지 않은 상태로 URL을 치고 갈 수 있는 상황이 생겨버림
// Tomcat Server -> 아무것도 Mapping되지 않은 것들을 위한 Default Servlet이 존재함.
// Tomcat에 내장되어 있는 Default Servlet이 존재하지만, Spring이 그 권한을 뺏어서 Dispatcher를 통해 가게
// 하도록 함. => / (기본의 시작을 뺏은 것이다 )
// 정적 Resource를 Mapping하지 않고, 약속된 폴더에 넣어서 Servletcontext.xml에서 정적 리소스에 대한 요청의
// Mapping이 되어 있음.
// 들어오는 정적 콘텐츠 요청이 Mapping가 같이 되어 있으면 resources에서 찾음