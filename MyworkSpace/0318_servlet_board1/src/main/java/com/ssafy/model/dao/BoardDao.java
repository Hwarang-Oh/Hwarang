package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.BoardDto;

public interface BoardDao {
	// 문서 작성
	int InsertArticle(BoardDto boardDto) throws SQLException;
	
	// 문서 조회 (단일)
	BoardDto selectArticle(int articleNo) throws SQLException;
	
	// 문서 조회 (목록)
	List<BoardDto> selectArticles() throws SQLException;
	
	// 문서 조회수 업데이트
	void UpdateHit(int articleNo) throws SQLException;
}
