package com.yjc.airq.service;

import java.util.ArrayList;

import com.yjc.airq.domain.Company_InfoVO;

public interface MypageService {
	public ArrayList<Company_InfoVO> c_code(String member_id);
}
