package com.yjc.airq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.IotInfoVO;
import com.yjc.airq.domain.MeasureDataVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.service.ManageService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 공기질 관리 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class ManageController {

	private ManageService manageService;

	// 내부 모니터링 메인페이지로 가기
	@RequestMapping(value = "monitoringIn", method = RequestMethod.GET)
	public String monitoringIn(Model model) {
		return "manage/monitoringIn";
	}

	// 외부 모니터링 메인페이지로 가기
	@RequestMapping(value = "monitoringOut", method = RequestMethod.GET)
	public String monitoringOut(Model model) {
		return "manage/monitoringOut";
	}
	
	// 라이브 차트 테스트페이지 가기
	@RequestMapping(value = "chartData", method = RequestMethod.GET)
	public String chartData(Model model) {
		return "manage/chartData";
	}
	// 각 시/도 미세먼지 수치 가져오기 지도부분 코드 
//	@RequestMapping(value = "dustData", method = RequestMethod.GET)
//	@ResponseBody
//	public JSONObject dustData(Model model, HttpServletRequest request) {
//		BufferedReader br = null;
//		// String sidoName[] = {"서울", "부산", "대구", "인천", "광주", "대전", "울산", "경기", "강원", "충북", "충남", "전북", "전남", "경북", "경남", "제주", "세종"};
//		String sidoName1[] = { "대구" };
//		JSONObject json = new JSONObject();
//		JSONArray dustDataArray = new JSONArray();
//		JSONArray areaDataArray = new JSONArray();
//		JSONArray resultArray = new JSONArray();
//		try {
//			// 미세먼지 목록 가져오기
//			for (int i = 0; i < sidoName1.length; i++) {
//				String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?"
//						+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
//						+ "&numOfRows=999&sidoName=" + URLEncoder.encode(sidoName1[i], "UTF-8")
//						+ "&ver=1.3&_returnType=json";
//				URL url = new URL(urlstr);
//				HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
//				urlconnection.setRequestMethod("GET");
//				br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
//				String result = "";
//				String line = "";
//				while ((line = br.readLine()) != null) {
//					result = result + line + "\n";
//					JSONObject jsonObj = JSONObject.fromObject(result);
//					JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
//					for (int j = 0; j < jsonArr.size(); j++) {
//						dustDataArray.add(jsonArr.get(j));
//					}
//				}
//				br.close();
//				urlconnection.disconnect();
//			}
//
//			// 미세먼지 측정소 목록 가져오기
//			for (int i = 0; i < sidoName1.length; i++) {
//				String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/MsrstnInfoInqireSvc/getMsrstnList?"
//						+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
//						+ "&numOfRows=999&addr=" + URLEncoder.encode(sidoName1[i], "UTF-8") + "&_returnType=json";
//				URL url = new URL(urlstr);
//				HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
//				urlconnection.setRequestMethod("GET");
//				br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
//				String result = "";
//				String line = "";
//				while ((line = br.readLine()) != null) {
//					result = result + line + "\n";
//					JSONObject jsonObj = JSONObject.fromObject(result);
//					JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
//					for (int j = 0; j < jsonArr.size(); j++) {
//						areaDataArray.add(jsonArr.get(j));
//					}
//				}
//				br.close();
//				urlconnection.disconnect();
//			}
//
//			// 미세먼지수치,측정소 좌표값 합치기
//			for (int i = 0; i < dustDataArray.size(); i++) {
//				JSONObject dustJSON = dustDataArray.getJSONObject(i);
//				for (int j = 0; j < areaDataArray.size(); j++) {
//					JSONObject areaJSON = areaDataArray.getJSONObject(j);
//					if (dustJSON.getString("stationName").equals(areaJSON.getString("stationName"))) {
//						JSONObject jsonObj = new JSONObject();
//						jsonObj.put("stationName", dustJSON.getString("stationName"));
//						jsonObj.put("dataTime", dustJSON.getString("dataTime"));
//						jsonObj.put("mangName", dustJSON.getString("mangName"));
//						jsonObj.put("addr", areaJSON.getString("addr"));
//						jsonObj.put("x", areaJSON.getString("dmX"));
//						jsonObj.put("y", areaJSON.getString("dmY"));
//						jsonObj.put("pm10Value", dustJSON.getString("pm10Value"));
//						jsonObj.put("pm10Grade1h", dustJSON.getString("pm10Grade1h"));
//						jsonObj.put("pm10Value24", dustJSON.getString("pm10Value24"));
//						jsonObj.put("pm10Grade", dustJSON.getString("pm10Grade"));
//						jsonObj.put("pm25Value", dustJSON.getString("pm25Value"));
//						jsonObj.put("pm25Grade1h", dustJSON.getString("pm25Grade1h"));
//						jsonObj.put("pm25Value24", dustJSON.getString("pm25Value24"));
//						jsonObj.put("pm25Grade", dustJSON.getString("pm25Grade"));
//						jsonObj.put("coValue", dustJSON.getString("coValue"));
//						jsonObj.put("coGrade", dustJSON.getString("coGrade"));
//						jsonObj.put("so2Value", dustJSON.getString("so2Value"));
//						jsonObj.put("so2Grade", dustJSON.getString("so2Grade"));
//						jsonObj.put("o3Value", dustJSON.getString("o3Value"));
//						jsonObj.put("o3Grade", dustJSON.getString("o3Grade"));
//						jsonObj.put("no2Value", dustJSON.getString("no2Value"));
//						jsonObj.put("no2Grade", dustJSON.getString("no2Grade"));
//						jsonObj.put("khaiValue", dustJSON.getString("khaiValue"));
//						jsonObj.put("khaiGrade", dustJSON.getString("khaiGrade"));
//						resultArray.add(jsonObj);
//					}
//				}
//			}
//
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("result", resultArray);
//			json = JSONObject.fromObject(map);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		return json;
//	}
	
	// 외부 모니터링 차트 데이터 가져오기
	@RequestMapping(value = "outsideChart", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject outSideChart(Model model, HttpServletRequest request) {
		String area = request.getParameter("area");
		String matter = request.getParameter("matter");
		
		BufferedReader br = null;
		JSONObject outsideChartJson = new JSONObject();
		JSONArray jArray = new JSONArray();
		
		try {
			//측정소에서 측정한 측정 데이터 가져오기
	        String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?"
	        			+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
	        			+ "&numOfRows=999&stationName="+URLEncoder.encode(area,"UTF-8")+"&dataTerm=DAILY&ver=1.0&_returnType=json";
	        URL url = new URL(urlstr);
	        HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
	        urlconnection.setRequestMethod("GET");
	        br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
	        String result = "";
	        String line = "";
	        while((line = br.readLine()) != null) {
	        	result = result + line + "\n";
	        	JSONObject jsonObj = JSONObject.fromObject(result);
                JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
                for(int i=jsonArr.size()-1; i>=0; i--) {
                	JSONObject resultJson = (JSONObject)jsonArr.get(i);
                	JSONObject dataJson = new JSONObject();
                	dataJson.put("dataTime",resultJson.getString("dataTime"));
                	dataJson.put("data",resultJson.getString(matter));
                	jArray.add(dataJson);
                }
	        }
	        br.close();
        	urlconnection.disconnect();
        	
        	Map<String, Object> map = new HashMap<String, Object>();
    		map.put("result",jArray);
    		outsideChartJson = JSONObject.fromObject(map);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return outsideChartJson;
	}
	
	// 외부 모니터링 테이블 데이터 가져오기
	@RequestMapping(value = "outsideTable", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject outSideTable(Model model, HttpServletRequest request) {
		String area = request.getParameter("area");
		
		//각 물질마다의 분류기준값
		String matter[] = {"pm10","pm25","no2","o3","co","so2"};
		float standardSheet[] = null;
		float pm10Value[] = {151,101,76,51,41,31,16,0};
		float pm25Value[] = {76,51,38,26,21,16,9,0};
		float no2Value[] = {(float)1.1,(float)0.2,(float)0.13,(float)0.06,(float)0.05,(float)0.03,(float)0.02,0};
		float o3Value[] = {(float)0.38,(float)0.15,(float)0.12,(float)0.09,(float)0.06,(float)0.03,(float)0.02,0};
		float coValue[] = {32,15,12,9,(float)5.5,2,1,0};
		float so2Value[] = {(float)0.6,(float)0.15,(float)0.1,(float)0.05,(float)0.04,(float)0.02,(float)0.01,0};
		
		BufferedReader br = null;
		JSONObject outsideTableJson = new JSONObject();
		JSONArray jArray = new JSONArray();
		
		try {
			//측정소에서 측정한 측정 데이터 가져오기
        	String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?"
        			+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
        			+ "&numOfRows=999&stationName="+URLEncoder.encode(area,"UTF-8")+"&dataTerm=DAILY&ver=1.0&_returnType=json";
        	URL url = new URL(urlstr);
        	HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
        	urlconnection.setRequestMethod("GET");
        	br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
        	String result = "";
        	String line = "";
        	while((line = br.readLine()) != null) {
        		result = result + line + "\n";
        		JSONObject jsonObj = JSONObject.fromObject(result);
                JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
                for(int i=0; i<jsonArr.size(); i++) {
                	JSONObject resultJson = (JSONObject)jsonArr.get(i);
                	JSONObject dataJson = new JSONObject();
                	
                	dataJson.put("dataTime",resultJson.getString("dataTime"));
                	
                	for(int j=0; j<matter.length; j++) {
                		switch (matter[j]) {
    					case "pm10":
    						standardSheet = pm10Value;
    						break;
    					case "pm25":
    						standardSheet = pm25Value;
    						break;
    					case "no2":
    						standardSheet = no2Value;
    						break;
    					case "o3":
    						standardSheet = o3Value;
    						break;
    					case "co":
    						standardSheet = coValue;
    						break;
    					case "so2":
    						standardSheet = so2Value;
    						break;
    					}
                		int x = 0;
    					int grade = 0;
    					float matterValue ;
    					dataJson.put(matter[j]+"data",resultJson.getString(matter[j] + "Value"));
    					if (resultJson.getString(matter[j] + "Value").equals("-")) {
    						dataJson.put(matter[j]+"grade","-");
    					} else {
    						matterValue = Float.parseFloat(resultJson.getString(matter[j] + "Value"));
    						while (matterValue < standardSheet[x]) {
    							x++;
    						}
    						grade = 8 - x;
    						dataJson.put(matter[j]+"grade",grade);
    					}
                	}
                	jArray.add(dataJson);
                }
        	}
        	br.close();
        	urlconnection.disconnect();
        	
        	Map<String, Object> map = new HashMap<String, Object>();
    		map.put("result",jArray);
    		outsideTableJson = JSONObject.fromObject(map);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return outsideTableJson;
	}
	
	// 외부 모니터링 지역 선택하기
	@RequestMapping(value = "outAreaList", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject outAreaList(Model model, HttpServletRequest request) {
		String area = request.getParameter("area");
		
		BufferedReader br = null;
		JSONObject json = new JSONObject();
		JSONArray jArray = new JSONArray();
		
		try {
			//측정소에서 측정한 측정 데이터 가져오기
        	String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/MsrstnInfoInqireSvc/getMsrstnList?"
        			+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
        			+ "&numOfRows=999&addr="+URLEncoder.encode(area,"UTF-8")+"&_returnType=json";
        	URL url = new URL(urlstr);
        	HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
        	urlconnection.setRequestMethod("GET");
        	br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
        	String result = "";
        	String line = "";
        	while((line = br.readLine()) != null) {
        		result = result + line + "\n";
        		JSONObject jsonObj = JSONObject.fromObject(result);
                JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
                for(int i=0; i<jsonArr.size(); i++) {
                	JSONObject resultJson = (JSONObject)jsonArr.get(i);
                	jArray.add(resultJson.getString("stationName"));
                }
        	}
        	br.close();
        	urlconnection.disconnect();
        	
        	Map<String, Object> map = new HashMap<String, Object>();
    		map.put("result",jArray);
    		json = JSONObject.fromObject(map);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return json;
	}
	
	// 실시간 차트 기본 데이터 30개 가져오기
	@RequestMapping(value = "inOldData", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject inOldData(HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();	// 나중에 IOT ID로 변경
		
		float dataGubun[] = new float[7];
		dataGubun[0] = 151;dataGubun[1] = 101;dataGubun[2] = 76;dataGubun[3] = 51;dataGubun[4] = 41;dataGubun[5] = 31;dataGubun[6] = 16;
		
		ArrayList<Map<String,Object>> oldData = manageService.getOldData();	//초기 30개의 값 가져오기
		String matterValue = (String) oldData.get(29).get("VALUE");	//마지막 값을 현재의 값으로 넣기
		ArrayList<Map<String,Object>> monthData = manageService.getMonthData(member_id);	//월 평균 값 가져오기
		ArrayList<Map<String,Object>> dayData = manageService.getDayData(member_id);	//요일 평균 값 가져오기
		ArrayList<Map<String,Object>> timeData = manageService.getTimeData(member_id);	//시간 평균 값 가져오기
		
		JSONArray jOldData = JSONArray.fromObject(oldData);
		JSONArray jMonthData = JSONArray.fromObject(monthData);
		JSONArray jDayData = JSONArray.fromObject(dayData);
		JSONArray jTimeData = JSONArray.fromObject(timeData);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oldData", jOldData);
		map.put("dataGubun", dataGubun);
		map.put("matterValue", matterValue);
		map.put("monthData", jMonthData);
		map.put("dayData", jDayData);
		map.put("timeData", jTimeData);
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
	
//	// 월 평균 값 가져오기
//	@RequestMapping(value = "monthData", method = RequestMethod.GET)
//	@ResponseBody
//	public JSONArray monthData(HttpServletRequest request) {
//		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();	// 나중에 IOT ID로 변경
//		
//		ArrayList<Map<String,Object>> monthData = manageService.getMonthData(member_id);	//월 평균 값 가져오기
//		
//		JSONArray json = JSONArray.fromObject(monthData);
//		
//		return json;
//	}
//	
//	// 요일 평균 값 가져오기
//	@RequestMapping(value = "dayData", method = RequestMethod.GET)
//	@ResponseBody
//	public JSONArray dayData(HttpServletRequest request) {
//		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();	// 나중에 IOT ID로 변경
//			
//		ArrayList<Map<String,Object>> dayData = manageService.getDayData(member_id);	//요일 평균 값 가져오기
//			
//		JSONArray json = JSONArray.fromObject(dayData);
//			
//		return json;
//	}
//		
//	// 시간 평균 값 가져오기
//	@RequestMapping(value = "timeData", method = RequestMethod.GET)
//	@ResponseBody
//	public JSONArray timeData(HttpServletRequest request) {
//		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();	// 나중에 IOT ID로 변경
//			
//		ArrayList<Map<String,Object>> timeData = manageService.getTimeData(member_id);	//시간 평균 값 가져오기
//			
//		JSONArray json = JSONArray.fromObject(timeData);
//			
//		return json;
//	}
	
	// 실시간 차트 최신 데이터 가져오기
	@RequestMapping(value = "inNowData", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray inNowData(HttpServletRequest request) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		
		ArrayList<Map<String,Object>> nowData = manageService.getNowData();
		System.out.println(nowData.get(0));
		System.out.println(nowData);
		
		JSONArray json = JSONArray.fromObject(nowData);
			
		return json;
	}
	
	// 원격제어 메인페이지로 가기
	@RequestMapping(value = "remoteMain", method = RequestMethod.GET)
	public String remoteMain(Model model, IotInfoVO iif, HttpServletRequest request, HttpSession session) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();

		ArrayList<IotInfoVO> myIot = manageService.iotMain(member_id);
		
		model.addAttribute("myIot", myIot);
		session.setAttribute("myIot", myIot);

		return "manage/remoteMain";
	}

	// 실내 모니터링에서 차트
	@ResponseBody
	@RequestMapping(value = "/insideChart", method = RequestMethod.GET)
	public JSONArray insideChart(Model model, HttpServletRequest request, HttpSession session) {
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
		
		String date = request.getParameter("date");
		
		ArrayList<MeasureDataVO> list = manageService.insideChart(member_id, date);
		model.addAttribute("list" + list);

		JSONArray jArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject json = new JSONObject();
			json.put("measure", list.get(i).getMeasure()); // 측정 값
			json.put("TODAY", list.get(i).getTODAY()); // 현재 날짜
			json.put("measuretime", list.get(i).getMeasuretime()); // 측정 시간
			json.put("CODE", list.get(i).getCODE()); // 측정 코드
			json.put("iotID", list.get(i).getIotID()); // 기기 ID
			jArray.add(json);
		}
		return jArray;
	}

	// IoT 원격제어 제품 등록 페이지로 가기
	@RequestMapping(value = "remoteRegist", method = RequestMethod.GET)
	public String remoteRegist(Model model) {
		return "manage/remoteRegist";
	}

	// 원격제어 등록하기
	@ResponseBody
	@RequestMapping(value = "remoteReg", method = RequestMethod.GET)
	public String remoteReg(Model model, IotInfoVO iif, HttpServletRequest request, HttpSession session) {

		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();

		String iot_id = request.getParameter("alias");
		String ModelName = request.getParameter("remote");
		String PlaceName = request.getParameter("location");

		System.out.println("iot_Id: " + iot_id);
		System.out.println("원격 장치(): " + ModelName);
		System.out.println("장소: " + PlaceName);

		// 혹시나 장치 추가할거면,,
		// manageService.modelInsert(ModelName);
		if (ModelName.equals("보일러")) {
			System.out.println("======================");
			System.out.println("보일러 추가");
			System.out.println(PlaceName + " 추가");

			iif.setIot_id(iot_id);
			iif.setMember_id(member_id);
			iif.setPlace_name(PlaceName);
			iif.setModel_id("boi_3jo");

			System.out.println(iif);
			manageService.iotInfoInsert(iif);
			System.out.println("======================");
		} else if (ModelName.equals("창문")) {
			System.out.println("======================");
			System.out.println("창문 추가");
			System.out.println(PlaceName + " 추가");

			iif.setIot_id(iot_id);
			iif.setMember_id(member_id);
			iif.setPlace_name(PlaceName);
			iif.setModel_id("win_3jo");

			System.out.println(iif);
			manageService.iotInfoInsert(iif);
			System.out.println("======================");
		} else if (ModelName.equals("공기청정기")) {
			System.out.println("======================");
			System.out.println("공기청정기 추가");
			System.out.println(PlaceName + " 추가");

			iif.setIot_id(iot_id);
			iif.setMember_id(member_id);
			iif.setPlace_name(PlaceName);
			iif.setModel_id("air_3jo");

			System.out.println(iif);
			manageService.iotInfoInsert(iif);
			System.out.println("======================");
		} else if (ModelName.equals("환풍기")) {
			System.out.println("======================");
			System.out.println("환풍기 추가");
			System.out.println(PlaceName + " 추가");

			iif.setIot_id(iot_id);
			iif.setMember_id(member_id);
			iif.setPlace_name(PlaceName);
			iif.setModel_id("ven_3jo");

			System.out.println(iif);
			manageService.iotInfoInsert(iif);
			System.out.println("======================");
		} else {
			System.out.println("원격 제어 등록 오류입니다.");
		}

		return "manage/remoteRegist";
	}

	// 별명 중복 체크
	@ResponseBody
	@RequestMapping(value = "/nicknameCheck", method = RequestMethod.GET)
	public String nicknameCheck(Model model, HttpServletRequest request) {

		String alias = request.getParameter("alias");
		System.out.println("alias넘어옴: " + alias);

		IotInfoVO nCheck = manageService.nCheck(alias);
		System.out.println("nCheck: " + nCheck);

		if (nCheck != null) {
			return "No";
		}
		return "Yes";
	}
}