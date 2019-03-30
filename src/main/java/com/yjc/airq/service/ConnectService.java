package com.yjc.airq.service;

import java.util.ArrayList;
import com.yjc.airq.domain.ProductVO;

public interface ConnectService {
	// 회원 목록
	public ArrayList<ProductVO> productList();
}