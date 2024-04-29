package com.ssafy.sampleapp.model.service;

import java.util.List;

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
    public Member logIn(String member_id, String password) {
        return memberDao.logIn(member_id, password);
    }

    @Override
    public Member getDetail(String member_id) {
        return memberDao.select(member_id);
    }

    @Override
    public List<Member> getList() {
        return memberDao.selectAll();
    }

    @Override
    public boolean register(Member member) {
        return memberDao.insert(member) > 0;

    }

    @Override
    public boolean modify(Member member) {
        return memberDao.update(member) > 0;
    }
}
