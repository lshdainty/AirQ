package com.yjc.airq;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.ReplyVO;
import com.yjc.airq.domain.ReportVO;
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.service.ConnectService;
import com.yjc.airq.service.LoginService;
import com.yjc.airq.service.MypageService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * mypage를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class MypageController {
	private ConnectService connectService;
	private LoginService memberService;
	private MypageService mypageService;

	// mypageMain 가기
	@RequestMapping(value = "mypageMain", method = RequestMethod.GET)
	public String mypageMain(Model model) {
		model.addAttribute("postMPrec", mypageService.postMPrec());
		model.addAttribute("postMPimp", mypageService.postMPimp());
		model.addAttribute("postMPlib", mypageService.postMPlib());
		model.addAttribute("postMPhea", mypageService.postMPhea());
		model.addAttribute("postMPmet", mypageService.postMPmet());
		model.addAttribute("tenderMP", mypageService.tenderMP());
		model.addAttribute("productMP", mypageService.productMP());

		return "mypage/mypageMain";
	}

	// mypageMain tender 해당 글 가기 클릭 이벤트

	@RequestMapping(value = "/tenderContent/${tender_code}", method = RequestMethod.GET)
	public String goTender(@PathVariable String tender_code) {
		mypageService.deletePosts(tender_code);
		return "redirect:/tenderContent/${tender_code}";
	}

	// mypageMain product 해당 글 가기 클릭 이벤트
	@RequestMapping(value = "/product?product_code=${product_code}", method = RequestMethod.GET)
	public String goProduct(@PathVariable String product_code) {
		mypageService.deletePostsProduct(product_code);
		return "redirect:/product?product_code=${product_code}";
	}

	// mypageMain post 해당 글 가기 클릭 이벤트
	@RequestMapping(value = "/postDetail?post_code=${post_code}", method = RequestMethod.GET)
	public String goPost(@PathVariable String post_code) {
		mypageService.deletePostsPost(post_code);
		return "redirect:/postDetail?post_code=${post_code}";
	}

	// mypageMainComment 가기
	@RequestMapping(value = "mypageMainComment", method = RequestMethod.GET)
	public String mypageMainComment(Model model) {
		model.addAttribute("Reply", mypageService.mypageReplys());
		model.addAttribute("ReplyPost", mypageService.mypageReplysPost());
		model.addAttribute("ReplyProduct", mypageService.mypageReplysProduct());

		return "mypage/mypageMainComment";
	}

	// mypageMainComment 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value = "mypageMainCommentAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageMainCommentOption(Model model, @RequestParam String selected) {

		if (selected.equals("0")) {
			return "0";
		}
		if (selected.equals("1")) {
			return "1";
		}
		if (selected.equals("2")) {
			return "2";
		}
		if (selected.equals("3")) {
			return "3";
		}
		return "";
	}

	// mypageMainComment 댓글 삭제 버튼 클릭 이벤트
	@RequestMapping(value = "/mypageMainComment/{reply_code}", method = RequestMethod.GET)
	public String deleteComment(@PathVariable String reply_code) {
		mypageService.deleteComment(reply_code);

		return "redirect:/mypageMainComment";
	}

	// mypageMainComment product 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/product?product_code=${Reply.product_code }", method = RequestMethod.GET)
	public String ReplyProduct(@PathVariable String product_code) {
		mypageService.deletePostsProduct(product_code);
		return "redirect:/product?product_code=${Reply.product_code }";
	}

	// mypageMainComment post 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/postDetail?post_code=${Reply.post_code }", method = RequestMethod.GET)
	public String ReplyPost(@PathVariable String post_code) {
		mypageService.deletePostsPost(post_code);
		return "redirect:/postDetail?post_code=${Reply.post_code }";
	}

	// mypageMainComment product2 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/product?product_code=${ReplyProduct.product_code }", method = RequestMethod.GET)
	public String ReplyProduct2(@PathVariable String product_code) {
		mypageService.deletePostsProduct(product_code);
		return "redirect:/product?product_code=${ReplyProduct.product_code }";
	}

	// mypageMainComment post2 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/postDetail?post_code=${ReplyPost.post_code }", method = RequestMethod.GET)
	public String ReplyPost2(@PathVariable String post_code) {
		mypageService.deletePostsPost(post_code);
		return "redirect:/postDetail?post_code=${ReplyPost.post_code }";
	}

	// mypageMainMember 가기
	@RequestMapping(value = "mypageMainMember", method = RequestMethod.GET)
	public String mypageMainMember(Model model) {
		model.addAttribute("getMemberList", memberService.getMemberList());

		return "mypage/mypageMainMember";
	}

	// mypageMainMember 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value = "mypageMainMemberAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageMainMemberOption(Model model, @RequestParam String selected) {
		if (selected.equals("0")) {
			return "0";
		}
		if (selected.equals("1")) {
			return "no";
		}
		if (selected.equals("2")) {
			return "se";
		}
		return "";
	}

	// mypageMainPosts 가기
	@RequestMapping(value = "mypageMainPosts", method = RequestMethod.GET)
	public String mypageMainPosts(Model model, ServletRequest request) {
		ArrayList<ReportVO> mypageMainR = mypageService.mypageMainR();
		model.addAttribute("mypageMainR", mypageMainR);
		return "mypage/mypageMainPosts";
	}

	// mypageMainPostsIn - 리스트에서 글 세부 내용으로 가기
	@RequestMapping(value = "mypageMainPostsIn", method = RequestMethod.GET)
	public String mypageMainPostsIn(@RequestParam("report_code") String report_code, Model model) {
		model.addAttribute("mypageMainRIn", mypageService.mypageMainRIn(report_code));
		return "mypage/mypageMainPostsIn";
	}

	// mypageMainPosts 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value = "mypageMainPostsAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageMainPostsOption(Model model, @RequestParam String selected) {
		if (selected.equals("0")) {
			return "0";
		}
		if (selected.equals("1")) {
			return "pd";
		}
		if (selected.equals("2")) {
			return "ps";
		}
		if (selected.equals("3")) {
			return "td";
		}
		return "";
	}

//////////////////////////////////일반 사용자//////////////////////////////////////////////////////////

	// mypageNormal 가기
	@RequestMapping(value = "mypageNormal", method = RequestMethod.GET)
	public String mypageNormal(Model model) {
		return "mypage/mypageNormal";
	}

	@RequestMapping(value = "mypageNormalPage", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String mypageNormalPage(HttpServletRequest request, HttpServletResponse response) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();

		MemberVO memberInfo = mypageService.memberInfo(member_id);
		ArrayList<ProductVO> reviewCompareList = mypageService.reviewCompareList(member_id);
		ArrayList<Map<String, Object>> newPost = mypageService.normalNewPost(member_id);
		ArrayList<Map<String, Object>> newReply = mypageService.normalNewReply(member_id);
		ArrayList<Map<String, Object>> newPayment = mypageService.normalNewPayment(member_id);
		
		JSONArray reviewCompareArr = JSONArray.fromObject(reviewCompareList);
		JSONArray newPostArr = JSONArray.fromObject(newPost);
		JSONArray newReplyArr = JSONArray.fromObject(newReply);
		JSONArray newPaymentArr = JSONArray.fromObject(newPayment);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("memberInfo", memberInfo);
		map.put("reviewCompareList", reviewCompareArr);
		map.put("newPostList", newPostArr);
		map.put("newReplyList", newReplyArr);
		map.put("newPaymentList", newPaymentArr);

		JSONObject json = JSONObject.fromObject(map);

		String jsonString = json.toString();

		return jsonString;
	}

	// mypageNormalPosts 가기
	@RequestMapping(value = "mypageNormalPosts", method = RequestMethod.GET)
	public String mypageNormalPosts(Model model, HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();

		ArrayList<TenderVO> tenderNMP = mypageService.tenderNMP(member_id);
		for (int i = 0; i < tenderNMP.size(); i++) {
			String tender_code = tenderNMP.get(i).getTender_code();
			tenderNMP.get(i).setCompany_count(connectService.company_count(tender_code));
			int d_day = connectService.d_day(tender_code);

			// 입찰 확인 여부
			int tenderCheck = connectService.tenderCheck(tender_code);

			if (tenderCheck == 0) {
				if (d_day < 0) {
					tenderNMP.get(i).setD_day("입찰 마감");
				} else if (d_day == 0) {
					tenderNMP.get(i).setD_day("D-day");
				} else {
					tenderNMP.get(i).setD_day("D-" + d_day);
				}
			} else {
				tenderNMP.get(i).setD_day("입찰 종료");
			}
		}
		model.addAttribute("tenderNMP", tenderNMP);
		model.addAttribute("postNMP", mypageService.postNMP(member_id));
		return "mypage/mypageNormalPosts";
	}

	// mypageNormalPosts 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value = "mypageNormalPostsAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageNormalPostsOption(Model model, @RequestParam String selected) {

		if (selected.equals("0")) {
			return "0";
		}
		if (selected.equals("1")) {
			return "1";
		}
		if (selected.equals("3")) {
			return "3";
		}
		return "";
	}
	// mypageNormalPosts tender 글 상세 버튼 클릭 이벤트

	@RequestMapping(value = "/tenderContent/${tenderNMP.tender_code}", method = RequestMethod.GET)
	public String deletePostsNormal(@PathVariable String tender_code) {
		mypageService.deletePosts(tender_code);
		return "redirect:/tenderContent/${tenderNMP.tender_code }";
	}

	// mypageNormalComment 가기
	@RequestMapping(value = "mypageNormalComment", method = RequestMethod.GET)
	public String mypageNormalComment(Model model, HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		model.addAttribute("ReplyN", mypageService.mypageReplysNS(member_id));
		model.addAttribute("ReplyNPost", mypageService.mypageReplysNSPost(member_id));
		model.addAttribute("ReplyNProduct", mypageService.mypageReplysNSProduct(member_id));
		return "mypage/mypageNormalComment";
	}

	// mypageNormalComment 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value = "mypageNormalCommentAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageNormalCommentOption(Model model, @RequestParam String selected) {

		if (selected.equals("0")) {
			return "0";
		}
		if (selected.equals("1")) {
			return "1";
		}
		if (selected.equals("2")) {
			return "2";
		}
		if (selected.equals("3")) {
			return "3";
		}
		return "";
	}

	// mypageNormalComment 댓글 삭제 버튼 클릭 이벤트
	@RequestMapping(value = "/mypageNormalComment/{reply_code}", method = RequestMethod.GET)
	public String deleteNormalComment(@PathVariable String reply_code) {
		mypageService.deleteComment(reply_code);

		return "redirect:/mypageNormalComment";
	}

	// mypageNormalComment product 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/product?product_code=${ReplyN.product_code }", method = RequestMethod.GET)
	public String ReplyNProduct(@PathVariable String product_code) {
		mypageService.deletePostsProduct(product_code);
		return "redirect:/product?product_code=${ReplyN.product_code }";
	}

	// mypageNormalComment post 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/postDetail?post_code=${ReplyN.post_code }", method = RequestMethod.GET)
	public String ReplyNPost(@PathVariable String post_code) {
		mypageService.deletePostsPost(post_code);
		return "redirect:/postDetail?post_code=${ReplyN.post_code }";
	}

	// mypageNormalComment product2 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/product?product_code=${ReplyNProduct.product_code }", method = RequestMethod.GET)
	public String ReplyNProduct2(@PathVariable String product_code) {
		mypageService.deletePostsProduct(product_code);
		return "redirect:/product?product_code=${ReplyNProduct.product_code }";
	}

	// mypageNormalComment post2 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/postDetail?post_code=${ReplyNPost.post_code }", method = RequestMethod.GET)
	public String ReplyNPost2(@PathVariable String post_code) {
		mypageService.deletePostsPost(post_code);
		return "redirect:/postDetail?post_code=${ReplyNPost.post_code }";
	}

	// mypageNormalPay 가기
	@RequestMapping(value = "mypageNormalPay", method = RequestMethod.GET)
	public String mypageNormalPay(Model model, PaymentVO paymentVO, HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		ArrayList<PaymentVO> mypay = mypageService.mypay(member_id);
		ArrayList<PaymentVO> mypayNotNull = mypageService.mypayNotNull(member_id);
		ArrayList<PaymentVO> mypayNull = mypageService.mypayNull(member_id);
		ArrayList<PaymentVO> mypayT = mypageService.mypayT(member_id);
		ArrayList<PaymentVO> mypayNotNullT = mypageService.mypayNotNullT(member_id);
		ArrayList<PaymentVO> mypayNullT = mypageService.mypayNullT(member_id);
		model.addAttribute("mypayNull", mypayNull);
		model.addAttribute("mypay", mypay);
		model.addAttribute("mypayNotNull", mypayNotNull);
		model.addAttribute("mypayNullT", mypayNullT);
		model.addAttribute("mypayT", mypayT);
		model.addAttribute("mypayNotNullT", mypayNotNullT);
		return "mypage/mypageNormalPay";
	}

	// mypageNormalPay 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value = "mypageNormalPayAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageNormalPayOption(Model model, @RequestParam String selected) {

		if (selected.equals("0")) {
			return "0";
		}
		if (selected.equals("1")) {
			return "1";
		}
		if (selected.equals("2")) {
			return "2";
		}
		if (selected.equals("3")) {
			return "3";
		}
		return "";
	}

	// mypageNormalPay 별점 추가 버튼에 따른 디비 값 업데이트
	@ResponseBody
	@RequestMapping(value = "/mypageNormalPayStarAjax", method = RequestMethod.POST)
	public Object mypayStarUp(Model model, HttpServletRequest request, PaymentVO paymentVO) {
		// ,@RequestParam("btn1") String btn1
		String btn1 = request.getParameter("btn1");
		String btn2 = request.getParameter("btn2");
		String code1 = request.getParameter("code1");
		String code2 = request.getParameter("code2");

		int sum1 = Integer.parseInt(btn1 + btn2);
		String sum2 = code1 + code2;

		if (sum1 >= 1 && sum1 <= 10) {
			paymentVO.setStar_score(sum1);
			paymentVO.setPayment_code(sum2);
			mypageService.mypayStarUp(paymentVO);
			return "1";
		} else {
			System.out.println("값 잘못 넣었음");
			return "2";
		}

	}

	// mypageNormalDelete 가기
	@RequestMapping(value = "mypageNormalDelete", method = RequestMethod.GET)
	public String mypageNormalDelete(Model model) {
		return "mypage/mypageNormalDelete";
	}

	// mypageNormalDelete
	@RequestMapping(value = "A", method = RequestMethod.GET)
	public String deleteNormalB(Model model, HttpServletRequest request, @RequestParam String pw, HttpSession session) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		String member_pw = ((MemberVO) request.getSession().getAttribute("user")).getMember_pw();
		model.addAttribute("member_id", member_id);
		model.addAttribute("member_pw", member_pw);
		if (member_pw.equals(pw)) {
			mypageService.deleteSelf(member_id, member_pw);
			System.out.println("성공");
			session.invalidate();
			return "home";
		} else {
			System.out.println("잘못됨");
			return "mypage/mypageNormalDelete";
		}
	}
///////////////////////////////////판매자//////////////////////////////////////////////////////////

	// mypageSeller 가기
	@RequestMapping(value = "mypageSeller", method = RequestMethod.GET)
	public String mypageSeller(HttpServletRequest request,Model model) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		ArrayList<Map<String,Object>> reservation=mypageService.getReservation(connectService.company_code(member_id));
		ArrayList<Map<String,Object>> hotItems=mypageService.getHotItems(connectService.company_code(member_id));
		model.addAttribute("reservation",reservation);
		model.addAttribute("hotItems",hotItems);

		return "mypage/mypageSeller";
	}
	
	//예약자 모니터링 페이지
	@RequestMapping(value="reservation", method=RequestMethod.GET)
	public String reservation(HttpServletRequest request, Model model) {
		String memberId=request.getParameter("member_id");
		model.addAttribute("memberId",memberId);
		
		return "mypage/reservation";
	}
	
	@RequestMapping(value="mReservation", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject mReservation(String member_id) {
		ArrayList<Map<String,Object>> reservation=mypageService.reservation(member_id);
		
		JSONArray rArr=JSONArray.fromObject(reservation);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("reservation", rArr);
		JSONObject json=JSONObject.fromObject(map);
		System.out.println(json);
		
		return json;
	}
	
	

	// mypageSeller 글관리 가기
	@RequestMapping(value = "mypageSellerPosts", method = RequestMethod.GET)
	public String mypageSellerPosts(Model model, HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		model.addAttribute("productSMP", mypageService.productSMP(member_id));
		model.addAttribute("postNMP", mypageService.postNMP(member_id));
		System.out.println(mypageService.productSMP(member_id));
		return "mypage/mypageSellerPosts";
	}

	// mypageMainPosts 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value = "mypageSellerPostsAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageSellerPostsOption(Model model, @RequestParam String selected, HttpServletRequest request) {

		if (selected.equals("0")) {
			return "0";
		}
		if (selected.equals("2")) {
			return "2";
		}
		if (selected.equals("3")) {
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

	// mypageSellerPosts product 글 상세 버튼 클릭 이벤트
	@RequestMapping(value = "/product?product_code=${productSMP.product_code }", method = RequestMethod.GET)
	public String deletePostsSellerProduct(@PathVariable String product_code) {
		mypageService.deletePostsProduct(product_code);
		return "redirect:/product?product_code=${productSMP.product_code }";
	}

	// mypageSellerPosts post 글 상세 버튼 클릭 이벤트
	@RequestMapping(value = "/postDetail?post_code=${postNMP.post_code }", method = RequestMethod.GET)
	public String deletePostsSellerPost(@PathVariable String post_code) {
		mypageService.deletePostsPost(post_code);
		return "redirect:/postDetail?post_code=${postNMP.post_code }";
	}

	// mypageSeller 댓글관리 가기
	@RequestMapping(value = "mypageSellerComment", method = RequestMethod.GET)
	public String mypageSellerComment(Model model, HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		model.addAttribute("ReplyS", mypageService.mypageReplysNS(member_id));
		model.addAttribute("ReplySPost", mypageService.mypageReplysNSPost(member_id));
		model.addAttribute("ReplySProduct", mypageService.mypageReplysNSProduct(member_id));

		return "mypage/mypageSellerComment";
	}

	// mypageSellerComment 셀렉트 옵션에 따른 페이지 ajax변환
	@RequestMapping(value = "mypageSellerCommentAjax", method = RequestMethod.POST)
	@ResponseBody
	public String mypageSellerCommentOption(Model model, @RequestParam String selected) {

		if (selected.equals("0")) {
			return "0";
		}
		if (selected.equals("1")) {
			return "1";
		}
		if (selected.equals("2")) {
			return "2";
		}
		if (selected.equals("3")) {
			return "3";
		}
		return "";
	}

	// mypageSellerComment 댓글 삭제 버튼 클릭 이벤트
	@RequestMapping(value = "/mypageSellerComment/{reply_code}", method = RequestMethod.GET)
	public String deleteSellerComment(@PathVariable String reply_code) {
		mypageService.deleteComment(reply_code);
		return "redirect:/mypageSellerComment";
	}

	// mypageSellerComment product 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/product?product_code=${ReplyS.product_code }", method = RequestMethod.GET)
	public String ReplySProduct(@PathVariable String product_code) {
		mypageService.deletePostsProduct(product_code);
		return "redirect:/product?product_code=${ReplyS.product_code }";
	}

	// mypageSellerComment post 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/postDetail?post_code=${ReplyS.post_code }", method = RequestMethod.GET)
	public String ReplySPost(@PathVariable String post_code) {
		mypageService.deletePostsPost(post_code);
		return "redirect:/postDetail?post_code=${ReplyS.post_code }";
	}

	// mypageSellerComment product2 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/product?product_code=${ReplySProduct.product_code }", method = RequestMethod.GET)
	public String ReplySProduct2(@PathVariable String product_code) {
		mypageService.deletePostsProduct(product_code);
		return "redirect:/product?product_code=${ReplySProduct.product_code }";
	}

	// mypageSellerComment post2 글 수정 버튼 클릭 이벤트
	@RequestMapping(value = "/postDetail?post_code=${ReplySPost.post_code }", method = RequestMethod.GET)
	public String ReplySPost2(@PathVariable String post_code) {
		mypageService.deletePostsPost(post_code);
		return "redirect:/postDetail?post_code=${ReplySPost.post_code }";
	}

	// mypageSeller 판매내역 가기
	@RequestMapping(value = "mypageSellerSales", method = RequestMethod.GET)
	public String mypageSellerSales(Model model, HttpSession session, HttpServletRequest request,
			Company_InfoVO company_InfoVO) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
//		System.out.println(member_id+"현재로그인정보");
		ArrayList<Company_InfoVO> cList = mypageService.c_code(member_id);
		System.out.println(cList);
		model.addAttribute("cList", cList);
//		String board_type = (String)request.getSession().getAttribute("board_type");

		return "mypage/mypageSellerSales";
	}

	// mypageSeller Json사용
	@ResponseBody
	@RequestMapping(value = "/mypageSellerSales", method = RequestMethod.POST)
	public JSONArray cList(HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		ArrayList<Company_InfoVO> list = mypageService.c_code(member_id);
//		System.out.println("dd"+list.get(1).getSum());
//		System.out.println("ss"+list.get(1).getMonth());
//		System.out.println(list.get(1));
//		System.out.println(list);
		JSONArray jArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject json = new JSONObject();
			json.put("sum", list.get(i).getSum());
			json.put("month", list.get(i).getMonth());
			jArray.add(json);
		}
		System.out.println(jArray);

		return jArray;
	}

	// mypageSeller 회원탈퇴 가기
	@RequestMapping(value = "mypageSellerDelete", method = RequestMethod.GET)
	public String mypageSellerDelete(Model model) {
		return "mypage/mypageSellerDelete";
	}

	// mypageSellerDelete
	@RequestMapping(value = "B", method = RequestMethod.GET)
	public String deleteSellerB(Model model, HttpServletRequest request, @RequestParam String pw, HttpSession session) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		String member_pw = ((MemberVO) request.getSession().getAttribute("user")).getMember_pw();
		model.addAttribute("member_id", member_id);
		model.addAttribute("member_pw", member_pw);
		if (member_pw.equals(pw)) {
			mypageService.deleteSelf(member_id, member_pw);
			System.out.println("성공");
			session.invalidate();
			return "home";
		} else {
			System.out.println("잘못됨");
			return "mypage/mypageSellerDelete";
		}
	}

///////////////////////////////////////////////신고하기////////////////////////////////////////////////////////
	// 분석비교/입찰/게시글 - 기존에 신고한 내용이 있는지 확인
	@RequestMapping(value = "checkReport", method = RequestMethod.GET)
	@ResponseBody
	public String checkReport(Model model, HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		String original_code = request.getParameter("original_code");
		String result = mypageService.checkReport(member_id, original_code);

		if (result == null) {
			return "success";
		} else {
			return "fail";
		}
	}

	// 분석비교/입찰/게시글 - 신고창으로 이동
	@RequestMapping(value = "report", method = RequestMethod.GET)
	public String report(Model model, HttpServletRequest request) {
		String original_code = request.getParameter("original_code");
		model.addAttribute("original_code", original_code);

		return "report";
	}

	// 분석비교/입찰/게시글 - 신고작성
	@RequestMapping(value = "insertReport", method = RequestMethod.POST)
	@ResponseBody
	public String insertReport(Model model, HttpServletRequest request) {
		ReportVO reportVO = new ReportVO();

		// 코드생성
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		String random = String.format("%04d", (int) (Math.random() * 10000));

		// 데이터 받아오기
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		String report_code = "rt" + day + random;
		String report_title = request.getParameter("report_title");
		String report_content = request.getParameter("report_content");
		String original_code = request.getParameter("original_code");

		reportVO.setReport_code(report_code);
		reportVO.setReport_title(report_title);
		reportVO.setReport_content(report_content);
		reportVO.setReport_classification(original_code.substring(0, 2));
		reportVO.setOriginal_code(original_code);
		reportVO.setMember_id(member_id);

		mypageService.insertReport(reportVO);

		return "success";
	}

	// 리뷰 페이지
	@RequestMapping(value = "reviewList", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String reviewList(HttpServletRequest request, HttpServletResponse response) {

		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		ArrayList<ProductVO> reviewCompareList = mypageService.reviewCompareList(member_id);
		ArrayList<TenderVO> reviewTenderList = mypageService.reviewTenderList(member_id);

		JSONArray reviewCompareArr = JSONArray.fromObject(reviewCompareList);
		JSONArray reviewTenderArr = JSONArray.fromObject(reviewTenderList);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reviewCompareList", reviewCompareArr);
		map.put("reviewTenderList", reviewTenderArr);
		JSONObject json = JSONObject.fromObject(map);
		String jsonString = json.toString();

		return jsonString;
	}

	@RequestMapping(value = "reviewWrite", method = RequestMethod.GET)
	public String reviewWrite(HttpServletRequest request, Model model) {
		String code = request.getParameter("code");

		model.addAttribute("code", code);
		return "mypage/mypageNormalReview";
	}

	@RequestMapping(value = "reviewWriteComplete", method = RequestMethod.POST)
	@ResponseBody
	public void reviewWriteComplete(ReplyVO replyVo,String code, String reviewContent, int reviewStar, HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
//		String devision = code.substring(0, 2);
		
		// 댓글 코드 생성
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		String random=String.format("%04d",(int)(Math.random()*10000));
		String reply_code="rp"+day+random;
		
		replyVo.setReply_code(reply_code);
		replyVo.setReply_content(reviewContent);
		replyVo.setMember_id(member_id);
		replyVo.setPayment_code(code);
		mypageService.starScoreupdate(reviewStar, code);
		mypageService.reviewInsert(replyVo);
		
//		if (devision.equals("dm")) {
//			replyVo.setProduct_code(mypageService.dProduct_code(code, member_id));
//			mypageService.pStarScoreupdate(reviewStar, code);
//			mypageService.pReviewInsert(replyVo);
//		}else {
//			//String company_code=mypageService.tBidCompayCode(code);
//			replyVo.setTender_code(code);
//			mypageService.tStarScoreupdate(reviewStar, code);
//			mypageService.tReviewInsert(replyVo);
//		}
//		System.out.println(replyVo);
	}
	@ResponseBody
	@RequestMapping(value = "reservationInfo", method = RequestMethod.GET ,produces = "application/text; charset=utf8")
	public String getReservation(HttpServletRequest request, Model model) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		ArrayList<Map<String,Object>> reservation=mypageService.getReservation(connectService.company_code(member_id));
		System.out.println(reservation);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reservation", reservation);
		JSONObject json = JSONObject.fromObject(map);
		String jsonString = json.toString();
		return jsonString;
	}
}