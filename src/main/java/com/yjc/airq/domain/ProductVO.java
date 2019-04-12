package com.yjc.airq.domain;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ProductVO {
	private String product_code;	//코드
	private String product_name;	//상품이름
	private String product_detail;	//상품 상세설명
	private int product_price;	//상품 가격
	private int p_space;	//평수
	private int measure_point;	//측정지점
	private String company_code;	//서비스 업체 코드
	private String sellnum;	//판매건수
	private String staravg;	//별점평균
	private ArrayList<AreaVO> areaVO;
}