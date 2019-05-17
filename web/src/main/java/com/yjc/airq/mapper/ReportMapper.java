package com.yjc.airq.mapper;

import com.yjc.airq.domain.ReportVO;

public interface ReportMapper {
	// 입찰 신고 insert
	public void tenderReport(ReportVO reportVo);
	
	// 입찰 삭제하면 delete_whether=y로 update
	public void tDelete_whether(String tender_code);
}
