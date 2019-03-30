package com.yjc.airq.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.TenderboardVO;
import com.yjc.airq.mapper.TenderboardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConnectServiceImplement implements ConnectService {
	private TenderboardMapper tenderMapper;
	
	// 입찰 리스트 출력
	@Override
	public ArrayList<TenderboardVO> tenderList() {
		return tenderMapper.tenderList();
	}
	
	// 입찰 공고 작성
	@Override
	public int addTenderboard(TenderboardVO tenderboardVo) {
		// TODO Auto-generated method stub
		return tenderMapper.addTenderboard(tenderboardVo);
	}
}
