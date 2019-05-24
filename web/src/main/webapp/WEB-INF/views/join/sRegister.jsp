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
		
		<label>우편번호</label>
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sample4_postcode" name="m_zipcode" placeholder="우편번호">
		<input type="text" id="sample4_roadAddress" name="m_road_addr" placeholder="도로명주소"><br>
		<input type="text" id="sample4_jibunAddress" name="m_addr" placeholder="지번주소">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" name="m_addr_detail" placeholder="상세주소">
		<input type="text" id="sample4_extraAddress" placeholder="참고항목">
		
<!-- 		<label for="address">Address:</label>
		<input type="text" id="address" name="address" required autocomplete="off"> -->
		<!-- enctype="multipart/form-data" 파일업로드 필수 옵션 -->
		<!-- application/x-www-form-urlencoded 기본옵션 -->
			<!-- <input type="file" name="file"> -->
		
		 <fieldset>
          <legend><span class="number">2</span>추가 정보 입력</legend>
        </fieldset>
        
        <label for="tel">Business Number</label>
		<input type="text" id="company_code" name="company_code" required autocomplete="off">
        
        <label for="c_name">Company Name</label>
		<input type="text" id="company_name" name="company_name" required autocomplete="off">
		
		<label for="c_tel">Company Tel</label>
		<input type="text" id="company_tel" name="company_tel" required autocomplete="off">		
		
		<label for="c_email">Company E-mail</label>
		<input type="email" id="company_email" name="company_email" required autocomplete="off">	
		
		<label>회사 우편번호</label>
		<input type="button" onclick="sampleC_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="sampleC_postcode" name="c_zipcode" placeholder="우편번호">
		<input type="text" id="sampleC_roadAddress" name="c_road_addr" placeholder="도로명주소"><br>
		<input type="text" id="sampleC_jibunAddress" name="c_addr" placeholder="지번주소">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sampleC_detailAddress" name="c_addr_detail" placeholder="상세주소">
		<input type="text" id="sampleC_extraAddress" placeholder="참고항목">
		
			<button type="submit" id="btn-join" disabled="disabled">JOIN</button>
		</form>
<%-- 판매자 회원가입 페이지 끝 --%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src='resources/js/join/register1.js'></script>
<%@include file="../include/footer.jsp" %>