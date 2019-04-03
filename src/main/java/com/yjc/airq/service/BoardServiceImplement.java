package com.yjc.airq.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.BoardVO;
import com.yjc.airq.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImplement implements BoardService {
	private BoardMapper mapper;
	@Override
	public ArrayList<BoardVO> getBoards() {
		// TODO Auto-generated method stub
		
		return mapper.getBoards();
	}
	
	@Override
	public BoardVO detailBoard(int board_id) {
		// TODO Auto-generated method stub
		return mapper.detailBoard(board_id);
	}

	@Override
	public String fileInfo(int board_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertBoard(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.insertBoard(board);
	}


	@Override
	public void deleteBoard(int board_id) {
		// TODO Auto-generated method stub
		mapper.deleteBoard(board_id);
		
	}

	@Override
	public void modifyBoard(BoardVO board) {
		// TODO Auto-generated method stub
		
		mapper.modifyBoard(board);
		
	}

}
