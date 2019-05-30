package com.yjc.airq.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.ReplyVO;
import com.yjc.airq.domain.ReportVO;
import com.yjc.airq.domain.TenderVO;

public interface MypageService {
	public ArrayList<Company_InfoVO> c_code(String member_id);
	
	public void deleteMember(String member_id);
	
	//마이페이지 일반사용자 결제내역
	public ArrayList<PaymentVO> mypay(@Param("member_id")String member_id);
	
	//마이페이지 일반사용자 결제내역(별점준거)
	public ArrayList<PaymentVO> mypayNotNull(@Param("member_id")String member_id);
	
	//마이페이지 일반사용자 결제내역(별점안준거)
	public ArrayList<PaymentVO> mypayNull(@Param("member_id")String member_id);
	
	//마이페이지 일반사용자 결제내역
	public ArrayList<PaymentVO> mypayT(@Param("member_id")String member_id);
	
	//마이페이지 일반사용자 결제내역(별점준거)
	public ArrayList<PaymentVO> mypayNotNullT(@Param("member_id")String member_id);
	
	//마이페이지 일반사용자 결제내역(별점안준거)
	public ArrayList<PaymentVO> mypayNullT(@Param("member_id")String member_id);
	
	//일반 회원 - 회원 정보
	public MemberVO memberInfo(String member_id);
	//mypageNormal - 최신 글
	public ArrayList<Map<String,Object>> normalNewPost(String member_id);
	//mypageNormal - 최신 댓글
	public ArrayList<Map<String,Object>> normalNewReply(String memeber_id);
	//mypageNormal - 최신 결제 내역
	public ArrayList<Map<String,Object>> normalNewPayment(String member_id);
	
	//마이페이지 관리자 글관리 - 글수정
	public void deletePostsPost(@Param("post_code") String post_code);
	//마이페이지 관리자 글관리 - 글삭제
//	public void deletePostsPost1(@Param("post_code") String post_code);	
	
	// 마이페이지 메인 - 관리자 상품추천 조회
	public ArrayList<PostVO> postMPrec();
	// 마이페이지 메인 - 관리자 공기질 향상방법 조회
	public ArrayList<PostVO> postMPimp();
	// 마이페이지 메인 - 관리자 자유게시판 조회
	public ArrayList<PostVO> postMPlib();
	// 마이페이지 메인 - 관리자 건강지킴이 조회
	public ArrayList<PostVO> postMPhea();
	// 마이페이지 메인 - 관리자 대기오염물질정보 조회
	public ArrayList<PostVO> postMPmet();
	//마이페이지 메인 관리자 - 글가져오기
	public ArrayList<TenderVO> tenderMP();
	// 마이페이지 메인 - 관리자 프로덕트 리스트 조회
	public ArrayList<ProductVO> productMP();
	
	//마이페이지 관리자 글관리 - 글수정
	public void deletePostsProduct(@Param("product_code") String product_code);
	//마이페이지 관리자 글관리 - 글삭제
//	public void deletePostsProduct1(@Param("product_code") String product_code);
	//마이페이지 관리자 댓글관리 - 댓글삭제
	public void deleteComment(@Param("reply_code") String reply_code);
	//마이페이지 관리자 글관리 - 상세내용
	public void deletePosts(@Param("tender_code") String tender_code);
	//마이페이지 관리자 글관리 - 글삭제
//	public void deletePosts1(@Param("tender_code") String tender_code);
		
	
	//마이페이지 일반사용자 결제내역 별점 업데이트
	public void mypayStarUp(PaymentVO paymentVO);

	//마이페이지 일반 글관리- 글삭제
	public ArrayList<PostVO> postNMP(@Param("member_id")String member_id);
	//마이페이지 일반 글관리 -텐더 리스트뽑기
	public ArrayList<TenderVO> tenderNMP(@Param("member_id")String member_id);
	//마이페이지 판매자 글관리 - 프로덕트
	public ArrayList<ProductVO> productSMP(@Param("member_id")String member_id);
	
	//마이페이지 메인 글관리
	public ArrayList<ReportVO> mypageMainR();
	//마이페이지 메인 글관리 상세
	public ArrayList<ReportVO> mypageMainRIn(@Param("report_code") String report_code);
	
	// 상품,입찰,게시글 삭제에 따른 신고테이블 삭제여부 update
	public void reportUpdate(@Param("original_code") String original_code);
	// 기존에 신고한 내용이 있는지 확인
	public String checkReport(@Param("member_id") String member_id,@Param("original_code") String original_code);
	// 신고insert
	public void insertReport(ReportVO reportVO);
	
	//댓글 관리자 모두
	ArrayList<ReplyVO> mypageReplys();
	//댓글 관리자 Post
	ArrayList<ReplyVO> mypageReplysPost();	
	//댓글 관리자 Product
	ArrayList<ReplyVO> mypageReplysProduct();
	
	//댓글 일반사용자,판매자 모두
	ArrayList<ReplyVO> mypageReplysNS(@Param("member_id") String member_id);
	//댓글 일반사용자,판매자 Post
	ArrayList<ReplyVO> mypageReplysNSPost(@Param("member_id") String member_id);	
	//댓글 일반사용자,판매자 Product
	ArrayList<ReplyVO> mypageReplysNSProduct(@Param("member_id") String member_id);
	
	//마이페이지 회원탈퇴
	public void deleteSelf(@Param("member_id")String member_id, @Param("member_pw")String member_pw);
	
	// 리뷰 안 한 목록 리스트
	public ArrayList<ProductVO> reviewCompareList(String member_id);
	public ArrayList<TenderVO> reviewTenderList(String member_id);
}
