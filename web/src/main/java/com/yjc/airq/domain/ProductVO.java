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
	private Company_InfoVO companyVO;	//상품을 제공하는 회사정보
	private String file_name;	//상품 썸네일 
	private ArrayList<AreaVO> areaVO;	//제품 서비스가 가능한 지역 리스트
	private ArrayList<MatterVO> matterVO;	//제품이 측정해주는 물질 리스트
	
	private String report_count;
	private int reply_count;
	private String member_id;
	
	private String d_service_date;
}