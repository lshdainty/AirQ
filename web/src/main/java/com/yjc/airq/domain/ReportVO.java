package com.yjc.airq.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReportVO {

	private String report_code;
	private String report_title;
	private String report_content;
	private Timestamp report_date;
	private String classification;
	private String original_code;
	private String delete_whether;
	private String member_id;
	
	private int count;
}
