package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.IotInfoVO;

public interface ManageMapper {
	
	// 로그인한 사람별로 원격 정보 알려줌
	public ArrayList<IotInfoVO> iotMain(@Param("member_id")String member_id);
	
	// Iot_Info 테이블에 원격 장치, 장소 insert
	public void iotInfoInsert(IotInfoVO iif);
	
	// Model 테이블에 Insert
	//public String modelInsert(@Param("modelName") String ModelName);
};
