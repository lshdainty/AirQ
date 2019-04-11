package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.TenderVO;

public interface TenderMapper {
	// 입찰 리스트 출력
	public ArrayList<TenderVO> tenderList();
	public ArrayList<TenderVO> companyCnt(String tender_code);
	// 입찰공고 작성
	public int addTenderboard(TenderVO tenderVo);
	// 입찰 세부내용 보기
	public TenderVO tenderContent(String tcode);
	// 입찰 공고 삭제
	public int tenderDelete(String tcode);
	// 입찰 공고 수정
	public int tenderModify(TenderVO tenderVo);
}
