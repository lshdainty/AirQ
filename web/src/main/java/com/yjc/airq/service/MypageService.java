package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.domain.ProductVO;
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
	//마이페이지 관리자 글관리 - 글수정
	public void deletePostsPost(@Param("post_code") String post_code);
	//마이페이지 관리자 글관리 - 글삭제
//	public void deletePostsPost1(@Param("post_code") String post_code);	
	// 마이페이지 - 관리자 포스트 리스트 조회
	public ArrayList<PostVO> postMP();
	// 마이페이지- 관리자 프로덕트 리스트 조회
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
	

}
