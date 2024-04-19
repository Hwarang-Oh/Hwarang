package com.ssafy.mybatis;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mybatis.model.MemberDto;
import com.ssafy.mybatis.model.dao.MemberDao;
import com.ssafy.mybatis.model.dao.MemberDaoImpl;

public class MemberMain {

	public static void main(String[] args) {
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId("mybatis");
		memberDto.setUserName("마이바티스");
		memberDto.setUserPwd("1234");
		memberDto.setEmailId("mybatis");
		memberDto.setEmailDomain("ssafy.com");
		
		MemberDao memberDao = new MemberDaoImpl();
		
//		try {
//			memberDao.joinMember(memberDto);
//			System.out.println("회원 가입 성공!!!!!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		try {
			List<MemberDto> list = memberDao.listMember();
			for(MemberDto member : list) {
				System.out.println(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
