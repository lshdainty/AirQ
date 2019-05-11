package com.yjc.airq;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;

/**
 * home화면을 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class HomeController {

	//홈 메인페이지로 가기
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}
	
	//홈 메인페이지로 가기
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(Model model,HttpServletRequest request) {
		System.out.println("test:");
		System.out.println("---------------------------------------");
	}
}
