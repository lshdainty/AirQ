package com.yjc.airq.mapper;

import com.yjc.airq.domain.Company_InfoVO;

public interface CompanyMapper {
	//회사
	public void sellerList(Company_InfoVO company);
	
	//투찰 작성
	public Company_InfoVO company_info(String member_id);
}
