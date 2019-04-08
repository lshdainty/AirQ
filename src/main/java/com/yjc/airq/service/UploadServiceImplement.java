package com.yjc.airq.service;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.UploadVO;
import com.yjc.airq.mapper.UploadMapper;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UploadServiceImplement implements UploadService {
	
	private UploadMapper mapper;
	
	@Override
	public void imgUpload(UploadVO uploadVO) {
		mapper.imgUpload(uploadVO);
	}
	public void uploadUpdate(String upload_code) {
		mapper.uploadUpdate(upload_code);
	}
	
}
