package com.yjc.airq.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;


public interface NotificationService {

	public CompletableFuture<String> send(HttpEntity<String> entity);
	public String periodicNotificationJson(ArrayList<String> token,String title,String content);
	public String getAlarmTime(String iot_id,String matter_code);
	public void setAlarmTime(String iot_id,String matter_code);
	public String getToken(String id);
	public void setToken(String id,String token);
}
