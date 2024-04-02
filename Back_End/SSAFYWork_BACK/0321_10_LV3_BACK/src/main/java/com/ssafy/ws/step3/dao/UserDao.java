package com.ssafy.ws.step3.dao;

import java.sql.SQLException;

import com.ssafy.ws.step3.dto.User;

public interface UserDao {
	// 사용자 조회
	User selectUser(String id, String pass) throws SQLException;
}
