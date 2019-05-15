package com.yjc.airq.app;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Map;

 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpSession;

 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.ResponseBody;

 import com.yjc.airq.domain.Company_InfoVO;
 import com.yjc.airq.domain.MemberVO;
 import com.yjc.airq.domain.PaymentVO;
 import com.yjc.airq.domain.PostVO;
 import com.yjc.airq.domain.ProductVO;
 import com.yjc.airq.domain.TenderVO;
 import com.yjc.airq.mapper.MemberMapper;
 import com.yjc.airq.mapper.PaymentMapper;
 import com.yjc.airq.mapper.PostMapper;
 import com.yjc.airq.mapper.ProductMapper;
 import com.yjc.airq.mapper.ReplyMapper;
 import com.yjc.airq.mapper.TenderMapper;
 import com.yjc.airq.service.ConnectService;
 import com.yjc.airq.service.LoginService;
 import com.yjc.airq.service.MypageService;

 import lombok.AllArgsConstructor;
 import net.sf.json.JSONObject;

 /**
  * mypage를 관리하는 controller
  */
 @Controller
 @AllArgsConstructor
 public class  MobileMypageController  {
 	private ConnectService connectService;
 	private LoginService memberService;
 	private MemberMapper memberMapper;
 	private ReplyMapper replyMapper;
 	private TenderMapper tenderMapper;
 	private ProductMapper productMapper;
 	private PostMapper postMapper;
 	private MypageService companyMapper;
 	private PaymentMapper paymentMapper;

 	// mypageMain 가기
 	@RequestMapping(value = "mypageMain", method = RequestMethod.GET)
 	public String mypageMain(Model model) {
 		return "mypage/mypageMain";
 	}

 	// mypageMainComment 가기
 	@RequestMapping(value = "mypageMainComment", method = RequestMethod.GET)
 	public String mypageMainComment(Model model) {
 		model.addAttribute("Reply", replyMapper.mypageReplys());
 		return "mypage/mypageMainComment";
 	}
 	
 	// mypageMainComment 댓글 삭제 버튼 클릭 이벤트
 	@RequestMapping(value = "/mypageMainComment/{reply_code}", method = RequestMethod.GET)
 	public String deleteComment(@PathVariable String reply_code) {
 		replyMapper.deleteComment(reply_code);
 		
 		return "redirect:/mypageMainComment";
 	}

 	// mypageMainMember 가기
 	@RequestMapping(value = "mypageMainMember", method = RequestMethod.GET)
 	public String mypageMainMember(Model model) {
 		model.addAttribute("getMemberList", memberService.getMemberList());
 		return "mypage/mypageMainMember";
 	}
 	
 	// mypageMainMember 회원 삭제 버튼 클릭 이벤트
 	@RequestMapping(value = "/mypageMainMember/{member_id}", method = RequestMethod.GET)
 	public String deleteMember(@PathVariable String member_id) {
 		memberMapper.deleteMember(member_id);
 		return "redirect:/mypageMainMember";
 	}


 	// mypageMainPosts 가기
 	@RequestMapping(value = "mypageMainPosts", method = RequestMethod.GET)
 	public String mypageMainPosts(Model model) {
 		model.addAttribute("tenderList", connectService.tenderList());
 		model.addAttribute("productMP", productMapper.productMP());
 		model.addAttribute("postMP", postMapper.postMP());
 		return "mypage/mypageMainPosts";
 	}
 	//mypageMainPosts 셀렉트 옵션에 따른 페이지 ajax변환
 	@RequestMapping(value ="mypageMainPostsAjax", method = RequestMethod.POST)
 	@ResponseBody
 	public String mypageMainPostsOption(Model model,@RequestParam String selected) {
 		ArrayList<TenderVO> tenderVO = connectService.tenderList();
 		ArrayList<ProductVO> productVO = productMapper.productMP();
 		ArrayList<PostVO> postVO = postMapper.postMP();
 		
 			 if(selected.equals("0")) {
 				 return "0";
 			 }
 			 if(selected.equals("1")) {
 				return "1";
 			 }		 
 			 if(selected.equals("2")){
 				 return "2";
 			 }
 			 if(selected.equals("3")) {
 				 return "3";
 			 }
 	return "";
 	
 		

 	}
 	// mypageMainPosts tender 글 삭제 버튼 클릭 이벤트
 	
 	@RequestMapping(value = "/mypageMainPosts/{tender_code}", method = RequestMethod.GET)
 	public String deletePosts(@PathVariable String tender_code) {
 		tenderMapper.deletePosts(tender_code);
 		return "redirect:/mypageMainPosts";
 	}
 	
 	// mypageMainPosts product 글 삭제 버튼 클릭 이벤트
 	@RequestMapping(value = "/mypageMainPostsProduct/{product_code}", method = RequestMethod.GET)
 	public String deletePostsProduct(@PathVariable String product_code) {
 		productMapper.deletePostsProduct(product_code);
 		return "redirect:/mypageMainPosts";
 	}
 	
 	// mypageMainPosts post 글 삭제 버튼 클릭 이벤트
 	@RequestMapping(value = "/mypageMainPostsPost/{post_code}", method = RequestMethod.GET)
 	public String deletePostsPost(@PathVariable String post_code) {
 		postMapper.deletePostsPost(post_code);
 		return "redirect:/mypageMainPosts";
 	}

 //////////////////////////////////일반 사용자//////////////////////////////////////////////////////////

 	// mypageNormal 가기
 	@RequestMapping(value = "mypageNormal", method = RequestMethod.GET)
 	public String mypageNormal(Model model) {
 		return "mypage/mypageNormal";
 	}

 	// mypageNormalPosts 가기
 	@RequestMapping(value = "mypageNormalPosts", method = RequestMethod.GET)
 	public String mypageNormalPosts(Model model) {
 		return "mypage/mypageNormalPosts";
 	}

 	// mypageNormalComment 가기
 	@RequestMapping(value = "mypageNormalComment", method = RequestMethod.GET)
 	public String mypageNormalComment(Model model) {
 		return "mypage/mypageNormalComment";
 	}

 	// mypageNormalPay 가기
 	@RequestMapping(value = "mypageNormalPay", method = RequestMethod.GET)
 	public String mypageNormalPay(Model model, PaymentVO paymentVO, HttpServletRequest request) {
 		String member_id = ((MemberVO)request.getSession().getAttribute("user")).getMember_id();
 		ArrayList<PaymentVO> mypay = paymentMapper.mypay(member_id);
 		ArrayList<PaymentVO> mypayNotNull = paymentMapper.mypayNotNull(member_id);
 		ArrayList<PaymentVO> mypayNull = paymentMapper.mypayNull(member_id);
 		model.addAttribute("mypayNull", mypayNull);
 		model.addAttribute("mypay", mypay);
 		model.addAttribute("mypayNotNull", mypayNotNull);
 		
 		return "mypage/mypageNormalPay";
 	}

 	//mypageNormalPay 셀렉트 옵션에 따른 페이지 ajax변환
 	@RequestMapping(value ="mypageNormalPayAjax", method = RequestMethod.POST)
 	@ResponseBody
 	public String mypageNormalPayOption(Model model,@RequestParam String selected, HttpServletRequest request) {
 		String member_id = ((MemberVO)request.getSession().getAttribute("user")).getMember_id();
 		ArrayList<PaymentVO> mypay = paymentMapper.mypay(member_id);
 		ArrayList<PaymentVO> mypayNotNull = paymentMapper.mypayNotNull(member_id);
 		ArrayList<PaymentVO> mypayNull = paymentMapper.mypayNull(member_id);
 		
 			 if(selected.equals("0")) {
 				 return "0";
 			 }
 			 if(selected.equals("1")) {
 				return "1";
 			 }		 
 			 if(selected.equals("2")){
 				 return "2";
 			 }
 			 if(selected.equals("3")) {
 				 return "3";
 			 }
 	return "";
 	}
 	
 	//mypageNormalPay 별점 추가 버튼에 따른 디비 값 업데이트
 	@ResponseBody
 	@RequestMapping(value ="/mypageNormalPayStarAjax", method = RequestMethod.POST)
 	public Object mypayStarUp(Model model, HttpServletRequest request,PaymentVO paymentVO) {
 		//,@RequestParam("btn1") String btn1
 		String btn1 = request.getParameter("btn1");
 		String btn2 = request.getParameter("btn2");
 		String code1 = request.getParameter("code1");
 		String code2 = request.getParameter("code2");
 		
// 		System.out.println(btn1);
// 		System.out.println(btn2);
// 		System.out.println(code1);
// 		System.out.println(code2);
 		
 		int sum1 = Integer.parseInt(btn1+btn2);
 		String sum2 = code1+code2;
 		
// 		System.out.println(sum1);
// 		System.out.println(sum2);
 		
 		if(sum1 >= 1 && sum1 <= 10) {
 			paymentVO.setStar_score(sum1);
 			paymentVO.setPayment_code(sum2);
 			paymentMapper.mypayStarUp(paymentVO);
 			return "1";
 		}else {
 			System.out.println("값 잘못 넣었음");
 			return "2";
 		}
 		
 	}
 	
 	// mypageNormalDelete 가기
 	@RequestMapping(value = "mypageNormalDelete", method = RequestMethod.GET)
 	public String mypageNormalDelete(Model model) {
 		return "mypage/mypageNormalDelete";
 	}

 ///////////////////////////////////판매자//////////////////////////////////////////////////////////

 	// mypageSeller 가기
 	@RequestMapping(value = "mypageSeller", method = RequestMethod.GET)
 	public String mypageSeller(Model model,HttpSession session, HttpServletRequest request,Company_InfoVO company_InfoVO){
 		String member_id = ((MemberVO)request.getSession().getAttribute("user")).getMember_id(); 
// 		System.out.println(member_id+"현재로그인정보");
 		ArrayList<Company_InfoVO> cList = companyMapper.c_code(member_id);
// 		System.out.println(cList);
 		model.addAttribute("cList",cList);
// 		String board_type = (String)request.getSession().getAttribute("board_type");
 		
 		return "mypage/mypageSeller";
 	}
 	//mypageSeller Json사용
 	@ResponseBody
 	@RequestMapping(value = "/mypageSeller",method =RequestMethod.POST)
 	public JSONObject cList(HttpServletRequest request){
 		String member_id = ((MemberVO)request.getSession().getAttribute("user")).getMember_id();
 		ArrayList<Company_InfoVO> list = companyMapper.c_code(member_id);
// 		System.out.println("dd"+list.get(1).getSum());
// 		System.out.println("ss"+list.get(1).getMonth());
// 		System.out.println(list.get(1));
// 		System.out.println(list);
 		Map<String, Object> map = new HashMap<String, Object>();
 		map.put("list", list);
 		JSONObject json = JSONObject.fromObject(map);
 		return json;
 		
 	}
 	// mypageSeller 가기
 	@RequestMapping(value = "mypageSellerPosts", method = RequestMethod.GET)
 	public String mypageSellerPosts(Model model) {
 		return "mypage/mypageSellerPosts";
 	}

 	// mypageSeller 가기
 	@RequestMapping(value = "mypageSellerComment", method = RequestMethod.GET)
 	public String mypageSellerComment(Model model) {
 		return "mypage/mypageSellerComment";
 	}

 	// mypageSeller 가기
 	@RequestMapping(value = "mypageSellerSales", method = RequestMethod.GET)
 	public String mypageSellerSales(Model model) {
 		return "mypage/mypageSellerSales";
 	}

 	// mypageSeller 가기
 	@RequestMapping(value = "mypageSellerDelete", method = RequestMethod.GET)
 	public String mypageSellerDelete(Model model) {
 		return "mypage/mypageSellerDelete";
 	}
 }