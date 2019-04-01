package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderboardVO;

public interface ConnectService {
	// 제품 목록
	public ArrayList<ProductVO> productList(@Param("startnum") int startnum,  @Param("endnum") int endnum);
	// 업체 리스트 출력
	public ArrayList<TenderboardVO> tenderList();
	//입찰 공고 작성
	public int addTenderboard(TenderboardVO tenderboardVo);
	//입찰 세부내용 보기
	public TenderboardVO tenderContent(TenderboardVO tenderboardVo);
	//입찰 공고 삭제
	public int tenderDelete(String tcode);
}
