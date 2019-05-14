<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/resources/css/join/sRegister.css" />
<%@include file="../include/header.jsp" %>
<%-- meta 태그 안에 http-equiv는 파일 업로드 할때 필요함 --%>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">

<%-- 판매자 회원가입 페이지 시작 --%>
<form action="Bsignup" method="post" enctype="multipart/form-data">
	<h1>Sign Up</h1>
		<fieldset>
          <legend><span class="number">1</span>판매자 회원가입</legend>
        </fieldset>

		<label for="id">ID</label>
		<input type="text" id="id" name="Member_id" required autocomplete="off">
		<a id="btn-check">ID중복 확인</a>
		<a class="result"><span class="msg" style="display:none">테스트 중..</span><br/><br/>
		
		<label for="password">Password</label>
		<input type="text" id="password" name="Member_pw" required autocomplete="off">
		
		<label for="name">Name</label>
		<input type="text" id="name" name="Member_name" required autocomplete="off">
		
		<label for="tel">Tel</label>
		<input type="text" id="tel" name="Member_tel" required autocomplete="off">
		
		<label for="email">E-mail</label>
		<input type="email" id="email" name="Member_email" required autocomplete="off">
		
<!-- 		<label for="address">Address:</label>
		<input type="text" id="address" name="address" required autocomplete="off"> -->
		
		<label for="tel">Business Number</label>
		<input type="text" id="company_code" name="company_code" required autocomplete="off"><br/><br/>
		<!-- enctype="multipart/form-data" 파일업로드 필수 옵션 -->
		<!-- application/x-www-form-urlencoded 기본옵션 -->
			<!-- <input type="file" name="file"> -->
		
		 <fieldset>
          <legend><span class="number">2</span>추가 정보 입력</legend>
        </fieldset>
        
        <label for="c_name">Company Name</label>
		<input type="text" id="company_name" name="company_name" required autocomplete="off">
		
		<label for="c_tel">Company Tel</label>
		<input type="text" id="company_tel" name="company_tel" required autocomplete="off">		
		
			<button type="submit" id="btn-join" disabled="disabled">JOIN</button>
		</form>
<%-- 판매자 회원가입 페이지 끝 --%>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src='resources/js/join/register1.js'></script>
<%@include file="../include/footer.jsp" %>