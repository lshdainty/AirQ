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
	private String product_code;
}
