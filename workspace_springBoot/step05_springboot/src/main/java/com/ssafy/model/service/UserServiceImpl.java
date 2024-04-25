package com.ssafy.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dao.UserDAO;
import com.ssafy.model.dto.User;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	private UserDAO userDao;

	public UserServiceImpl(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Transactional(readOnly = true)
	@Override
	public String login(User user) {
		return userDao.login(user);
	}

	@Override
	public boolean register(User user) {
		return userDao.register(user);
	}
}
