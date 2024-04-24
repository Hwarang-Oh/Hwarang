package com.ssafy.model.service;

import com.ssafy.model.dto.User;

public interface UserService {

	String login(User user);

	boolean register(User user);
}