package com.yjc.airq.domain;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class TenderVO {
	
	private int rnum;
	private String tender_code;
	private String tender_title;
	private String tender_name;
	private Timestamp t_creation_date;
	private String service_date;
	private String tender_deadline;
	private int calculate_period;
	private int t_space;
	private int floor_number;
	private String requirement;
	private String t_addr_do;
	private String t_addr_si;
	private String t_addr_dong;
	private String t_addr_detail;
	
	//조인 할 속성
	private String member_id;

	// 참여 업체 수 
	private int company_count;
	// 마감기한 D-day
	private String d_day;
	
	private String tcreationdate;
}
