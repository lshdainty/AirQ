package com.yjc.airq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
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
import com.yjc.airq.domain.IotVO;
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

	// 공기질 모니터링 메인페이지로 가기
	@RequestMapping(value = "monitoringMain", method = RequestMethod.GET)
	public String monitoringMain(Model model) {
		return "manage/monitoringMain";
	}
	
	// 각 시/도 미세먼지 수치 가져오기
	@RequestMapping(value = "test1111", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject testTT(Model model) {
		BufferedReader br = null;
		//String sidoName[] = {"서울", "부산", "대구", "인천", "광주", "대전", "울산", "경기", "강원", "충북", "충남", "전북", "전남", "경북", "경남", "제주", "세종"};
		String sidoName1[] = {"서울", "부산", "대구", "인천", "광주", "대전", "울산", "경기", "강원", "충북", "충남", "전북", "전남", "경북", "경남", "제주", "세종"};
		JSONObject json = new JSONObject();
		JSONArray dustDataArray = new JSONArray();
		JSONArray areaDataArray = new JSONArray();
		JSONArray resultArray = new JSONArray();
        try{
        	//미세먼지 목록 가져오기
//        	for(int i=0; i<sidoName.length; i++) {
//        		String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?"
//            			+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
//            			+ "&numOfRows=999&sidoName="+URLEncoder.encode(sidoName[i],"UTF-8")+"&ver=1.3&_returnType=json";
//                URL url = new URL(urlstr);
//                HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
//                urlconnection.setRequestMethod("GET");
//                br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
//                String result = "";
//                String line = "";
//                while((line = br.readLine()) != null) {
//                    result = result + line + "\n";
//                    System.out.println(result);
//                    JSONObject jsonObj = JSONObject.fromObject(result);
//                    JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
//                    for(int j=0; j<jsonArr.size(); j++) {
//                    	dustDataArray.add(jsonArr.get(j));
//                    }
//                }
//        	}
//        	System.out.println(dustDataArray.size());
        	
        	//미세먼지 측정소 목록 가져오기
        	for(int i=0; i<sidoName1.length; i++) {
        		String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/MsrstnInfoInqireSvc/getMsrstnList?"
            			+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
            			+ "&numOfRows=999&addr="+URLEncoder.encode(sidoName1[i],"UTF-8")+"&_returnType=json";
                URL url = new URL(urlstr);
                HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
                urlconnection.setRequestMethod("GET");
                br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
                String result = "";
                String line = "";
                while((line = br.readLine()) != null) {
                    result = result + line + "\n";
                    System.out.println(result);
//                    JSONObject jsonObj = JSONObject.fromObject(result);
//                    JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
//                    for(int j=0; j<jsonArr.size(); j++) {
//                    	areaDataArray.add(jsonArr.get(j));
//                    }
                }
        	}
//        	System.out.println(areaDataArray.size());
        	
        	//미세먼지수치,측정소 좌표값 합치기
//        	for(int i=0; i<dustDataArray.size(); i++) {
//        		JSONObject dustJSON = dustDataArray.getJSONObject(i);
//        		for(int j=0; j<areaDataArray.size(); j++) {
//        			JSONObject areaJSON = areaDataArray.getJSONObject(j);
//        			if(dustJSON.getString("stationName").equals(areaJSON.getString("stationName"))) {
//        				JSONObject jsonObj = new JSONObject();
//        				jsonObj.put("stationName",dustJSON.getString("stationName"));
//        				jsonObj.put("dataTime",dustJSON.getString("dataTime"));
//        				jsonObj.put("mangName",dustJSON.getString("mangName"));
//        				jsonObj.put("addr",areaJSON.getString("addr"));
//        				jsonObj.put("x",areaJSON.getString("dmX"));
//        				jsonObj.put("y",areaJSON.getString("dmY"));
//        				jsonObj.put("pm10Value",dustJSON.getString("pm10Value"));
//        				jsonObj.put("pm10Grade1h",dustJSON.getString("pm10Grade1h"));
//        				jsonObj.put("pm10Value24",dustJSON.getString("pm10Value24"));
//        				jsonObj.put("pm10Grade",dustJSON.getString("pm10Grade"));
//        				jsonObj.put("pm25Value",dustJSON.getString("pm25Value"));
//        				jsonObj.put("pm25Grade1h",dustJSON.getString("pm25Grade1h"));
//        				jsonObj.put("pm25Value24",dustJSON.getString("pm25Value24"));
//        				jsonObj.put("pm25Grade",dustJSON.getString("pm25Grade"));
//        				jsonObj.put("coValue",dustJSON.getString("coValue"));
//        				jsonObj.put("coGrade",dustJSON.getString("coGrade"));
//        				jsonObj.put("so2Value",dustJSON.getString("so2Value"));
//        				jsonObj.put("so2Grade",dustJSON.getString("so2Grade"));
//        				jsonObj.put("o3Value",dustJSON.getString("o3Value"));
//        				jsonObj.put("o3Grade",dustJSON.getString("o3Grade"));
//        				jsonObj.put("no2Value",dustJSON.getString("no2Value"));
//        				jsonObj.put("no2Grade",dustJSON.getString("no2Grade"));
//        				jsonObj.put("khaiValue",dustJSON.getString("khaiValue"));
//        				jsonObj.put("khaiGrade",dustJSON.getString("khaiGrade"));
//        				resultArray.add(jsonObj);
//        			}
//        		}
//        	}
//        	
//        	System.out.println(resultArray);
//        	Map<String, Object> map = new HashMap<String, Object>();
//    		map.put("result", resultArray);
//    		json = JSONObject.fromObject(map);
//    		System.out.println(json);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
		return json;
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
