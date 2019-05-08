package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.yjc.airq.domain.AreaVO;
import com.yjc.airq.domain.BidVO;
import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.DemandVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.domain.UploadVO;
import com.yjc.airq.mapper.AreaMapper;
import com.yjc.airq.mapper.BidMapper;
import com.yjc.airq.mapper.CompanyMapper;
import com.yjc.airq.mapper.DemandMapper;
import com.yjc.airq.mapper.MemberMapper;
import com.yjc.airq.mapper.PaymentMapper;
import com.yjc.airq.mapper.ProductMapper;
import com.yjc.airq.mapper.TenderMapper;
import com.yjc.airq.mapper.UploadMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConnectServiceImplement implements ConnectService {
	private TenderMapper tenderMapper;
	private BidMapper bidMapper;
	private CompanyMapper companyMapper;
	private ProductMapper productMapper;
	private AreaMapper areaMapper;
	private MemberMapper memberMapper;
	private UploadMapper uploadMapper;
	private DemandMapper demandMapper;
	private PaymentMapper paymentMapper;
	
	//회원 이름 가져오기
	@Override
	public String member_name(String member_id) {
		// TODO Auto-generated method stub
		return memberMapper.member_name(member_id);
	}
	
	// 입찰 리스트 출력
	@Override
	public ArrayList<TenderVO> tenderList() {
		return tenderMapper.tenderList();
	}

	// 참여 업체 수
	@Override
	public int company_count(String tender_code) {
		return tenderMapper.company_count(tender_code);
	}
	
	// 마감기한 d_day
	@Override
	public int d_day(String tender_code) {
		return tenderMapper.d_day(tender_code);
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
	
	// 입찰 공고 열람 권한(글쓴이)
	@Override
	public String tMemberCheck(String tender_code) {
		return tenderMapper.tMemberCheck(tender_code);
	}
	
	// 입찰 공고 열람 권한(사업자)
	@Override
	public String member_devision(String member_id) {
		return memberMapper.member_devision(member_id);
	}
	
	//투찰 작성 권한 체크(한 번만 등록 가능)
	@Override
	public ArrayList<BidVO> bidPCheck(String tender_code) {
		return bidMapper.bidPCheck(tender_code);
	}
	
	//투찰 작성
	@Override
	public void addBid(BidVO bidVo) {
		bidMapper.addBid(bidVo);
	}
	
	@Override
	public Company_InfoVO company_info(String member_id) {
		return companyMapper.company_info(member_id);
	}
	
	// 건수
	@Override
	public int bidNumber(String company_code) {
		return companyMapper.bidNumber(company_code);
	}
	
	//별점
	@Override
	public double star_score_avg(String company_code) {
		return companyMapper.star_score_avg(company_code);
	}
	
	//투찰 파일업로드
	@Override
	public void bidUpload(UploadVO uploadVo) {
		uploadMapper.bidUpload(uploadVo);
	}
	
	//투찰 리스트에 필요한 것
	@Override
	public String company_code(String member_id) {
		return companyMapper.company_code(member_id);
	}
	
	@Override
	public String company_name(String company_code) {
		return companyMapper.company_name(company_code);
	}
	
	@Override
	public String member_id(String company_code) {
		return companyMapper.member_id(company_code);
	}
	
	// 투찰 삭제
	@Override
	public void bidDelete(BidVO bidVo) {
		bidMapper.bidDelete(bidVo);
	}
	@Override
	public String bUpload_code(BidVO bidVo) {
		return bidMapper.bUpload_code(bidVo);
	}
	@Override
	public void bidUploadDelete(String upload_code) {
		uploadMapper.bidUploadDelete(upload_code);
	}
	
	// 투찰 점수 - 건수
	@Override
	public ArrayList<BidVO> bidNumScore(String tender_code) {
		return bidMapper.bidNumScore(tender_code);
	}
	// 투찰 점수 - 별점
	@Override
	public ArrayList<BidVO> bidStarScore(String tender_code) {
		return bidMapper.bidStarScore(tender_code);
	}
	// 투찰 점수 - 별점
	@Override
	public ArrayList<BidVO> bidPriceScore(String tender_code) {
		return bidMapper.bidPriceScore(tender_code);
	}
	
	// 상품 리스트 출력
	@Override
	public ArrayList<ProductVO> productList(@Param("sort") String sort, @Param("startnum") int startnum, @Param("endnum") int endnum) {
		return productMapper.productList(sort,startnum, endnum);
	}

	// 사용자가 선택한 도,시,평수에 해당하는 제품목록
	@Override
	public ArrayList<ProductVO> selectList(@Param("sido") String sido, @Param("sigoon") String sigoon, @Param("space") int space, @Param("sort") String sort, @Param("startnum") int startnum,  @Param("endnum") int endnum){
		return productMapper.selectList(sido,sigoon,space,sort,startnum,endnum);
	}
	
	// 상품 상세 페이지
	@Override
	public ProductVO productContent(String product_code) {
		return productMapper.productContent(product_code);
	}

	// 광역시/도를 선택시 해당하는 시,구 목록출력
	@Override
	public ArrayList<AreaVO> selectSigoon(AreaVO areaVO) {
		return areaMapper.selectSigoon(areaVO);
	}
	
	// 서비스 제품 주문정보 insert
	@Override
	public void pInsertDemand(DemandVO demandVO) {
		demandMapper.pInsertDemand(demandVO);
	}
		
	// 서비스 제품 결제정보 insert
	@Override
	public void pInsertPayment(PaymentVO paymentVO) {
		 paymentMapper.pInsertPayment(paymentVO);
	}
}
