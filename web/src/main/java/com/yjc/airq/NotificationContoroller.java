package com.yjc.airq;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.service.NotificationService;

import lombok.AllArgsConstructor;



@Controller
@AllArgsConstructor
public class NotificationContoroller {

	NotificationService notificationService;
	
	@ResponseBody
	@RequestMapping(value = "/appPush", method = RequestMethod.POST)
	public ResponseEntity<String> appPush(HttpServletRequest request) {
		System.out.println("FCM TEST");
//		String[] token = (String[]) request.getAttribute("token");
//		String[] token = {"cztdXKTuE-o:APA91bH_zMpK-xShmgWoPhUwshR4ITf4cTumdoMAysXhh3HxCfUU5w4ZqUxRpKOR5LVJozMsXpIBmjQpaxqMfuVR3zZ4_Yd9XGI-IuNZIw8zBUSkSXJFvUjy1q35U3sBkRc6Yc9BPZ3S"};
		ArrayList<String> token = new ArrayList<String> ();
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
		String title = "title";
		String content = "content";
		String memberToken = notificationService.getToken("kimminsu");
		System.out.println("MEMBER TOKEN : "+memberToken);
		token.add(notificationService.getToken("kimminsu"));
		
		notificationService.appPush(token,title,content);
//		String notifications = notificationService.periodicNotificationJson(token,title,content);
//
//        HttpEntity<String> entity = new HttpEntity<>(notifications);
//
//        CompletableFuture<String> pushNotification = notificationService.send(entity);
//        CompletableFuture.allOf(pushNotification).join();
//
//        try{
//            String firebaseResponse = pushNotification.get();
//            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
//        }
//        catch (InterruptedException e){
//        }
//        catch (ExecutionException e){
//        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	}

}
