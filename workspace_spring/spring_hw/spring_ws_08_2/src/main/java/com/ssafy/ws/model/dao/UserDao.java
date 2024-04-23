package com.ssafy.ws.model.dao;

import org.springframework.stereotype.Repository;

import com.ssafy.ws.model.dto.User;

@Repository
public interface UserDao {
	User select(String id);
}
