package com.yjc.airq.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.TenderboardVO;
import com.yjc.airq.mapper.TenderboardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConnectServiceImplement implements ConnectService {
	private TenderboardMapper mapper;
	
	// 입찰 리스트 출력
	@Override
	public ArrayList<TenderboardVO> tenderList() {
		return mapper.tenderList();
	}
}
