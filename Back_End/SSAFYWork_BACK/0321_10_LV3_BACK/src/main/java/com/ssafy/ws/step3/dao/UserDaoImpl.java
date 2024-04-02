package com.ssafy.ws.step3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.ws.step3.dto.User;
import com.ssafy.ws.step3.util.DBUtil;

/**
 * UserDaoImpl은 stateless하므로 Singleton으로 작성한다.
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User selectUser(String id, String pass) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select * from user where id = ? and pass = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if (rs.next())
				return new User(rs.getString(1), rs.getString(2), rs.getString(3));
		} finally {
			DBUtil.close(rs, pstmt, conn);
		} return null;
	}
}
