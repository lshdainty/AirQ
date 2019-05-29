package com.yjc.airq.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.IotInfoVO;
import com.yjc.airq.domain.MeasureDataVO;

public interface ManageMapper {
	
	// 로그인한 사람별로 원격 정보 알려줌
	public ArrayList<IotInfoVO> iotMain(@Param("member_id")String member_id);
	
	// Iot_Info 테이블에 원격 장치, 장소 insert
	public void iotInfoInsert(IotInfoVO iif);
	
	// 자신 원격 제품 고유 별명 중복 체크
	public IotInfoVO nCheck(String alias);

	public int measureData(Map<String, Object> m);
	
	// Model 테이블에 Insert
	//public String modelInsert(@Param("modelName") String ModelName);
};
