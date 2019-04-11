package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;

import com.yjc.airq.domain.ReplyVO;

public interface ReplyMapper {
	public ArrayList<ReplyVO> getReplys(String post_code);
	public void insertReply(ReplyVO replyVO);
	public void deletePostReply(String post_code);
	public void replyDelete(String reply_code);
	public ArrayList<ReplyVO> mypageReplys();
	//마이페이지 관리자 댓글관리 - 댓글삭제
	@Delete("delete from reply where reply_code=#{reply_code}")
	public boolean deleteComment(String reply_code);
}