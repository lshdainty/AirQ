<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/resources/css/join/sRegister.css" />
<%@include file="../include/header.jsp" %>
<%-- meta 태그 안에 http-equiv는 파일 업로드 할때 필요함 --%>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">

<%-- 판매자 회원가입 페이지 시작 --%>
<form action="/upload" method="post" enctype="multipart/form-data">
	<h1>Sign Up</h1>
		<legend>판매자 회원가입</legend>

		<label for="id">ID:</label>
		<input type="text" id="id" name="id" required autocomplete="off">
		<a id="btn-check">ID중복 확인</a><br/>
		<p class="result"><span class="msg">테스트 중..</span><br/>
		
		<label for="password">Password:</label>
		<input type="text" id="password" name="password" required autocomplete="off">
		
		<label for="name">Name:</label>
		<input type="text" id="name" name="name" required autocomplete="off">
		
		<label for="email">E-mail:</label>
		<input type="text" id="email" name="email" required autocomplete="off">
		
		<label for="tel">Tel:</label>
		<input type="text" id="tel" name="tel" required autocomplete="off">
		
		<label for="address">Address:</label>
		<input type="text" id="address" name="address" required autocomplete="off">
		
		<label for="tel">Business Number:</label>
		<input type="text" id="bnumber" required autocomplete="off"><br/><br/>
		<!-- enctype="multipart/form-data" 파일업로드 필수 옵션 -->
		<!-- application/x-www-form-urlencoded 기본옵션 -->
			<input type="file" name="file">
			<button type="submit" id="btn-join" disabled="disabled">JOIN</button>
		</form>
<%-- 판매자 회원가입 페이지 끝 --%>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src='resources/js/join/register1.js'></script>
<%@include file="../include/footer.jsp" %>