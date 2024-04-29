package com.ssafy.sampleapp.model.dao;

<<<<<<< HEAD
import java.util.List;
=======
import java.sql.SQLException;
>>>>>>> ff04bcea937c4e1a9645d2bb90070137e914f1e0

import org.springframework.stereotype.Repository;

import com.ssafy.sampleapp.model.dto.Member;

@Repository
public interface MemberDao {

<<<<<<< HEAD
    Member logIn(String member_id, String password);

    Member select(String member_id);

    List<Member> selectAll();

    int insert(Member member);

    int update(Member member);
=======
    Member logIn(String id, String password) throws SQLException;

    int register(Member member) throws SQLException;
>>>>>>> ff04bcea937c4e1a9645d2bb90070137e914f1e0
}
