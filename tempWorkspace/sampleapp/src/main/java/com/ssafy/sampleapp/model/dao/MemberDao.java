package com.ssafy.sampleapp.model.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {

    void logIn(String id, String password);
}
