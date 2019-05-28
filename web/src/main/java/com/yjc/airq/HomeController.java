package com.yjc.airq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value = "/test", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> test(@RequestBody Map<String, Object> info) {
		
		System.out.println("test:");
		System.out.println("---------------------------------------");
		
		System.out.println("dust value: " + info.get("dustvalue"));
		
		Map<String, Object> resultVal = new HashMap<String, Object>();
		resultVal.put("result", "success!!");
		
		return resultVal;
	}
}
