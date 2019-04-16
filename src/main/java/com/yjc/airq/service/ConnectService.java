package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.AreaVO;
import com.yjc.airq.domain.BidVO;
import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderVO;

public interface ConnectService {
	// 제품 목록
	public ArrayList<ProductVO> productList(@Param("startnum") int startnum,  @Param("endnum") int endnum);
	
	// 업체 리스트 출력
	public ArrayList<TenderVO> tenderList();
	public ArrayList<TenderVO> companyCnt(String tender_code);
	
	// 입찰 공고 작성
	public int addTenderboard(TenderVO tenderVo);
	
	// 입찰 세부내용 보기
	public TenderVO tenderContent(String tender_code);
	public ArrayList<BidVO> bidContent(String tender_code);
	
	// 투찰 작성
	public Company_InfoVO company_info(String member_id);
	public BidVO addBid(String company_code);
	public int bidNumber(String company_code);
	
	// 입찰 공고 삭제
	public ArrayList<BidVO> findUploadCode(String tender_code);
	public void deleteBid(String tender_code);
	public int tenderDelete(String tender_code);
	
	// 입찰 공고 수정
	public int tenderModify(TenderVO tenderVo);
	// 상품중 서비스 가능한 지역 리스트 찾기
	public ArrayList<AreaVO> productAreaList();
	
	// 사용자가 선택한 도,시,평수에 해당하는 제품목록
	public ArrayList<ProductVO> selectList(@Param("sido") String sido,@Param("sigoon") String sigoon,@Param("space") int space, @Param("startnum") int startnum,  @Param("endnum") int endnum);
	// 결제내역리스트
	public ArrayList<PaymentVO> paymentList();
}
