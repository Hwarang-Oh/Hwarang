package com.ssafy.service;

import java.util.List;

import com.ssafy.model.dao.BoardDao;
import com.ssafy.model.dao.BoardDaoImpl;
import com.ssafy.model.dto.BoardDto;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = new BoardDaoImpl();

	@Override
	public boolean writeBoard(BoardDto board) throws Exception {
		return boardDao.insertBoard(board) > 0;
	}

	@Override
	public boolean modifyBoard(BoardDto board) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.updateBoard(board) > 0;
	}

	@Override
	public boolean deleteBoard(int articleNo) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(articleNo) > 0;
	}

	@Override
	public BoardDto getBoard(int articleNo) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.selectBoard(articleNo);
	}
	
	@Override
	public List<BoardDto> getBoards() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.selectBoards();
	}

	@Override
	public void upHit(int articleNo) throws Exception {
		boardDao.updateHit(articleNo);
	}
}
