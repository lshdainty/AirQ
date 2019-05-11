package com.yjc.airq.mapper;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.DemandVO;

public interface DemandMapper {
	// 서비스 제품 주문정보 insert
	public void pInsertDemand(DemandVO demandVO);
	
	// 서비스 제품 주문 삭제
	public void productDemandDelete(@Param("product_code") String product_code);
}
