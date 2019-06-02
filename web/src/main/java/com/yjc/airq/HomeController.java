package com.yjc.airq;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.MeasureDataVO;
import com.yjc.airq.service.ManageService;

import lombok.AllArgsConstructor;

/**
 * home화면을 관리하는 controller
 */

@Controller
@AllArgsConstructor
public class HomeController {

	private ManageService manageService;

	// 홈 메인페이지로 가기
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}
	
	@RequestMapping(value = "/dustData", method = RequestMethod.POST, produces = {"application/json"})
	public @ResponseBody Map<String, Object> dustData(@RequestBody Map<String, Object> info, MeasureDataVO msd, HttpServletRequest request) {

		Map<String, Object> retVal = new HashMap<String, Object>();
		
		System.out.println("iotId: " + info.get("iotId"));
		System.out.println("dust_val: " + info.get("dust_val"));
		System.out.println("현재 시간(mtime): " + info.get("mtime"));
		System.out.println("========================================");

		// 현재 날짜 생성
		Date date = new Date();
//		String str = date.toString();
		SimpleDateFormat formatType = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("yyyy-MM-dd 형식의 현재 날짜: " + formatType.format(date));

		String iotId = info.get("iotId").toString(); // iot_id(기기명)
		String dust = info.get("dust_val").toString(); // 먼지 측정 값
		String mtime = info.get("mtime").toString(); // 먼지 측정 시간
		System.out.println("(String)mtime: " + mtime);
		// 날짜 + 시간
		String measureTime = formatType.format(date);
		measureTime += " ";
		measureTime += mtime;
		
		Map<String, Object> m = new HashMap<String, Object>();
		msd.setIot_id(iotId);
		msd.setMeasure_value(dust);

		System.out.println("iotId: " + iotId);
		System.out.println("dust: " + dust);
		System.out.println("measureTime: " + measureTime);

		m.put("msd", msd);
		m.put("time", (Object) measureTime);

		manageService.measureData(m);
		System.out.println("msd: " + msd);

		retVal.put("result", "success!!");
		System.out.println("retVal: " + retVal);
		
		return retVal;
	}

}