package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.yjc.airq.domain.AreaVO;
import com.yjc.airq.domain.BidVO;
import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.mapper.AreaMapper;
import com.yjc.airq.mapper.BidMapper;
import com.yjc.airq.mapper.CompanyMapper;
import com.yjc.airq.mapper.PaymentMapper;
import com.yjc.airq.mapper.ProductMapper;
import com.yjc.airq.mapper.TenderMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConnectServiceImplement implements ConnectService {
	private TenderMapper tenderMapper;
	private BidMapper bidMapper;
	private CompanyMapper companyMapper;
	private ProductMapper productMapper;
	private AreaMapper areaMapper;
	private PaymentMapper paymentMapper;
	
	// 입찰 리스트 출력
	@Override
	public ArrayList<TenderVO> tenderList() {
		return tenderMapper.tenderList();
	}

	@Override
	public ArrayList<TenderVO> companyCnt(String tender_code) {
		return tenderMapper.companyCnt(tender_code);
	}

	// 입찰 공고 작성
	@Override
	public int addTenderboard(TenderVO tenderVo) {
		return tenderMapper.addTenderboard(tenderVo);
	}

	// 입찰 세부 내용 보기
	@Override
	public TenderVO tenderContent(String tender_code) {
		return tenderMapper.tenderContent(tender_code);
	}

	@Override
	public ArrayList<BidVO> bidContent(String tender_code) {
		return bidMapper.bidContent(tender_code);
	}

	// 입찰 공고 삭제
	@Override
	public ArrayList<BidVO> findUploadCode(String tender_code) {
		return bidMapper.findUploadCode(tender_code);
	}

	@Override
	public void deleteBid(String tender_code) {
		bidMapper.deleteBid(tender_code);
	}

	@Override
	public int tenderDelete(String tender_code) {
		return tenderMapper.tenderDelete(tender_code);
	}

	// 입찰 공고 수정
	@Override
	public int tenderModify(TenderVO tenderVo) {
		return tenderMapper.tenderModify(tenderVo);
	}
	
	//투찰 작성
	@Override
	public Company_InfoVO company_info(String member_id) {
		return companyMapper.company_info(member_id);
	}
	
	@Override
	public int bidNumber(String company_code) {
		return companyMapper.bidNumber(company_code);
	}
	
	@Override
	public BidVO addBid(String company_code) {
		// TODO Auto-generated method stub
		return null;
	}

	// 상품 리스트 출력
	@Override
	public ArrayList<ProductVO> productList(@Param("startnum") int startnum, @Param("endnum") int endnum) {
		return productMapper.productList(startnum, endnum);
	}

	// 상품중 서비스 가능한 지역 리스트 출력
	@Override
	public ArrayList<AreaVO> productAreaList() {
		return areaMapper.productAreaList();
	}

	// 사용자가 선택한 도,시,평수에 해당하는 제품목록
	@Override
	public ArrayList<ProductVO> selectList(@Param("sido") String sido,@Param("sigoon") String sigoon,@Param("space") int space, @Param("startnum") int startnum,  @Param("endnum") int endnum){
		return productMapper.selectList(sido,sigoon,space,startnum,endnum);
	}
	
	// 결제내역리스트
	@Override
	public ArrayList<PaymentVO> paymentList(){
		return paymentMapper.paymentList();
	}
	
	// 상품 상세 페이지
	@Override
	public ProductVO productContent(String product_code) {
		return productMapper.productContent(product_code);

	//마이페이지- 관리자 프로덕트 리스트 조회
	@Override
	public ArrayList<ProductVO> productMP() {
		return productMapper.productMP();
	}
}
