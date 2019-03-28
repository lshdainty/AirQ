package com.yjc.airq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;

/**
 * 회원가입을 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class JoinController {
	
	//회원가입 메인페이지로 가기
	@RequestMapping(value = "joinMain", method = RequestMethod.GET)
	public String joinMain(Model model) {
		return "join/joinMain";
	}
	
}
