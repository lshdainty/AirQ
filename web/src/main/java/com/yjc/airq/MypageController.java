package com.yjc.airq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
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
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.service.CommunityService;
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
public class MypageController {
	private ConnectService connectService;
	private LoginService memberService;
	private CommunityService communityService;
	private MypageService mypageService;

	// mypageMain 가기
	@RequestMapping(value = "mypageMain", method = RequestMethod.GET)
	public String mypageMain(Model model) {
		return "mypage/mypageMain";
	}

	// mypageMainComment 가기
	@RequestMapping(value = "mypageMainComment", method = RequestMethod.GET)
	public String mypageMainComment(Model model) {
		model.addAttribute("Reply", communityService.mypageReplys());
		return "mypage/mypageMainComment";
	}
	
	// mypageMainComment 댓글 삭제 버튼 클릭 이벤트
	@RequestMapping(value = "/mypageMainComment/{reply_code}", method = RequestMethod.GET)
	public String deleteComment(@PathVariable String reply_code) {
		mypageService.deleteComment(reply_code);
		
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
		mypageService.deleteMember(member_id);
		return "redirect:/mypageMainMember";
	}


	// mypageMainPosts 가기
	@RequestMapping(value = "mypageMainPosts", method = RequestMethod.GET)
	public String mypageMainPosts(Model model, ServletRequest request) {
		ArrayList<TenderVO> tenderList=connectService.tenderList();
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
		model.addAttribute("productMP", mypageService.productMP());
		model.addAttribute("postMP", mypageService.postMP());
//		System.out.println(mypageService.postMP());
//		System.out.println(tenderList);
//		System.out.println(mypageService.productMP());
		return "mypage/mypageMainPosts";
	}

	//mypageMainPosts 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value ="mypageMainPostsAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageMainPostsOption(Model model,@RequestParam String selected) {
		
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

	// mypageMainPosts tender 글 수정 버튼 클릭 이벤트
	
	@RequestMapping(value = "/tenderContentGo/${tenderList.tender_code}", method = RequestMethod.GET)
	public String deletePosts(@PathVariable String tender_code) {
		mypageService.deletePosts(tender_code);
		return "redirect:/tenderContentGo/${tenderList.tender_code }";
	}
	
	// mypageMainPosts product 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/product?product_code=${productMP.product_code }", method = RequestMethod.GET)
	public String deletePostsProduct(@PathVariable String product_code) {
		mypageService.deletePostsProduct(product_code);
		return "redirect:/product?product_code=${productMP.product_code }";
	}
	
	// mypageMainPosts post 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/postDetail?post_code=${postMP.post_code }", method = RequestMethod.GET)
	public String deletePostsPost(@PathVariable String post_code) {
		mypageService.deletePostsPost(post_code);
		return "redirect:/postDetail?post_code=${postMP.post_code }";
	}
	
//	// mypageMainPosts tender 글 삭제 버튼 클릭 이벤트
//	@RequestMapping(value = "/mypageMainPosts/{tender_code}", method = RequestMethod.GET)
//	public String deletePosts1(@PathVariable String tender_code) {
//		mypageService.deletePosts1(tender_code);
//		return "redirect:/mypageMainPosts";
//	}
//	
//	// mypageMainPosts product 글 삭제 버튼 클릭 이벤트
//	@RequestMapping(value = "/mypageMainPostsProduct/{product_code}", method = RequestMethod.GET)
//	public String deletePostsProduct1(@PathVariable String product_code) {
//		mypageService.deletePostsProduct1(product_code);
//		return "redirect:/mypageMainPosts";
//	}
//	
//	// mypageMainPosts post 글 삭제 버튼 클릭 이벤트
//	@RequestMapping(value = "/mypageMainPostsPost/{post_code}", method = RequestMethod.GET)
//	public String deletePostsPost1(@PathVariable String post_code) {
//		mypageService.deletePostsPost1(post_code);
//		return "redirect:/mypageMainPosts";
//	}

//////////////////////////////////일반 사용자//////////////////////////////////////////////////////////

	// mypageNormal 가기
	@RequestMapping(value = "mypageNormal", method = RequestMethod.GET)
	public String mypageNormal(Model model) {
		return "mypage/mypageNormal";
	}

	// mypageNormalPosts 가기
	@RequestMapping(value = "mypageNormalPosts", method = RequestMethod.GET)
	public String mypageNormalPosts(Model model, HttpServletRequest request) {
		String member_id = ((MemberVO)request.getSession().getAttribute("user")).getMember_id();
		
		ArrayList<TenderVO> tenderNMP=connectService.tenderNMP(member_id);
		for(int i=0;i<tenderNMP.size();i++) {
			String tender_code=tenderNMP.get(i).getTender_code();
			tenderNMP.get(i).setCompany_count(connectService.company_count(tender_code));
			int d_day=connectService.d_day(tender_code);
			
			//입찰 확인 여부
			int tenderCheck = connectService.tenderCheck(tender_code);
			
			if(tenderCheck == 0) {
				if(d_day < 0) {
					tenderNMP.get(i).setD_day("입찰 마감");
				} else if(d_day == 0) {
					tenderNMP.get(i).setD_day("D-day");
				} else {
					tenderNMP.get(i).setD_day("D-"+d_day);
				}
			} else {
				tenderNMP.get(i).setD_day("입찰 종료");
			}
		}
		model.addAttribute("tenderNMP", tenderNMP);
		model.addAttribute("postNMP", mypageService.postNMP(member_id));
		return "mypage/mypageNormalPosts";
	}
	
	//mypageNormalPosts 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value ="mypageNormalPostsAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageNormalPostsOption(Model model,@RequestParam String selected) {

		
			 if(selected.equals("0")) {
				 return "0";
			 }
			 if(selected.equals("1")) {
				return "1";
			 }
			 if(selected.equals("3")) {
				 return "3";
			 }
	return "";
	}
	// mypageMainPosts tender 글 수정 버튼 클릭 이벤트
	
	// mypageMainPosts tender 글 수정 버튼 클릭 이벤트
	
	@RequestMapping(value = "/tenderContentGo/${tenderNMP.tender_code}", method = RequestMethod.GET)
	public String deletePostsNormal(@PathVariable String tender_code) {
		mypageService.deletePosts(tender_code);
		return "redirect:/tenderContentGo/${tenderNMP.tender_code }";
	}
	
//	// mypageMainPosts post 글 수정 버튼 클릭 이벤트 ( 판매자 쪽에서 만들어져 있어서 필요x)
//	@RequestMapping(value = "/postDetail?post_code=${postNMP.post_code }", method = RequestMethod.GET)
//	public String deletePostsNormalPost(@PathVariable String post_code) {
//		mypageService.deletePostsPost(post_code);
//		return "redirect:/postDetail?post_code=${postNMP.post_code }";
//	}
//	// mypageNormalPosts tender 글 삭제 버튼 클릭 이벤트
//	
//	@RequestMapping(value = "/mypageNormalPosts/{tender_code}", method = RequestMethod.GET)
//	public String deleteNormalPosts(@PathVariable String tender_code) {
//		mypageService.deletePosts(tender_code);
//		return "redirect:/mypageNormalPosts";
//	}
//	
//	// mypageNormalPosts post 글 삭제 버튼 클릭 이벤트
//	@RequestMapping(value = "/mypageNormalPostsPost/{post_code}", method = RequestMethod.GET)
//	public String deleteNormalPostsPost(@PathVariable String post_code) {
//		mypageService.deletePostsPost(post_code);
//		return "redirect:/mypageNormalPosts";
//	}

	// mypageNormalComment 가기
	@RequestMapping(value = "mypageNormalComment", method = RequestMethod.GET)
	public String mypageNormalComment(Model model) {
		return "mypage/mypageNormalComment";
	}

	// mypageNormalPay 가기
	@RequestMapping(value = "mypageNormalPay", method = RequestMethod.GET)
	public String mypageNormalPay(Model model, PaymentVO paymentVO, HttpServletRequest request) {
		String member_id = ((MemberVO)request.getSession().getAttribute("user")).getMember_id();
		ArrayList<PaymentVO> mypay = mypageService.mypay(member_id);
		ArrayList<PaymentVO> mypayNotNull = mypageService.mypayNotNull(member_id);
		ArrayList<PaymentVO> mypayNull = mypageService.mypayNull(member_id);
		model.addAttribute("mypayNull", mypayNull);
		model.addAttribute("mypay", mypay);
		model.addAttribute("mypayNotNull", mypayNotNull);
		
		return "mypage/mypageNormalPay";
	}

	//mypageNormalPay 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value ="mypageNormalPayAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageNormalPayOption(Model model,@RequestParam String selected) {

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
		
//		System.out.println(btn1);
//		System.out.println(btn2);
//		System.out.println(code1);
//		System.out.println(code2);
		
		int sum1 = Integer.parseInt(btn1+btn2);
		String sum2 = code1+code2;
		
//		System.out.println(sum1);
//		System.out.println(sum2);
		
		if(sum1 >= 1 && sum1 <= 10) {
			paymentVO.setStar_score(sum1);
			paymentVO.setPayment_code(sum2);
			mypageService.mypayStarUp(paymentVO);
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
//		System.out.println(member_id+"현재로그인정보");
		ArrayList<Company_InfoVO> cList = mypageService.c_code(member_id);
//		System.out.println(cList);
		model.addAttribute("cList",cList);
//		String board_type = (String)request.getSession().getAttribute("board_type");
		
		return "mypage/mypageSeller";
	}
	//mypageSeller Json사용
	@ResponseBody
	@RequestMapping(value = "/mypageSeller",method =RequestMethod.POST)
	public JSONObject cList(HttpServletRequest request){
		String member_id = ((MemberVO)request.getSession().getAttribute("user")).getMember_id();
		ArrayList<Company_InfoVO> list = mypageService.c_code(member_id);
//		System.out.println("dd"+list.get(1).getSum());
//		System.out.println("ss"+list.get(1).getMonth());
//		System.out.println(list.get(1));
//		System.out.println(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		JSONObject json = JSONObject.fromObject(map);
		return json;
		
	}
	// mypageSeller 글관리 가기
	@RequestMapping(value = "mypageSellerPosts", method = RequestMethod.GET)
	public String mypageSellerPosts(Model model, HttpServletRequest request) {
		String member_id = ((MemberVO)request.getSession().getAttribute("user")).getMember_id();
		model.addAttribute("productSMP", mypageService.productSMP(member_id));
		model.addAttribute("postNMP", mypageService.postNMP(member_id));
		return "mypage/mypageSellerPosts";
	}
	
	//mypageMainPosts 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value ="mypageSellerPostsAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageSellerPostsOption(Model model,@RequestParam String selected, HttpServletRequest request) {

			 if(selected.equals("0")) {
				 return "0";
			 }
			 if(selected.equals("2")){
				 return "2";
			 }
			 if(selected.equals("3")) {
				 return "3";
			 }
	return "";
	}
	
//	// mypageSellerPosts product 글 삭제 버튼 클릭 이벤트
//	@RequestMapping(value = "/mypageSellerPostsProduct/{product_code}", method = RequestMethod.GET)
//	public String deleteSellrePostsProduct(@PathVariable String product_code) {
//		mypageService.deletePostsProduct(product_code);
//		return "redirect:/mypageSellerPosts";
//	}
//	
//	// mypageSellerPosts post 글 삭제 버튼 클릭 이벤트
//	@RequestMapping(value = "/mypageSellerPostsPost/{post_code}", method = RequestMethod.GET)
//	public String deleteSellerPostsPost(@PathVariable String post_code) {
//		mypageService.deletePostsPost(post_code);
//		return "redirect:/mypageSellerPosts";
//	}
	
	// mypageSellerPosts product 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/product?product_code=${productSMP.product_code }", method = RequestMethod.GET)
	public String deletePostsSellerProduct(@PathVariable String product_code) {
		mypageService.deletePostsProduct(product_code);
		return "redirect:/product?product_code=${productSMP.product_code }";
	}
	
	// mypageSellerPosts post 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/postDetail?post_code=${postNMP.post_code }", method = RequestMethod.GET)
	public String deletePostsSellerPost(@PathVariable String post_code) {
		mypageService.deletePostsPost(post_code);
		return "redirect:/postDetail?post_code=${postNMP.post_code }";
	}

	// mypageSeller 댓글관리 가기
	@RequestMapping(value = "mypageSellerComment", method = RequestMethod.GET)
	public String mypageSellerComment(Model model) {
		return "mypage/mypageSellerComment";
	}

	// mypageSeller 판매내역 가기
	@RequestMapping(value = "mypageSellerSales", method = RequestMethod.GET)
	public String mypageSellerSales(Model model) {
		return "mypage/mypageSellerSales";
	}

	// mypageSeller 회원탈퇴 가기
	@RequestMapping(value = "mypageSellerDelete", method = RequestMethod.GET)
	public String mypageSellerDelete(Model model) {
		return "mypage/mypageSellerDelete";
	}
}