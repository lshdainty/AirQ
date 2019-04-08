package com.yjc.airq.service;

import org.springframework.stereotype.Service;
import com.yjc.airq.mapper.CompanyMapper;
import com.yjc.airq.mapper.MemberMapper;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.Company_InfoVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JoinImplement implements JoinService{

	private MemberMapper mapper;
	private CompanyMapper cMapper;

	// 사업자 등록번호 insert
	@Override
	public void sellerList(Company_InfoVO company) {
		cMapper.sellerList(company);
	}

	// 일반 회원가입
	@Override
	public void signup(MemberVO mb) {
		mapper.signup(mb);
	}

	// 아이디 중복 체크
	@Override
	public MemberVO idCheck(String id) {
		return mapper.idCheck(id);
	}

	// 파일 업로드
//	@Override
//	public String fileDB(UploadVO fDB) {
//		return mapper.fileDB(fDB);
//	}
}
