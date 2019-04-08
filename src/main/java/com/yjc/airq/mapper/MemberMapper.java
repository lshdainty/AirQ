package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.UploadVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.SellerVO;

public interface MemberMapper {
	public ArrayList<MemberVO> getMemberList();
	public MemberVO login(String id);
	public MemberVO findPw(@Param("member_name") String name, @Param("member_id") String id, @Param("member_tel") String tel, @Param("member_email") String email);
	public MemberVO findId(@Param("member_name") String name, @Param("member_tel")String tel, @Param("member_email")String email);

	public ArrayList<MemberVO> memberList();
	
	// 판매자 회원 목록 조회
	public String sellerList(SellerVO sl);
	
	// 일반 회원가입
	public String signup(MemberVO mb);
	
	// 중복 체크
	public MemberVO idCheck(String id);
	
	// 파일 업로드
	public String fileDB(UploadVO fDB);
	
}
