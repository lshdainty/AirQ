package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.TenderboardVO;

public interface TenderboardMapper {
	// 입찰 리스트 출력
	public ArrayList<TenderboardVO> tenderList();
	// 입찰공고 작성
	public int addTenderboard(TenderboardVO tenderboardVo);
	// 입찰 세부내용 보기
	public TenderboardVO tenderContent(String tcode);
	// 입찰 공고 삭제
	public int tenderDelete(String tcode);
	// 입찰 공고 수정
	public int tenderModify(TenderboardVO tenderboardVo);
}
