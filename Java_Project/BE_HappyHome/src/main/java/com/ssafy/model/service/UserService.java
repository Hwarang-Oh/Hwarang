package com.ssafy.model.service;

import com.ssafy.model.dto.User;

public interface UserService {
	User validateUser(String userId, String userPwd ) throws Exception; // 로그인 확인
	User getUser(String userId) throws Exception; // 회원 정보 조회
	boolean registerUser(User user) throws Exception; // 회원 등록
	boolean modifyUser(User user) throws Exception; // 회원 수정
	boolean removeUser(String UserId) throws Exception; // 회원 탈퇴
}
