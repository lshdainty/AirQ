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
import com.yjc.airq.mapper.MemberMapper;
import com.yjc.airq.mapper.ReplyMapper;
import com.yjc.airq.service.ConnectService;
import com.yjc.airq.service.MemberService;

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

	// mypageMainMember 가기
	@RequestMapping(value = "mypageMainMember", method = RequestMethod.GET)
	public String mypageMainMember(Model model) {
		model.addAttribute("getMemberList", memberService.getMemberList());
		return "mypage/mypageMainMember";
	}
	
	// mypageMainMember 회원 삭제 버튼 클릭 이벤트
	@RequestMapping(value = "/mypageMainMember/{member_id}", method = RequestMethod.GET)
	public String delete(@PathVariable String member_id) {
		memberMapper.delete(member_id);
		System.out.println(member_id);
		return "redirect:/mypageMainMember";
	}


	// mypageMainPosts 가기
	@RequestMapping(value = "mypageMainPosts", method = RequestMethod.GET)
	public String mypageMainPosts(Model model) {
		model.addAttribute("tenderList", connectService.tenderList());
		return "mypage/mypageMainPosts";
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
