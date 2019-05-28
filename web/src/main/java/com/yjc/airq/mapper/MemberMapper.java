package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import com.yjc.airq.domain.MemberVO;

public interface MemberMapper {
	public ArrayList<MemberVO> getMemberList();
	public MemberVO login(String id);
	public MemberVO findPw(@Param("member_name") String name, @Param("member_id") String id, @Param("member_tel") String tel, @Param("member_email") String email);
	public MemberVO findId(@Param("member_name") String name, @Param("member_tel")String tel, @Param("member_email")String email);

	// 일반 회원가입
	public void signup(MemberVO mb);
	
	// 중복 체크
	public MemberVO idCheck(String id);
	
	//마이페이지 관리자 회원관리 - 회원삭제
	public void deleteMember(String member_id);
	
	// 파일 업로드
	// public String fileDB(FileTestVO fDB);
	
	// 회원 이름 가져오기
	public String member_name(String member_id);
	
	// 입찰 공고 열람 권한(사업자)
	public String member_devision(String member_id);
	
	// 사용자가 사는 곳의 우편번호 가져오기
	public String selectZipcode(@Param("member_id") String member_id);
	
	//마이페이지 회원탈퇴
	public void deleteSelf(@Param("member_id")String member_id, @Param("member_pw")String member_pw);
}
