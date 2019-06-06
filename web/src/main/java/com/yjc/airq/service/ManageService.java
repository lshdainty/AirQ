package com.yjc.airq.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.IotInfoVO;
import com.yjc.airq.domain.MeasureDataVO;

public interface ManageService {
	
	// 로그인 아이디를 통한 원격 메인 화면
	public ArrayList<IotInfoVO> iotMain(@Param("member_id")String member_id);
	
	// Iot_Info 테이블에 원격 장치, 장소 insert
	public void iotInfoInsert(IotInfoVO iif);

	// 자신 원격 제품 고유 별명 중복 체크
	public IotInfoVO nCheck(String alias);

	// 미세먼지 측정 데이터
	public int measureData(Map<String, Object> m);

	// inside Chart
	public ArrayList<MeasureDataVO> insideChart(@Param("member_id") String member_id, @Param("date") String date);

	// 차트 세부내용
//	public ArrayList<MeasureDataVO> chartValue(String member_id);
}
