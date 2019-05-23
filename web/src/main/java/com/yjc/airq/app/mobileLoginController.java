package com.yjc.airq.app;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.service.LoginService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONObject;

@Controller
@AllArgsConstructor
public class mobileLoginController {
	private LoginService memberService;
	
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.login", method = RequestMethod.GET)
	public JSONObject loginMain(MemberVO member, HttpSession session, Model model,@RequestParam String id, @RequestParam String password) {
		MemberVO result = memberService.login(id);
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject json;
		System.out.println("로그인");
		
		if(result!=null) {
			if(password.equals(result.getMember_pw())) {
				map.put("userInfo", result);
				map.put("result","success");
				json = JSONObject.fromObject(map);
			//session.setAttribute("devision", memberService.getDevision(id));
			return json;
			}
			else {
				map.put("result","passError");
				json = JSONObject.fromObject(map);
				return json;
			}
		}
		else {
			map.put("result","idError");
			json = JSONObject.fromObject(map);
			return json;
		}
	}
}
