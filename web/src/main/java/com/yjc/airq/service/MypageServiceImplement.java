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
	private CompanyMapper companyMapper;
	private MemberMapper memberMapper;
	private PaymentMapper paymentMapper;
	private PostMapper postMapper;
	private ProductMapper productMapper;
	private ReplyMapper replyMapper;
	private TenderMapper tenderMapper;
	
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
	public void deletePostsPost(String post_code) {
		postMapper.deletePostsPost(post_code);
	}
//	@Override
//	public void deletePostsPost1(String post_code) {
//		postMapper.deletePostsPost1(post_code);
//	}
	@Override
	public ArrayList<PostVO> postMP() {
		return postMapper.postMP();
	}

	@Override
	public ArrayList<ProductVO> productMP() {
		return productMapper.productMP();
	}

	@Override
	public void deletePostsProduct(String product_code) {
		productMapper.deletePostsProduct(product_code);
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



}