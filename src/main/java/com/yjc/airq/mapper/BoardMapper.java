package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.BoardVO;

public interface BoardMapper {
	
	public ArrayList<BoardVO> getBoards();
	public void insertBoard(BoardVO board);
	public BoardVO detailBoard(int board_id);
	public void deleteBoard(int board_id);
	public void modifyBoard(BoardVO board);
}
