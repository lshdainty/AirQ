package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.TenderboardVO;

public interface TenderboardMapper {
	// 입찰 리스트 출력
	public ArrayList<TenderboardVO> tenderList();
	
	// 입찰공고 작성
	public int addTenderboard(TenderboardVO tenderboardVo);

	
}
