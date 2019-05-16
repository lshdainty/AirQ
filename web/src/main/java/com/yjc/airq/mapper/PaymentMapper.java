package com.yjc.airq.mapper;

import java.util.ArrayList;

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
	
	//마이페이지 일반사용자 결제내역 별점 업데이트
	public int mypayStarUp(PaymentVO paymentVO);

	// 입찰 신청 결제
	public void tendering(PaymentVO paymentVo);
}