package com.yjc.airq.app;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.service.NotificationService;

import lombok.AllArgsConstructor;

/**
 * 커뮤니티 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class MobileNotificationController {

	private NotificationService notification;
	
	// Database에 Token이 있는지 확인
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.isTokenExist", method = RequestMethod.GET)
	public String isTokenExist(Model model, HttpServletRequest request) {
		System.out.println("isTokenExistController");
		String id = request.getParameter("id");
		System.out.println("ID : "+ id);
		String token = notification.getToken(id);
		
		System.out.println("TOKEN:"+token);
		
		if(token==null) {
			return "null";
		}
		else {
			return "exist";
		}
	}
	
	
	// Database에 Token과 접속한 device의 토큰이 일치하는지 확인
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.tokenCompare", method = RequestMethod.GET)
	public String compareToekn(Model model, HttpServletRequest request) {
		
		String token = request.getParameter("token");
		String member_id = request.getParameter("id");
		String dbToken = notification.getToken(member_id);
		
		System.out.println("DB TOKEN: " + dbToken);
		System.out.println("DEVICE TOKEN: "+token);
		if(token.equals(dbToken)) {
			return "equal";
		}
		else {
			return "different";
		}
						
	}
	
	
	
	// Database에 Token이 Update
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.tokenUpdate", method = RequestMethod.GET)
	public void tokenUpdate(Model model, HttpServletRequest request) {
		
		String token = request.getParameter("token");
		String member_id = request.getParameter("id");
		System.out.println("TOKEN UPDATE");
		System.out.println(token+"/"+member_id);
		
		notification.setToken(token,member_id);
		
	}

}
