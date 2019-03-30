package com.yjc.airq;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderboardVO;
import com.yjc.airq.service.ConnectService;

import lombok.AllArgsConstructor;
/**
 * 업체연결 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class ConnectController {
	private ConnectService connectService;
	
	// 업체 분석/비교 메인페이지로 가기
	@RequestMapping(value = "compareMain", method = RequestMethod.GET)
	public String compareMain(Model model) {
		ArrayList<ProductVO> pList = connectService.productList();
		model.addAttribute("pList",pList);
		
		return "connect/compareMain";
	}
	// 입찰 서비스 메인페이지로 가기
	@RequestMapping(value = "tenderMain", method = RequestMethod.GET)
	public String tenderMain(Model model) {
		model.addAttribute("tenderList",connectService.tenderList());
		return "connect/tenderMain";
	}

	// 입찰 서비스 - 리스트에서 글쓰기로 가기
	@RequestMapping(value = "tenderboardWrite", method = RequestMethod.POST)
	public String tenderWrite() {
		return "connect/tenderWrite";
	}
	// 입찰 서비스 - 글쓰기에서 리스트로 가기
	@RequestMapping(value = "tenderWriteComplete", method = RequestMethod.POST)
	@ResponseBody
	public String tenderList(TenderboardVO tenderboardVo) {
		//코드 앞에 날짜 6자리
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		
		//코드 뒤에 랜덤 4자리
		int random=(int)(Math.random()*10000);
		String tcode=day+random;
		
		//VO에 생성한 코드 set하기
		tenderboardVo.setTcode(tcode);
		
		//insert에 영향을 받은 행의 갯수
		int s=connectService.addTenderboard(tenderboardVo);
		
		if(s==0) {
			return "f";
		}
		return "s";
	}
	
	// 입찰 서비스 - 리스트에서 게시물 내용으로 가기
	@RequestMapping(value="tender",method=RequestMethod.GET)
	public String tenderBoard() {
		return "connect/tender";
	}
}