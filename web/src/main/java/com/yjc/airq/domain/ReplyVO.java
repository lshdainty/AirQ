package com.yjc.airq.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyVO {
	private String reply_code;
	private String reply_content;
	private Timestamp r_creation_date;
	private String member_id;
	private String post_code;
	private String payment_code;
	
	private String board_name;
	private String product_name;
	private String post_title;
	private String product_code;
}
