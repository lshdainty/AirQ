<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/login/findPw.css" />

<div class="container">

	<section class="content">
		<main> <%-- 등록된 이름+  전화번호 or 이메일로  pw 찾기 시작 --%>
		<div class="login-form">
			<div class="form-group">

				<label>User Name</label>  
				<input type="text" id="name" class="form-control-1"placeholder="User Name"> <br>
				 <label>User Id</label>             
				 <input type="text"id="id" class="form-control-1" placeholder="User ID"> <br>
				<label>전화번호 또는 이메일을 선택해 입력해주세요.</label><br>
				<ul class="tree">
					<li><input type="checkbox" id="root">
					 <label for="root">등록된 전화번호로 찾기</label><br>
						<ul>
							<li>  <input type="text" id="tel" name="member_tel" class="form-control-1"placeholder="Phone Number"><br></li>
						</ul></li>
				</ul>
				<ul class="tree2">
					<li><input type="checkbox" id="root2"> 
					<label for="root2">등록된 이메일로 찾기</label><br>
						<ul>
							<li> <input type="text" id="email" name="member_email" class="form-control-1"placeholder="e-mail"> <br></li>
						</ul></li>
				</ul>
			</div>
			<button type="submit" id="findpwtest" class="btn btn-login">확인</button>
		</div>
		<%-- 등록된 이름+  전화번호 or 이메일로  pw 찾기 끝 --%> </main>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='/resources/js/login/findPw.js'></script>
<%@include file="../include/footer.jsp"%>
