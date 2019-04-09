package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.AreaVO;

public interface AreaMapper {
	// 상품중 서비스 가능한 지역 리스트 출력
	public ArrayList<AreaVO> productAreaList();
}
