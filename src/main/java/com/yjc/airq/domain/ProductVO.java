package com.yjc.airq.domain;

import lombok.Data;

@Data
public class ProductVO {
	private String product_code;	//코드
	private String product_name;	//상품이름
	private String detail;	//상품 상세설명
	private int price;	//상품 가격
	private int area;	//평수
	private int branch;	//측정지점
	private String service_area;	//서비스가능지역
	private int star_average;	//별점 평균
	private int sell_num;	//판매건수
}