package com.ssafy.model.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ssafy.model.dao.UserDAO;
import com.ssafy.model.dto.User;

@Primary
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public String login(String userId, String password) throws Exception {
        return userDao.login(userId, password);
    }

    @Override
    public boolean register(User user) throws Exception {
        return userDao.register(user);
    }
}
