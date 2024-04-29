package com.ssafy.sampleapp.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sampleapp.model.dao.login_historyDao;
import com.ssafy.sampleapp.model.dto.login_history;

// @Service
public class login_historyServiceImpl implements login_historyService {

    private final login_historyDao login_historyDao;

    public login_historyServiceImpl(login_historyDao login_historyDao) {
        this.login_historyDao = login_historyDao;
    }

    @Override
    public boolean register(login_history login_history) {
        return login_historyDao.insert(login_history) > 0;
    }

    @Override
    public List<login_history> getAll(int log_id) {
        return login_historyDao.selectAll(log_id);
    }

    @Override
    public List<login_history> getAll_admin() {
        return login_historyDao.selectAll_admin();
    }

    @Override
    public List<login_history> getByDate(int log_id, String date1, String date2) {
        return login_historyDao.selectByDate(log_id, date1, date2);
    }

    @Override
    public List<login_history> getByDate_admin(String date1, String date2) {
        return login_historyDao.selectByDate_admin(date1, date2);
    }

}
