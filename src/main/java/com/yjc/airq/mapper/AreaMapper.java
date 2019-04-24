package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.AreaVO;

public interface AreaMapper {
	// 광역시/도를 선택시 해당하는 시,구 목록출력
	public ArrayList<AreaVO> selectSigoon(AreaVO areaVO);
}
