package com.yjc.airq.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.MatterVO;

public interface MatterMapper {
	// 측정 물질 리스트 가져오기
	public ArrayList<MatterVO> matterList();
	// 측정 가능한 물질 등록
	public void productMatterInsert(@Param("matter_code") String matter_code,@Param("product_code") String product_code);
	// 측정 가능 물질 삭제
	public void productMatterDelete(@Param("product_code") String product_code);
	
	//일별 예약자 모니터링
	public ArrayList<Map<String,Object>> reservation(@Param("member_id") String member_id, @Param("iot_id") String iot_id, @Param("matter_code") String matter_code);
	
	//시간별 예약자 모니터링
	public ArrayList<Map<String,Object>> timeGraph(@Param("member_id") String member_id, @Param("iot_id") String iot_id, @Param("matter_code") String matter_code, @Param("dayMatterData") String dayMatterData);
	
	//나쁨 횟수
	public int badNum(@Param("member_id") String member_id, @Param("iot_id") String iot_id, @Param("matter_code") String matter_code, @Param("badValue") int badValue);
	
	//일주일 미세먼지 평균
	public String measure_value_avg(@Param("member_id") String member_id, @Param("iot_id") String iot_id, @Param("matter_code") String matter_code);

	//현재 미세먼지 농도
	public int measure_value(@Param("member_id") String member_id, @Param("iot_id") String iot_id, @Param("matter_code") String matter_code);
	
	//IOT 앱푸쉬 시간정보 가져오기
	public String alarm_time(@Param("iot_id")String iot_id, @Param("matter_code")String matter_code);

	//IOT 앱푸쉬 시간정보 업데이트 
	public void alarm_time_update(@Param("iot_id")String iot_id,@Param("matter_code")String matter_code);
	
};
