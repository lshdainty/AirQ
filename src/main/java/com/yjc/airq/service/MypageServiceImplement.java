package com.yjc.airq.service;


import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.DemandVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.mapper.MypageMapper;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class MypageServiceImplement implements MypageService {

	private MypageMapper mapper;

	@Override
	public ArrayList<Company_InfoVO> c_code( String member_id) {
		return mapper.c_code(  member_id);
	}





}
