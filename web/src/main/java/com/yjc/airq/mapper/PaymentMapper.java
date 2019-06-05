package com.yjc.airq.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.PaymentVO;

public interface PaymentMapper {
	// 서비스 제품 주문정보 insert
	public void pInsertPayment(PaymentVO paymentVO);
	
	// 서비스 제품 결제 삭제
	public void productPaymentDelete(@Param("product_code") String product_code);
	
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
	
	//마이페이지 일반사용자 결제내역 별점 업데이트
	public int mypayStarUp(PaymentVO paymentVO);

	// 입찰 신청 결제
	public void tendering(PaymentVO paymentVo);
	
	//mypageNormal - 최신 결제 내역
	public ArrayList<Map<String,Object>> normalNewPayment(String member_id);

	//상품,입찰 별점 update
	public void starScoreupdate(@Param("star_score")int star_score, @Param("payment_code")String payment_code);
	
	//판매자 월별 매출 차트 - 상품서비스
	
}