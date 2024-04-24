package com.ssafy.model.dao;

import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.User;

@Repository
public interface UserDAO {

	String login(User user);

	boolean register(User user);

}