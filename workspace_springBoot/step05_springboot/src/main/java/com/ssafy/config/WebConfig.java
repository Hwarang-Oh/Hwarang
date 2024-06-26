package com.ssafy.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.controller.interceptor.CheckLoginInterceptor;
import com.ssafy.listener.AppInitListener;

import jakarta.servlet.ServletContextListener;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/dept/registerForm").setViewName("deptRegister");
        registry.addViewController("/user/loginForm").setViewName("user/login");
        registry.addViewController("/user/registerForm").setViewName("user/register");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CheckLoginInterceptor()).addPathPatterns("/dept/**");
    }

    @Bean
    ServletListenerRegistrationBean<ServletContextListener> initListener() {
        ServletListenerRegistrationBean<ServletContextListener> srb = new ServletListenerRegistrationBean<>();
        srb.setListener(new AppInitListener());
        return srb;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500", "http://127.0.0.1:9000", "http://127.0.0.1:9001",
                        "http://localhost:9001")
                .allowedMethods("*")
                .allowCredentials(true);
    }
}
