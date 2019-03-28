package com.yjc.airq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;

/**
 * 커뮤니티 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class CommunityController {
	
	//상품추천 메인페이지로 가기
	@RequestMapping(value = "recommendMain", method = RequestMethod.GET)
	public String recommendMain(Model model) {
		return "community/recommendMain";
	}
	
	// 상품추천 글쓰기로 가기
	@RequestMapping(value = "recommendWrite", method = RequestMethod.GET)
	public String recommandWrite(Model model) {
		return "community/recommendWriteForm";
	}
	
	//자유게시판 메인페이지로 가기
	@RequestMapping(value = "libertyMain", method = RequestMethod.GET)
	public String libertyMain(Model model) {
		return "community/libertyMain";
	}
	
	// 자유게시판 글쓰기로 가기
		@RequestMapping(value = "libertyWrite", method = RequestMethod.GET)
		public String libertyWrite(Model model) {
			return "community/libertyWriteForm";
		}
	
	//대기오염물질 메인페이지로 가기
	@RequestMapping(value = "metterMain", method = RequestMethod.GET)
	public String metterMain(Model model) {
		return "community/metterMain";
	}
	
	//공기질 향상방법 메인페이지로 가기
	@RequestMapping(value = "improveMain", method = RequestMethod.GET)
	public String improveMain(Model model) {
		return "community/improveMain";
	}
	
	//건강지킴이 메인페이지로 가기
	@RequestMapping(value = "healthMain", method = RequestMethod.GET)
	public String healthMain(Model model) {
		return "community/healthMain";
	}
	
}
