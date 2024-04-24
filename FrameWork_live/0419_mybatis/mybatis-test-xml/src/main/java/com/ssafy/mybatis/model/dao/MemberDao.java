package com.ssafy.mybatis.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mybatis.model.MemberDto;

public interface MemberDao {

	void joinMember(MemberDto memberDto) throws SQLException;

	List<MemberDto> listMember() throws SQLException;

}
