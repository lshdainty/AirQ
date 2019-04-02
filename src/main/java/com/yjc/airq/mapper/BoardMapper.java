package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.BoardVO;

public interface BoardMapper {
	
	public ArrayList<BoardVO> getBoards();
	public void insertBoard();
	public BoardVO detailBoard(int board_id);

}
