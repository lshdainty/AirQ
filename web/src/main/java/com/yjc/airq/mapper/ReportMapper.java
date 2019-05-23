package com.yjc.airq.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

import com.yjc.airq.domain.ReportVO;

public interface ReportMapper {
	// 서비스 제품 삭제에 따른 신고테이블 삭제여부 update
	public void reportUpdate(@Param("original_code") String original_code);
	// 기존에 신고한 내용이 있는지 확인
	public String checkReport(@Param("member_id") String member_id,@Param("original_code") String original_code);
	// 신고 insert
	public void insertReport(ReportVO reportVO);
	
	//마이페이지 글관리
	public ArrayList<ReportVO> mypageMainR();

	//마이페이지 글관리 상세
	public ArrayList<ReportVO> mypageMainRIn(@Param("report_code") String report_code);
}
