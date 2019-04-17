package com.yjc.airq;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.ManageVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.service.ManageService;
import com.yjc.airq.service.LoginService;

import lombok.AllArgsConstructor;

/**
 * 공기질 관리 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class ManageController {
	
	private LoginService memberService;
	private ManageService manageService;

	// 공기질 모니터링 메인페이지로 가기
	@RequestMapping(value = "monitoringMain", method = RequestMethod.GET)
	public String monitoringMain(Model model) {
		return "manage/monitoringMain";
	}

	// IoT 원격제어 메인페이지로 가기
	@RequestMapping(value = "remoteMain", method = RequestMethod.GET)
	public String remoteMain(Model model) {
		return "manage/remoteMain";
	}

	// IoT 원격제어 제품 등록 페이지로 가기
	@RequestMapping(value = "remoteRegist", method = RequestMethod.GET)
	public String remoteRegist(Model model) {
		return "manage/remoteRegist";
	}
	
	// 원격제어 등록하기
	@RequestMapping(value = "remoteReg", method = RequestMethod.GET)
	public String remoteReg(Model model, ManageVO rg) {
		
		System.out.println(rg.getRemote());
		System.out.println(rg.getLocation());
		
		
		return "manage/remoteRegist";
	}
	
	// JSON 연습 Map 방식
	@ResponseBody
	@RequestMapping(value = "/abcd", method = RequestMethod.GET)
	public Map<String, Object> getJsonByMap(MemberVO mb){
		Map<String, Object> jsonObject =  new HashMap<String, Object>();
		Map<String, Object> jsonSubObject = null;
		ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();

		
		// 1번째 데이터
		jsonSubObject = new HashMap<String, Object>();
		jsonSubObject.put("idsx", mb.getMember_id());
		jsonSubObject.put("title", "제목1입니다.");
		jsonSubObject.put("create_date", new Date());
		jsonList.add(jsonSubObject);

		
		jsonObject.put("success", true);
		jsonObject.put("total_count", 10);
		jsonObject.put("result_list", jsonList);
		
		System.out.println(jsonObject);
		
		return jsonObject;
	}
}
