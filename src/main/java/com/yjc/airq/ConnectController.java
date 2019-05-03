package com.yjc.airq;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yjc.airq.domain.AreaVO;
import com.yjc.airq.domain.BidVO;
import com.yjc.airq.domain.Company_InfoVO;
import com.yjc.airq.domain.Criteria;
import com.yjc.airq.domain.DemandVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PaymentVO;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.domain.UploadVO;
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
		
		ArrayList<ProductVO> pList = connectService.productList(sort,criteria.getStartnum(),criteria.getEndnum());
		model.addAttribute("pList",pList);
		model.addAttribute("criteria",criteria);

		return "connect/compareMain";
	}

	// 입찰 서비스 메인페이지로 가기
	@RequestMapping(value = "tenderMain", method = RequestMethod.GET)
	public String tenderMain(Model model, TenderVO tenderVo) {
		ArrayList<TenderVO> tenderList=connectService.tenderList();
		for(int i=0;i<tenderList.size();i++) {
			String tender_code=tenderList.get(i).getTender_code();
			tenderList.get(i).setCompany_count(connectService.company_count(tender_code));
			int d_day=connectService.d_day(tender_code);
			
			if(d_day < 0) {
				tenderList.get(i).setD_day("입찰 종료");
			} else if(d_day == 0) {
				tenderList.get(i).setD_day("D-day");
			} else {
				tenderList.get(i).setD_day("D-"+d_day);
			}
			
		}
		model.addAttribute("tenderList", tenderList);

		return "connect/tenderMain";
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

	// 입찰 서비스 - 리스트에서 입찰 세부 내용으로 가기
	@RequestMapping(value = "tenderContent/{tender_code}", method = RequestMethod.GET)
	public String tenderContent(@PathVariable String tender_code,BidVO bidVo, Model model, HttpServletRequest request) {
		//입찰
		model.addAttribute("tenderContent", connectService.tenderContent(tender_code));
		
		//투찰
		ArrayList<BidVO> bidArr=connectService.bidContent(tender_code);
		
		for(int i=0;i<bidArr.size();i++) {
			String company_code=bidArr.get(i).getCompany_code();
			bidArr.get(i).setMember_id(connectService.member_id(company_code));
			bidArr.get(i).setBidNum(connectService.bidNumber(company_code));
			bidArr.get(i).setCompany_name(connectService.company_name(company_code));
			
			int bidNum=bidArr.get(i).getBidNum();
			if(bidNum != 0) {
				bidArr.get(i).setStar_score_avg(connectService.star_score_avg(company_code));
				bidArr.get(i).setNote("없음");
			}else {
				bidArr.get(i).setStar_score_avg(0);
				bidArr.get(i).setNote("신규회원");
			}
			//System.out.println(bidArr.get(i));
			
			
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
		
		model.addAttribute("bidContent", bidArr);
		
		return "connect/tenderContent";
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
		int s = connectService.tenderDelete(tender_code); // 입찰 공고 삭제

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
	@RequestMapping(value = "addBid", method = RequestMethod.GET)
	@ResponseBody
	public Company_InfoVO addBid(Company_InfoVO c_info, HttpServletRequest request, Model model) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		String member_name=connectService.member_name(member_id);
		c_info.setMember_name(member_name);
		
		c_info = connectService.company_info(member_id);

		// 건수
		int bidNum = connectService.bidNumber(c_info.getCompany_code());
		if (bidNum != 0) {
			c_info.setBidNum(bidNum);
			// 별점
			c_info.setStar_score_avg(connectService.star_score_avg(c_info.getCompany_code()));
			c_info.setNote("없음");
		}else {
			c_info.setBidNum(0);
			c_info.setStar_score_avg(0);
			c_info.setNote("신규회원");
		}
		return c_info;
	}
	
	// 입찰 서비스 - 투찰 작성 완료
	@PostMapping(value = "/addBidComplete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public void addBidComplete(MultipartFile[] uploadFile, String sBid_price, UploadVO uploadVo, BidVO bidVo , HttpServletRequest request, Model model) {
		
		//insert bid
		String member_id=((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		bidVo.setCompany_code(connectService.company_code(member_id));
		bidVo.setBidNum(connectService.bidNumber(bidVo.getCompany_code()));
		int bidNum=bidVo.getBidNum();
		if(bidNum != 0) {
			bidVo.setStar_score_avg(connectService.star_score_avg(bidVo.getCompany_code()));
		}else {
			bidVo.setStar_score_avg(0);
		}
		
		//금액 int로 변환
		String s=request.getParameter("sBid_price"); 
		int bid_price=Integer.parseInt(s);
		bidVo.setBid_price(bid_price);
		 
		//업로드
		String uploadFolder=request.getServletContext().getRealPath("/resources/uploadFile/ppt/");
		
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
	
	/* 투찰 삭제 */
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
	
	/* 투찰 수정 */
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
	
	@RequestMapping(value="member_devision",method=RequestMethod.POST)
	@ResponseBody
	public String member_devision(HttpServletRequest request) {
		String member_devision = ((MemberVO) request.getSession().getAttribute("user")).getMember_devision();
		
		return member_devision;
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
	@RequestMapping(value = "product/{product_code}", method = RequestMethod.GET)
	public String productDetail(@PathVariable String product_code, Model model) {
		model.addAttribute("productContent", connectService.productContent(product_code));

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
	
	// 분석/비교 서비스 - 결제창으로 이동
	@RequestMapping(value = "cPayment/{product_code}", method = RequestMethod.GET)
	public String cPayment(@PathVariable String product_code, Model model) {
		model.addAttribute("productContent", connectService.productContent(product_code));
		
		return "connect/cPayment";
	}
	
	// 분석/비교 서비스 - 결제정보 insert
	@RequestMapping(value = "cOrder", method = RequestMethod.POST)
	@ResponseBody
	public String cOrder(Model model, HttpServletRequest request, DemandVO demandVO, PaymentVO paymentVO) {
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
	
	// 분석/비교 서비스 - 상품 등록 insert
	@RequestMapping(value = "productInsert", method = RequestMethod.GET)
	public String productInsert(Model model,HttpServletRequest request) {
			
		String product_title = request.getParameter("product_title");
		String payment_price = request.getParameter("payment_price");
		String p_space = request.getParameter("p_space");
		String measure_point = request.getParameter("measure_point");
		String product_content = request.getParameter("product_content");
		String[] area_code = request.getParameterValues("area_code");
		System.out.println("title : "+product_title);
		System.out.println("price : "+payment_price);
		System.out.println("space : "+p_space);
		System.out.println("point : "+measure_point);
		System.out.println("content : "+product_content);
		System.out.println("area_code : "+area_code);
		Document doc = Jsoup.parse(product_content);
		Elements imageElement;
		imageElement = doc.select("img : ");
		System.out.println("element : "+imageElement);
		// 포스트 코드 생성
//		Date today = new Date();
//		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
//		String day = date.format(today);
//		Timestamp current_date = new Timestamp(System.currentTimeMillis());
//		String random=String.format("%04d",(int)(Math.random()*10000));
		return "";
	}
}