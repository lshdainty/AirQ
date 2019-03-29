package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.FileTestVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.SellerVO;

public interface MemberMapper {
	public ArrayList<MemberVO> getMemberList();
	public MemberVO login(String id);
	public MemberVO findId(MemberVO LVOI);
	public MemberVO findPw(MemberVO LVOP);
	public ArrayList<MemberVO> memberList();
	
	// 판매자 회원 목록 조회
	public String sellerList(SellerVO sl);
	
	// 일반 회원가입
	public int signup(MemberVO mb);
	
	// 중복 체크
	public MemberVO idCheck(String id);
	
	// 파일 업로드
	public String fileDB(FileTestVO fileUp);
	
}
