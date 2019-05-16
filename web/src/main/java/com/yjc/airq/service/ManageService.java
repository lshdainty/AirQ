package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.IotInfoVO;

public interface ManageService {
	
	// 로그인 아이디를 통한 원격 메인 화면
	public ArrayList<IotInfoVO> iotMain(@Param("member_id")String member_id);
	
	// Iot_Info 테이블에 원격 장치, 장소 insert
	public void iotInfoInsert(IotInfoVO iif);

	
	
	
	
	// Model 테이블에 Insert
	//public String modelInsert(@Param("modelName") String ModelName);
}
