package com.ssafy.service;

import java.util.List;

import com.ssafy.model.dto.BoardDto;

public interface BoardService {
	
	boolean writeBoard(BoardDto board) throws Exception;
	
	boolean modifyBoard(BoardDto board) throws Exception;
	
	boolean deleteBoard(int articleNo) throws Exception;
	
	BoardDto getBoard(int articleNo) throws Exception;
	
	List<BoardDto> getBoards() throws Exception;
	
	void upHit(int articleNo) throws Exception;
}
