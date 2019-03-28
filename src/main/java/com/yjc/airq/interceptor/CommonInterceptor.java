package com.yjc.airq.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			System.out.println("로그인 interceptor 걸림");
			response.sendRedirect("/loginMain");
			return false;
		}
		else {
			System.out.println("로그인 interceptor 안걸림");
			return true;
		}
	}
}