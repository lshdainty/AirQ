<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/resources/css/join/nRegister.css" />
	
<%--일반 사용자 회원가입 시작 --%>
<div class="container">
	<div class="login-main-text">
		<h1>Join Page</h1>
		<p>일반 회원가입을 선택하셨습니다 :)</p>
	</div>
	<section class="content">
		<main>
		<div class="join">
			<div class="join-form">
				<form>
					<div class="form">
						<h1>회원가입</h1>
						<input id="id" type="text" placeholder="ID">
						<p class="result">
							<span class="msg">테스트 중..</span>
						</p><br />
						<input id="password" type="text" placeholder="Password"><br /><br />
						<input id="name" type="text" placeholder="Name"><br /><br />
						<input id="email" type="text" placeholder="E-mail"><br /><br />
						<input id="tel" type="text" placeholder="Tel"><br /><br />
						<input id="address" type="text" placeholder="Address"><br /><br />
						<a id="btn-check">ID중복 확인</a>
						<button type="submit" id="btn-join" disabled="disabled">JOIN</button>
					</div>
				</form>
			</div>
		</div>
		</main>
	</section>
	<%--일반 사용자 목록 시작 --%>
	<c:forEach var="ml" items="${memberlist }">
		<p>회원 ID: ${ml.id }</p>
		<p>회원 PW: ${ml.password }</p>
		<p>회원 이름: ${ml.name }</p>
		<p>회원 이메일: ${ml.email }</p>
		<p>회원 휴대폰 번호: ${ml.tel }</p>
		<p>회원 주소: ${ml.address }</p>
	=============================
	</c:forEach>
	<%--일반 사용자 목록 끝 --%>
</div>
<%--일반 사용자 회원가입 끝 --%>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/join/register1.js'></script>