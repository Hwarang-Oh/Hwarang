package com.ssafy.controlller;

import com.ssafy.service.DeptService;
import com.ssafy.service.DeptServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeptController implements Controller{

	private DeptService deptService = new DeptServiceImpl();
	
	@Override
	public Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String action = req.getParameter("action");
		if ("dept/register".equals(action))
			return registerDept(req, resp);
		else if ("dept/mo")
	}

}
