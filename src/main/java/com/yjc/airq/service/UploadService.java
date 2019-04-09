package com.yjc.airq.service;

import com.yjc.airq.domain.UploadVO;

public interface UploadService {
	void imgUpload(UploadVO uploadVO);
	void uploadUpdate(String upload_code);
	void deletePostUpload(String post_code);
}
