package com.yjc.airq.domain;

import lombok.Data;

@Data
public class MatterVO {
	//matter테이블
	private String matter_code;	//물질코드
	private String matter_name;	//물질이름
	
	//p_measure_matter테이블
	private String product_code;	//상품코드
}