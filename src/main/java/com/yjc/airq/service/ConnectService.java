package com.yjc.airq.service;

import java.util.ArrayList;

import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderboardVO;

public interface ConnectService {
	// 제품 목록
	public ArrayList<ProductVO> productList();
	// 업체 리스트 출력
	public ArrayList<TenderboardVO> tenderList();
	//입찰 공고 작성
	public int addTenderboard(TenderboardVO tenderboardVo);
}
