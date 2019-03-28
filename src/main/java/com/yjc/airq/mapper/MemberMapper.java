package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.MemberVO;

public interface MemberMapper {
	public ArrayList<MemberVO> getMemberList();
	public MemberVO login(String id);
	public MemberVO findId(MemberVO LVOI);
	public MemberVO findPw(MemberVO LVOP);
}
