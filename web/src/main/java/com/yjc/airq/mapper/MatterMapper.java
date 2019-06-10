package com.yjc.airq.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.MatterVO;

public interface MatterMapper {
	// 측정 물질 리스트 가져오기
	public ArrayList<MatterVO> matterList();
	// 측정 가능한 물질 등록
	public void productMatterInsert(@Param("matter_code") String matter_code,@Param("product_code") String product_code);
	// 측정 가능 물질 삭제
	public void productMatterDelete(@Param("product_code") String product_code);
	
	//예약자 모니터링
	public ArrayList<Map<String,Object>> reservation(String member_id);
};
