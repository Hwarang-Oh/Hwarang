package com.ssafy.sampleapp.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.sampleapp.controller.listener.AppInitListener;

import jakarta.servlet.ServletContextListener;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
<<<<<<< HEAD
        registry.addViewController("/member/join").setViewName("join");
        // registry.addViewController("/user/loginForm").setViewName("user/login");
        // registry.addViewController("/user/registerForm").setViewName("user/register");
=======
        registry.addViewController("/product/registerForm").setViewName("regist");
        registry.addViewController("/member/loginForm").setViewName("member/login");
        registry.addViewController("/member/registerForm").setViewName("member/register");
>>>>>>> ff04bcea937c4e1a9645d2bb90070137e914f1e0
    }

    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    // registry.addInterceptor(new
    // CheckLoginInterceptor()).addPathPatterns("/dept/**");
    // }

    @Bean
    ServletListenerRegistrationBean<ServletContextListener> initListener() {
        ServletListenerRegistrationBean<ServletContextListener> srb = new ServletListenerRegistrationBean<>();
        srb.setListener(new AppInitListener());
        return srb;
    }

    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    // registry.addMapping("/**")
    // .allowedOrigins("http://127.0.0.1:5500", "http://127.0.0.1:9090")
    // .allowedMethods("*")
    // .allowCredentials(true);
    // }
}
