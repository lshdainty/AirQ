package com.yjc.airq.service;

import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.Company_InfoVO;

public interface JoinService {
	// 사업자 등록 번호
	public void sellerList(Company_InfoVO company);

	// 회원가입
	public void signup(MemberVO mb);

	// 아이디 중복 체크
	public MemberVO idCheck(String id);
	
	// 파일 업로드
	//public String fileDB(FileTestVO fDB);
}
