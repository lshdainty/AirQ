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
import com.yjc.airq.domain.MeasureDataVO;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.Recommend;
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
	
	// 사용자가 가지고있는 공기질 측정 iot기기 개수 확인
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/m.checkIot", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject checkIot(HttpServletRequest request) {
		String member_id = request.getParameter("member_id");
		int iotNum = manageService.checkIot(member_id);
			
		Map<String, Object> map = new HashMap<String, Object>();
			
		if(iotNum == 0) {
			map.put("result", "no");
		}else {
			map.put("result", "yes");
			ArrayList<Map<String,Object>> iotList = manageService.iotList(member_id);
			JSONArray jIotList = JSONArray.fromObject(iotList);
			for(int i=0; i<jIotList.size(); i++) {
				JSONObject jObj = JSONObject.fromObject(jIotList.get(i));
				ArrayList<Map<String,Object>> iotMatterList = manageService.iotMatterList(jObj.getString("MODEL"));
				JSONArray jIotMatterList = JSONArray.fromObject(iotMatterList);
				jObj.put("matterList",jIotMatterList);
				jIotList.set(i,jObj); 
			}
			map.put("iotInfo", jIotList);
		}
			
		JSONObject json = JSONObject.fromObject(map);
			
		return json;
	}
		
	// 사용자가 선택한 IOT가 측정할 수 있는 물질목록 가져오기
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/m.changeMatter", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject changeMatter(HttpServletRequest request) {
		String iot_id = request.getParameter("id");
			
		String model = manageService.selectModel(iot_id);
			
		ArrayList<Map<String,Object>> iotMatterList = manageService.iotMatterList(model);
			
		JSONArray jIotMatterList = JSONArray.fromObject(iotMatterList);
			
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iotMatterList",jIotMatterList);
			
		JSONObject json = JSONObject.fromObject(map);
			
		return json;
	}
	
	// 실시간 차트 기본 데이터 30개 가져오기
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/m.inOldData", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject inOldData(HttpServletRequest request) {
		String id = request.getParameter("id");
		String matter = request.getParameter("matter");
		
		float dataGubun[] = null;
		float PM10[] = {151,101,76,51,41,31,16,0};
		float CO2[] = {5000,3000,2000,1500,1000,700,450,0};
		
		String unit = "";
		
		switch (matter) {
		case "PM10":
			dataGubun = PM10;
			unit = "µg/m³";
			break;
		case "CO2":
			dataGubun = CO2;
			unit = "ppm";
			break;
		}
		
		ArrayList<Map<String,Object>> oldData = manageService.getOldData(id,matter);	//초기 30개의 값 가져오기
		String matterValue = "";
		if(oldData.size()>0) {
			matterValue = (String) oldData.get(oldData.size()-1).get("VALUE");	//마지막 값을 현재의 값으로 넣기
		}else {
			matterValue="0";
		}
		String todayAvg = manageService.getTodayAvgData(id,matter);	//하루 평균값 가져오기
		int overValue = manageService.getOverValue(id,matter);	//임계값 초과 횟수 가져오기
		ArrayList<Map<String,Object>> monthData = manageService.getMonthData(id,matter);	//월 평균 값 가져오기
		ArrayList<Map<String,Object>> dayData = manageService.getDayData(id,matter);	//요일 평균 값 가져오기
		ArrayList<Map<String,Object>> timeData = manageService.getTimeData(id,matter);	//시간 평균 값 가져오기
		
		JSONArray jOldData = JSONArray.fromObject(oldData);
		JSONArray jMonthData = JSONArray.fromObject(monthData);
		JSONArray jDayData = JSONArray.fromObject(dayData);
		JSONArray jTimeData = JSONArray.fromObject(timeData);
		
		int x = 0;
		int grade = 0;
		while (Float.parseFloat(matterValue) < dataGubun[x]) {
			x++;
		}
		grade = 8 - x;
		
		Recommend recommendObject = new Recommend();
		recommendObject.setMatter(matter);
		recommendObject.setGrade(grade);
		recommendObject.setRecommend();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oldData", jOldData);
		map.put("matterValue", matterValue);
		map.put("todayAvg", todayAvg);
		map.put("overValue", overValue);
		map.put("dataGubun", dataGubun);
		map.put("grade",grade);
		map.put("unit",unit);
		map.put("recommend",recommendObject.getRecommend());
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}
		
	// 실시간 차트 최신 데이터 가져오기
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/m.inNowData", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject inNowData(HttpServletRequest request) {
		String id = request.getParameter("id");
		String matter = request.getParameter("matter");
		
		float dataGubun[] = null;
		float PM10[] = {151,101,76,51,41,31,16,0};
		float CO2[] = {5000,3000,2000,1500,1000,700,450,0};
		
		switch (matter) {
		case "PM10":
			dataGubun = PM10;
			break;
		case "CO2":
			dataGubun = CO2;
			break;
		}
		
		ArrayList<Map<String,Object>> nowData = manageService.getNowData(id,matter);
		String matterValue = "";
		if(nowData.size()>0) {
			matterValue = (String) nowData.get(nowData.size()-1).get("VALUE");	//마지막 값을 현재의 값으로 넣기
		}else {
			matterValue="0";
		}
		String todayAvg = manageService.getTodayAvgData(id,matter);	//하루 평균값 가져오기
		int overValue = manageService.getOverValue(id,matter);	//임계값 초과 횟수 가져오기
		
		JSONArray jNowData = JSONArray.fromObject(nowData);
		
		int x = 0;
		int grade = 0;
		while (Float.parseFloat(matterValue) < dataGubun[x]) {
			x++;
		}
		grade = 8 - x;
		
		Recommend recommendObject = new Recommend();
		recommendObject.setMatter(matter);
		recommendObject.setGrade(grade);
		recommendObject.setRecommend();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nowData", jNowData);
		map.put("matterValue", matterValue);
		map.put("todayAvg", todayAvg);
		map.put("overValue", overValue);
		map.put("grade",grade);
		map.put("recommend",recommendObject.getRecommend());
		
		JSONObject json = JSONObject.fromObject(map);
		
		return json;
	}

	// 사용자의 현재 위치에서 가장 가까운 측정소 측정정보 가져오기
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/m.dustData", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject dustData(Model model, HttpServletRequest request) {
		String x = request.getParameter("x");
		String y = request.getParameter("y");

		// 각 물질마다의 분류기준값
		String code[] = {"PM10","PM2.5","NO2","O3","CO","SO2"};
		String name[] = {"미세먼지","초미세먼지","이산화질소","오존","일산화탄소","아황산가스"};
		String unit[] = {"µg/m³","µg/m³","ppm","ppm","ppm","ppm"};
		String matter[] = {"pm10","pm25","no2","o3","co","so2"};
		float standardSheet[] = null;
		float pm10Value[] = { 151, 101, 76, 51, 41, 31, 16, 0};
		float pm25Value[] = { 76, 51, 38, 26, 21, 16, 9, 0};
		float no2Value[] = { (float) 1.1, (float) 0.2, (float) 0.13, (float) 0.06, (float) 0.05, (float) 0.03,(float) 0.02, 0};
		float o3Value[] = { (float) 0.38, (float) 0.15, (float) 0.12, (float) 0.09, (float) 0.06, (float) 0.03,(float) 0.02, 0};
		float coValue[] = { 32, 15, 12, 9, (float) 5.5, 2, 1, 0};
		float so2Value[] = { (float) 0.6, (float) 0.15, (float) 0.1, (float) 0.05, (float) 0.04, (float) 0.02,(float) 0.01, 0};

		String areaName = "";
		BufferedReader br = null;

		JSONObject json = new JSONObject();
		JSONArray jArray = new JSONArray();
		try {
			// 좌표값에서 근접 측정소 목록 가져오기
			String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/MsrstnInfoInqireSvc/getNearbyMsrstnList?"
					+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
					+ "&numOfRows=999&tmX=" + x + "&tmY=" + y + "&ver=1.0&_returnType=json";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String result = "";
			String line = "";
			while ((line = br.readLine()) != null) {
				result = result + line + "\n";
				JSONObject jsonObj = JSONObject.fromObject(result);
				JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
				areaName = ((JSONObject) jsonArr.get(0)).getString("stationName");
			}
			br.close();
			urlconnection.disconnect();

			// 측정소에서 측정한 측정 데이터 가져오기
			String urlstr1 = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?"
					+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
					+ "&numOfRows=999&stationName=" + URLEncoder.encode(areaName, "UTF-8")
					+ "&dataTerm=DAILY&ver=1.0&_returnType=json";
			url = new URL(urlstr1);
			urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			result = "";
			line = "";
			while ((line = br.readLine()) != null) {
				result = result + line + "\n";
				JSONObject jsonObj = JSONObject.fromObject(result);
				JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
				JSONObject resultJson = (JSONObject) jsonArr.get(0);
				JSONObject dataJson = new JSONObject();
				
				for(int i=0; i<matter.length; i++) {
            		switch (matter[i]) {
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
            		int count = 0;
					int grade = 0;
					float matterValue ;
					
					dataJson.put("code", code[i]);
					dataJson.put("name", name[i]);
					dataJson.put("unit", unit[i]);
					dataJson.put("data",resultJson.getString(matter[i] + "Value"));
					if (resultJson.getString(matter[i] + "Value").equals("-")) {
						dataJson.put("grade","-");
					} else {
						matterValue = Float.parseFloat(resultJson.getString(matter[i] + "Value"));
						while (matterValue < standardSheet[count]) {
							count++;
						}
						grade = 8 - count;
						dataJson.put("grade",grade);
					}
					jArray.add(dataJson);
            	}
			}
			br.close();
			urlconnection.disconnect();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", jArray);
			json = JSONObject.fromObject(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return json;
	}

	// 외부 모니터링 차트 데이터 가져오기
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.outsideChart", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject outSideChart(Model model, HttpServletRequest request) {
		String area = request.getParameter("area");
		String matter = request.getParameter("matter");
		BufferedReader br = null;
		JSONObject outsideChartJson = new JSONObject();
		JSONArray jArray = new JSONArray();
		// 각 물질마다의 분류기준값
		float standardSheet[] = null;
		float pm10Value[] = { 151, 101, 76, 51, 41, 31, 16, 0 };
		float pm25Value[] = { 76, 51, 38, 26, 21, 16, 9, 0 };
		float no2Value[] = { (float) 1.1, (float) 0.2, (float) 0.13, (float) 0.06, (float) 0.05, (float) 0.03,(float) 0.02, 0 };
		float o3Value[] = { (float) 0.38, (float) 0.15, (float) 0.12, (float) 0.09, (float) 0.06, (float) 0.03,(float) 0.02, 0 };
		float coValue[] = { 32, 15, 12, 9, (float) 5.5, 2, 1, 0 };
		float so2Value[] = { (float) 0.6, (float) 0.15, (float) 0.1, (float) 0.05, (float) 0.04, (float) 0.02,(float) 0.01, 0 };
		try {
			// 측정소에서 측정한 측정 데이터 가져오기
			String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?"
					+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
					+ "&numOfRows=999&stationName=" + URLEncoder.encode(area, "UTF-8")
					+ "&dataTerm=DAILY&ver=1.0&_returnType=json";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String result = "";
			String line = "";
			while ((line = br.readLine()) != null) {
				result = result + line + "\n";
				JSONObject jsonObj = JSONObject.fromObject(result);
				JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
				for (int i = jsonArr.size() - 1; i >= 0; i--) {
					JSONObject resultJson = (JSONObject) jsonArr.get(i);
					JSONObject dataJson = new JSONObject();
					switch (matter) {
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
					if (resultJson.getString(matter + "Value").equals("-")) {
						System.out.println("null");
						grade = 0;
					} else {
						matterValue = Float.parseFloat(resultJson.getString(matter + "Value"));
						while (matterValue < standardSheet[x]) {
							x++;
						}
						grade = 8 - x;
					}
					dataJson.put("grade", grade);
					dataJson.put("dataTime", resultJson.getString("dataTime"));
					dataJson.put("data", resultJson.getString(matter + "Value"));
					jArray.add(dataJson);
				}
			}
			br.close();
			urlconnection.disconnect();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", jArray);
			outsideChartJson = JSONObject.fromObject(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return outsideChartJson;
	}

	// 외부 모니터링 지역 선택하기
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.outAreaList", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject outAreaList(Model model, HttpServletRequest request) {
		String area = request.getParameter("area");

		BufferedReader br = null;
		JSONObject json = new JSONObject();
		JSONArray jArray = new JSONArray();

		try {
			// 측정소에서 측정한 측정 데이터 가져오기
			String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/MsrstnInfoInqireSvc/getMsrstnList?"
					+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
					+ "&numOfRows=999&addr=" + URLEncoder.encode(area, "UTF-8") + "&_returnType=json";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String result = "";
			String line = "";
			while ((line = br.readLine()) != null) {
				result = result + line + "\n";
				JSONObject jsonObj = JSONObject.fromObject(result);
				JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));
				for (int i = 0; i < jsonArr.size(); i++) {
					JSONObject resultJson = (JSONObject) jsonArr.get(i);
					jArray.add(resultJson.getString("stationName"));
				}
			}
			br.close();
			urlconnection.disconnect();

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", jArray);
			json = JSONObject.fromObject(map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return json;
	}

}