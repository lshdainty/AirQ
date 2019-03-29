<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/resources/css/join/sRegister.css" />
<%-- meta 태그 안에 http-equiv는 파일 업로드 할때 필요함 --%>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">

<%-- 판매자 회원가입 페이지 시작 --%>
<div class="container">
		<div class="login-main-text">
			<h1>Join Page</h1>
			<p>판매자 회원가입을 선택하셨습니다 :)</p>
		</div>
		<section class="content">
			<div class="join">
				<div class="join-form">
					<div class="form">
						<h1>회원가입</h1>
						<input id="id" type="text" placeholder="ID">
						<p class="result">
							<span class="msg">테스트 중..</span>
						</p><br />
						<input id="password" type="text" placeholder="Password"><br/><br/>
						<input id="name" type="text" placeholder="Name"><br/><br/>
						<input id="email" type="text" placeholder="E-mail"><br/><br/>
						<input id="tel" type="text" placeholder="Tel"><br/><br/>
                        <input id="address" type="text" placeholder="Address"><br/><br/>
                        <input id="bnumber" type="text" placeholder="사업자 등록 번호"><br/><br/>
						<a id="btn-check">ID중복 확인</a><br>
						<!-- enctype="multipart/form-data" 파일업로드 필수 옵션 -->
						<!-- application/x-www-form-urlencoded 기본옵션 -->
						<form action="${Path }/upload/uploadForm" method="post" enctype="multipart/form-data">
							<input type="file" name="file">
							<button type="submit" id="btn-join" disabled="disabled">JOIN</button>
						</form>
					</div>
				</div>
			</div>
		</section>
		<%-- 판매회원 목록 시작 --%>
 		<c:forEach var="sl" items="${sellerlist }">
			<p>회원 ID: ${sl.id }</p>
			<p>회원 PW: ${sl.password }</p>
			<p>회원 이름: ${sl.name }</p>
			<p>회원 이메일: ${sl.email }</p>
			<p>회원 휴대폰 번호: ${sl.tel }</p>
			<p>회원 주소: ${sl.address }</p>
		=============================
		</c:forEach>
		<%-- 판매회원 목록 끝 --%>
	</div>
<%-- 판매자 회원가입 페이지 끝 --%>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/join/register1.js'></script>