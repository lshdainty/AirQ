package com.yjc.airq;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.service.MemberService;

import lombok.AllArgsConstructor;

/**
 * 로그인을 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class LoginController {
	MemberService memberService;
	
	//로그인 메인페이지로 가기
	@RequestMapping(value = "/loginMain", method = RequestMethod.GET)
	public String loginMain(Model model) {
		return "login/loginMain";
	}
	
	//로그인 기능
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(MemberVO member, HttpSession session, Model model) {
		MemberVO result = memberService.login(member.getId(),member.getPassword());
		if(result!=null) {
			System.out.println("성공은 했다");
			System.out.println(result);
			session.setAttribute("user",result);
			return "home";
		}else {
			System.out.println("실패를 했다");
			return "login/loginMain";
		}
	}
	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃 했다.");
		return "home";
	}
}
