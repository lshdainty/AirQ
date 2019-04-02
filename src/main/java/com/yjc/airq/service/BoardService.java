package com.yjc.airq.service;

import java.util.ArrayList;

import com.yjc.airq.domain.BoardVO;

public interface BoardService {
	ArrayList<BoardVO> getBoards();
	void insertBoard();
	void updateBoard();
	BoardVO detailBoard(int board_id);
	String fileInfo(int board_id);
}
