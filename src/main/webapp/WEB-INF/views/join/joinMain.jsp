<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="resources/css/join/registerform.css" />

<%-- 일반 사용자/판매자 선택하는 페이지 시작 --%>
<div class="container">
	<div class="register">
		<div class="cus" style="text-align: center;">
			<p id="nregister">일반 사용자 회원가입</p>
		</div>

		<div class="sel" style="text-align: center;">
			<p id="sregister">판매자 회원가입</p>
		</div>
	</div>
</div>
<%-- 일반 사용자/판매자 선택하는 페이지 끝 --%>

<script src='resources/js/join/register.js'></script>
<%@include file="../include/footer.jsp"%>