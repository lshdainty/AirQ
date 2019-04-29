package com.yjc.airq.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.DemandVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.ProductVO;

public interface MypageService {

	public ArrayList<Company_InfoVO> c_code( String member_id);

}
