package com.yjc.airq.service;

import java.util.ArrayList;

import com.yjc.airq.domain.UploadVO;

public interface UploadService {
	void imgUpload(UploadVO uploadVO);
	void uploadUpdate(String upload_code);
	void deletePostUpload(String post_code);
	
	// 업로드 정보
	public UploadVO uploadInfo(String upload_code);
	
	//투찰에 있던 파일 삭제
	public void deleteBidUpload(ArrayList<String> uploadArr);
	
	//입찰 업로드 삭제
	public void tenderUploadDelete(String upload_code);
}
