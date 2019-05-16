package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.yjc.airq.domain.IotInfoVO;
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


//	@Override
//	public String modelInsert(String ModelName) {
//		return mapper.modelInsert(ModelName);
//		
//	}

}
