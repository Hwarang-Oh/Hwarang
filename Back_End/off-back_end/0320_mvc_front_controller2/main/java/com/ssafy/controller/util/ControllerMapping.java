package com.ssafy.controller.util;

import com.ssafy.controller.Controller;
import com.ssafy.controller.DeptController;

public class ControllerMapping {

	private DeptController deptController = new DeptController();
	
	public Controller getController(String command) {
		if(command.startsWith("dept/")) {
			return deptController;
		}
		return null;
	}
	
}
