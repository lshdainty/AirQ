package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.AreaVO;
import com.yjc.airq.domain.BidVO;
import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.DemandVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.domain.UploadVO;

public interface ConnectService {
	// 제품 목록
	public ArrayList<ProductVO> productList(@Param("sort") String sort, @Param("startnum") int startnum, @Param("endnum") int endnum);

	// 회원 이름 가져오기
	public String member_name(String member_id);

	// 업체 리스트 출력
	public ArrayList<TenderVO> tenderList();
	// 참여 업체 수
	public int company_count(String tender_code);
	// 마감기한 d_day
	public int d_day(String tender_code);
	// 입찰 공고 작성
	public int addTenderboard(TenderVO tenderVo);

	// 입찰 세부내용 보기
	public TenderVO tenderContent(String tender_code);
	public ArrayList<BidVO> bidContent(String tender_code);
	
	// 입찰 공고 열람 권한(글쓴이)
	public String tMemberCheck(String tender_code);
	
	// 입찰 공고 열람 권한(사업자)
	public String member_devision(String member_id);

	// 투찰 작성
	public Company_InfoVO company_info(String member_id);
	public void addBid(BidVO bidVo);

	// 건수
	public int bidNumber(String company_code);

	// 별점
	public double star_score_avg(String company_code);

	// 투찰 파일 업로드
	public void bidUpload(UploadVO uploadVo);

	// 투찰 리스트에 필요한 것
	public String company_code(String member_id);
	public String company_name(String company_code);
	public String member_id(String company_code);
	
	//투찰 작성 권한 체크(한 번만 등록 가능)
	public ArrayList<BidVO> bidPCheck(String tender_code);

	// 입찰 공고 삭제
	public ArrayList<BidVO> findUploadCode(String tender_code);
	public void deleteBid(String tender_code);
	public int tenderDelete(String tender_code);
	
	// 투찰 삭제
	public void bidDelete(BidVO bidVo);
	public String bUpload_code(BidVO bidVo); 
	public void bidUploadDelete(String upload_code);
	
	// 입찰 공고 수정
	public int tenderModify(TenderVO tenderVo);

	// 사용자가 선택한 도,시,평수에 해당하는 제품목록
	public ArrayList<ProductVO> selectList(@Param("sido") String sido, @Param("sigoon") String sigoon, @Param("space") int space, @Param("sort") String sort, @Param("startnum") int startnum, @Param("endnum") int endnum);

	// 상품 상세 페이지
	public ProductVO productContent(String product_code);

	// 광역시/도를 선택시 해당하는 시,구 목록출력
	public ArrayList<AreaVO> selectSigoon(AreaVO areaVO);
	// 서비스제품 주문정보 insert
	public void pInsertDemand(DemandVO demandVO);
	// 서비스 제품 결제정보 insert
	public void pInsertPayment(PaymentVO paymentVO);
	// 서비스 제품 등록
	public void productInsert(ProductVO productVO);
	// 서비스 가능 지역 등록
	public void productAreaInsert(@Param("area_code") String area_code,@Param("product_code") String product_code);
	// 서비스 제품 사진 등록
	public void productImageUpload(UploadVO uploadVO);
}
