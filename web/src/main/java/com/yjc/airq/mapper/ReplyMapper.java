package com.yjc.airq.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.ReplyVO;

public interface ReplyMapper {
	public ArrayList<ReplyVO> getReplys(String post_code);
	public void insertReply(ReplyVO replyVO);
	public void deletePostReply(String post_code);
	public void replyDelete(String reply_code);
	//상품 댓글 select
	public ArrayList<ReplyVO> productReply(String product_code);
	//서비스 제품 댓글 삭제
	public void productReplyDelete(@Param("product_code") String product_code);
	//상품 댓글 insert
	public void insertPReply(ReplyVO replyVO);
	//본인 댓글 delete
	public void deletePReply(@Param("reply_code") String reply_code);
	//마이페이지 관리자 댓글관리 - 댓글삭제
	public void deleteComment(@Param("reply_code") String reply_code);
	//마이페이지 관리자 댓글 목록
	public ArrayList<ReplyVO> mypageReplys();
	public ArrayList<ReplyVO> mypageReplysPost();
	public ArrayList<ReplyVO> mypageReplysProduct();
	//마이페이지 일반사용자, 판매자 댓글 목록
	public ArrayList<ReplyVO> mypageReplysNS(@Param("member_id") String member_id);
	public ArrayList<ReplyVO> mypageReplysNSPost(@Param("member_id") String member_id);
	public ArrayList<ReplyVO> mypageReplysNSProduct(@Param("member_id") String member_id);

	//mypageNormal - 최신 댓글
	public ArrayList<Map<String,Object>> normalNewReply(String memeber_id);

}
