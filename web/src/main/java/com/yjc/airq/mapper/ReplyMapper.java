package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.ReplyVO;

public interface ReplyMapper {
	public ArrayList<ReplyVO> getReplys(String post_code);
	public void insertReply(ReplyVO replyVO);
	public void deletePostReply(String post_code);
	public void replyDelete(String reply_code);
	public ArrayList<ReplyVO> mypageReplys();
	//상품 댓글 select
	public ArrayList<ReplyVO> productReply(String product_code);
	//상품 댓글 insert
	public void insertPReply(ReplyVO replyVO);
	//마이페이지 관리자 댓글관리 - 댓글삭제
	public void deleteComment(@Param("reply_code") String reply_code);
}
