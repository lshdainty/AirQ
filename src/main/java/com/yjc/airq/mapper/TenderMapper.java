package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;

import com.yjc.airq.domain.TenderVO;

public interface TenderMapper {
	// 입찰 리스트 출력
	public ArrayList<TenderVO> tenderList();
	// 참여 업체 수
	public int company_count(String tender_code);
	// 마감기한 d_day
	public int d_day(String tender_code);
	// 입찰공고 작성
	public int addTenderboard(TenderVO tenderVo);
	// 입찰 세부내용 보기
	public TenderVO tenderContent(String tcode);
	// 입찰 공고 삭제
	public int tenderDelete(String tcode);
	// 입찰 공고 수정
	public int tenderModify(TenderVO tenderVo);
	// 입찰 공고 열람 권한(글쓴이)
	public String tMemberCheck(String tender_code);
	
	//마이페이지 관리자 글관리 - 글삭제
	@Delete("delete from tender where tender_code=#{tender_code}")
	public boolean deletePosts(String tender_code);
}
