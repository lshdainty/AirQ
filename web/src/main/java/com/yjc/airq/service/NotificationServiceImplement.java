package com.yjc.airq.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.interceptor.HeaderRequestInterceptor;
import com.yjc.airq.mapper.MatterMapper;
import com.yjc.airq.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
@AllArgsConstructor
public class NotificationServiceImplement implements NotificationService {

	private MatterMapper matterMapper;
	private MemberMapper memberMapper;

	private static final String firebase_server_key = "AAAAr1R79uM:APA91bGMeRAH4gvbtW9gKnlrm4-XPGpX9EeAP_UprCGQj25L1J2hyOGe2nJu48oV8TtJHNdwX7cVbuB4e0UPN7xY1efGIR43yxuA699jFiVhADTf_X15YfBa0cCXTB4h49aaIkhrZOCf";
	private static final String firebase_api_url = "https://fcm.googleapis.com/fcm/send";

	@Override
	public CompletableFuture<String> send(HttpEntity<String> entity) {

		RestTemplate restTemplate = new RestTemplate();

		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + firebase_server_key));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json;charset=UTF-8"));
		restTemplate.setInterceptors(interceptors);

		String firebaseResponse = restTemplate.postForObject(firebase_api_url, entity, String.class);

		return CompletableFuture.completedFuture(firebaseResponse);
	}

	@Override
	public String periodicNotificationJson(ArrayList<String> token, String title, String content) {

		JSONObject body = new JSONObject();

		JSONArray array = new JSONArray();

		for (int i = 0; i < token.size(); i++) {
			array.add(token.get(i));
		}

		body.put("registration_ids", array);

		JSONObject notification = new JSONObject();
		notification.put("title", title);
		notification.put("body", content);

		body.put("notification", notification);

		System.out.println(body.toString());

		return body.toString();
	}

	@Override
	public String getAlarmTime(String iot_id, String matter_code) {
		// TODO Auto-generated method stub
		return matterMapper.alarm_time(iot_id, matter_code);
	}

	@Override
	public void setAlarmTime(String iot_id, String matter_code) {
		// TODO Auto-generated method stub
		matterMapper.alarm_time_update(iot_id, matter_code);
	}

	@Override
	public String getToken(String id) {
		// TODO Auto-generated method stub
		MemberVO member = memberMapper.memberInfo(id);
		System.out.println("MEMBER : " + member);
		return member.getToken();
	}

	@Override
	public void setToken(String token, String id) {

		memberMapper.tokenUpdate(token, id);
	}

//	@Override
//	public void appPush(ArrayList<String> token, String title, String content) {
//		// TODO Auto-generated method stub
//
//		JSONObject body = new JSONObject();
//
//		JSONArray array = new JSONArray();
//
//		for (int i = 0; i < token.size(); i++) {
//			array.add(token.get(i));
//		}
//
//		body.put("registration_ids", array);
//
//		JSONObject notification = new JSONObject();
//		notification.put("title",title);
//		notification.put("body", content);
//		System.out.println("서비스인코딩:"+title);
//		body.put("notification", notification);
//
//		System.out.println(body.toString());
//
//		String result = body.toString();
//
//		HttpEntity<String> entity = new HttpEntity<>(result);
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//
//		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + firebase_server_key));
//		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json;"));
//		restTemplate.setInterceptors(interceptors);
//
//		String firebaseResponse = restTemplate.postForObject(firebase_api_url, entity, String.class);
//
//		CompletableFuture<String> pushNotification = CompletableFuture.completedFuture(firebaseResponse);
//
//		CompletableFuture.allOf(pushNotification).join();
//
//	}

	@Override
	public void appPush(ArrayList<String> token, String title, String content) {

		try {
			URL url = new URL(firebase_api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "key=" + firebase_server_key);

			conn.setDoOutput(true);

			JSONObject notification = new JSONObject();
			JSONObject body = new JSONObject();

			notification.put("title", title);
			notification.put("body", content);

			body.put("notification", notification);
			body.put("registration_ids", token);
			OutputStream os = conn.getOutputStream();

			// 서버에서 날려서 한글 깨지는 사람은 아래처럼 UTF-8로 인코딩해서 날려주자
			os.write(body.toString().getBytes("UTF-8"));
			os.flush();
			os.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
