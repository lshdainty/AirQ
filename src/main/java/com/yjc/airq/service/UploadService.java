package com.yjc.airq.service;

import com.yjc.airq.domain.BidVO;
import com.yjc.airq.domain.UploadVO;

public interface UploadService {
	void imgUpload(UploadVO uploadVO);
	void uploadUpdate(String upload_code);
	void deletePostUpload(String post_code);
	
	//투찰에 있던 파일 삭제
	public void deleteUpload(BidVO bidVo);
}
