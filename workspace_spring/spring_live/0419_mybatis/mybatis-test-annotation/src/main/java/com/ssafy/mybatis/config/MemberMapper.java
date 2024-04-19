package com.ssafy.mybatis.config;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ssafy.mybatis.model.MemberDto;

public interface MemberMapper {

	final String joinMember = "insert into members (user_name, user_id, user_password, email_id, email_domain, join_date) values (#{userName}, #{userId}, #{userPwd}, #{emailId}, #{emailDomain}, now())";
	final String listMember = "select * from members";
	
	@Insert(joinMember)
	void join(MemberDto memberDto);
	
	@Select(listMember)
	   @Results(value = {
	      @Result(property = "userId", column = "user_id"),
	      @Result(property = "userName", column = "user_name"),
	      @Result(property = "userPwd", column = "user_password"),
	      @Result(property = "emailId", column = "email_id"),       
	      @Result(property = "emailDomain", column = "email_domain"),
	      @Result(property = "joinDate", column = "join_date")
	   })
	List<MemberDto> list();
}
