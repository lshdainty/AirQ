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

	// 사용자가 가지고있는 공기질 측정 iot기기 개수 확인
	public int checkIot(@Param("member_id") String member_id);
	
	// 사용자가 가지고있는 공기질 측정 iot목록 가져오기
	public ArrayList<Map<String,Object>> iotList(@Param("member_id") String member_id);
	
	// iot기기가 측정할 수 있는 물질 목록 가져오기
	public ArrayList<Map<String,Object>> iotMatterList(@Param("model") String model);
	
	// 사용자가 선택한 IOT의 모델명 가져오기
	public String selectModel(@Param("iot_id") String iot_id);
	
	// 실시간 차트 기본 데이터 30개 가져오기
	public ArrayList<Map<String,Object>> getOldData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code);
	
	// 하루 평균값 가져오기
	public String getTodayAvgData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code);
	
	// 임계값 초과 횟수 가져오기
	public int getOverValue(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code);
	
	// 월 평균 데이터 가져오기
	public ArrayList<Map<String,Object>> getMonthData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code);
	
	// 요일 평균 데이터 가져오기
	public ArrayList<Map<String,Object>> getDayData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code);
	
	// 시간 평균 데이터 가져오기
	public ArrayList<Map<String,Object>> getTimeData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code);
	
	// 실시간 차트 최신 데이터 가져오기
	public ArrayList<Map<String,Object>> getNowData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code);
	
	// 차트 세부내용
//	public ArrayList<MeasureDataVO> chartValue(String member_id);
}
