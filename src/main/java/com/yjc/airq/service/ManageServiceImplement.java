package com.yjc.airq.service;

import org.springframework.stereotype.Service;
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
	


}
