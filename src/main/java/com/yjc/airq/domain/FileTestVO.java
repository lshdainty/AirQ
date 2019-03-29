package com.yjc.airq.domain;

import com.yjc.airq.domain.FileTestVO;
import lombok.Data;

@Data
public class FileTestVO {
	private String filename; // uuid 합친 이름
	private String oriname;	// 원본 이름
	private String path; // 파일 경로
}