package com.yjc.airq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;

/**
 * 공기질 관리 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class ManageController {
	
	//공기질 모니터링 메인페이지로 가기
	@RequestMapping(value = "/monitoringMain", method = RequestMethod.GET)
	public String monitoringMain(Model model) {
		return "manage/monitoringMain";
	}
	
	//IOT 원격제어 메인페이지로 가기
	@RequestMapping(value = "/remoteMain", method = RequestMethod.GET)
	public String remoteMain(Model model) {
		return "manage/remoteMain";
	}
	
}
