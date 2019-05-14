package com.yjc.airq.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.IotInfoVO;
import com.yjc.airq.domain.IotVO;
import com.yjc.airq.mapper.ManageMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageServiceImplement implements ManageService{
	private ManageMapper mapper;
	
	@Override
	public String remoteReg(IotVO rg) {
		return mapper.remoteReg(rg);
	}
	
	public ArrayList<IotInfoVO> iotMain(String member_id) {
		return mapper.iotMain(member_id);
	}

}
