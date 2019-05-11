package com.yjc.airq;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.IotInfoVO;
import com.yjc.airq.domain.IotVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.service.ManageService;

import lombok.AllArgsConstructor;

/**
 * 공기질 관리 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class ManageController {
	
	private ManageService manageService;

	// 공기질 모니터링 메인페이지로 가기
	@RequestMapping(value = "monitoringMain", method = RequestMethod.GET)
	public String monitoringMain(Model model) {
		return "manage/monitoringMain";
	}

	// IoT 원격제어 메인페이지로 가기
	@RequestMapping(value = "remoteMain", method = RequestMethod.GET)
	public String remoteMain(Model model, IotInfoVO iif, HttpServletRequest request, HttpSession session) {
		String member_id = ((MemberVO)request.getSession().getAttribute("user")).getMember_id();
		System.out.println("로그인 ID: " + member_id);
		
		ArrayList<IotInfoVO> myIot = manageService.iotMain(member_id);
		System.out.println("myIot: " + myIot);
		model.addAttribute("myIot", myIot);
		session.setAttribute("myIot", myIot);
		
		return "manage/remoteMain";
	}

	// IoT 원격제어 제품 등록 페이지로 가기
	@RequestMapping(value = "remoteRegist", method = RequestMethod.GET)
	public String remoteRegist(Model model) {
		return "manage/remoteRegist";
	}

	// 원격제어 등록하기
	@ResponseBody
	@RequestMapping(value = "remoteReg", method = RequestMethod.GET)
	public String remoteReg(Model model, IotVO i) {

		System.out.println("i.getRemote(): " + i.getRemote());
		System.out.println("i.getLocation(): " + i.getLocation());
		
		
		
//		if(rg.getRemote().equals("보일러")) {
//			return "boiler";
//		}else if(rg.getRemote().equals("창문")) {
//			return "window";
//		}else if(rg.getRemote().equals("공기청정기")) {
//			return "airclean";
//		}else if(rg.getRemote().equals("환풍기")) {
//			return "ventilator";
//		}
		
		return "manage/remoteRegist";
	}

	// JSON 연습 Map 방식
//	@ResponseBody
//	@RequestMapping(value = "/abcd", method = RequestMethod.GET)
//	public Map<String, Object> getJsonByMap(MemberVO mb){
//		Map<String, Object> jsonObject =  new HashMap<String, Object>();
//		Map<String, Object> jsonSubObject = null;
//		ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
//
//		
//		// 1번째 데이터
//		jsonSubObject = new HashMap<String, Object>();
//		jsonSubObject.put("idsx", mb.getMember_id());
//		jsonSubObject.put("title", "제목1입니다.");
//		jsonSubObject.put("create_date", new Date());
//		jsonList.add(jsonSubObject);
//
//		
//		jsonObject.put("success", true);
//		jsonObject.put("total_count", 10);
//		jsonObject.put("result_list", jsonList);
//		
//		System.out.println(jsonObject);
//		
//		return jsonObject;
//	}
}
