package com.ssafy.sampleapp.model.service;

import java.util.List;

import com.ssafy.sampleapp.model.dto.Member;

public interface MemberService {
    Member logIn(String member_id, String password);

    Member getDetail(String member_id);

    List<Member> getList();

    boolean register(Member member);

    boolean modify(Member member);
}