package com.yjc.airq.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UploadVO {
	private String upload_code;
	private String original_name;
	private String file_name;
	private Timestamp upload_date;
	private String product_code;
	private String post_code;
	private String thumbnail_whether;
}