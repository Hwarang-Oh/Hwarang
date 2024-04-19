package com.ssafy.model.dao;

import java.sql.SQLException;
import com.ssafy.model.dto.User;

public interface UserDAO {

    String login(String userId, String password) throws SQLException;

    boolean register(User user) throws SQLException;

}