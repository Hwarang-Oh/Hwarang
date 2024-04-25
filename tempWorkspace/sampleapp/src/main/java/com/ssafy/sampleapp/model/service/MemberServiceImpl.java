package com.ssafy.sampleapp.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.sampleapp.model.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDao memberDao;

    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public String logIn(String id, String password) {
        return memberDao.logIn(id, password);
    }

}
