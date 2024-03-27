package com.ssafy.model.dto;

public class User {
	
	private String userId;
	private String userPwd;
	private String userName;
	private String address;
	private String phoneNum;
	
	public User() {
	}
	
	public User(String userId, String userPwd, String userName, String address, String phoneNum) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.address = address;
		this.phoneNum = phoneNum;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
