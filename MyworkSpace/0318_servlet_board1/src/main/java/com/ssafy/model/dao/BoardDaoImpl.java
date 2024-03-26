package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	@Override
	public int InsertArticle(BoardDto boardDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "Insert into board (user_id, subject, content) values (?, ?, ?)";
		int rCnt = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());
			rCnt = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return rCnt;
	}

	@Override
	public BoardDto selectArticle(int articleNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select * from board where article_no = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, articleNo);
			rs = pstmt.executeQuery();
			if (rs.next())
				return new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getInt(5), rs.getString(6));
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return null;
	}

	@Override
	public List<BoardDto> selectArticles() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDto> list = new ArrayList<>();
		String sql = "Select * from board";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public void UpdateHit(int articleNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "Update board set hit = hit + 1 where article_no = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, articleNo);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

}
