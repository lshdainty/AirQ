package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.MatterVO;

public interface MatterMapper {
	// 측정 물질 리스트 가져오기
	public ArrayList<MatterVO> matterList();
};
