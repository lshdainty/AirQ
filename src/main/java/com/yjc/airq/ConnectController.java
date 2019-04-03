package com.yjc.airq;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.Criteria;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderboardVO;
import com.yjc.airq.mapper.ProductMapper;
import com.yjc.airq.service.ConnectService;

import lombok.AllArgsConstructor;
/**
 * 업체연결 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class ConnectController {
	private ConnectService connectService;
	private ProductMapper productMapper;
	
	// 업체 분석/비교 메인페이지로 가기
	@RequestMapping(value = "compareMain", method = RequestMethod.GET)
	public String compareMain(Model model,HttpServletRequest request) {
		Criteria criteria = new Criteria();
		int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		criteria.setTotalcount(productMapper.productCount());	//전체 게시글 개수를 지정
		criteria.setPagenum(pagenum);	//현재 페이지를 페이지 객체에 지정
		criteria.setStartnum(pagenum);	//컨텐츠 시작 번호 지정
		criteria.setEndnum(pagenum);	//컨텐츠 끈 번호 지정 
		criteria.setCurrentblock(pagenum);	//현재 페이지 블록이 몇번인지 현재 페이지 번호 통해 지정
		criteria.setLastblock(criteria.getTotalcount());	//마지막 블록 번호를 전체 게시글 수를 통해 정함
		
		criteria.prevnext(pagenum);	//현재 페이지 번호로 화살표를 나타낼지 정함
		criteria.setStartPage(criteria.getCurrentblock());	//시작 페이지를 페이지 블록번호로 정함
		criteria.setEndPage(criteria.getLastblock(),criteria.getCurrentblock());	//마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록으로 정함
		ArrayList<ProductVO> pList = connectService.productList(criteria.getStartnum(),criteria.getEndnum());
		model.addAttribute("pList",pList);
		model.addAttribute("criteria",criteria);
		
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
	
	// 입찰 서비스 - 글쓰기 작성 후 리스트로 가기
	@RequestMapping(value = "tenderWriteComplete", method = RequestMethod.POST)
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
		
		return "redirect: /tenderMain";
	}
	
	// 입찰 서비스 - 리스트에서 입찰 세부 내용으로 가기
	@RequestMapping(value="tender/{tcode}",method=RequestMethod.GET)
	public String ten(@PathVariable String tcode,Model model) {
		model.addAttribute("tenderContent",connectService.tenderContent(tcode));
		
		return "connect/tender";
	}
	
	// 입찰 서비스 - 입찰 공고 삭제 후 리스트로 가기
		@RequestMapping(value="tenderDelete/{tcode}",method=RequestMethod.GET)
		public String tenderDelete(@PathVariable String tcode,Model model) {
			int s=connectService.tenderDelete(tcode);
			
			return "redirect: /tenderMain";
		}

	// 입찰 서비스 - 입찰 공고 수정 페이지로 가기
	@RequestMapping(value="tenderModify/{tcode}",method=RequestMethod.GET)
	public String tenderModify(@PathVariable String tcode,Model model) {
		model.addAttribute("tenderModify",connectService.tenderContent(tcode));
		
		return "connect/tenderModify";
	}
	
	// 입찰 서비스- 입찰 공고 수정 완료
	@RequestMapping(value="tenderModifyComplete",method=RequestMethod.POST)
	public String tenderModifyComplete(TenderboardVO tenderboardVo,Model model) {
		int s=connectService.tenderModify(tenderboardVo);
		String tcode=tenderboardVo.getTcode();
		return "redirect: /tender/"+tcode;
	}
}