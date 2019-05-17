<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/manage/remoteMain.css" />
	<div class="container2">
	
<%-- 	<c:forEach var="myiot" items="${myIot}">
		${myiot.member_id}
		${myiot.model_name}
		${myiot.place_name}
	</c:forEach> --%>
	<c:forEach var="myiot" items="${myIot}">
		<figure>
			<div class="switch">
			
			<%-- 보일러 사진 --%>
			<c:if test="${myiot.model_name eq 'boiler' }">
				<img class="window" src="resources/images/boiler.png" /><br/>
			</c:if>
			
			<%-- 창문 사진 --%>
			<c:if test="${myiot.model_name eq 'window' }">
				<img class="window" src="resources/images/window.png" /><br/>
			</c:if>
			
			<%-- 환풍기 사진 --%>
			<c:if test="${myiot.model_name eq 'ventilator' }">
				<img class="window" src="resources/images/Ventilator.jpg" /><br/>
			</c:if>
			
			<%-- 공기청정기 사진 --%>
			<c:if test="${myiot.model_name eq 'aircleaner' }">
				<img class="window" src="resources/images/airclean.jpg" /><br/>
			</c:if>
			
	        <div class="local">
	           	 ${myiot.model_name } 원격제어 <br/> 위치: ${myiot.place_name}
	        </div>
	        <div class="on_off">
	            <label class="rocker rocker-small">
	                <input type="checkbox">
	                <span class="switch-left">ON</span>
	                <span class="switch-right">OFF</span>
	            </label>
	  
	            <label class="rocker rocker-small">
	                <input type="checkbox">
	                <span class="switch-left">자동</span>
	                <span class="switch-right">수동</span>
	            </label>
	        </div>
	        </div>
        </figure>
	</c:forEach>
		
        
        <!-- <figure>
	        <div class="switch">
	        <img class="boiler" src="resources/images/boiler.png" /><br/>
	        <div class="local">
	     	       보일러 원격제어 <br/> 위치: 보일러실
	        </div>
	        <div class="on_off">
	            <label class="rocker rocker-small">
	                <input type="checkbox">
	                <span class="switch-left">ON</span>
	                <span class="switch-right">OFF</span>
	            </label>
	  
	            <label class="rocker rocker-small">
	                <input type="checkbox">
	                <span class="switch-left">자동</span>
	                <span class="switch-right">수동</span>
	            </label>
	        </div>
	        </div>
        </figure>
        
        <figure>
	        <div class="switch">
	        <img class="airclean" src="resources/images/airclean.jpg" /><br/>
	        <div class="local">
				공기청정기 원격제어 <br/> 위치: 거실
	        </div>
	        <div class="on_off">
	            <label class="rocker rocker-small">
	                <input type="checkbox">
	                <span class="switch-left">ON</span>
	                <span class="switch-right">OFF</span>
	            </label>
	  
	            <label class="rocker rocker-small">
	                <input type="checkbox">
	                <span class="switch-left">자동</span>
	                <span class="switch-right">수동</span>
	            </label>
	        </div>
	        </div>
        </figure> -->
        
        
        <button id="btn-reg">IoT 제품 제어 등록</button>
    </div>
    
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src='resources/js/manage/remoteMain.js'></script>
<%@include file="../include/footer.jsp" %>