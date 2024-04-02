package com.ssafy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	
	Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// 요청 응답을 그대로 가지고, 세부 Controller에게 줘야 한다 
}
