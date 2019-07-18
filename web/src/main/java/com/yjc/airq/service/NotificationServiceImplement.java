package com.yjc.airq.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yjc.airq.interceptor.HeaderRequestInterceptor;
import com.yjc.airq.mapper.AreaMapper;
import com.yjc.airq.mapper.BidMapper;
import com.yjc.airq.mapper.CompanyMapper;
import com.yjc.airq.mapper.DemandMapper;
import com.yjc.airq.mapper.MatterMapper;
import com.yjc.airq.mapper.MemberMapper;
import com.yjc.airq.mapper.PaymentMapper;
import com.yjc.airq.mapper.ProductMapper;
import com.yjc.airq.mapper.ReplyMapper;
import com.yjc.airq.mapper.TenderMapper;
import com.yjc.airq.mapper.UploadMapper;

import lombok.AllArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Service
@AllArgsConstructor
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
	public String periodicNotificationJson(ArrayList<String> token,String title,String content) {


        JSONObject body = new JSONObject();

        JSONArray array = new JSONArray();

        for(int i=0; i<token.size(); i++) {
            array.add(token.get(i));
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
		return matterMapper.alarm_time(iot_id, matter_code);
	}

	@Override
	public void setAlarmTime(String iot_id, String matter_code) {
		// TODO Auto-generated method stub
		matterMapper.alarm_time_update(iot_id, matter_code);
	}

	
}
