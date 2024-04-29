package com.ssafy.sampleapp.model.service;

import java.util.List;

import com.ssafy.sampleapp.model.dto.loginHistory;

public interface loginHistoryService {

    boolean register(loginHistory log);

    List<loginHistory> getAll(int log_id);

    List<loginHistory> getAll_admin();

    List<loginHistory> getByDate(int log_id, String date1, String date2);

    List<loginHistory> getByDate_admin(String date1, String date2);
}
