package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;

import com.yjc.airq.domain.TenderVO;

public interface TenderMapper {
	// 입찰 리스트 출력
	public ArrayList<TenderVO> tenderList();
	//public ArrayList<TenderVO> companyCnt(String tender_code);
	// 입찰공고 작성
	public int addTenderboard(TenderVO tenderVo);
	// 입찰 세부내용 보기
	public TenderVO tenderContent(String tcode);
	// 입찰 공고 삭제
	public int tenderDelete(String tcode);
	// 입찰 공고 수정
	public int tenderModify(TenderVO tenderVo);
	//마이페이지 관리자 글관리 - 글삭제
	@Delete("delete from tender where tender_code=#{tender_code}")
	public boolean deletePosts(String tender_code);
}
