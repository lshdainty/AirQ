package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
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
	@Delete("delete from member where member_id=#{member_id}")
	public boolean deleteMember(String member_id);
	
	// 파일 업로드
	// public String fileDB(FileTestVO fDB);
	
}
