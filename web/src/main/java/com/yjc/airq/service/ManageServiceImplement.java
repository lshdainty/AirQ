package com.yjc.airq.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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

	// inside Chart
	public ArrayList<MeasureDataVO> insideChart(@Param("member_id") String member_id, @Param("date") String date) {
		return mapper.insideChart(member_id, date);
	}
	
	// 사용자가 가지고있는 공기질 측정 iot기기 개수 확인
	public int checkIot(@Param("member_id") String member_id){
		return mapper.checkIot(member_id);
	}

	// 사용자가 가지고있는 공기질 측정 iot목록 가져오기
	public ArrayList<Map<String,Object>> iotList(@Param("member_id") String member_id){
		return mapper.iotList(member_id);
	}
	
	// iot기기가 측정할 수 있는 물질 목록 가져오기
	public ArrayList<Map<String,Object>> iotMatterList(@Param("model") String model){
		return mapper.iotMatterList(model);
	}
	
	// 사용자가 선택한 IOT의 모델명 가져오기
	public String selectModel(@Param("iot_id") String iot_id) {
		return mapper.selectModel(iot_id);
	}
	
	// 실시간 차트 기본 데이터 30개 가져오기
	public ArrayList<Map<String,Object>> getOldData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code){
		return mapper.getOldData(iot_id,matter_code);
	}
	
	// 하루 평균값 가져오기
	public String getTodayAvgData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code){
		return mapper.getTodayAvgData(iot_id,matter_code);
	}
	
	// 임계값 초과 횟수 가져오기
	public int getOverValue(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code,@Param("limit") int limit){
		return mapper.getOverValue(iot_id,matter_code,limit);
	}
	
	// 월 평균 데이터 가져오기
	public ArrayList<Map<String,Object>> getMonthData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code){
		return mapper.getMonthData(iot_id,matter_code);
	}
	
	// 요일 평균 데이터 가져오기
	public ArrayList<Map<String,Object>> getDayData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code){
		return mapper.getDayData(iot_id,matter_code);
	}
	
	// 시간 평균 데이터 가져오기
	public ArrayList<Map<String,Object>> getTimeData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code){
		return mapper.getTimeData(iot_id,matter_code);
	}
	
	// 실시간 차트 최신 데이터 가져오기
	public ArrayList<Map<String,Object>> getNowData(@Param("iot_id") String iot_id,@Param("matter_code") String matter_code){
		return mapper.getNowData(iot_id,matter_code);
	}

	@Override
	public ArrayList<Map<String, Object>> getDailyHourData(String iot_id, String matter_code) {
		// TODO Auto-generated method stub
		return mapper.getDailyHourData(iot_id, matter_code);
	}

	@Override
	public String getMeasureData(String iot_id, String matter_code,String matter_code1) {
		// TODO Auto-generated method stub
		return mapper.measure_value(iot_id, matter_code,matter_code1);
	}

	@Override
	public String getIotMember(String iot_id) {
		// TODO Auto-generated method stub
		return mapper.iot_member_id(iot_id);
	}
	
	// 차트 세부내용
//	public ArrayList<MeasureDataVO> chartValue(String member_id, String date) {
//		// TODO Auto-generated method stub
//		return mapper.chartValue(member_id, date);
//	}
}
