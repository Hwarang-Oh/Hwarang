package com.ssafy.jdbc;

public class ConnectionTest {
	
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/ssafyweb?serverTimezone=UTC";
	private final String DB_ID = "ssafy";
	private final String DB_PWD = "ssafy";
	
	public  ConnectionTest () throws ClassNotFoundException {
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공 !!!");                                     
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		ConnectionTest ct = new ConnectionTest();
		ct.connect();
	}

	private void connect() {
		// API를 보면,DB랑 연결하면 Connection이 선행되어어야 한다.
		// 나랑 Java랑 DB를 연결하는 것은 Connection 기반 But Connection은 강제로 new 불가 => 다른 생성방법 존재
		
	}
}
