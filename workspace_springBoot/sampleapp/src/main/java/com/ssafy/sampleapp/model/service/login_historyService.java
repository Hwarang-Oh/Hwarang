package com.ssafy.sampleapp.model.service;

import java.util.List;

import com.ssafy.sampleapp.model.dto.login_history;

public interface login_historyService {

    boolean register(login_history login_history);

    List<login_history> getAll(int log_id);

    List<login_history> getAll_admin();

    List<login_history> getByDate(int log_id, String date1, String date2);

    List<login_history> getByDate_admin(String date1, String date2);
}
