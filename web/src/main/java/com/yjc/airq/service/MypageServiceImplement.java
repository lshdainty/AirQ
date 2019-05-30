package com.yjc.airq.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.ReplyVO;
import com.yjc.airq.domain.ReportVO;
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.mapper.CompanyMapper;
import com.yjc.airq.mapper.MemberMapper;
import com.yjc.airq.mapper.PaymentMapper;
import com.yjc.airq.mapper.PostMapper;
import com.yjc.airq.mapper.ProductMapper;
import com.yjc.airq.mapper.ReplyMapper;
import com.yjc.airq.mapper.TenderMapper;
import com.yjc.airq.mapper.ReportMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MypageServiceImplement implements MypageService{
	private CompanyMapper companyMapper;
	private MemberMapper memberMapper;
	private PaymentMapper paymentMapper;
	private PostMapper postMapper;
	private ProductMapper productMapper;
	private ReplyMapper replyMapper;
	private TenderMapper tenderMapper;
	private ReportMapper reportMapper;
	
	@Override
	public ArrayList<Company_InfoVO> c_code( String member_id) {
		return companyMapper.c_code(  member_id);
	}
	
	@Override
	public void deleteMember(String member_id) {
		memberMapper.deleteMember(member_id);
	}
	
	@Override
	public ArrayList<PaymentVO> mypay(String member_id) {
		return paymentMapper.mypay(member_id);
	}

	@Override
	public ArrayList<PaymentVO> mypayNotNull(String member_id) {
		return paymentMapper.mypayNotNull(member_id);
	}

	@Override
	public ArrayList<PaymentVO> mypayNull(String member_id) {
		return paymentMapper.mypayNull(member_id);
	}
	
	@Override
	public ArrayList<PaymentVO> mypayT(String member_id) {
		return paymentMapper.mypayT(member_id);
	}

	@Override
	public ArrayList<PaymentVO> mypayNotNullT(String member_id) {
		return paymentMapper.mypayNotNullT(member_id);
	}

	@Override
	public ArrayList<PaymentVO> mypayNullT(String member_id) {
		return paymentMapper.mypayNullT(member_id);
	}

	@Override
	public void deletePostsPost(String post_code) {
		postMapper.deletePostsPost(post_code);
	}
	
	@Override
	public void deletePostsProduct(String product_code) {
		productMapper.deletePostsProduct(product_code);
	}	
//	@Override
//	public void deletePostsPost1(String post_code) {
//		postMapper.deletePostsPost1(post_code);
//	}
	@Override
	public ArrayList<PostVO> postMPrec() {
		return postMapper.postMPrec();
	}
	@Override
	public ArrayList<PostVO> postMPimp() {
		return postMapper.postMPimp();
	}
	@Override
	public ArrayList<PostVO> postMPlib() {
		return postMapper.postMPlib();
	}
	@Override
	public ArrayList<PostVO> postMPhea() {
		return postMapper.postMPhea();
	}
	@Override
	public ArrayList<PostVO> postMPmet() {
		return postMapper.postMPmet();
	}	
	@Override
	public ArrayList<TenderVO> tenderMP() {
		return tenderMapper.tenderMP();
	}	
	@Override
	public ArrayList<ProductVO> productMP() {
		return productMapper.productMP();
	}


//	@Override
//	public void deletePostsProduct1(String product_code) {
//		productMapper.deletePostsProduct1(product_code);
//	}
	@Override
	public void deleteComment(String reply_code) {
		replyMapper.deleteComment(reply_code);
	}

	@Override
	public void deletePosts(String tender_code) {
		tenderMapper.deletePosts(tender_code);
	}

//	@Override
//	public void deletePosts1(String tender_code) {
//		tenderMapper.deletePosts1(tender_code);
//	}
	@Override
	public void mypayStarUp(PaymentVO paymentVO) {
		paymentMapper.mypayStarUp(paymentVO);
	}

	@Override
	public ArrayList<PostVO> postNMP(String member_id) {
		return postMapper.postNMP(member_id);
	}

	@Override
	public ArrayList<TenderVO> tenderNMP(String member_id) {
		return tenderMapper.tenderNMP(member_id);
	}

	@Override
	public ArrayList<ProductVO> productSMP(String member_id) {
		return productMapper.productSMP(member_id);
	}


	
	// 상품,입찰,게시글 삭제에 따른 신고테이블 삭제여부 update
	@Override
	public void reportUpdate(@Param("original_code") String original_code) {
		reportMapper.reportUpdate(original_code);
	}
	
	// 기존에 신고한 내용이 있는지 확인
	@Override
	public String checkReport(@Param("member_id") String member_id,@Param("original_code") String original_code) {
		return reportMapper.checkReport(member_id,original_code);
	}
	
	// 신고insert
	@Override
	public void insertReport(ReportVO reportVO) {
		reportMapper.insertReport(reportVO);
	}
	
	//마이페이지 글관리
	@Override
	public ArrayList<ReportVO> mypageMainR() {
		return reportMapper.mypageMainR();
	}

	@Override
	public ArrayList<ReportVO> mypageMainRIn(@Param("report_code") String report_code) {
		return reportMapper.mypageMainRIn(report_code);
	}

	@Override
	public ArrayList<ReplyVO> mypageReplys() {
		return replyMapper.mypageReplys();
	}
	@Override
	public ArrayList<ReplyVO> mypageReplysPost() {
		return replyMapper.mypageReplysPost();
	}
	@Override
	public ArrayList<ReplyVO> mypageReplysProduct() {
		return replyMapper.mypageReplysProduct();
	}
	
	@Override
	public ArrayList<ReplyVO> mypageReplysNS(@Param("member_id") String member_id) {
		return replyMapper.mypageReplysNS(member_id);
	}
	@Override
	public ArrayList<ReplyVO> mypageReplysNSPost(@Param("member_id") String member_id) {
		return replyMapper.mypageReplysNSPost(member_id);
	}
	@Override
	public ArrayList<ReplyVO> mypageReplysNSProduct(@Param("member_id") String member_id) {
		return replyMapper.mypageReplysNSProduct(member_id);
	}
	
	//리뷰 안 한 목록 리스트
	@Override
	public ArrayList<ProductVO> reviewCompareList(String member_id) {
		return productMapper.reviewCompareList(member_id);
	}
	@Override
	public ArrayList<TenderVO> reviewTenderList(String member_id) {
		return tenderMapper.reviewTenderList(member_id);
	}

	@Override
	public void deleteSelf(String member_id, String member_pw) {
		 memberMapper.deleteSelf(member_id, member_pw);
	}
	
	//일반 회원 - 회원 정보
	@Override
	public MemberVO memberInfo(String member_id) {
		return memberMapper.memberInfo(member_id);
	}
	//mypageNormal - 최신 글
	@Override
	public ArrayList<Map<String, Object>> normalNewPost(String member_id) {
		return postMapper.normalNewPost(member_id);
	}
	//mypageNormal - 최신 댓글
	@Override
	public ArrayList<Map<String, Object>> normalNewReply(String memeber_id) {
		return replyMapper.normalNewReply(memeber_id);
	}
	//mypageNormal - 최신 결제 내역
	@Override
	public ArrayList<Map<String, Object>> normalNewPayment(String member_id) {
		return paymentMapper.normalNewPayment(member_id);
	}
}