<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/join/nRegister.css" />
	
<%--일반 사용자 회원가입 시작 --%>
<form>

	<h1>Sign Up</h1>

	<fieldset>
		<legend>Your basic info</legend>

		<label for="id">ID:</label><input type="text" id="id" name="id">
		<a id="btn-check">ID중복 확인</a><br/>
		<p class="result"><span class="msg">테스트 중..</span>
		
		<label for="password">Password:</label><input type="text" id="password" name="password">
		
		<label for="name">Name:</label><input type="text" id="name" name="name">
		
		<label for="email">E-mail:</label><input type="text" id="email" name="email">
		
		<label for="tel">Tel:</label><input type="text" id="tel" name="tel"><label for="address">Address:</label>
		
		<input type="text" id="address" name="address">
	</fieldset>
	<button type="submit" id="btn-join" disabled="disabled">Sign Up</button>
</form>
<%--일반 사용자 회원가입 끝 --%>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src='resources/js/join/register2.js'></script>
<%@include file="../include/footer.jsp" %>