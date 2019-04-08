package com.yjc.airq.service;

import org.springframework.stereotype.Service;
import com.yjc.airq.domain.ManageVO;
import com.yjc.airq.mapper.ManageMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManageServiceImplement implements ManageService{
	private ManageMapper mapper;
	
	@Override
	public String remoteReg(ManageVO rg) {
		return mapper.remoteReg(rg);
	}
	


}
