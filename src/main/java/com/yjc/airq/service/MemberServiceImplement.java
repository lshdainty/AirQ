package com.yjc.airq.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.mapper.MemberMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImplement implements MemberService{
	private MemberMapper mapper;
	
	@Override
	public ArrayList<MemberVO> getMemberList(){
		return mapper.getMemberList();
	}
	
	@Override
	public MemberVO findId(MemberVO LVOI) {
		return mapper.findId(LVOI);
	}

	@Override
	public MemberVO findPw(MemberVO LVOP) {
		return mapper.findPw(LVOP);
	}

	@Override
	public MemberVO login(String id) {
		// TODO Auto-generated method stub
		return mapper.login(id);
	}
}
