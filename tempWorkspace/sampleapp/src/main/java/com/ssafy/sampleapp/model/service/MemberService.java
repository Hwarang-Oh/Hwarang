package com.ssafy.sampleapp.model.service;

import com.ssafy.sampleapp.model.dto.Member;

public interface MemberService {
    Member logIn(String id, String password) throws Exception;

    boolean register(Member member) throws Exception;
}