package com.ssafy.sampleApp.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.sampleApp.listener.AppInitListener;

import jakarta.servlet.ServletContextListener;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/product/registForm").setViewName("regist");
//		registry.addViewController("/registerForm").setViewName("deptRegister");
//		registry.addViewController("/user/loginForm").setViewName("login");
//		registry.addViewController("/user/registerForm").setViewName("register");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new CheckLoginInterceptor()).addPathPatterns("/dept/**");
	}
	
	@Bean
	ServletListenerRegistrationBean<ServletContextListener> initListener() {
		ServletListenerRegistrationBean<ServletContextListener> srb = new ServletListenerRegistrationBean<>();
		srb.setListener(new AppInitListener());
		return srb;
	}
}
