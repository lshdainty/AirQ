package com.yjc.airq.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PostVO {

	private String post_code;
	private String post_title;
	private String post_content;
	private Timestamp p_creation_date;
	private int view_num;
	private int recommend_num;
	private String member_id;
	private String board_code;
	private String post_thumbnail;
	private int reply_count;
}
