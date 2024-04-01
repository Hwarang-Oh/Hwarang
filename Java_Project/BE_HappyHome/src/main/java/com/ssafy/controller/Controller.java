package com.ssafy.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}