package com.ssafy.sampleapp.model.service;

<<<<<<< HEAD
import java.util.List;

import com.ssafy.sampleapp.model.dto.Member;

public interface MemberService {
    Member logIn(String member_id, String password);

    Member getDetail(String member_id);

    List<Member> getList();

    boolean register(Member member);

    boolean modify(Member member);
=======
import com.ssafy.sampleapp.model.dto.Member;

public interface MemberService {
    Member logIn(String id, String password) throws Exception;

    boolean register(Member member) throws Exception;
>>>>>>> ff04bcea937c4e1a9645d2bb90070137e914f1e0
}