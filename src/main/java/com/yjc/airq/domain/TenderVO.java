package com.yjc.airq.domain;

import java.sql.Timestamp;
import java.sql.Date;

import lombok.Data;

@Data
public class TenderVO {
	private int rownum;
	private String tender_code;
	private String tender_title;
	private String tender_name;
	private Timestamp t_creation_date;
	private Date service_date;
	private Date tender_deadline;
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
	private int company_count; 
}
