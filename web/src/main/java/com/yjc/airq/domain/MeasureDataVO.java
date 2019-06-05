package com.yjc.airq.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MeasureDataVO {
	private int measure_data_code;
	private String measure_value;
	private Timestamp measure_time;
	private String iot_id;
	private String matter_code;
	
	private String measure; // 차트 들어가는 측정 값
	private String measuretime; // 차트 들어가는 측정 시간
	private String TODAY; // 차트 세부내용 들어가는 현재 날짜
	private String iotID; // 차트 세부내용 들어가는 측정 기기
	private String CODE; // 차트 세부내용 들어가는 측정 코드
}
