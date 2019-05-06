package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.AreaVO;

public interface AreaMapper {
	// 광역시/도를 선택시 해당하는 시,구 목록출력
	public ArrayList<AreaVO> selectSigoon(AreaVO areaVO);
	// 서비스 가능 지역 등록
	public void productAreaInsert(@Param("area_code") String area_code,@Param("product_code") String product_code);
}
