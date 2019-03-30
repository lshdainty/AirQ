package com.yjc.airq.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.mapper.ProductMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConnectImplement implements ConnectService{

	private ProductMapper productMapper;
	
	public ArrayList<ProductVO> productList(){
		return productMapper.productList();
	};

}
