package com.yjc.airq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebSocketController {

	@RequestMapping(value = "/WebSocketServer", method = RequestMethod.GET)
	public String tenderWrite() throws Exception {

		System.out.println("WebSocketController 넘어옴");

		return "WebSocket/WebSocketServer";
	}

}