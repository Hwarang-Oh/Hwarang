package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.model.dto.User;
import com.ssafy.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User selectUser(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select *  from user where userId = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getString(1), rs.getString(2),  rs.getString(3),
						 rs.getString(4),  rs.getString(5));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		} return null;
	}

	@Override
	public int insertUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into user(userId, userPwd, userName, address, phoneNum) "
				+ "values (?, ?, ?, ?, ?)";
		int rCnt = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getPhoneNum());
			rCnt = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		} return rCnt;
	}

	@Override
	public int updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update user set userPwd = ?, userName = ?, address = ?, phoneNum = ? "
				+ "where userId = ?";
		int rCnt = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserPwd());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getPhoneNum());
			pstmt.setString(5, user.getUserId());
			rCnt = pstmt.executeUpdate();
		}
		finally {
			DBUtil.close(pstmt, conn);
		} return rCnt;
	}

	@Override
	public int deleteUser(String userId) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from user where userId = ?";
		int rCnt = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rCnt = pstmt.executeUpdate();
		}
		finally {
			DBUtil.close(pstmt, conn);
		} return rCnt;
	}
	
	@Override
	public User loginUser(String userId, String userPwd) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select userID, userName from user where userId = ? and userPwd = ?";
		User user = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		} return user;
	}
}
