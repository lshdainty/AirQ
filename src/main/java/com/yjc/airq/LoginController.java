package com.yjc.airq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;

/**
 * 로그인을 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class LoginController {
	
	//로그인 메인페이지로 가기
	@RequestMapping(value = "/loginMain", method = RequestMethod.GET)
	public String loginMain(Model model) {
		return "login/loginMain";
	}
	
}
