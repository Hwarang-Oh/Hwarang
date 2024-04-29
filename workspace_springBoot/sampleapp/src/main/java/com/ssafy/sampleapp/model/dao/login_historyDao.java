package com.ssafy.sampleapp.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.sampleapp.model.dto.login_history;

// @Repository
public interface login_historyDao {

    int insert(login_history log);

    List<login_history> selectAll(int log_id);

    List<login_history> selectAll_admin();

    List<login_history> selectByDate(int log_id, String date1, String date2);

    List<login_history> selectByDate_admin(String date1, String date2);
}
