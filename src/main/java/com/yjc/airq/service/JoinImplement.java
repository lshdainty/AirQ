package com.yjc.airq.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.mapper.MemberMapper;
import com.yjc.airq.domain.FileTestVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.SellerVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JoinImplement implements JoinService{

	private MemberMapper mapper;

	// 일반 회원 목록 조회
	@Override
	public ArrayList<MemberVO> memberList() {
		return mapper.memberList();
	}

	// 판매자 회원 목록 조회
	@Override
	public String sellerList(SellerVO sl) {
		return mapper.sellerList(sl);
	}

	// 일반 회원가입
	@Override
	public String signup(MemberVO mb) {
		return mapper.signup(mb);
	}

	// 아이디 중복 체크
	@Override
	public MemberVO idCheck(String id) {
		return mapper.idCheck(id);
	}

	// 파일 업로드
	@Override
	public String fileDB(FileTestVO fDB) {
		return mapper.fileDB(fDB);
	}
}
