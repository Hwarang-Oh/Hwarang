package com.ssafy.mybatis.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.mybatis.config.SqlMapConfig;
import com.ssafy.mybatis.model.MemberDto;

public class MemberDaoImpl implements MemberDao {

	private final String NameSpace = "com.ssafy.mybatis.model.dao.MemberDao.";

	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.insert("com.ssafy.mybatis.model.dao.MemberDao.joinMember", memberDto);
			sqlSession.commit();
		}
	}

	@Override
	public List<MemberDto> listMember() throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			List<MemberDto> list = sqlSession.selectList(NameSpace + )
		}

	}

}
