package com.yjc.airq.domain;

import lombok.Data;

@Data
public class AreaVO {
	//area테이블
	private String area_code;	//지역코드
	private String area_do;	//광역시/도
	private String area_si;	//시/구
	
	//p_possible_area테이블
	private String product_code;	//제품코드
}