package com.ssafy.ws.step3.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.step3.dto.Book;

public interface BookDao {
	// 도서 등록
	int insertBook(Book book) throws SQLException;
	
	// 도서 조회 ( 단일 )
	Book selectBook(String isbn) throws SQLException;
	
	// 도서 조회 ( 목록 )
	List<Book> selectBooks() throws SQLException;
}
