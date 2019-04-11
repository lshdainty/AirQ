package com.yjc.airq.mapper;

import com.yjc.airq.domain.BidVO;
import com.yjc.airq.domain.UploadVO;

public interface UploadMapper {
	public void imgUpload(UploadVO uploadVO);
	public void uploadUpdate(String upload_code);
	public void deletePostUpload(String post_code);
	
	//투찰에 있던 파일 삭제
	public void deleteUpload(BidVO bidVo);

}
