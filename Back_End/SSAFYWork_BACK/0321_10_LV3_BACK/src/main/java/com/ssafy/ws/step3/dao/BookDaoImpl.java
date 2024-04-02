package com.ssafy.ws.step3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step3.dto.Book;
import com.ssafy.ws.step3.util.DBUtil;

/**
 * BookDaoImpl은 stateless하므로 Singleton으로 작성한다.
 */
public class BookDaoImpl implements BookDao {

	@Override
	public int insertBook(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "Insert into book(isbn, title, author, price, `desc`) values(?, ?, ?, ?, ?)";
		int rCnt = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getDesc());
			rCnt = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		} return rCnt;
	}
	
	@Override
	public Book selectBook(String isbn) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Sql = "select * from book where isbn = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			if (rs.next())
				return new Book(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5));
		} finally {
			DBUtil.close(rs, pstmt, conn);
		} return null;
	}

	@Override
	public List<Book> selectBooks() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select * from book";
		List<Book> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5)));
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}return list;
	}
}
