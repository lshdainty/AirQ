package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.UploadVO;

public interface UploadMapper {
	public void imgUpload(UploadVO uploadVO);
	public void uploadUpdate(String upload_code);
	public void deletePostUpload(String post_code);
	
	// 입찰 삭제할 때 투찰에 있던 파일 삭제
	public void deleteBidUpload(ArrayList<String> uploadArr);
	
	//투찰 파일 업로드
	public void bidUpload(UploadVO uploadVo);
	
	// 투찰 삭제
	public void bidUploadDelete(String upload_code);
	
	// 서비스 제품 사진 등록
	public void productImageUpload(UploadVO uploadVO);
	
	// 서비스 제품 썸네일 등록
	public void productThumbnailUpload(UploadVO uploadVO);
	
	// 서비스 제품 사진 삭제
	public void productImageDelete(@Param("product_code") String product_code);
}
