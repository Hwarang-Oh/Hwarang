package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver"; // 마음대로 하는게 아니라 정해져 있음
	private static final String URL = "jdbc:mysql://localhost:3306/scott?serverTimeZone=UTC";
	private static final String USER_NAME = "ssafy";
	private static final String USER_PW = "ssafy";
	
	static {
		try {
			Class.forName(DRIVER_CLASS_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER_NAME, USER_PW);
	}
	
	public static void close(AutoCloseable... resources) { // ... -> 가변 인자로 만들기
		for (AutoCloseable res: resources) {			
			if(res != null) {
				try {
					res.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
