<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/login/loginMain.css"/>
	<c:if test="${sessionScope.user == null }">
	<div class="container">
		<section class="content">
			<main>
			<%-- 로그인 비밀번호 작성 시작부분 --%>
				<div class="login-form">
						<div class="form-group">
						<label>User ID</label> <input type="text" id="id" class="form-control-1" placeholder="User ID">
						</div>
						<p class="txt_message" >
                       		<span id="noid"class="msg" >없는 아이디 입니다. </span>
                     	</p>	
						<div class="form-group">
						<label>Password</label> <input type="password" id="pw" class="form-control-2" placeholder="Password">
						</div>
						<p class="txt_message" >
                       		<span id="nopw"class="msg" >틀린 비밀번호 입니다. </span>
                     	</p>
						<button type="submit" id="logintest" class="btn btn-login">로그인</button><br>
						<input type="checkbox" id="remember"class="loginCheckbox" checked>
						<label for="remember">Remember me</label>	
				</div>
			<%-- 로그인 비밀번호 작성 끝부분 --%>
			</main>
			<nav></nav>
			<aside></aside>
			
			<footer>
				<%-- 아아디찾기,비밀번호찾기,회원가입 링크 시작부분 --%>
				<div class="submit-wrap">

					<a href="findId" class="btn btn-id">아이디 찾기</a> 
					<a href="findPw" class="btn btn-pw">비밀번호 찾기</a> 
					<a href="joinMain" class="btn btn-register">회원가입</a>
				</div>
			<%-- 아아디찾기,비밀번호찾기,회원가입 링크 끝부분 --%>
			</footer>
		</section>
	</div>
	
	</c:if>

	<c:if test="${sessionScope.user != null}">
		<a href="logout">logout</a>
	</c:if>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='/resources/js/login/loginMain.js'></script>
<%@include file="../include/footer.jsp" %>