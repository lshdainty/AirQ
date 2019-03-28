package com.yjc.airq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;

/**
 * 업체연결 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class ConnectController {

	// 업체 분석/비교 메인페이지로 가기
	@RequestMapping(value = "compareMain", method = RequestMethod.GET)
	public String compareMain(Model model) {
		return "connect/compareMain";
	}

	// 입찰 서비스 메인페이지로 가기
	@RequestMapping(value = "tenderMain", method = RequestMethod.GET)
	public String tenderMain(Model model) {
		return "connect/tenderMain";
	}

	// 입찰 서비스 - 리스트에서 글쓰기로 가기
	@RequestMapping(value = "tenderboardWrite", method = RequestMethod.POST)
	public String tenderWrite() {
		return "connect/tenderWrite";
	}

	// 입찰 서비스 - 글쓰기에서 리스트로 가기
	@RequestMapping(value = "tenderList", method = RequestMethod.POST)
	public String tenderList() {
		return "connect/tenderMain";
	}
	
	// 입찰 서비스 - 리스트에서 게시물 내용으로 가기
	@RequestMapping(value="tender",method=RequestMethod.POST)
	public String tenderBoard() {
		return "connect/tender";
	}
}
