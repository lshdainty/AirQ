package com.yjc.airq.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.mapper.CompanyMapper;
import com.yjc.airq.mapper.MemberMapper;
import com.yjc.airq.mapper.PaymentMapper;
import com.yjc.airq.mapper.PostMapper;
import com.yjc.airq.mapper.ProductMapper;
import com.yjc.airq.mapper.ReplyMapper;
import com.yjc.airq.mapper.TenderMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MypageServiceImplement implements MypageService{
	private CompanyMapper mapper;
	private MemberMapper mapper1;
	private PaymentMapper mapper2;
	private PostMapper mapper3;
	private ProductMapper mapper4;
	private ReplyMapper mapper5;
	private TenderMapper mapper6;
	
	@Override
	public ArrayList<Company_InfoVO> c_code( String member_id) {
		return mapper.c_code(  member_id);
	}
	
	@Override
	public void deleteMember(String member_id) {
		mapper1.deleteMember(member_id);
	}
	
	@Override
	public ArrayList<PaymentVO> mypay(String member_id) {
		return mapper2.mypay(member_id);
	}

	@Override
	public ArrayList<PaymentVO> mypayNotNull(String member_id) {
		return mapper2.mypayNotNull(member_id);
	}

	@Override
	public ArrayList<PaymentVO> mypayNull(String member_id) {
		return mapper2.mypayNull(member_id);
	}

	@Override
	public void deletePostsPost(String post_code) {
		mapper3.deletePostsPost(post_code);
	}

	@Override
	public ArrayList<PostVO> postMP() {
		return mapper3.postMP();
	}

	@Override
	public ArrayList<ProductVO> productMP() {
		return mapper4.productMP();
	}

	@Override
	public void deletePostsProduct(String product_code) {
		mapper4.deletePostsProduct(product_code);
	}

	@Override
	public void deleteComment(String reply_code) {
		mapper5.deleteComment(reply_code);
	}

	@Override
	public void deletePosts(String tender_code) {
		mapper6.deletePosts(tender_code);
	}

	@Override
	public void mypayStarUp(PaymentVO paymentVO) {
		mapper2.mypayStarUp(paymentVO);
	}

	@Override
	public ArrayList<PostVO> postNMP(String member_id) {
		return mapper3.postNMP(member_id);
	}

	@Override
	public ArrayList<TenderVO> tenderNMP(String member_id) {
		return mapper6.tenderNMP(member_id);
	}

	@Override
	public ArrayList<ProductVO> productSMP(String member_id) {
		return mapper4.productSMP(member_id);
	}

}