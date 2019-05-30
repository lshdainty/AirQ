package com.yjc.airq;

import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	
	// 홈화면 광역시/도 카드 데이터 만들기
	@RequestMapping(value = "/homematterdata", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject homeMatterData(HttpServletRequest request) {
		BufferedReader br = null;
		JSONObject json = new JSONObject();	//최종 json
		JSONArray jArray = new JSONArray();	//최종 jsonArray
		String matter = request.getParameter("matter");
		try {
			String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?"
        			+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
        			+ "&numOfRows=1&pageNo=1&itemCode="+URLEncoder.encode(matter,"UTF-8")+"&dataGubun=HOUR&_returnType=json";
			URL url = new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
            String result = "";
            String line = "";
            while((line = br.readLine()) != null) {
                result = result + line + "\n";
                String kName[] = {"서울","부산","대구"};
                String eName[] = {"seoul","busan","daegu"};
                JSONObject jsonObj = JSONObject.fromObject(result);	//json으로 변환
                JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));	//json안에 list배열만 가져오기
                JSONObject convertJSON = jsonArr.getJSONObject(0);	//list배열안에 최신 평균값을 가져오기위해 index0번째 가져오기
                json.put("itemCode",convertJSON.getString("itemCode"));	//최종 반환되는 json에 물질코드 넣기
                json.put("dataTime",convertJSON.getString("dataTime"));	//최종 반환되는 json에 시간값 넣기
                float dataGubun[] = new float[7];
				switch(matter) {
					case "PM10":
						dataGubun[0] = 151;dataGubun[1] = 101;dataGubun[2] = 76;dataGubun[3] = 51;dataGubun[4] = 41;dataGubun[5] = 31;dataGubun[6] = 16;
						json.put("dataGubun",dataGubun);break;
					case "PM25":
						dataGubun[0] = 76;dataGubun[1] = 51;dataGubun[2] = 38;dataGubun[3] = 26;dataGubun[4] = 21;dataGubun[5] = 16;dataGubun[6] = 9;
						json.put("dataGubun",dataGubun);break;
					case "NO2":
						dataGubun[0] = (float)1.1;dataGubun[1] = (float)0.2;dataGubun[2] = (float)0.13;dataGubun[3] = (float)0.06;dataGubun[4] = (float)0.05;dataGubun[5] = (float)0.03;dataGubun[6] = (float)0.02;
						json.put("dataGubun",dataGubun);break;
					case "O3":
						dataGubun[0] = (float)0.38;dataGubun[1] = (float)0.15;dataGubun[2] = (float)0.12;dataGubun[3] = (float)0.09;dataGubun[4] = (float)0.06;dataGubun[5] = (float)0.03;dataGubun[6] = (float)0.02;
						json.put("dataGubun",dataGubun);break;
					case "CO":
						dataGubun[0] = 32;dataGubun[1] = 15;dataGubun[2] = 12;dataGubun[3] = 9;dataGubun[4] = (float)5.5;dataGubun[5] = 2;dataGubun[6] = 1;
						json.put("dataGubun",dataGubun);break;
					case "SO2":
						dataGubun[0] = (float)0.6;dataGubun[1] = (float)0.15;dataGubun[2] = (float)0.1;dataGubun[3] = (float)0.05;dataGubun[4] = (float)0.04;dataGubun[5] = (float)0.02;dataGubun[6] = (float)0.01;
						json.put("dataGubun",dataGubun);break;
				}
                for(int i=0; i<kName.length; i++) {
                	JSONObject resultJSON = new JSONObject();
                	resultJSON.put("ename",eName[i]);
                	resultJSON.put("kname",kName[i]);
            		resultJSON.put("data",convertJSON.getString(eName[i]));
            		jArray.add(resultJSON);
                }
                json.put("result",jArray);	//최종 반환되는 json에 광역시의 이름과 측정값 넣기
            }
            br.close();
            urlconnection.disconnect();
		}catch(Exception e){
            System.out.println(e.getMessage());
        }
		return json;
	}
	
	// 홈화면 선택된 광역시/도의 24시간 물질 수치 가져오기
	@RequestMapping(value = "/homematterdatadetail", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject homeMatterDataDetail(HttpServletRequest request) {
		BufferedReader br = null;
		JSONObject json = new JSONObject();	//최종 json
		JSONArray jArray = new JSONArray();	//최종 jsonArray
		String matter = request.getParameter("matter");
		if(matter.equals("PM2.5")) {matter = "PM25";}
		String area = request.getParameter("area");
		try {
			String urlstr = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureLIst?"
	       			+ "serviceKey=ih2Gzic0JjfHpYSWXRXk4QNjcf9DaJo6F6hMKgBRQpn4T7YiXPelW%2B8Z%2BJCqkH1%2FSeeNJa%2BROW54XiWGBQmKTg%3D%3D"
	       			+ "&numOfRows=24&pageNo=1&itemCode="+URLEncoder.encode(matter,"UTF-8")+"&dataGubun=HOUR&_returnType=json";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
			String result = "";
			String line = "";
			while((line = br.readLine()) != null) {
				result = result + line + "\n";
				JSONObject jsonObj = JSONObject.fromObject(result);	//json으로 변환
				JSONArray jsonArr = JSONArray.fromObject(jsonObj.get("list"));	//json안에 list배열만 가져오기
				float dataGubun[] = new float[7];
				switch(matter) {
					case "PM10":
						dataGubun[0] = 151;dataGubun[1] = 101;dataGubun[2] = 76;dataGubun[3] = 51;dataGubun[4] = 41;dataGubun[5] = 31;dataGubun[6] = 16;
						json.put("dataGubun",dataGubun);
						json.put("unit","µg/m");break;
					case "PM25":
						dataGubun[0] = 76;dataGubun[1] = 51;dataGubun[2] = 38;dataGubun[3] = 26;dataGubun[4] = 21;dataGubun[5] = 16;dataGubun[6] = 9;
						json.put("dataGubun",dataGubun);
						json.put("unit","µg/m");break;
					case "NO2":
						dataGubun[0] = (float)1.1;dataGubun[1] = (float)0.2;dataGubun[2] = (float)0.13;dataGubun[3] = (float)0.06;dataGubun[4] = (float)0.05;dataGubun[5] = (float)0.03;dataGubun[6] = (float)0.02;
						json.put("dataGubun",dataGubun);
						json.put("unit","ppm");break;
					case "O3":
						dataGubun[0] = (float)0.38;dataGubun[1] = (float)0.15;dataGubun[2] = (float)0.12;dataGubun[3] = (float)0.09;dataGubun[4] = (float)0.06;dataGubun[5] = (float)0.03;dataGubun[6] = (float)0.02;
						json.put("dataGubun",dataGubun);
						json.put("unit","ppm");break;
					case "CO":
						dataGubun[0] = 32;dataGubun[1] = 15;dataGubun[2] = 12;dataGubun[3] = 9;dataGubun[4] = (float)5.5;dataGubun[5] = 2;dataGubun[6] = 1;
						json.put("dataGubun",dataGubun);
						json.put("unit","ppm");break;
					case "SO2":
						dataGubun[0] = (float)0.6;dataGubun[1] = (float)0.15;dataGubun[2] = (float)0.1;dataGubun[3] = (float)0.05;dataGubun[4] = (float)0.04;dataGubun[5] = (float)0.02;dataGubun[6] = (float)0.01;
						json.put("dataGubun",dataGubun);
						json.put("unit","ppm");break;
				}
				if(matter.equals("PM25")) {matter = "PM2.5";}
				json.put("matter_code",matter);
				for(int i=jsonArr.size()-1; i>=0; i--) {
					JSONObject resultJSON = new JSONObject();
					resultJSON.put("time",((JSONObject) jsonArr.get(i)).getString("dataTime").substring(11));
					resultJSON.put("data",((JSONObject) jsonArr.get(i)).getString(area));
					jArray.add(resultJSON);
				}
				json.put("result",jArray);	//최종 반환되는 json에 광역시의 이름과 측정값 넣기
			}
			br.close();
			urlconnection.disconnect();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return json;
	}

	// 미세먼지 측정
	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.POST, produces = { "application/json" })
	public Map<String, Object> test(@RequestBody Map<String, Object> info, MeasureDataVO msd,
			HttpServletRequest request) {

		System.out.println("iotId: " + info.get("iotId"));
		System.out.println("dust_val: " + info.get("dust_val"));
		System.out.println("현재 시간(mtime): " + info.get("mtime"));
		System.out.println("========================================");

		// 현재 날짜 생성
		Date date = new Date();
		String str = date.toString();
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

		System.out.println("=============================");
		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓원격 제어↓↓↓↓↓↓↓↓↓↓↓");
		System.out.println("=============================");

//		String sw = request.getParameter("switch");
//		String sw = "success!!";
//		System.out.println("switch: " + sw);

		Map<String, Object> resultVal = new HashMap<String, Object>();
		resultVal.put("result", "success!!");
		
		return resultVal;
	}
}

//홈 메인페이지로 가기
//	@RequestMapping(value = "/DataControl", method = RequestMethod.POST)
//	public String DataControl(Model model) throws Exception {
//
//		System.out.println("================↓↓↓↓↓↓Arduino Test↓↓↓↓↓↓===================");
//		while (true) {
//			ServerSocket serverSocket = null;
//
//			try {
//
//				serverSocket = new ServerSocket(333);
//
//				System.out.println("3WDA3JO Arduino ON");
//
//				Socket clientSocket = null;
//
//				while (true) {
//
//					try {
//						clientSocket = serverSocket.accept();
//
//						System.out.print("접속 완료 " + clientSocket.getLocalAddress());
//						Calendar c = Calendar.getInstance();
//						System.out.println(" 접속시간:" + c.getTime());
//						System.out.println("===========================================================");
//						new Thread(new SerialWriter(clientSocket)).start(); // 데이터 수신
//
//					} catch (IOException e) {
//						System.err.println("accept() 실패");
//						System.exit(1);
//					}
//				}
//			} catch (IOException e) {
//				System.err.println("다음의 포트 번호에 연결할 수 없습니다");
//				serverSocket.close();
//				System.exit(1);
//			}
//		} // while문
//	}
//	/*********************/
//	// 데이터 송신
//	/*********************/
//	public class SerialWriter implements Runnable {
//
//		boolean switched = true;
//		Socket out;
//		OutputStream os;
//		OutputStreamWriter osw;
//		
//		public SerialWriter(Socket clientSocket) {
//			System.out.println("clientSocket: " + clientSocket);
//			this.out = clientSocket;
//		}
//
//		@Override
//		public void run() {
//			System.out.println("abcd");
//			try {
//				os = out.getOutputStream();
//				osw = new OutputStreamWriter(System.out); 
//				int c;
//				
//				while(true) {
//					Thread.sleep(1000);
//					if(switched == true) {
//						c = 0;
//						osw.write(c);
//						System.out.println("내가 보낸 값: " + c);
//					}
//					else if(switched == false) {
//						c = 1;
//						osw.write(c);
//						System.out.println("내가 보낸 값: " + c);
//					}
//				}
//			} catch(IOException | InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}
