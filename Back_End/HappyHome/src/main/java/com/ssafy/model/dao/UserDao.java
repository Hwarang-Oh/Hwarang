package com.ssafy.model.dao;

import java.sql.SQLException;

import com.ssafy.model.dto.User;

public interface UserDao {
	User selectUser(String userId) throws SQLException; // Select
	int insertUser(User user) throws SQLException; // Insert
	int updateUser(User user) throws SQLException; // Update
	int deleteUser(String userId) throws SQLException; // delete
	User loginUser(String userId, String userPwd) throws SQLException; // Login check
}
