package com.yjc.airq.mapper;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.DemandVO;

public interface DemandMapper {
	// 서비스 제품 주문정보 insert
	public void pInsertDemand(DemandVO demandVO);
	
	// 서비스 제품 주문 삭제
	public void productDemandDelete(@Param("product_code") String product_code);
	
	// 사용자가 상품을 구매했는지 확인
	public int checkPayment(@Param("member_id") String member_id,@Param("product_code") String product_code);
}
