package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.IotInfoVO;
import com.yjc.airq.domain.IotVO;

public interface ManageMapper {
	
	public String remoteReg(IotVO rg);
	
	public ArrayList<IotInfoVO> iotMain(@Param("member_id")String member_id);
};
