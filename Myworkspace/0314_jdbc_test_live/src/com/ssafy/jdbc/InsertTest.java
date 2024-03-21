package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	
	private final String URL = "jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC";
	private final String DB_ID = "ssafy";
	private final String DB_PWD = "ssafy";

	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		int cnt = it.register("Hosino AI", "호시노 아이", "1234", "Hosino", "ssafy.com");
		System.out.println(cnt + " row(s) inserted.");
	}

	private int register(String userID, String userName, String userPwd, String emailID,
			String emailDomain) {
		int cnt = 0;
		String sql = "";
		sql += "insert into ssafy_member(userID, userName, userPwd, emailID, emailDomain) \n";
		sql += "values (?, ?, ?, ?, ?)";
		try( Connection conn = DriverManager.getConnection(URL, DB_ID, DB_PWD);
			PreparedStatement pstmt = conn.prepareStatement(sql); ){
			// conn.setAutoCommit(false);
			int i = 0;
			pstmt.setString(++i, userID);
			pstmt.setString(++i, userName);
			pstmt.setString(++i, userPwd);
			pstmt.setString(++i, emailID);
			pstmt.setString(++i, emailDomain);
			cnt = pstmt.executeUpdate();
			// conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// conn.rollback();
			// conn.rollback(null);

		}
		return cnt;
	}
}
