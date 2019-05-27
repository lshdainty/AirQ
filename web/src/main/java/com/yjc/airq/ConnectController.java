package com.yjc.airq;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yjc.airq.domain.AreaVO;
import com.yjc.airq.domain.BidVO;
import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.Criteria;
import com.yjc.airq.domain.DemandVO;
import com.yjc.airq.domain.MatterVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.ReplyVO;
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.domain.UploadVO;
import com.yjc.airq.mapper.ProductMapper;
import com.yjc.airq.service.ConnectService;
import com.yjc.airq.service.MypageService;
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
	private MypageService mypageService;
	
	// 업체 분석/비교 메인페이지로 가기
	@RequestMapping(value = "compareMain", method = RequestMethod.GET)
	public String compareMain(Model model, HttpServletRequest request) {
		Criteria criteria = new Criteria();
		int pagenum = 1;
		String sort = "sellnum";

		criteria.setTotalcount(productMapper.productCount());	//전체 게시글 개수를 지정
		criteria.setPagenum(pagenum);	//현재 페이지를 페이지 객체에 지정
		criteria.setStartnum(pagenum);	//컨텐츠 시작 번호 지정
		criteria.setEndnum(pagenum);	//컨텐츠 끈 번호 지정 
		criteria.setCurrentblock(pagenum);	//현재 페이지 블록이 몇번인지 현재 페이지 번호 통해 지정
		criteria.setLastblock(criteria.getTotalcount());	//마지막 블록 번호를 전체 게시글 수를 통해 정함
		criteria.prevnext(pagenum);	//현재 페이지 번호로 화살표를 나타낼지 정함
		criteria.setStartPage(criteria.getCurrentblock());	//시작 페이지를 페이지 블록번호로 정함
		criteria.setEndPage(criteria.getLastblock(),criteria.getCurrentblock());	//마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록으로 정함
		
		String member_id=((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		String zipcode = connectService.selectZipcode(member_id);
		
		// 사용자가 사는곳에서 많이 팔린 제품리스트
		ArrayList<ProductVO> recommend = connectService.recommendList(zipcode);
		
		// 전체 상품리스트
		ArrayList<ProductVO> pList = connectService.productList(sort,criteria.getStartnum(),criteria.getEndnum());
		
		model.addAttribute("recommend",recommend);
		model.addAttribute("pList",pList);
		model.addAttribute("criteria",criteria);

		return "connect/compareMain";
	}

	// 입찰 서비스 메인페이지로 가기
	@RequestMapping(value = "tenderMain", method = RequestMethod.GET)
	public String tenderMain(Model model, TenderVO tenderVo) {
		Criteria criteria = new Criteria();
		int pagenum = 1;
		String sort = "sellnum";

		criteria.setTotalcount(connectService.tenderCount());	//전체 게시글 개수를 지정
		criteria.setPagenum(pagenum);	//현재 페이지를 페이지 객체에 지정
		criteria.setStartnum(pagenum);	//컨텐츠 시작 번호 지정
		criteria.setEndnum(pagenum);	//컨텐츠 끈 번호 지정 
		criteria.setCurrentblock(pagenum);	//현재 페이지 블록이 몇번인지 현재 페이지 번호 통해 지정
		criteria.setLastblock(criteria.getTotalcount());	//마지막 블록 번호를 전체 게시글 수를 통해 정함
		criteria.prevnext(pagenum);	//현재 페이지 번호로 화살표를 나타낼지 정함
		criteria.setStartPage(criteria.getCurrentblock());	//시작 페이지를 페이지 블록번호로 정함
		criteria.setEndPage(criteria.getLastblock(),criteria.getCurrentblock());	//마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록으로 정함
		
		ArrayList<TenderVO> tenderList=connectService.tenderMain(criteria.getStartnum(),criteria.getEndnum());
		
		for(int i=0;i<tenderList.size();i++) {
			String tender_code=tenderList.get(i).getTender_code();
			tenderList.get(i).setCompany_count(connectService.company_count(tender_code));
			int d_day=connectService.d_day(tender_code);
			
			//입찰 확인 여부
			int tenderCheck = connectService.tenderCheck(tender_code);
			
			if(tenderCheck == 0) {
				if(d_day < 0) {
					tenderList.get(i).setD_day("입찰 마감");
				} else if(d_day == 0) {
					tenderList.get(i).setD_day("D-day");
				} else {
					tenderList.get(i).setD_day("D-"+d_day);
				}
			} else {
				tenderList.get(i).setD_day("입찰 종료");
			}
		}
		
		model.addAttribute("tenderList", tenderList);
		model.addAttribute("criteria",criteria);
		
		return "connect/tenderMain";
	}
	
	// 입찰 서비스 - 페이징
	@RequestMapping(value="selectTender", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject selectTender(HttpServletRequest request) {
		String member_id=((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		
		Criteria criteria = new Criteria();
		String sort = request.getParameter("sort");
		int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		
		if(sort.equals("tTender")) {
			criteria.setTotalcount(connectService.tenderCount()); // 전체 게시글 개수를 지정
		} else {
			criteria.setTotalcount(connectService.selectCount(member_id)); // 내가 쓴 글 개수 지정
		}
		
		
		criteria.setPagenum(pagenum); // 현재 페이지를 페이지 객체에 지정
		criteria.setStartnum(pagenum); // 컨텐츠 시작 번호 지정
		criteria.setEndnum(pagenum); // 컨텐츠 끈 번호 지정
		criteria.setCurrentblock(pagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호 통해 지정
		criteria.setLastblock(criteria.getTotalcount()); // 마지막 블록 번호를 전체 게시글 수를 통해 정함
		criteria.prevnext(pagenum); // 현재 페이지 번호로 화살표를 나타낼지 정함
		criteria.setStartPage(criteria.getCurrentblock()); // 시작 페이지를 페이지 블록번호로 정함
		criteria.setEndPage(criteria.getLastblock(), criteria.getCurrentblock()); // 마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록으로 정함
		
		ArrayList<TenderVO> tenderList=connectService.selectTender(sort,member_id,criteria.getStartnum(),criteria.getEndnum());
		
		for(int i=0;i<tenderList.size();i++) {
			String tender_code=tenderList.get(i).getTender_code();
			tenderList.get(i).setCompany_count(connectService.company_count(tender_code));
			int d_day=connectService.d_day(tender_code);
			
			//입찰 확인 여부
			int tenderCheck = connectService.tenderCheck(tender_code);
			
			if(tenderCheck == 0) {
				if(d_day < 0) {
					tenderList.get(i).setD_day("입찰 마감");
				} else if(d_day == 0) {
					tenderList.get(i).setD_day("D-day");
				} else {
					tenderList.get(i).setD_day("D-"+d_day);
				}
			} else {
				tenderList.get(i).setD_day("입찰 종료");
			}
		}
		
		JSONArray jArr=JSONArray.fromObject(tenderList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tenderList",jArr);
		map.put("criteria",criteria);
		JSONObject json = JSONObject.fromObject(map);

		return json;
	} 
	
	// 입찰 서비스 - 입찰 공고 열람 권한 체크
	@RequestMapping(value="tMemberCheck", method=RequestMethod.POST)
	@ResponseBody
	public String tMembercheck(String tcode, HttpServletRequest request) {
		String member_id=((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		String tMember_id=connectService.tMemberCheck(tcode);
		String member_devision=connectService.member_devision(member_id);
		
		if(member_id.equals(tMember_id) || member_devision.equals("se") || member_devision.equals("ma")) {
			return "s";
		}else {
			return "f";
		}
	}
	
	// 입찰 서비스 - 메인페이지 멤버체크
	@RequestMapping(value="tCheck", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject tCheck(HttpServletRequest request) {
		String member_id=((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		String member_devision=connectService.member_devision(member_id);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("member_devision",member_devision);
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}

	// 입찰 서비스 - 리스트에서 글쓰기로 가기
	@RequestMapping(value = "tenderboardWrite", method = RequestMethod.POST)
	public String tenderWrite() {
		return "connect/tenderWrite";
	}

	// 입찰 서비스 - 글쓰기 작성 후 리스트로 가기
	@RequestMapping(value = "tenderWriteComplete", method = RequestMethod.POST)
	public String tenderList(TenderVO tenderVo, HttpServletRequest request) {
		tenderVo.setMember_id(((MemberVO) request.getSession().getAttribute("user")).getMember_id());
		
		// 코드 앞에 날짜 6자리
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		
		// 코드 뒤에 랜덤 4자리
		String random=String.format("%04d",(int)(Math.random()*10000));
		String tender_code = "td" + day + random;
		
		// VO에 생성한 코드 set하기
		tenderVo.setTender_code(tender_code);
		
		// insert에 영향을 받은 행의 갯수
		int s = connectService.addTenderboard(tenderVo);
		
		return "redirect: /tenderMain";
	}
	
	@RequestMapping(value = "tenderContent/{tender_code}", method = RequestMethod.GET)
	public String tenderContentGo(@PathVariable String tender_code, Model model) {
		model.addAttribute("tender_code",tender_code);
		return "connect/tenderContent";
	}
	
	// 입찰 서비스 - 리스트에서 입찰 세부 내용으로 가기
	@RequestMapping(value = "tenderContentGo/{tender_code}", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject tenderContent(@PathVariable String tender_code,BidVO bidVo, HttpServletRequest request) {
		String member_id=((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		int check=connectService.tenderBid(tender_code, member_id);
		String member_devision=connectService.member_devision(member_id);
		
		//입찰
		TenderVO tender = connectService.tenderContent(tender_code);
		//model.addAttribute("tenderContent", connectService.tenderContent(tender_code));
		
		//투찰 리스트
		ArrayList<BidVO> bidArr=connectService.bidContent(tender_code);
		
		// 기간 설정
		int period=connectService.calculate_period(tender_code);
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String period_day;
		if(period != 0) {
			cal.add(Calendar.MONTH, period);
			Date d = cal.getTime();
			period_day = dt.format(d);
		} else {
			period_day="0";
		}
		
		for(int i=0;i<bidArr.size();i++) {
			String company_code=bidArr.get(i).getCompany_code();
			bidArr.get(i).setMember_id(connectService.member_id(company_code)); //아이디 가져오기
			bidArr.get(i).setBidNum(connectService.bidNumber(company_code, period_day)); //특정 기간 건수
			bidArr.get(i).setCompany_name(connectService.company_name(company_code));
			
			int bidNum=bidArr.get(i).getBidNum(); //특정 기간 건수
			int bidTotalNum=connectService.bidTotalNum(company_code); //전체 기간 건수
			
			if(bidTotalNum != 0) { //전체 기간 건수가 0이 아닐경우
				bidArr.get(i).setNote("없음");
			}else {
				bidArr.get(i).setNote("신규회원");
			}
			
			if(bidNum != 0) { // 특정 기간 건수가 0이 아닐 경우
				bidArr.get(i).setStar_score_avg(connectService.star_score_avg(company_code, period_day)); //전체 기간 별점
			}else {
				bidArr.get(i).setStar_score_avg(0);
			}
			
			Resource resource = new FileSystemResource("/resources/uploadFile/ppt/"+bidArr.get(i).getBid_ppt_name());
			String resourceName = resource.getFilename(); //bid_ppt_name
			
			//System.out.println(resource);
			//System.out.println(resourceName);

			HttpHeaders headers = new HttpHeaders();
			try {
				headers.add("Content-Disposition","attachment; filename="+new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
				//System.out.println(headers);
			} catch(UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		// 투찰 점수 - 건수
		ArrayList<BidVO> numScoreArr=connectService.bidNumScore(tender_code, period_day);
		
		// 투찰 점수 - 별점
		ArrayList<BidVO> starScoreArr=connectService.bidStarScore(tender_code, period_day);
		
		// 투찰 점수 - 가격
		ArrayList<BidVO> priceScoreArr=connectService.bidPriceScore(tender_code);
		
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for(int i=0; i<bidArr.size(); i++) {
			String company_code=bidArr.get(i).getCompany_code();
			int pptScore=bidArr.get(i).getBid_ppt_score();
			map.put(company_code,pptScore);
		}
		
		for(int i=0; i<numScoreArr.size(); i++) {
			String company_code=numScoreArr.get(i).getCompany_code();
			int score=map.get(company_code);
			int numScore=numScoreArr.get(i).getBidNumScore();
			map.replace(company_code, score+numScore);
		}
		
		for(int i=0; i<starScoreArr.size(); i++) {
			String company_code=starScoreArr.get(i).getCompany_code();
			int starScore=starScoreArr.get(i).getBidStarScore();
			int score=map.get(company_code);
			map.replace(company_code,score+starScore);
		}
		
		for(int i=0; i<priceScoreArr.size(); i++) {
			String company_code=priceScoreArr.get(i).getCompany_code();
			int priceScore=priceScoreArr.get(i).getBidPriceScore();
			int score=map.get(company_code);
			map.replace(company_code,score+priceScore);
		}
		
		for(int i=0; i<bidArr.size(); i++) {
			String company_code=bidArr.get(i).getCompany_code();
			for(String key:map.keySet()) {
				if(company_code.equals(key)) {
					bidArr.get(i).setTotalScore(map.get(key));
				}
			}
		}
		
		//객체는 jsonArray에 넣지말고 map에 바로 넣기
		JSONArray bidJson = JSONArray.fromObject(bidArr);
		Map<String, Object> aMap = new HashMap<String, Object>();
		aMap.put("tenderVo", tender);
		aMap.put("bidArr", bidJson);
		aMap.put("check",check);
		aMap.put("member_devision",member_devision);
		aMap.put("member_id",member_id);
		
		JSONObject json = JSONObject.fromObject(aMap);
		//model.addAttribute("bidContent", bidArr);
		
		return json;
	}
	
	@GetMapping(value="/download", produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName, String upload_code, HttpServletRequest request){

		fileName=connectService.filename(upload_code);
		System.out.println(fileName);
		Resource resource = new FileSystemResource(request.getServletContext().getRealPath("/resources/uploadFile/ppt/")+fileName);
		
		if(resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		String resourceName = resource.getFilename();
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1);
		HttpHeaders headers = new HttpHeaders();
		
		try {
			String downloadName=null;
			
			if(userAgent.contains("Trident")) {
				downloadName=URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+"," ");
				
			}else if(userAgent.contains("Edge")) {
				downloadName=URLEncoder.encode(resourceOriginalName, "UTF-8");
			}else {
				downloadName=new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}
			
			headers.add("Content-Disposition","attachment; filename="+new String(resourceName.getBytes("UTF-8"),"ISO-8859-1").substring(36));
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	// 입찰 서비스 - 입찰 공고 삭제 후 리스트로 가기
	@RequestMapping(value = "tenderDelete/{tender_code}", method = RequestMethod.GET)
	public String tenderDelete(@PathVariable String tender_code, Model model) {
		
		ArrayList<BidVO> arr = connectService.findUploadCode(tender_code); // 투찰에 있던 파일 찾기
		ArrayList<String> uploadArr = new ArrayList<>();

		for (int i = 0; i < arr.size(); i++) {
			uploadArr.add(arr.get(i).getUpload_code());
		}
		if (!uploadArr.isEmpty()) {
			connectService.deleteBid(tender_code); // 투찰 업체 삭제

			uploadService.deleteBidUpload(uploadArr); // 투찰에 있던 파일 삭제
		}
		connectService.tenderDelete(tender_code); // 입찰 공고 삭제
		mypageService.reportUpdate(tender_code);	//신고 테이블 update
		
		return "redirect: /tenderMain";
	}

	// 입찰 서비스 - 입찰 공고 수정 페이지로 가기
	@RequestMapping(value = "tenderModify/{tender_code}", method = RequestMethod.GET)
	public String tenderModify(@PathVariable String tender_code, Model model) {
		model.addAttribute("tenderModify", connectService.tenderContent(tender_code));
		return "connect/tenderModify";
	}

	// 입찰 서비스- 입찰 공고 수정 완료
	@RequestMapping(value = "tenderModifyComplete", method = RequestMethod.POST)
	public String tenderModifyComplete(TenderVO tenderVo, Model model) {
		int s = connectService.tenderModify(tenderVo);
		String tender_code = tenderVo.getTender_code();
		return "redirect: /tenderContent/" + tender_code;
	}
	
	// 입찰 서비스 - ppt점수 부여
	@RequestMapping(value="bid_ppt_score", method=RequestMethod.POST)
	@ResponseBody
	public void bid_ppt_score(BidVO bidVo) {
		connectService.bid_ppt_score(bidVo);
	}
	
	// 입찰 서비스 - 입찰 신청
	@RequestMapping(value="tendering",method=RequestMethod.POST)
	@ResponseBody
	public void tendering(PaymentVO paymentVo, String tender_code, String company_code) {
		//주문 코드,결제 코드 생성
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		String random=String.format("%04d",(int)(Math.random()*10000));
		String payment_code="pm"+day+random;
		
		int bid_price = connectService.bid_price(tender_code, company_code);
		
		paymentVo.setPayment_code(payment_code);
		paymentVo.setPayment_price(bid_price);
		paymentVo.setTender_code(tender_code);
		
		connectService.tendering(paymentVo);
		connectService.win_bid_whether(tender_code, company_code);
	}
	
	// 입찰 서비스 - 투찰 작성 권한 체크(한 번만 등록 가능)
	@RequestMapping(value="BidPCheck/{tender_code}", method=RequestMethod.POST)
	@ResponseBody
	public String BidPrivilegeCheck(@PathVariable String tender_code, HttpServletRequest request) {
		ArrayList<BidVO> bidPCheck=connectService.bidPCheck(tender_code);
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		String company_code=connectService.company_code(member_id);
		
		for(int i=0;i<bidPCheck.size();i++) {
			if(bidPCheck.get(i).getCompany_code().equals(company_code)) {
				return "s";
			}
		}
		return "f";
	}

	// 입찰 서비스 - 투찰 작성
	@RequestMapping(value = "addBid/{tender_code}", method = RequestMethod.GET)
	@ResponseBody
	public Company_InfoVO addBid(@PathVariable String tender_code, Company_InfoVO c_info, HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		String member_name=connectService.member_name(member_id);
		c_info.setMember_name(member_name);
		
		c_info = connectService.company_info(member_id);
		
		// 기간 설정
		int period=connectService.calculate_period(tender_code);
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, period);
		Date d = cal.getTime();
		String period_day = dt.format(d);
		
		// 건수
		int bidNum = connectService.bidNumber(c_info.getCompany_code(),period_day);
		if (bidNum != 0) {
			c_info.setBidNum(bidNum);
			// 별점
			c_info.setStar_score_avg(connectService.star_score_avg(c_info.getCompany_code(),period_day));
			c_info.setNote("없음");
		}else {
			c_info.setBidNum(0);
			c_info.setStar_score_avg(0);
			c_info.setNote("신규회원");
		}

		return c_info;
	}
	
	// 입찰 서비스 - 투찰 작성 완료
	@PostMapping(value = "/addBidComplete/{tender_code}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void addBidComplete(@PathVariable String tender_code,MultipartFile[] uploadFile, String sBid_price, UploadVO uploadVo, BidVO bidVo , HttpServletRequest request, Model model) {
		// 기간 설정
		int period=connectService.calculate_period(tender_code);
				
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, period);
		Date d = cal.getTime();
		String period_day = dt.format(d);
		
		//insert bid
		String member_id=((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		bidVo.setCompany_code(connectService.company_code(member_id));
		bidVo.setBidNum(connectService.bidNumber(bidVo.getCompany_code(),period_day));
		int bidNum=bidVo.getBidNum();
		if(bidNum != 0) {
			bidVo.setStar_score_avg(connectService.star_score_avg(bidVo.getCompany_code(),period_day));
		}else {
			bidVo.setStar_score_avg(0);
		}
		
		//금액 int로 변환
		String s=request.getParameter("sBid_price"); 
		int bid_price=Integer.parseInt(s);
		bidVo.setBid_price(bid_price);
		 
		//업로드
		String uploadFolder=request.getServletContext().getRealPath("/resources/uploadFile/ppt/");
		System.out.println(uploadFolder);
		// make folder
		File uploadPath = new File(uploadFolder);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();// yyyy-MM-dd 폴더 생성
		}
		
		for(MultipartFile multipartFile : uploadFile) {
			//업로드 코드
			Date today = new Date();
			SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
			String day = date.format(today);
			String random=String.format("%04d",(int)(Math.random()*10000));
			String upload_code="ul"+day+random;
			uploadVo.setUpload_code(upload_code);
			bidVo.setUpload_code(upload_code);
			String uploadFileName = multipartFile.getOriginalFilename();
			uploadVo.setOriginal_name(uploadFileName);
			bidVo.setBid_ppt_name(uploadFileName);
			// IE has file path IE는 전체 파일 경로가 전송됨
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString()+uploadFileName;
			uploadVo.setFile_name(uploadFileName);
			
			connectService.bidUpload(uploadVo);
			connectService.addBid(bidVo);
			try {
				File saveFile = new File(uploadFolder, uploadFileName);
				
				multipartFile.transferTo(saveFile);
			} catch(Exception e) {
				 e.printStackTrace();
			} // end catch
		} // end for
	}
	
	// 입찰서비스 - 투찰 삭제 
	@RequestMapping(value="bidDelete", method=RequestMethod.POST)
	@ResponseBody
	public String bidDelete(BidVO bidVo ,String company_code, String tender_code, HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		// 로그인 한 사업자 번호
		String mCompany_code=connectService.company_code(member_id);
		
		if(company_code.equals(mCompany_code)) {
			// 삭제할 업로드 코드 가져옴
			String upload_code=connectService.bUpload_code(bidVo);
			
			connectService.bidDelete(bidVo);
			
			connectService.bidUploadDelete(upload_code);
			return "s";
		}else {
			return "f";
		}
	}
	
	// 입찰서비스 - 투찰 수정 
	@RequestMapping(value="bidModify", method=RequestMethod.POST)
	@ResponseBody
	public String bidModify(String tender_code, String company_code, HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		// 로그인 한 사업자 번호
		String mCompany_code=connectService.company_code(member_id);
		
		if(company_code.equals(mCompany_code)) {
			return "s";
		}else {
			return "f";
		}
		
	}
	
	@RequestMapping(value="member_devision/{tender_code}",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject member_devision(HttpServletRequest request, @PathVariable String tender_code) {
		Map<String,String> map = new HashMap<String, String>();
		
		int check = connectService.tenderCheck(tender_code);
		String tenderCheck=Integer.toString(check);
		String member_devision = ((MemberVO) request.getSession().getAttribute("user")).getMember_devision();
		
		map.put("member_devision",member_devision);
		map.put("tenderCheck",tenderCheck);
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	
	// 업체 분석/비교 도,시,평수 선택완료
	@RequestMapping(value = "selectCompare", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject selectCompare(Model model, HttpServletRequest request) {
		String sido = request.getParameter("sido");
		String sigoon = request.getParameter("sigoon");
		int space = Integer.parseInt(request.getParameter("space"));
		String sort = request.getParameter("sort");

		Criteria criteria = new Criteria();
		int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		if (sido.equals("광역시/도") && sigoon.equals("선택") && space == 0) {
			criteria.setTotalcount(productMapper.productCount()); // 전체 게시글 개수를 지정
		} else {
			criteria.setTotalcount(productMapper.selectCount(sido, sigoon, space)); // 전체 게시글 개수를 지정
		}
		criteria.setPagenum(pagenum); // 현재 페이지를 페이지 객체에 지정
		criteria.setStartnum(pagenum); // 컨텐츠 시작 번호 지정
		criteria.setEndnum(pagenum); // 컨텐츠 끈 번호 지정
		criteria.setCurrentblock(pagenum); // 현재 페이지 블록이 몇번인지 현재 페이지 번호 통해 지정
		criteria.setLastblock(criteria.getTotalcount()); // 마지막 블록 번호를 전체 게시글 수를 통해 정함
		criteria.prevnext(pagenum); // 현재 페이지 번호로 화살표를 나타낼지 정함
		criteria.setStartPage(criteria.getCurrentblock()); // 시작 페이지를 페이지 블록번호로 정함
		criteria.setEndPage(criteria.getLastblock(), criteria.getCurrentblock()); // 마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록으로 정함

		ArrayList<ProductVO> pList;
		if (sido.equals("광역시/도") && sigoon.equals("선택") && space == 0) {
			pList = connectService.productList(sort,criteria.getStartnum(), criteria.getEndnum());
		} else {
			pList = connectService.selectList(sido, sigoon, space, sort,criteria.getStartnum(), criteria.getEndnum());
		}
		JSONArray pJson = JSONArray.fromObject(pList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pList", pJson);
		map.put("criteria", criteria);
		JSONObject json = JSONObject.fromObject(map);

		return json;
	}

	// 분석/비교 서비스 - 리스트에서 서비스상품 세부 내용으로 가기
	@RequestMapping(value = "product", method = RequestMethod.GET)
	public String productDetail(@RequestParam("product_code") String product_code, Model model) {
		ProductVO productContent = connectService.productContent(product_code);
		ArrayList<ReplyVO> productReply = connectService.productReply(product_code);
		productContent.setReply_count(productReply.size());
		
		model.addAttribute("productContent", productContent);
		model.addAttribute("productReply" , productReply);

		return "connect/productContent";
	}
	
	// 분석/비교 서비스 - 광역시/도를 선택시 해당하는 시,구 목록출력
	@RequestMapping(value = "areasido", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject areasido(Model model, AreaVO areaVO) {
		ArrayList<AreaVO> aList = connectService.selectSigoon(areaVO);
		JSONArray aJson = JSONArray.fromObject(aList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aList", aJson);
		JSONObject json = JSONObject.fromObject(map);
		return json;
	}
	
	// 분석/비교 서비스 - 물질 목록 가져오기
	@RequestMapping(value = "matterList", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject matterList() {
		ArrayList<MatterVO> matterList = connectService.matterList();
		JSONArray mJson = JSONArray.fromObject(matterList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("matterList", mJson);
		JSONObject json = JSONObject.fromObject(map);
		return json;
	}
	
	// 분석/비교 서비스 - 결제창으로 이동
	@RequestMapping(value = "cPayment", method = RequestMethod.GET)
	public String cPayment(@RequestParam("product_code") String product_code, Model model) {
		model.addAttribute("productContent", connectService.productContent(product_code));
		
		return "connect/cPayment";
	}
	
	// 분석/비교 서비스 - 결제정보 insert
	@RequestMapping(value = "cOrder", method = RequestMethod.POST)
	@ResponseBody
	public String cOrder(Model model, HttpServletRequest request, DemandVO demandVO ,PaymentVO paymentVO) {
		//주문 코드,결제 코드 생성
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		String random=String.format("%04d",(int)(Math.random()*10000));
		String random1=String.format("%04d",(int)(Math.random()*10000));
		String demand_code="dm"+day+random;
		String payment_code="pm"+day+random1;
		String member_id=((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		
		demandVO.setDemand_code(demand_code);
		demandVO.setMember_id(member_id);
		paymentVO.setPayment_code(payment_code);
		paymentVO.setDemand_code(demand_code);
		
		connectService.pInsertDemand(demandVO);
		connectService.pInsertPayment(paymentVO);
		
		return demand_code;
	}
	
	// 분석/비교 서비스 - 상품 등록 페이지로 가기
	@RequestMapping(value = "productWrite", method = RequestMethod.GET)
	public String productWrite() {
		return "connect/productWrite";
	}
	
	// 분석/비교 서비스 - 작성글 수정,삭제 권한 체크
	@RequestMapping(value = "permissionCheck", method = RequestMethod.GET)
	@ResponseBody
	public String permissionCheck(HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		String product_code = request.getParameter("product_code");
		String writePerson = connectService.writePersonCheck(product_code);
		if(member_id.equals(writePerson)) {
			return "success";
		}else {
			return "fail";
		}
	}
		
	// 분석/비교 서비스 - 상품 등록 insert
	@RequestMapping(value = "productInsert", method = RequestMethod.POST)
	public String productInsert(Model model,HttpServletRequest request,MultipartFile[] thumbnail) {
		ProductVO productVO = new ProductVO();
		UploadVO uploadVO = new UploadVO();
			
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		String random=String.format("%04d",(int)(Math.random()*10000));
		String product_code="pd"+day+random;
		
		//상품정보 insert
		productVO.setProduct_code(product_code);
		productVO.setProduct_name(request.getParameter("product_name"));
		productVO.setProduct_detail(request.getParameter("product_detail"));
		productVO.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
		productVO.setP_space(Integer.parseInt(request.getParameter("p_space")));
		productVO.setMeasure_point(Integer.parseInt(request.getParameter("measure_point")));
		productVO.setCompany_code(connectService.company_code(((MemberVO) request.getSession().getAttribute("user")).getMember_id()));
		connectService.productInsert(productVO);
		
		//서비스 가능한 지역 insert
		String[] area_code = request.getParameterValues("area_code");
		for(int i=0; i<area_code.length; i++) {
			connectService.productAreaInsert(area_code[i],product_code);
		}
		
		//측정 가능한 물질 insert
		String[] matter_code = request.getParameterValues("matter_code");
		for(int i=0; i<matter_code.length; i++) {
			connectService.productMatterInsert(matter_code[i],product_code);
		}
			
		//이미지 정보 insert
		Document doc = Jsoup.parse(request.getParameter("product_detail"));
		Elements imageElement = doc.select("img");
		String image_name[] = new String[imageElement.size()];
		for(int i=0; i<imageElement.size(); i++) {
			random=String.format("%04d",(int)(Math.random()*10000));
			String upload_code = "ul"+day+random;
			image_name[i] = imageElement.get(i).attr("src");
			uploadVO.setUpload_code(upload_code);
			uploadVO.setOriginal_name(image_name[i].substring(image_name[i].lastIndexOf("/")+33));
			uploadVO.setFile_name(image_name[i].substring(image_name[i].lastIndexOf("/")+1));
			uploadVO.setProduct_code(product_code);
			connectService.productImageUpload(uploadVO);
		}
		
		//thumbnail정보 insert
		for(MultipartFile multipartFile : thumbnail) {
			random=String.format("%04d",(int)(Math.random()*10000));
			String uuid=UUID.randomUUID().toString().replace("-", "");
			
			if(multipartFile.isEmpty()) {
				
			}else {
				String upload_code = "ul"+day+random;
				String original_name = multipartFile.getOriginalFilename();
				String file_name = uuid+original_name;
				
				uploadVO.setUpload_code(upload_code);
				uploadVO.setOriginal_name(original_name);
				uploadVO.setFile_name(file_name);
				uploadVO.setProduct_code(product_code);
				connectService.productThumbnailUpload(uploadVO);
				
				//업로드
				String uploadFolder=request.getServletContext().getRealPath("/resources/uploadFile/images/");
				
				File uploadFold = new File(uploadFolder);
				if(!uploadFold.exists()) {
					uploadFold.mkdirs();
				}
				
				try {
					File saveFile = new File(uploadFolder, file_name);
					
					multipartFile.transferTo(saveFile);
				} catch(Exception e) {
					 e.printStackTrace();
				} // end catch
			}
		}
			
		return "redirect: /product?product_code=" + product_code;
	}
		
	// 분석/비교 서비스 - 상품 등록 update넘어가기
	@RequestMapping(value = "productModify", method = RequestMethod.GET)
	public String productModify(Model model,@RequestParam("product_code") String product_code) {
		model.addAttribute("productContent", connectService.productContent(product_code));
			
		return "connect/productModify";
	}
		
	// 분석/비교 서비스 - 상품 정보 update
	@RequestMapping(value = "productUpdate", method = RequestMethod.POST)
	public String productUpdate(Model model,HttpServletRequest request,@RequestParam("product_code") String product_code, MultipartFile[] thumbnail, String ori_thumbnail) {
		ProductVO productVO = new ProductVO();
		UploadVO uploadVO = new UploadVO();
				
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		
		//상품정보 update
		productVO.setProduct_code(product_code);
		productVO.setProduct_name(request.getParameter("product_name"));
		productVO.setProduct_detail(request.getParameter("product_detail"));
		productVO.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
		productVO.setP_space(Integer.parseInt(request.getParameter("p_space")));
		productVO.setMeasure_point(Integer.parseInt(request.getParameter("measure_point")));
		productVO.setCompany_code(connectService.company_code(((MemberVO) request.getSession().getAttribute("user")).getMember_id()));
		connectService.productUpdate(productVO);
		
		//서비스 가능한 지역 삭제후 insert
		connectService.productAreaDelete(product_code);
		String[] area_code = request.getParameterValues("area_code");
		for(int i=0; i<area_code.length; i++) {
			connectService.productAreaInsert(area_code[i],product_code);
		}	
		
		//측정 가능한 물질 삭제후 insert
		connectService.productMatterDelete(product_code);
		String[] matter_code = request.getParameterValues("matter_code");
		for(int i=0; i<matter_code.length; i++) {
			connectService.productMatterInsert(matter_code[i],product_code);
		}
		
		//상품 사진 삭제 후 insert
		connectService.productImageDelete(product_code);
		Document doc = Jsoup.parse(request.getParameter("product_detail"));
		Elements imageElement = doc.select("img");
		String image_name[] = new String[imageElement.size()];
		for(int i=0; i<imageElement.size(); i++) {
			String random=String.format("%04d",(int)(Math.random()*10000));
			String upload_code = "ul"+day+random;
			image_name[i] = imageElement.get(i).attr("src");
			uploadVO.setUpload_code(upload_code);
			uploadVO.setOriginal_name(image_name[i].substring(image_name[i].lastIndexOf("/")+33));
			uploadVO.setFile_name(image_name[i].substring(image_name[i].lastIndexOf("/")+1));
			uploadVO.setProduct_code(product_code);
			connectService.productImageUpload(uploadVO);
		}
		
		//thumbnail정보 insert
		for(MultipartFile multipartFile : thumbnail) {
			//첫번째 index는 무조건 나오기때문에 첫번째 index의 파일유무를 통하여 update작업 수행
			if(multipartFile.isEmpty()) {
				String random=String.format("%04d",(int)(Math.random()*10000));
				
				String upload_code = "ul"+day+random;
				String file_name = ori_thumbnail;
				String original_name = ori_thumbnail.substring(32);
				
				uploadVO.setUpload_code(upload_code);
				uploadVO.setOriginal_name(original_name);
				uploadVO.setFile_name(file_name);
				uploadVO.setProduct_code(product_code);
				connectService.productThumbnailUpload(uploadVO);
			}else {
				String random=String.format("%04d",(int)(Math.random()*10000));
				String uuid=UUID.randomUUID().toString().replace("-", "");
						
				String upload_code = "ul"+day+random;
				String original_name = multipartFile.getOriginalFilename();
				String file_name = uuid+original_name;
						
				uploadVO.setUpload_code(upload_code);
				uploadVO.setOriginal_name(original_name);
				uploadVO.setFile_name(file_name);
				uploadVO.setProduct_code(product_code);
				connectService.productThumbnailUpload(uploadVO);
						
				//업로드
				String uploadFolder=request.getServletContext().getRealPath("/resources/uploadFile/images/");
				
				File uploadFold = new File(uploadFolder);
				if(!uploadFold.exists()) {
					uploadFold.mkdirs();
				}
				
				try {
					File saveFile = new File(uploadFolder, file_name);
					
					multipartFile.transferTo(saveFile);
				} catch(Exception e) {
					e.printStackTrace();
				} // end catch
			}					
		}
		return "redirect: /product?product_code=" + product_code;
	}
		
	// 분석/비교 서비스 - 상품 정보 delete
	@RequestMapping(value = "productDelete", method = RequestMethod.GET)
	public String productDelete(@RequestParam("product_code") String product_code) {
		connectService.productAreaDelete(product_code);
		connectService.productMatterDelete(product_code);
		connectService.productImageDelete(product_code);
		connectService.productPaymentDelete(product_code);
		connectService.productDemandDelete(product_code);
		connectService.productReplyDelete(product_code);
		connectService.productDelete(product_code);
		mypageService.reportUpdate(product_code);
			
		return "redirect: /compareMain";
	}
	
	// 분석/비교 서비스 - 상품 댓글 insert
	@RequestMapping(value = "productReplyInsert", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject productReplyInsert(ReplyVO replyVO,HttpServletRequest request) {
		int count = connectService.checkPayment(replyVO.getMember_id(),replyVO.getProduct_code());
		if(count>0) {
			Date today = new Date();
			SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
			String day = date.format(today);
			String random=String.format("%04d",(int)(Math.random()*10000));
			String reply_code="rp"+day+random;
			replyVO.setReply_code(reply_code);
			connectService.insertPReply(replyVO);
			
			ArrayList<ReplyVO> productReply = connectService.productReply(replyVO.getProduct_code());
			JSONArray rJson = JSONArray.fromObject(productReply);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productReply", rJson);
			map.put("reply_count",productReply.size());
			map.put("result","success");
			map.put("member_id",((MemberVO) request.getSession().getAttribute("user")).getMember_id());
			JSONObject json = JSONObject.fromObject(map);
			return json;
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result","fail");
			JSONObject json = JSONObject.fromObject(map);
			return json;
		}
	}
	
	// 분석/비교 서비스 - 본인 댓글 삭제
	@RequestMapping(value = "productReplyDelete", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject productReplyDelete(ReplyVO replyVO,HttpServletRequest request) {
		connectService.deletePReply(replyVO.getReply_code());
		
		ArrayList<ReplyVO> productReply = connectService.productReply(replyVO.getProduct_code());
		JSONArray rJson = JSONArray.fromObject(productReply);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productReply", rJson);
		map.put("reply_count",productReply.size());
		map.put("member_id",((MemberVO) request.getSession().getAttribute("user")).getMember_id());
		JSONObject json = JSONObject.fromObject(map);
		return json;
	}
}