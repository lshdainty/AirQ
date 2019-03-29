package com.yjc.airq.service;

import java.util.ArrayList;
import com.yjc.airq.domain.FileTestVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.SellerVO;

public interface JoinService {
	// 회원 목록
	public ArrayList<MemberVO> memberList();

	// 사업자 등록 번호
	public String sellerList(SellerVO sl);

	// 판매자 회원 목록
	public int signup(MemberVO mb);

	// 아이디 중복 체크
	public MemberVO idCheck(String id);

	// 파일 업로드
	public String fileDB(FileTestVO fDB);
}
