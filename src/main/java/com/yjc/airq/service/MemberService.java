package com.yjc.airq.service;

import java.util.ArrayList;

import com.yjc.airq.domain.MemberVO;

public interface MemberService {
	public ArrayList<MemberVO> getMemberList();
	public MemberVO login(String id, String password);
}
