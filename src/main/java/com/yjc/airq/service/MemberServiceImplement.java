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
}
