package com.yjc.airq.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.ReplyVO;
import com.yjc.airq.mapper.ReplyMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReplyServiceImplement implements ReplyService {
	
	ReplyMapper mapper;
	@Override
	public ArrayList<ReplyVO> getReplys(String post_code) {
		
		return mapper.getReplys(post_code);
	}

	@Override
	public void insertReply(ReplyVO replyVO) {
		mapper.insertReply(replyVO);
	}
	public void deletePostReply(String post_code) {
		mapper.deletePostReply(post_code);
	}

}
