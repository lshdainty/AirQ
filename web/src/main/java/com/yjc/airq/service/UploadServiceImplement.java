package com.yjc.airq.service;

import java.util.ArrayList;

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
	public void deletePostUpload(String post_code) {
		System.out.println("UPLOAD MAPPER");
		mapper.deletePostUpload(post_code);
	}
	
	// 업로드 정보
	@Override
	public UploadVO uploadInfo(String upload_code) {
		return mapper.uploadInfo(upload_code);
	}
	
	//투찰에 있던 파일 삭제
	@Override
	public void deleteBidUpload(ArrayList<String> uploadArr) {
		mapper.deleteBidUpload(uploadArr);
	}
	
	//입찰 업로드 삭제
	@Override
	public void tenderUploadDelete(String upload_code) {
		mapper.tenderUploadDelete(upload_code);
	}
}
