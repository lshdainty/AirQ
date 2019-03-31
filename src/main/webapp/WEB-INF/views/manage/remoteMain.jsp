<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/manage/remoteMain.css" />
	<h1>IOT원격제어 서비스 페이지입니다.</h1>
	<div class="container2">
       <div class="switch">
        <div class="local">
            창문 원격제어 <br/> 위치: 베란다
        </div>
        <div class="on_off">
            <label class="rocker rocker-small">
                <input type="checkbox">
                <span class="switch-left">Yes</span>
                <span class="switch-right">No</span>
            </label>
  
            <label class="rocker rocker-small">
                <input type="checkbox">
                <span class="switch-left">자동</span>
                <span class="switch-right">수동</span>
            </label>
        </div>
        </div><br/>
        
        <div class="switch">
        <div class="local">
            보일러 원격제어 <br/> 위치: 보일러실
        </div>
        <div class="on_off">
            <label class="rocker rocker-small">
                <input type="checkbox">
                <span class="switch-left">Yes</span>
                <span class="switch-right">No</span>
            </label>
  
            <label class="rocker rocker-small">
                <input type="checkbox">
                <span class="switch-left">자동</span>
                <span class="switch-right">수동</span>
            </label>
        </div>
        </div><br/>
        
        <div class="switch">
        <div class="local">
            공기청정기 원격제어 <br/> 위치: 거실
        </div>
        <div class="on_off">
            <label class="rocker rocker-small">
                <input type="checkbox">
                <span class="switch-left">Yes</span>
                <span class="switch-right">No</span>
            </label>
  
            <label class="rocker rocker-small">
                <input type="checkbox">
                <span class="switch-left">자동</span>
                <span class="switch-right">수동</span>
            </label>
        </div>
        </div><br/>
        <button id="btn-reg">IoT 제품 제어 등록</button>
    </div>
<%@include file="../include/footer.jsp" %>