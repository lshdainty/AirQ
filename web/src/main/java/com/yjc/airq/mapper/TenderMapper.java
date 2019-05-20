package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.TenderVO;

public interface TenderMapper {
	// 입찰 리스트 출력
	public ArrayList<TenderVO> tenderList();
	public ArrayList<TenderVO> tenderMain(@Param("startnum") int startnum, @Param("endnum") int endnum);
	public ArrayList<TenderVO> selectTender(@Param("sort") String sort, @Param("member_id") String member_id,@Param("startnum") int startnum, @Param("endnum") int endnum);
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
	// 투찰 기간 설정
	public int calculate_period(String tender_code);
	// 입찰 확인 여부
	public int tenderCheck(String tender_code);
	// 입찰 페이징
	public int tenderCount();
	public int selectCount(String member_id);
	
	//마이페이지 관리자 글관리 - 글수정
	public void deletePosts(@Param("tender_code") String tender_code);
	
	//마이페이지 관리자 글관리 - 글삭제
//	public void deletePosts1(@Param("tender_code") String tender_code);
	//마이페이지 일반 글관리 - 글삭제
	public ArrayList<TenderVO> tenderNMP(@Param("member_id")String member_id);
}
