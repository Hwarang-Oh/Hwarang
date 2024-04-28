package com.ssafy.sampleapp.model.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ssafy.sampleapp.model.dto.Member;

@Repository
public interface MemberDao {

    Member logIn(String id, String password) throws SQLException;

    int register(Member member) throws SQLException;
}
