package com.yjc.airq.domain;

import lombok.Data;

@Data
public class TenderVO {
	private int rnum;
	private int rownum;
	private String tender_code;
	private String tender_title;
	private String tender_name;
	private String t_creation_date;
	private String service_date;
	private String tender_deadline;
	private int calculate_period;
	private int t_space;
	private int floor_number;
	private String requirement;
	private String t_zipcode;
	private String t_road_addr;
	private String t_addr;
	private String t_addr_detail;
	
	//조인 할 속성
	private String member_id;

	// 참여 업체 수 
	private int company_count;
	// 마감기한 D-day
	private String d_day;
	
	private String tcreationdate;
	
	private String report_count;
	
	private int payment_price;
	private String payment_code;
}
