package com.yjc.airq.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.IotInfoVO;
import com.yjc.airq.domain.MeasureDataVO;
import com.yjc.airq.mapper.ManageMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageServiceImplement implements ManageService{
	private ManageMapper mapper;
	
	// 원격 메인화면에 뿌려주기
	public ArrayList<IotInfoVO> iotMain(String member_id) {
		return mapper.iotMain(member_id);
	}

	// Iot_Info 테이블에 원격 장치, 장소 insert
	public void iotInfoInsert(IotInfoVO iif) {
		mapper.iotInfoInsert(iif);
	}

	public IotInfoVO nCheck(String alias) {
		return mapper.nCheck(alias);
	}

	// 미세먼지 측정 데이터
	public int measureData(Map<String, Object> m) {
		return mapper.measureData(m);
	}
	
//	@Override
//	public String modelInsert(String ModelName) {
//		return mapper.modelInsert(ModelName);
//		
//	}

}
