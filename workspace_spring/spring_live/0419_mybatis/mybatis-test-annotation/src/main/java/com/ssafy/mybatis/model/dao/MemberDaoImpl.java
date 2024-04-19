package com.ssafy.mybatis.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.mybatis.config.MemberMapper;
import com.ssafy.mybatis.config.SqlMapConfig;
import com.ssafy.mybatis.model.MemberDto;

public class MemberDaoImpl implements MemberDao {

	@Override
	public void joinMember(MemberDto memberDto) throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			mapper.join(memberDto);
			sqlSession.commit();
		}
	}

	@Override
	public List<MemberDto> listMember() throws SQLException {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			return mapper.list();
		}
	}

}
