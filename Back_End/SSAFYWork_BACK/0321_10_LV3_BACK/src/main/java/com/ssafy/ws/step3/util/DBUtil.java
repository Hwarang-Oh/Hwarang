package com.ssafy.ws.step3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/ssafyWeb?serverTimeZone=UTC";
	private static final String USER_NAME = "root";
	private static final String USER_PW = "admin";
	
	static {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER_NAME, USER_PW);
	}
	
	public static void close(AutoCloseable... resources) {
		for (AutoCloseable res : resources) {
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
