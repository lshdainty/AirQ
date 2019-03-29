package com.yjc.airq;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.SellerVO;
import com.yjc.airq.service.JoinService;

import lombok.AllArgsConstructor;

/**
 * 회원가입을 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class JoinController {
	
	JoinService joinService;
	
	//회원가입 메인페이지로 가기
	@RequestMapping(value = "joinMain", method = RequestMethod.GET)
	public String joinMain(Model model) {
		return "join/joinMain";
	}
	
	// 일반 사용자 회원가입 이동
	@RequestMapping(value = "/nRegister", method = RequestMethod.GET)
	public String nRegister(Locale locale, Model model) {

		model.addAttribute("memberlist", joinService.memberList());

		return "join/nRegister";
	}

	// 판매자 회원가입 이동
	@RequestMapping(value = "/sRegister", method = RequestMethod.GET)
	public String sRegister(Locale locale, Model model) {

		model.addAttribute("sellerlist", joinService.memberList());

		return "join/sRegister";
	}

	// 회원 가입
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model, MemberVO mb) {

		System.out.println("회원가입 id: " + mb.getId());
		System.out.println("회원가입 pw: " + mb.getPassword());
		System.out.println("name: " + mb.getName());
		System.out.println("email: " + mb.getEmail());
		System.out.println("tel: " + mb.getTel());
		System.out.println("address: " + mb.getAddress());

		joinService.signup(mb);

		return "join/nRegister";
	}

	// (회원가입)사업자 등록번호 DB insert
	@RequestMapping(value = "/Bsignup", method = RequestMethod.GET)
	public String Bsignup(Model model, SellerVO sl) {

		System.out.println("사업자 등록 번호: " + sl.getBnumber());

		joinService.sellerList(sl);

		return "join/nRegister";
	}

	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public int postIdCheck(Model model, HttpServletRequest req) {

		String id = req.getParameter("id");
		System.out.println("(중복)회원가입 id: " + id);

		MemberVO idCheck = joinService.idCheck(id);

		int result = 0;

		if (idCheck != null) {
			result = 1;
		}

		return result;
	}

	// 버튼 테스트
	@RequestMapping(value = "/ButtonTest", method = RequestMethod.GET)
	public String ButtonTest(Locale locale, Model model) {

		return "ButtonTest";
	}
}
