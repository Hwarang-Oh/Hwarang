package com.ssafy.sampleapp.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.sampleapp.model.dao.loginHistoryDao;
import com.ssafy.sampleapp.model.dto.loginHistory;

@Service
public class loginHistoryServiceImpl implements loginHistoryService {

    private final loginHistoryDao loginhistoryDao;

    public loginHistoryServiceImpl(loginHistoryDao loginhistoryDao) {
        this.loginhistoryDao = loginhistoryDao;
    }

    @Override
    public boolean register(loginHistory log) {
        return loginhistoryDao.insert(log) > 0;
    }

    @Override
    public List<loginHistory> getAll(int log_id) {
        return loginhistoryDao.selectAll(log_id);
    }

    @Override
    public List<loginHistory> getAll_admin() {
        return loginhistoryDao.selectAll_admin();
    }

    @Override
    public List<loginHistory> getByDate(int log_id, String date1, String date2) {
        return loginhistoryDao.selectByDate(log_id, date1, date2);
    }

    @Override
    public List<loginHistory> getByDate_admin(String date1, String date2) {
        return loginhistoryDao.selectByDate_admin(date1, date2);
    }

}
