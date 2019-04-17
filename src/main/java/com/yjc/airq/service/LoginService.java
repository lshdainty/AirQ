package com.yjc.airq.service;

import java.util.ArrayList;
import com.yjc.airq.domain.MemberVO;

public interface LoginService {
	public ArrayList<MemberVO> getMemberList();
	public MemberVO login(String id);
	public MemberVO findId(String name, String tel, String email);
	public MemberVO findPw(String name, String id, String tel, String email);
}
