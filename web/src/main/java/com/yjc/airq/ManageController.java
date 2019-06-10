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
		float pm10Value[] = {151,101,76,51,41,31,16};
		float pm25Value[] = {76,51,38,26,21,16,9};
		float no2Value[] = {(float)1.1,(float)0.2,(float)0.13,(float)0.06,(float)0.05,(float)0.03,(float)0.02};
		float o3Value[] = {(float)0.38,(float)0.15,(float)0.12,(float)0.09,(float)0.06,(float)0.03,(float)0.02};
		float coValue[] = {32,15,12,9,(float)5.5,2,1};
		float so2Value[] = {(float)0.6,(float)0.15,(float)0.1,(float)0.05,(float)0.04,(float)0.02,(float)0.01};
		
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
                	
                	//미세먼지
                	dataJson.put("pm10code","PM10");
                	dataJson.put("pm10name","미세먼지");
                	dataJson.put("pm10unit","µg/m³");
                	dataJson.put("pm10data",resultJson.getString("pm10Value"));
                	if(resultJson.getString("pm10Value").equals("-")) {
                		dataJson.put("pm10grade","-");
                	}else {
                    	if (Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[0]) {
                    		dataJson.put("pm10grade",8);
                    	}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[1]){
                    		dataJson.put("pm10grade",7);
                    	}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[2]){
                    		dataJson.put("pm10grade",6);
                    	}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[3]){
                    		dataJson.put("pm10grade",5);
                    	}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[4]){
                    		dataJson.put("pm10grade",4);
                    	}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[5]){
                    		dataJson.put("pm10grade",3);
                    	}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[6]){
                    		dataJson.put("pm10grade",2);
                    	}else {
                    		dataJson.put("pm10grade",1);
                    	}
                	}
        		
                	//초미세먼지
                	dataJson.put("pm25code","PM2.5");
                	dataJson.put("pm25name","초미세먼지");
                	dataJson.put("pm25unit","µg/m³");
                	dataJson.put("pm25data",resultJson.getString("pm25Value"));
                	if(resultJson.getString("pm25Value").equals("-")) {
                		dataJson.put("pm25grade","-");
                	}else {
                    	if (Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[0]) {
                    		dataJson.put("pm25grade",8);
                    	}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[1]){
                    		dataJson.put("pm25grade",7);
                    	}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[2]){
                    		dataJson.put("pm25grade",6);
                    	}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[3]){
                    		dataJson.put("pm25grade",5);
                    	}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[4]){
                    		dataJson.put("pm25grade",4);
                    	}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[5]){
                    		dataJson.put("pm25grade",3);
                    	}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[6]){
                    		dataJson.put("pm25grade",2);
                    	}else {
                    		dataJson.put("pm25grade",1);
                    	}
                	}
        		
                	//이산화질소
                	dataJson.put("no2code","NO2");
                	dataJson.put("no2name","이산화질소");
                	dataJson.put("no2unit","ppm");
                	dataJson.put("no2data",resultJson.getString("no2Value"));
                	if(resultJson.getString("no2Value").equals("-")) {
                		dataJson.put("no2grade","-");
                	}else {
                		if (Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[0]) {
                    		dataJson.put("no2grade",8);
                    	}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[1]){
                    		dataJson.put("no2grade",7);
                    	}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[2]){
                    		dataJson.put("no2grade",6);
                    	}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[3]){
                    		dataJson.put("no2grade",5);
                    	}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[4]){
                    		dataJson.put("no2grade",4);
                    	}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[5]){
                    		dataJson.put("no2grade",3);
                    	}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[6]){
                    		dataJson.put("no2grade",2);
                    	}else {
                    		dataJson.put("no2grade",1);
                    	}
                	}
                	
                	
                	//오존
                	dataJson.put("o3code","O3");
                	dataJson.put("o3name","오존");
                	dataJson.put("o3unit","ppm");
                	dataJson.put("o3data",resultJson.getString("o3Value"));
                	if(resultJson.getString("o3Value").equals("-")) {
                		dataJson.put("o3grade","-");
                	}else {
                    	if (Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[0]) {
                    		dataJson.put("o3grade",8);
                    	}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[1]){
                    		dataJson.put("o3grade",7);
                    	}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[2]){
                    		dataJson.put("o3grade",6);
                    	}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[3]){
                    		dataJson.put("o3grade",5);
                    	}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[4]){
                    		dataJson.put("o3grade",4);
                    	}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[5]){
                    		dataJson.put("o3grade",3);
                    	}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[6]){
                    		dataJson.put("o3grade",2);
                    	}else {
                    		dataJson.put("o3grade",1);
                    	}
                	}
        		
                	//일산화탄소
                	dataJson.put("cocode","CO");
                	dataJson.put("coname","일산화탄소");
                	dataJson.put("counit","ppm");
                	dataJson.put("codata",resultJson.getString("coValue"));
                	if(resultJson.getString("coValue").equals("-")) {
                		dataJson.put("cograde","-");
                	}else {
                    	if (Float.parseFloat((String)resultJson.get("coValue")) >= coValue[0]) {
                    		dataJson.put("cograde",8);
                    	}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[1]){
                    		dataJson.put("cograde",7);
                    	}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[2]){
                    		dataJson.put("cograde",6);
                    	}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[3]){
                    		dataJson.put("cograde",5);
                    	}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[4]){
                    		dataJson.put("cograde",4);
                    	}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[5]){
                    		dataJson.put("cograde",3);
                    	}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[6]){
                    		dataJson.put("cograde",2);
                    	}else {
                    		dataJson.put("cograde",1);
                    	}
                	}
        		
                	//아황산가스
                	dataJson.put("so2code","SO2");
                	dataJson.put("so2name","아황산가스");
                	dataJson.put("so2unit","ppm");
                	dataJson.put("so2data",resultJson.getString("so2Value"));
                	if(resultJson.getString("so2Value").equals("-")) {
                		dataJson.put("so2grade","-");
                	}else {
                    	if (Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[0]) {
                    		dataJson.put("so2grade",8);
                    	}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[1]){
                    		dataJson.put("so2grade",7);
                    	}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[2]){
                    		dataJson.put("so2grade",6);
                    	}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[3]){
                    		dataJson.put("so2grade",5);
                    	}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[4]){
                    		dataJson.put("so2grade",4);
                    	}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[5]){
                    		dataJson.put("so2grade",3);
                    	}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[6]){
                    		dataJson.put("so2grade",2);
                    	}else {
                    		dataJson.put("so2grade",1);
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

	// 실외 모니터링 페이지 이동
	@RequestMapping(value = "outside", method = RequestMethod.GET)
	public String outside(Model model) {
		return "manage/monitoringMain";
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

	// 공기질 모니터링 메인페이지로 가기
	@RequestMapping(value = "control", method = RequestMethod.GET)
	public String control(Model model) {
		System.out.println("sensorControl 컨트롤러");
		return "manage/control";
	}
}