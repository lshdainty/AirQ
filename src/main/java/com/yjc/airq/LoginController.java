package com.yjc.airq;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
	@RequestMapping(value = "loginMain", method = RequestMethod.GET)
	public String loginMain(Model model) {
		return "login/loginMain";
	}
	
	//로그인 기능
	@RequestMapping(value="login", method = RequestMethod.POST)
	@ResponseBody
	public String loginMain(MemberVO member, HttpSession session, Model model,@RequestParam String id, @RequestParam String password) {
		MemberVO result = memberService.login(id);
		if(result!=null) {
			if(password.equals(result.getPassword())) {
			session.setAttribute("user",result);
			return "success";
			}
			else {
				return "failpw";
			}
		}
		else
		return "failid";
		
}
	// 아이디찾기 페이지
	@RequestMapping(value = "findId", method = RequestMethod.GET)
	public String findId(Model model) {
		return "login/findId";
	}
	
	// 아이디 찾기 작성후 확인 버튼 클릭
	@RequestMapping(value = "/findidajax", method = RequestMethod.POST) // value 값이 들어오면 method에 적혀있는 것을 불러주세요
	@ResponseBody
	public String findId(Model model, MemberVO LVOI,@RequestParam String name, @RequestParam String tel, @RequestParam String email) {
		MemberVO A = memberService.findId(LVOI);
		
		if(A != null) {
			if(name.equals(LVOI.getName()) && email.equals(LVOI.getEmail()) || tel.equals(LVOI.getTel())) {
				
				return A.getId();
			}
		 else {
            return "fail";
         }
      }
		return "fail";
		
	}
	
	// 비밀번호찾기 페이지
	@RequestMapping(value = "findPw", method = RequestMethod.GET)
	public String findPw(Model model) {
		return "login/findPw";
	}
	
	// 비밀번호 찾기 작성후 확인 버튼 클릭
	@RequestMapping(value = "/findpwajax", method = RequestMethod.POST) // value 값이 들어오면 method에 적혀있는 것을 불러주세요
	@ResponseBody
	public String findPw(Model model, MemberVO LVOP,@RequestParam String name, @RequestParam String tel, @RequestParam String email, @RequestParam String id) {

		MemberVO A = memberService.findPw(LVOP);
		if(A != null) {
			if((name.equals(LVOP.getName()) && id.equals(LVOP.getId())) && (email.equals(LVOP.getEmail()) || tel.equals(LVOP.getTel())))  {

				return A.getPassword();
			}
		 else {
            return "fail";
         }
      }
		return "fail";
		
	}
	
	//로그아웃
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
}
