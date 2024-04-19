package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.User;
import com.ssafy.util.DBUtil;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

    private DataSource dataSource;

    public UserDAOImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    @Override
    public String login(String userId, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select name from userinfo where userid=? and password=?";

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userId);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } finally {
            DBUtil.close(stmt, conn);
        }
        return null;
    }

    @Override
    public boolean register(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "insert into userinfo values(?,?,?,?)";
        int rowCnt = 0;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUserId());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getEmail());

            rowCnt = stmt.executeUpdate();

        } finally {
            DBUtil.close(stmt, conn);
        }
        return rowCnt > 0;
    }

}