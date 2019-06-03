package com.yjc.airq.domain;

import com.yjc.airq.domain.Company_InfoVO;
import lombok.Data;

@Data
public class Company_InfoVO {
	private String company_code;
	private String company_name;
	private String company_tel;
	private String company_email;
	private String c_zipcode;
	private String c_road_addr;
	private String c_addr;
	private String c_addr_detail;
	private String registration_status;
	private String member_id;
	
	private int bidNum;
	private double star_score_avg;
	private String note;
	private String member_name;
	private String sum;
	private String month;
	private int reviewNum;
}
