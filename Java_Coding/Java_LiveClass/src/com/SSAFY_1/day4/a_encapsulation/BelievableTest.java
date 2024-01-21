package com.SSAFY_1.day4.a_encapsulation;


class BelievableUserInfo {
	private String name = "홍길동";
	private int account = 10000;
	
	public void setName(String name) {
		if (name == null) {
			System.out.println("name은 Not Null!"); // 보호하는 과정
			return;
		}
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAccount(int account) {
		if (account < 0) {
			System.out.println("마이너스 통장은 안돼!");
			return;
		}
		this.account = account;
	}
	public int getAccount() {
		return account;
	}

}

public class BelievableTest {
	public static void main(String[] args) {
		BelievableUserInfo info = new BelievableUserInfo();
		System.out.printf("사용자 정보 : %s, %d%n", info.getName(), info.getAccount());
		info.setName(null);
		info.setAccount(-1000);
		System.out.printf("사용자 정보 : %s, %d%n", info.getName(), info.getAccount());
	}
}

