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

	// 실시간 차트 기본 데이터 30개 가져오기
	public ArrayList<Map<String,Object>> getOldData(){
		return mapper.getOldData();
	}
	
	// 하루 평균값 가져오기
	public String getTodayAvgData(@Param("member_id") String member_id){
		return mapper.getTodayAvgData(member_id);
	}
	
	// 임계값 초과 횟수 가져오기
	public int getOverValue(@Param("member_id") String member_id){
		return mapper.getOverValue(member_id);
	}
	
	// 월 평균 데이터 가져오기
	public ArrayList<Map<String,Object>> getMonthData(@Param("member_id") String member_id){
		return mapper.getMonthData(member_id);
	}
	
	// 요일 평균 데이터 가져오기
	public ArrayList<Map<String,Object>> getDayData(@Param("member_id") String member_id){
		return mapper.getDayData(member_id);
	}
	
	// 시간 평균 데이터 가져오기
	public ArrayList<Map<String,Object>> getTimeData(@Param("member_id") String member_id){
		return mapper.getTimeData(member_id);
	}
	
	// 실시간 차트 최신 데이터 가져오기
	public ArrayList<Map<String,Object>> getNowData(){
		return mapper.getNowData();
	}
	
	// 차트 세부내용
//	public ArrayList<MeasureDataVO> chartValue(String member_id, String date) {
//		// TODO Auto-generated method stub
//		return mapper.chartValue(member_id, date);
//	}
}
