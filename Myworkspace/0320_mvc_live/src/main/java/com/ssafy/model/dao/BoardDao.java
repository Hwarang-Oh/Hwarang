package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.BoardDto;

public interface BoardDao {
	
	// Article 등록
	int insertBoard(BoardDto board) throws SQLException;
	
	// Article 수정
	int updateBoard(BoardDto board) throws SQLException;
	
	// Article 삭제
	int deleteBoard(int articleNo) throws SQLException;
	
	// Article 조회 (단일)
	BoardDto selectBoard(int articleNo) throws SQLException;
	
	// Article 조회 (목록)
	List<BoardDto> selectBoards() throws SQLException;
	
	// Article 조회수 추가
	void updateHit(int articleNo) throws SQLException;
}
