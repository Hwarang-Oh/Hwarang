package com.ssafy.sampleapp.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.sampleapp.model.dto.loginHistory;

// @Repository
public interface loginHistoryDao {

    int insert(loginHistory log);

    List<loginHistory> selectAll(int log_id);

    List<loginHistory> selectAll_admin();

    List<loginHistory> selectByDate(int log_id, String date1, String date2);

    List<loginHistory> selectByDate_admin(String date1, String date2);
}
