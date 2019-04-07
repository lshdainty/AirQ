package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.AreaVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderboardVO;

public interface ConnectService {
	// 제품 목록
	public ArrayList<ProductVO> productList(@Param("startnum") int startnum,  @Param("endnum") int endnum);
	// 업체 리스트 출력
	public ArrayList<TenderboardVO> tenderList();
	// 입찰 공고 작성
	public int addTenderboard(TenderboardVO tenderboardVo);
	// 입찰 세부내용 보기
	public TenderboardVO tenderContent(String tcode);
	// 입찰 공고 삭제
	public int tenderDelete(String tcode);
	// 입찰 공고 수정
	public int tenderModify(TenderboardVO tenderboardVo);
	//상품중 서비스 가능한 지역 리스트 찾기
	public ArrayList<AreaVO> productAreaList();
}
