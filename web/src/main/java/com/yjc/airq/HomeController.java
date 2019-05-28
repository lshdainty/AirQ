package com.yjc.airq;

import java.util.Calendar;
import java.util.Date;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
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
