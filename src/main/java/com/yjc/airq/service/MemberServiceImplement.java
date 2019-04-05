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
	public MemberVO login(String id) {
		// TODO Auto-generated method stub
		return mapper.login(id);
	}

	@Override
	public MemberVO findPw(String name, String id, String tel, String email) {
		// TODO Auto-generated method stub
		
		return mapper.findPw(name,id,tel,email);
	}

	@Override
	public MemberVO findId(String name, String tel, String email) {
		// TODO Auto-generated method stub
		return mapper.findId(name,tel,email);
	}
}
