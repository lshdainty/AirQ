package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.ProductVO;

public interface ProductMapper {
	// 상품리스트 조회
	public ArrayList<ProductVO> productList(@Param("startnum") int startnum,  @Param("endnum") int endnum);
	// 상품 전체 개수 조회
	public int productCount();
}
