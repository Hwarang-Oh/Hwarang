package com.ssafy.controller.util;

import com.ssafy.controller.Controller;
import com.ssafy.controller.MapController;
import com.ssafy.controller.UserController;

public class ControllerMapping {
	private MapController mapController = new MapController();
	private UserController userController = new UserController();
	public Controller getController(String command) {
		if (command.startsWith("map/")) {
			System.out.println("ControllerMapping : map/");
			return mapController;
		} else if (command.startsWith("user/")){
			return userController;
		}
		return null;
	}
}
