package com.yjc.airq.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;


public interface NotificationService {

	public CompletableFuture<String> send(HttpEntity<String> entity);
	public String periodicNotificationJson(String[] token,String title,String content);
}
