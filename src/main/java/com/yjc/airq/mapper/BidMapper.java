package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.BidVO;

public interface BidMapper {
	// 입찰 공고 삭제
	public ArrayList<BidVO> findUploadCode(String tender_code);
	public void deleteBid(String tender_code);
	//입찰 공고 세부 내용
	public ArrayList<BidVO> bidContent(String tender_code);
	
}
