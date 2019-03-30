package com.yjc.airq.mapper;

import java.util.ArrayList;
import com.yjc.airq.domain.ProductVO;

public interface ProductMapper {
	// 상품리스트 조회
	public ArrayList<ProductVO> productList();
}
