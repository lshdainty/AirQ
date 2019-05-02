package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.BidVO;

public interface BidMapper {
	// 입찰 공고 삭제
	public ArrayList<BidVO> findUploadCode(String tender_code);
	public void deleteBid(String tender_code);
	
	// 투찰 공고 세부 내용
	public ArrayList<BidVO> bidContent(String tender_code);
	
	// 투찰 등록
	public void addBid(BidVO bidVo);
	
	//투찰 작성 권한 체크(한 번만 등록 가능)
	public ArrayList<BidVO> bidPCheck(String tender_code);
}
