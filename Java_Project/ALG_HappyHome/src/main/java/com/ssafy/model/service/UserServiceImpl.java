package com.ssafy.model.service;

import com.ssafy.model.dao.UserDao;
import com.ssafy.model.dao.UserDaoImpl;
import com.ssafy.model.dto.User;
import com.ssafy.util.HashUtil;

import jakarta.servlet.annotation.WebServlet;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User validateUser(String userId, String userPwd) throws Exception {
		return userDao.loginUser(userId, HashUtil.sha1(userPwd));
	}

	@Override
	public User getUser(String userId) throws Exception {
		return userDao.selectUser(userId);
	}

	@Override
	public boolean registerUser(User user) throws Exception {
		if(userDao.selectUser(user.getUserId()) == null) {
			user.setUserPwd(HashUtil.sha1(user.getUserPwd()));
			return userDao.insertUser(user)>0;
		}
		return false;
	}

	@Override
	public boolean modifyUser(User user) throws Exception {
		// TODO Auto-generated method stub
		user.setUserPwd(HashUtil.sha1(user.getUserPwd()));
		return userDao.updateUser(user)>0;
	}

	@Override
	public boolean removeUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId)>0;
	}
}
