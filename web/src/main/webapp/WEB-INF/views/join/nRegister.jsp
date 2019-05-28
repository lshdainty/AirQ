<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/join/nRegister.css" />

<%--일반 사용자 회원가입 시작 --%>
<div class="form">
	<div class="tab-content">
		<div id="signup">
			<form action="signup" method="POST">
				<h1>Sign Up</h1>
				<legend>일반 사용자 회원가입</legend>
				<div class="top-row">
					<div class="field-wrap">
						<label>ID</label>
						<input type="text" id="id" name="Member_id" required autocomplete="off" />
						
						<a id="btn-check">ID중복 확인</a>
						<a class="result">
						<span class="msg" style="display:none">테스트 중..</span><br/><br/>
					</div>

					<div class="field-wrap">
						<label>Password</label>
						<input type="password" id="password" name="Member_pw" required autocomplete="off" />
					</div>
				</div>

				<div class="field-wrap">
					<label>Name</label>
					<input type="text" id="name" name="Member_name" required autocomplete="off" />
				</div>

				<div class="field-wrap">
					<label>Tel</label>
					<input type="text" id="tel" name="Member_tel" required autocomplete="off" />
				</div>

				<div class="field-wrap">
					<label>E-mail</label>
					<input type="email" id="email" name="Member_email" required autocomplete="off" />
				</div>
				
				<div class="field-wrap">
					<label>우편번호</label>
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="sample4_postcode" name="m_zipcode" placeholder="우편번호">
					<input type="text" id="sample4_roadAddress" name="m_road_addr" placeholder="도로명주소"><br>
					<input type="text" id="sample4_jibunAddress" name="m_addr" placeholder="지번주소">
					<span id="guide" style="color:#999;display:none"></span>
					<input type="text" id="sample4_detailAddress" name="m_addr_detail" placeholder="상세주소">
					<input type="text" id="sample4_extraAddress" placeholder="참고항목">
				</div>

				<!--<div class="field-wrap">
            <label>
              Address<span class="req">*</span>
            </label>
            <input type="text" id="address" name="address" required autocomplete="off"/>
          </div> -->

				<button type="submit" id="btn-join" disabled="disabled">JOIN</button>

			</form>
		</div><!-- signup -->
	</div><!-- tab-content -->
</div>
<!-- /form -->
<%--일반 사용자 회원가입 끝 --%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src='resources/js/join/register2.js'></script>
<%@include file="../include/footer.jsp"%>