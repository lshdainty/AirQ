package com.yjc.airq.mapper;


import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.DemandVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.ProductVO;

public interface MypageMapper {
	//mypageSeller - 그래프 합산 가격 들고오기
	public ArrayList<Company_InfoVO> c_code(
			@Param("member_id")String member_id
			);

}
