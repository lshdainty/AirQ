package com.yjc.airq.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.mapper.CompanyMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MypageServiceImplement implements MypageService{
	private CompanyMapper mapper;
@Override
public ArrayList<Company_InfoVO> c_code( String member_id) {
	return mapper.c_code(  member_id);
}

}
