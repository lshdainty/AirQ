package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.PaymentVO;

public interface PaymentMapper {
	// 결제내역리스트
	public ArrayList<PaymentVO> paymentList();
}
