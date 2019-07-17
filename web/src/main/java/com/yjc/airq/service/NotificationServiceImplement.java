package com.yjc.airq.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yjc.airq.interceptor.HeaderRequestInterceptor;
import com.yjc.airq.mapper.MatterMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Service
public class NotificationServiceImplement implements NotificationService {
	
	private MatterMapper matterMapper; 
	

	private static final String firebase_server_key = "AAAAr1R79uM:APA91bGMeRAH4gvbtW9gKnlrm4-XPGpX9EeAP_UprCGQj25L1J2hyOGe2nJu48oV8TtJHNdwX7cVbuB4e0UPN7xY1efGIR43yxuA699jFiVhADTf_X15YfBa0cCXTB4h49aaIkhrZOCf";
	private static final String firebase_api_url="https://fcm.googleapis.com/fcm/send";
	
	@Override
	public CompletableFuture<String> send(HttpEntity<String> entity) {

		RestTemplate restTemplate = new RestTemplate();

		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + firebase_server_key));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json; UTF-8 "));
		restTemplate.setInterceptors(interceptors);

		String firebaseResponse = restTemplate.postForObject(firebase_api_url, entity, String.class);

		return CompletableFuture.completedFuture(firebaseResponse);
	}

	@Override
	public String periodicNotificationJson(String[] token,String title,String content) {

        String sampleData[] = token;

        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();

        for(int i=0; i<sampleData.length; i++){
            tokenlist.add(sampleData[i]);
        }

        JSONArray array = new JSONArray();

        for(int i=0; i<tokenlist.size(); i++) {
            array.add(tokenlist.get(i));
        }

        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();
        notification.put("title",title);
        notification.put("body",content);

        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
	}


	@Override
	public String getAlarmTime(String iot_id, String matter_code) {
		// TODO Auto-generated method stub
		
		
		
		return matterMapper.getAlarmTime(iot_id, matter_code);
	}
}
