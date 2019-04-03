package com.yjc.airq.service;

import java.util.ArrayList;

import com.yjc.airq.domain.BoardVO;

public interface BoardService {
	ArrayList<BoardVO> getBoards();
	void insertBoard(BoardVO boardVO);
	void modifyBoard(BoardVO boardVO);
	void deleteBoard(int board_id);
	BoardVO detailBoard(int board_id);
	
	String fileInfo(int board_id);
}
