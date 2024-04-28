package com.ssafy.sampleapp.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.sampleapp.model.dao.MemberDao;
import com.ssafy.sampleapp.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public Member logIn(String id, String password) throws Exception {
        return memberDao.logIn(id, password);
    }

    @Override
    public boolean register(Member member) throws Exception {
        return memberDao.register(member) > 0;
    }

}
