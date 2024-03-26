package com.ssafy.controlller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
