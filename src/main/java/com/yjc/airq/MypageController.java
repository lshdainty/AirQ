package com.yjc.airq;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderVO;
import com.yjc.airq.mapper.MemberMapper;
import com.yjc.airq.mapper.PostMapper;
import com.yjc.airq.mapper.ProductMapper;
import com.yjc.airq.mapper.ReplyMapper;
import com.yjc.airq.mapper.TenderMapper;
import com.yjc.airq.service.ConnectService;
import com.yjc.airq.service.MemberService;
import com.yjc.airq.service.PostService;

import lombok.AllArgsConstructor;

/**
 * mypage를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class MypageController {
	private ConnectService connectService;
	private MemberService memberService;
	private MemberMapper memberMapper;
	private ReplyMapper replyMapper;
	private TenderMapper tenderMapper;
	private ProductMapper productMapper;
	private PostMapper postMapper;

	// mypageMain 가기
	@RequestMapping(value = "mypageMain", method = RequestMethod.GET)
	public String mypageMain(Model model) {
		return "mypage/mypageMain";
	}

	// mypageMainCategory 가기
	@RequestMapping(value = "mypageMainCategory", method = RequestMethod.GET)
	public String mypageMainCategory(Model model) {
		return "mypage/mypageMainCategory";
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
		System.out.println(tenderVO);
		System.out.println(productVO);
		System.out.println(postVO);
		System.out.println(selected+"머넘어옴?");
//		System.out.println(selectB+"머넘어옴?22");
		
			 if(selected.equals("0")) {
				 System.out.println("0번 선택됨");
				 return "0";
			 }
			 if(selected.equals("1")) {
				 System.out.println("1번선택됨");
				return "1";
			 }		 
			 if(selected.equals("2")){
				 System.out.println("2번선택됨");
				 return "2";
			 }
			 if(selected.equals("3")) {
				 System.out.println("3번 선택됨");
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
	public String mypageNormalPay(Model model) {
		return "mypage/mypageNormalPay";
	}

	// mypageNormalDelete 가기
	@RequestMapping(value = "mypageNormalDelete", method = RequestMethod.GET)
	public String mypageNormalDelete(Model model) {
		return "mypage/mypageNormalDelete";
	}

///////////////////////////////////판매자//////////////////////////////////////////////////////////

	// mypageSeller 가기
	@RequestMapping(value = "mypageSeller", method = RequestMethod.GET)
	public String mypageSeller(Model model) {
		return "mypage/mypageSeller";
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
