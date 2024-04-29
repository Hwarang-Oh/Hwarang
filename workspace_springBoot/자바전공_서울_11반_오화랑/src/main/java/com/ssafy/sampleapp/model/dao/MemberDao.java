package com.ssafy.sampleapp.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.sampleapp.model.dto.Member;

@Repository
public interface MemberDao {

    Member logIn(String member_id, String password);

    Member select(String member_id);

    List<Member> selectAll();

    int insert(Member member);

    int update(Member member);
}
