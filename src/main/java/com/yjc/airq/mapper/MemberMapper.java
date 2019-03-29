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
	public String sellerList(SellerVO sl);
	public int signup(MemberVO mb);
	public MemberVO idCheck(String id);
	public String fileDB(FileTestVO fileUp);
}
