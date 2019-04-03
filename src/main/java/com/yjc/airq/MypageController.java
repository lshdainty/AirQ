package com.yjc.airq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yjc.airq.service.ConnectService;

import lombok.AllArgsConstructor;

/**
 * mypage를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class MypageController {
	private ConnectService connectService;
	//mypageMain  가기
	@RequestMapping(value = "mypageMain", method = RequestMethod.GET)
	public String mypageMain(Model model) {
		return "mypage/mypageMain";
	}
	//mypageMainCategory 가기
	@RequestMapping(value = "mypageMainCategory", method = RequestMethod.GET)
	public String mypageMainCategory(Model model) {
		return "mypage/mypageMainCategory";
	}
	//mypageMainComment 가기
	@RequestMapping(value = "mypageMainComment", method = RequestMethod.GET)
	public String mypageMainComment(Model model) {
		return "mypage/mypageMainComment";
	}
	//mypageMainMember 가기
	@RequestMapping(value = "mypageMainMember", method = RequestMethod.GET)
	public String mypageMainMember(Model model) {
		return "mypage/mypageMainMember";
	}
	//mypageMainPosts 가기
	@RequestMapping(value = "mypageMainPosts", method = RequestMethod.GET)
	public String mypageMainPosts(Model model) {
		model.addAttribute("tenderList",connectService.tenderList());
		return "mypage/mypageMainPosts";
	}
	
}
