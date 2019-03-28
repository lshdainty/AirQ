<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/login/findid.css" />
<div class="container">
	
	<section class="content">
		<main>
		<%-- 등록된 이름+ 전화번호 or 이메일로 id 찾기 시작 --%>
		<div class="login-form">
			<div class="form-group">
 
					<input type="text" id="name"class="form-control-1" placeholder="User Name"> <br> 
									<label>등록된 전화번호로 찾기</label><br>
					<input type="text" id="tel"class="form-control-1" placeholder="Pone Number"><br> 
					<label>등록된 이메일로 찾기</label><br> 
					<input type="text" id="email"class="form-control-1" placeholder="e-mail"> <br>
			</div>
		
			<button type="submit" id="findidtest"class="btn btn-login">확인</button>
		</div>
		<%-- 등록된 전화번호, 이메일로 id 찾기 끝 --%>
		</main>
		<nav></nav>
		<aside></aside>
		<footer>
			<%-- 아아디찾기,비밀번호찾기,회원가입 링크 시작부분 --%>
			<div class="submit-wrap">

				<a href="findid" class="btn btn-id">아이디 찾기</a> 
				<a href="findpw" class="btn btn-pw">비밀번호 찾기</a> 
				<a href="register" class="btn btn-register">회원가입</a>
			</div>
			<%-- 아아디찾기,비밀번호찾기,회원가입 링크 끝부분 --%>	
		</footer>
	</section>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='${pageContext.request.contextPath}/resources/js/login/findid.js'></script>
<%@include file="../include/footer.jsp"%>
