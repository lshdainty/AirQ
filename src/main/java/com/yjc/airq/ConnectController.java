package com.yjc.airq;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.AreaVO;
import com.yjc.airq.domain.BidVO;
import com.yjc.airq.domain.Criteria;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.mapper.ProductMapper;
import com.yjc.airq.service.ConnectService;
import com.yjc.airq.service.UploadService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 업체연결 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class ConnectController {
	private ConnectService connectService;
	private ProductMapper productMapper;
	private UploadService uploadService;
	
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
		ArrayList<AreaVO> aList= connectService.productAreaList();
		ArrayList<PaymentVO> pmList = connectService.paymentList();
		int sellnum=0;
		float staravg=0;
		for(ProductVO provo:pList) {
			for(PaymentVO payvo:pmList) {
				if(provo.getProduct_code().equals(payvo.getDemandVO().getProduct_code())&&payvo.getRefund_whether().equals("n")) {
					sellnum = sellnum+1;
					staravg = staravg + payvo.getStar_score();
				}
				provo.setSellnum(String.valueOf(sellnum));
				if(staravg==0) {
					provo.setStaravg("0");
				}else {
					provo.setStaravg(new DecimalFormat(".#").format(staravg/sellnum));
				}
			}
			sellnum=0; staravg=0;
		}
		model.addAttribute("pList",pList);
		model.addAttribute("aList",aList);
		model.addAttribute("criteria",criteria);
		
		return "connect/compareMain";
	}
	
	// 입찰 서비스 메인페이지로 가기
	@RequestMapping(value = "tenderMain", method = RequestMethod.GET)
	public String tenderMain(Model model,TenderVO tenderVo) {
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
	public String tenderList(TenderVO tenderVo,HttpServletRequest request) {
		tenderVo.setMember_id(((MemberVO) request.getSession().getAttribute("user")).getMember_id());
		
		//코드 앞에 날짜 6자리
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		
		//코드 뒤에 랜덤 4자리
		int random=(int)(Math.random()*10000);
		String tender_code="td"+day+random;
		
		//VO에 생성한 코드 set하기
		tenderVo.setTender_code(tender_code);
		
		//insert에 영향을 받은 행의 갯수
		int s=connectService.addTenderboard(tenderVo);
		
		return "redirect: /tenderMain";
	}
	
	// 입찰 서비스 - 리스트에서 입찰 세부 내용으로 가기
	@RequestMapping(value="tender/{tender_code}",method=RequestMethod.GET)
	public String ten(@PathVariable String tender_code,Model model) {
		model.addAttribute("tenderContent",connectService.tenderContent(tender_code));
		model.addAttribute("bidContent",connectService.bidContent(tender_code));
		System.out.println(connectService.bidContent(tender_code));
		return "connect/tenderContent";
	}
	
	// 입찰 서비스 - 입찰 공고 삭제 후 리스트로 가기
	@RequestMapping(value="tenderDelete/{tender_code}",method=RequestMethod.GET)
	public String tenderDelete(@PathVariable String tender_code,Model model) {
		ArrayList<BidVO> uploadArr=connectService.findUploadCode(tender_code);
		for(int i=0; i<uploadArr.size();i++) {
			uploadService.deleteUpload(uploadArr.get(i));
		}
		connectService.deleteBid(tender_code);
		int s=connectService.tenderDelete(tender_code);
		
		return "redirect: /tenderMain";
	}

	// 입찰 서비스 - 입찰 공고 수정 페이지로 가기
	@RequestMapping(value="tenderModify/{tender_code}",method=RequestMethod.GET)
	public String tenderModify(@PathVariable String tender_code,Model model) {
		model.addAttribute("tenderModify",connectService.tenderContent(tender_code));
		
		return "connect/tenderModify";
	}
	
	// 입찰 서비스- 입찰 공고 수정 완료
	@RequestMapping(value="tenderModifyComplete",method=RequestMethod.POST)
	public String tenderModifyComplete(TenderVO tenderVo,Model model) {
		int s=connectService.tenderModify(tenderVo);
		String tender_code=tenderVo.getTender_code();
		return "redirect: /tenderContent/"+tender_code;
	}
	
	// 업체 분석/비교 도,시,평수 선택완료
	@RequestMapping(value="selectCompare",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject selectCompare(Model model,HttpServletRequest request) {
		String sido = request.getParameter("sido");
		String sigoon = request.getParameter("sigoon");
		int space = Integer.parseInt(request.getParameter("space"));
		
		Criteria criteria = new Criteria();
		int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		criteria.setTotalcount(productMapper.selectCount(sido,sigoon,space));	//전체 게시글 개수를 지정
		criteria.setPagenum(pagenum);	//현재 페이지를 페이지 객체에 지정
		criteria.setStartnum(pagenum);	//컨텐츠 시작 번호 지정
		criteria.setEndnum(pagenum);	//컨텐츠 끈 번호 지정 
		criteria.setCurrentblock(pagenum);	//현재 페이지 블록이 몇번인지 현재 페이지 번호 통해 지정
		criteria.setLastblock(criteria.getTotalcount());	//마지막 블록 번호를 전체 게시글 수를 통해 정함
		criteria.prevnext(pagenum);	//현재 페이지 번호로 화살표를 나타낼지 정함
		criteria.setStartPage(criteria.getCurrentblock());	//시작 페이지를 페이지 블록번호로 정함
		criteria.setEndPage(criteria.getLastblock(),criteria.getCurrentblock());	//마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록으로 정함
		
		ArrayList<ProductVO> pList = connectService.selectList(sido,sigoon,space,criteria.getStartnum(),criteria.getEndnum());
		ArrayList<AreaVO> aList= connectService.productAreaList();
		ArrayList<PaymentVO> pmList = connectService.paymentList();
		int sellnum=0;
		float staravg=0;
		for(ProductVO provo:pList) {
			for(PaymentVO payvo:pmList) {
				if(provo.getProduct_code().equals(payvo.getDemandVO().getProduct_code())&&payvo.getRefund_whether().equals("n")) {
					sellnum = sellnum+1;
					staravg = staravg + payvo.getStar_score();
				}
				provo.setSellnum(String.valueOf(sellnum));
				if(staravg==0) {
					provo.setStaravg("0");
				}else {
					provo.setStaravg(new DecimalFormat(".#").format(staravg/sellnum));
				}
			}
			sellnum=0; staravg=0;
		}
		JSONArray pJson = JSONArray.fromObject(pList);
		JSONArray aJson = JSONArray.fromObject(aList);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pList",pJson);
		map.put("aList",aJson);
		map.put("criteria",criteria);
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
}