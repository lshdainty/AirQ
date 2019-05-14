package com.yjc.airq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;

/**
 * 서비스 소개를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class ServiceController {
	
	//서비스 소개 메인페이지로 가기
	@RequestMapping(value = "introMain", method = RequestMethod.GET)
	public String introMain(Model model) {
		return "service/introMain";
	}
	
}
