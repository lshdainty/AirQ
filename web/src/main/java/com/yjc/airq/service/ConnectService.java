package com.yjc.airq.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.AreaVO;
import com.yjc.airq.domain.BidVO;
import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.DemandVO;
import com.yjc.airq.domain.MatterVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.ReplyVO;
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.domain.UploadVO;

public interface ConnectService {
	// 회원 이름 가져오기
	public String member_name(String member_id);

	// 업체 리스트 출력
	public ArrayList<TenderVO> tenderList();
	public ArrayList<TenderVO> tenderMain(@Param("startnum") int startnum, @Param("endnum") int endnum);
	public ArrayList<TenderVO> selectTender(@Param("sort") String sort, @Param("member_id") String member_id,@Param("startnum") int startnum, @Param("endnum") int endnum);
	// 참여 업체 수
	public int company_count(String tender_code);
	// 마감기한 d_day
	public int d_day(String tender_code);
	// 입찰 공고 작성
	public int addTenderboard(TenderVO tenderVo);
	
	// 입찰 확인 여부
	public int tenderCheck(String tender_code);
	
	//입찰 여부
	public void win_bid_whether(@Param("tender_code") String tender_code, @Param("company_code") String company_code);
	
	// 입찰 세부내용 보기
	public TenderVO tenderContent(String tender_code);
	public ArrayList<BidVO> bidContent(String tender_code);
	
	// 투찰 기간 설정
	public int calculate_period(String tender_code);
	
	// 입찰 공고 열람 권한(글쓴이)
	public String tMemberCheck(String tender_code);
	
	// 입찰 공고 열람 권한(사업자)
	public String member_devision(String member_id);

	// 투찰 작성
	public Company_InfoVO company_info(String member_id);
	public void addBid(BidVO bidVo);

	// 건수
	public int bidNumber(@Param("company_code") String company_code,@Param("period_day") String period_day);
	
	//건수
	public int bidTotalNum(String company_code);
	
	// 별점
	public double star_score_avg(@Param("company_code") String company_code,@Param("period_day") String period_day);
	
	// 투찰 점수 부여
	public int bid_ppt_score(BidVO bidVo);
	
	// 투찰 파일 업로드
	public void bidUpload(UploadVO uploadVo);
	
	// 업로드 다운받기(filename가져오기)
	public String filename(String upload_code);

	// 투찰 리스트에 필요한 것
	public String company_code(String member_id);
	public String company_name(String company_code);
	public String member_id(String company_code);
	
	//투찰 작성 권한 체크(한 번만 등록 가능)
	public ArrayList<BidVO> bidPCheck(String tender_code);
	
	// 입찰 신청 결제
	public void tendering(PaymentVO paymentVo);
	
	// 투찰 가격
	public int bid_price(@Param("tender_code") String tender_code, @Param("company_code") String company_code);
	
	// 입찰 공고 삭제
	public ArrayList<BidVO> findUploadCode(String tender_code);
	public void deleteBid(String tender_code);
	public int tenderDelete(String tender_code);
	
	// 투찰 삭제
	public void bidDelete(BidVO bidVo);
	public String bUpload_code(BidVO bidVo); 
	public void bidUploadDelete(String upload_code);
	
	// 투찰 점수 - 건수
	public ArrayList<BidVO> bidNumScore(@Param("tender_code") String tender_code,@Param("period_day") String period_day);
	// 투찰 점수 - 별점
	public ArrayList<BidVO> bidStarScore(@Param("tender_code") String tender_code,@Param("period_day") String period_day);
	// 투찰 점수 - 별점
	public ArrayList<BidVO> bidPriceScore(String tender_code);
	
	// 입찰 공고 수정
	public int tenderModify(TenderVO tenderVo);
	
	// 입찰 페이징
	public int tenderCount();
	public int selectCount(String member_id);
	
	public int tenderBid(@Param("tender_code") String tender_code, @Param("member_id") String member_id);	
	
	//회사별 리뷰
	public ArrayList<Map<String,Object>> companyReview(String company_code);
	
	//리뷰에서 보여줄 별점
	public double rStarScore(String company_code);
	
	//리뷰 개수
	public int reviewNum(String company_code);
	
	//입찰 마감
	public int tender_deadline(String tender_code);
	
	//낙찰하기
	public int bid_open_date(String tender_code);
	
	// 상품 전체 개수 조회
	public int productCount();
	// 항목 선택후 항목에 맞는 상품 개수 조회
	public int selectCount(@Param("sido") String sido,@Param("sigoon") String sigoon,@Param("space") int space,@Param("matter") String matter);
	// 사용자가 사는 곳의 우편번호 가져오기
	public String selectZipcode(@Param("member_id") String member_id);
	// 사용자가 사는곳에서 많이 팔린 제품 리스트
	public ArrayList<ProductVO> recommendList(@Param("zipcode") String zipcode);
	// 제품 목록
	public ArrayList<ProductVO> productList(@Param("sort") String sort, @Param("startnum") int startnum, @Param("endnum") int endnum);
	// 측정 물질 리스트 가져오기
	public ArrayList<MatterVO> matterList();
	// 사용자가 선택한 도,시,평수에 해당하는 제품목록
	public ArrayList<ProductVO> selectList(@Param("sido") String sido, @Param("sigoon") String sigoon, @Param("space") int space, @Param("matter") String matter, @Param("sort") String sort, @Param("startnum") int startnum, @Param("endnum") int endnum);
	// 상품 상세 페이지
	public ProductVO productContent(String product_code);
	// 결제 페이지 - 주소 자동 입력
	public MemberVO memberAddr(String member_id);
	// 상품 댓글
	public ArrayList<ReplyVO> productReply(String product_code);
	// 광역시/도를 선택시 해당하는 시,구 목록출력
	public ArrayList<AreaVO> selectSigoon(AreaVO areaVO);
	// 서비스제품 주문정보 insert
	public void pInsertDemand(DemandVO demandVO);
	// 서비스 제품 결제정보 insert
	public void pInsertPayment(PaymentVO paymentVO);
	// 작성글 수정,삭제 권한 체크
	public String writePersonCheck(@Param("product_code") String product_code);
	// 서비스 제품 등록
	public void productInsert(ProductVO productVO);
	// 서비스 가능 지역 등록
	public void productAreaInsert(@Param("area_code") String area_code,@Param("product_code") String product_code);
	// 측정 가능한 물질 등록
	public void productMatterInsert(@Param("matter_code") String matter_code,@Param("product_code") String product_code);
	// 서비스 제품 사진 등록
	public void productImageUpload(UploadVO uploadVO);
	// 서비스 제품 썸네일 등록
	public void productThumbnailUpload(UploadVO uploadVO);
	// 서비스 제품 수정
	public void productUpdate(ProductVO productVO);
	// 서비스 가능 지역 삭제
	public void productAreaDelete(@Param("product_code") String product_code);
	// 측정 가능 물질 삭제
	public void productMatterDelete(@Param("product_code") String product_code);
	// 서비스 제품 사진 삭제
	public void productImageDelete(@Param("product_code") String product_code);
	// 서비스 제품 결제 삭제
	public void productPaymentDelete(@Param("product_code") String product_code);
	// 서비스 제품 주문 삭제
	public void productDemandDelete(@Param("product_code") String product_code);
	// 서비스 제품 댓글 삭제
	public void productReplyDelete(@Param("product_code") String product_code);
	// 서비스 제품 삭제
	public void productDelete(@Param("product_code") String product_code);
	
	// 본인 댓글 delete
	public void deletePReply(@Param("reply_code") String reply_code);
	
}
