package com.yjc.airq.service;

import java.util.ArrayList;

import com.yjc.airq.domain.ReplyVO;

public interface ReplyService {
	public ArrayList<ReplyVO> getReplys(String post_code);
	public void insertReply(ReplyVO replyVO);
	public void deletePostReply(String post_code);
}
