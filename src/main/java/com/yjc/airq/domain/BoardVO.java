package com.yjc.airq.domain;

import lombok.Data;

@Data
public class BoardVO {

	private int board_id;
	private String board_name;
	private String board_content;
	private String board_author;
}
