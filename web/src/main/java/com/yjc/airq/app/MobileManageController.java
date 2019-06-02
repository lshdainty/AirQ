package com.yjc.airq.app;

import java.io.BufferedReader;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.IotInfoVO;
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
public class MobileManageController {
	
	private ManageService manageService;
	
	// 각 시/도 미세먼지 수치 가져오기
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.dustData", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject dustData(Model model, HttpServletRequest request) {
		String x = request.getParameter("x");
		String y = request.getParameter("y");
	
		//각 물질마다의 분류기준값
		float pm10Value[] = {151,101,76,51,41,31,16};
		float pm25Value[] = {76,51,38,26,21,16,9};
		float no2Value[] = {(float)1.1,(float)0.2,(float)0.13,(float)0.06,(float)0.05,(float)0.03,(float)0.02};
		float o3Value[] = {(float)0.38,(float)0.15,(float)0.12,(float)0.09,(float)0.06,(float)0.03,(float)0.02};
		float coValue[] = {32,15,12,9,(float)5.5,2,1};
		float so2Value[] = {(float)0.6,(float)0.15,(float)0.1,(float)0.05,(float)0.04,(float)0.02,(float)0.01};
		
		String areaName = "";
		BufferedReader br = null;

		JSONObject json = new JSONObject();
		JSONArray jArray = new JSONArray();
        try{
        	//좌표값에서 근접 측정소 목록 가져오기
        	String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/MsrstnInfoInqireSvc/getNearbyMsrstnList?"
            		+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
            		+ "&numOfRows=999&tmX="+x+"&tmY="+y+"&ver=1.0&_returnType=json";
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
                areaName = ((JSONObject) jsonArr.get(0)).getString("stationName");
        	}
        	br.close();
        	urlconnection.disconnect();
        	
        	//측정소에서 측정한 측정 데이터 가져오기
        	String urlstr1 = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?"
        			+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
        			+ "&numOfRows=999&stationName="+URLEncoder.encode(areaName,"UTF-8")+"&dataTerm=DAILY&ver=1.0&_returnType=json";
        	url = new URL(urlstr1);
        	urlconnection = (HttpURLConnection) url.openConnection();
        	urlconnection.setRequestMethod("GET");
        	br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
        	result = "";
        	line = "";
        	while((line = br.readLine()) != null) {
        		result = result + line + "\n";
        		JSONObject jsonObj = JSONObject.fromObject(result);
                JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
                JSONObject resultJson = (JSONObject)jsonArr.get(0);
                JSONObject dataJson = new JSONObject();
                
                //미세먼지
                dataJson.put("code","PM10");
                dataJson.put("name","미세먼지");
                dataJson.put("unit","µg/m³");
                dataJson.put("data",resultJson.getString("pm10Value"));
        		if (Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[0]) {
        			dataJson.put("grade",8);
        		}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[1]){
        			dataJson.put("grade",7);
        		}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[2]){
        			dataJson.put("grade",6);
        		}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[3]){
        			dataJson.put("grade",5);
        		}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[4]){
        			dataJson.put("grade",4);
        		}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[5]){
        			dataJson.put("grade",3);
        		}else if(Float.parseFloat((String)resultJson.get("pm10Value")) >= pm10Value[6]){
        			dataJson.put("grade",2);
        		}else {
        			dataJson.put("grade",1);
        		}
        		jArray.add(dataJson);
        		
        		//초미세먼지
        		dataJson.put("code","PM2.5");
        		dataJson.put("name","초미세먼지");
                dataJson.put("unit","µg/m³");
                dataJson.put("data",resultJson.getString("pm25Value"));
        		if (Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[0]) {
        			dataJson.put("grade",8);
        		}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[1]){
        			dataJson.put("grade",7);
        		}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[2]){
        			dataJson.put("grade",6);
        		}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[3]){
        			dataJson.put("grade",5);
        		}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[4]){
        			dataJson.put("grade",4);
        		}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[5]){
        			dataJson.put("grade",3);
        		}else if(Float.parseFloat((String)resultJson.get("pm25Value")) >= pm25Value[6]){
        			dataJson.put("grade",2);
        		}else {
        			dataJson.put("grade",1);
        		}
        		jArray.add(dataJson);
        		
        		//이산화질소
        		dataJson.put("code","NO2");
        		dataJson.put("name","이산화질소");
                dataJson.put("unit","ppm");
                dataJson.put("data",resultJson.getString("no2Value"));
        		if (Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[0]) {
        			dataJson.put("grade",8);
        		}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[1]){
        			dataJson.put("grade",7);
        		}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[2]){
        			dataJson.put("grade",6);
        		}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[3]){
        			dataJson.put("grade",5);
        		}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[4]){
        			dataJson.put("grade",4);
        		}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[5]){
        			dataJson.put("grade",3);
        		}else if(Float.parseFloat((String)resultJson.get("no2Value")) >= no2Value[6]){
        			dataJson.put("grade",2);
        		}else {
        			dataJson.put("grade",1);
        		}
        		jArray.add(dataJson);
        		
        		//오존
        		dataJson.put("code","O3");
        		dataJson.put("name","오존");
                dataJson.put("unit","ppm");
                dataJson.put("data",resultJson.getString("o3Value"));
        		if (Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[0]) {
        			dataJson.put("grade",8);
        		}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[1]){
        			dataJson.put("grade",7);
        		}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[2]){
        			dataJson.put("grade",6);
        		}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[3]){
        			dataJson.put("grade",5);
        		}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[4]){
        			dataJson.put("grade",4);
        		}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[5]){
        			dataJson.put("grade",3);
        		}else if(Float.parseFloat((String)resultJson.get("o3Value")) >= o3Value[6]){
        			dataJson.put("grade",2);
        		}else {
        			dataJson.put("grade",1);
        		}
        		jArray.add(dataJson);
        		
        		//일산화탄소
        		dataJson.put("code","CO");
        		dataJson.put("name","일산화탄소");
                dataJson.put("unit","ppm");
                dataJson.put("data",resultJson.getString("coValue"));
        		if (Float.parseFloat((String)resultJson.get("coValue")) >= coValue[0]) {
        			dataJson.put("grade",8);
        		}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[1]){
        			dataJson.put("grade",7);
        		}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[2]){
        			dataJson.put("grade",6);
        		}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[3]){
        			dataJson.put("grade",5);
        		}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[4]){
        			dataJson.put("grade",4);
        		}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[5]){
        			dataJson.put("grade",3);
        		}else if(Float.parseFloat((String)resultJson.get("coValue")) >= coValue[6]){
        			dataJson.put("grade",2);
        		}else {
        			dataJson.put("grade",1);
        		}
        		jArray.add(dataJson);
        		
        		//아황산가스
        		dataJson.put("code","SO2");
        		dataJson.put("name","아황산가스");
                dataJson.put("unit","ppm");
                dataJson.put("data",resultJson.getString("so2Value"));
        		if (Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[0]) {
        			dataJson.put("grade",8);
        		}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[1]){
        			dataJson.put("grade",7);
        		}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[2]){
        			dataJson.put("grade",6);
        		}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[3]){
        			dataJson.put("grade",5);
        		}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[4]){
        			dataJson.put("grade",4);
        		}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[5]){
        			dataJson.put("grade",3);
        		}else if(Float.parseFloat((String)resultJson.get("so2Value")) >= so2Value[6]){
        			dataJson.put("grade",2);
        		}else {
        			dataJson.put("grade",1);
        		}
        		jArray.add(dataJson);
        	}
        	br.close();
        	urlconnection.disconnect();
        	
        	Map<String, Object> map = new HashMap<String, Object>();
    		map.put("result",jArray);
    		json = JSONObject.fromObject(map);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
		return json;
	}

	// IoT 원격제어 메인페이지로 가기
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.remoteMain", method = RequestMethod.GET)
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
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.remoteRegist", method = RequestMethod.GET)
	public String remoteRegist(Model model) {
		return "manage/remoteRegist";
	}

	// 원격제어 등록하기
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.remoteReg", method = RequestMethod.GET)
	@ResponseBody
	public String remoteReg(Model model, IotInfoVO iif, HttpServletRequest request, HttpSession session) {
		
		String member_id = ((MemberVO)request.getSession().getAttribute("user")).getMember_id();
		
		String iot_id = request.getParameter("alias");
		String ModelName = request.getParameter("remote");
		String PlaceName = request.getParameter("location");
		
		System.out.println("iot_Id: " + iot_id);
		System.out.println("원격 장치(): " + ModelName);
		System.out.println("장소: " + PlaceName);
		
		// 혹시나 장치 추가할거면,,
		// manageService.modelInsert(ModelName);
		if(ModelName.equals("보일러")) {
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
		}else if(ModelName.equals("창문")) {
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
		}else if(ModelName.equals("공기청정기")) {
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
		}else if(ModelName.equals("환풍기")) {
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
		}else {
			System.out.println("원격 제어 등록 오류입니다.");
		}
		
		return "manage/remoteRegist";
	}
	
	// 별명 중복 체크
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/m.nicknameCheck", method = RequestMethod.GET)
	@ResponseBody
	public String nicknameCheck(Model model, HttpServletRequest request) {
		
		String alias = request.getParameter("alias");
		System.out.println("alias넘어옴: " + alias);
		
		IotInfoVO nCheck = manageService.nCheck(alias);
		System.out.println("nCheck: " + nCheck);
		
		if(nCheck != null) {
			return "No";
		}
		return "Yes";
		}
}