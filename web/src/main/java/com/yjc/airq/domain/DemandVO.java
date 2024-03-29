package com.yjc.airq.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DemandVO {
	private String demand_code;
	private Timestamp demand_date;
	private String d_zipcode;
	private String d_road_addr;
	private String d_addr;
	private String d_addr_detail;
	private String member_id;
	private String product_code;
	private Timestamp d_service_date;
	
	private String service_date;
}