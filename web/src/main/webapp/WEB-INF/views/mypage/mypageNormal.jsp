<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/mypage/mypageNormal.css" />
<h1 id="h1">일반 사용자-메인 페이지 입니다.</h1>
<div id="memberInfo">
	<p class="infoTitle">회원 정보</p>
	<table id="memberInfoTbl">
		<tr>
			<td class="memberIdTd">아이디</td>
			<td class="memberIdTd">kimgoeun</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>김고은</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>01087224235</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>복현동 북2길 5</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>zmxn4235@naver.com</td>
		</tr>
		<tr>
			<td>회원 구분</td>
			<td>일반 사용자</td>
		</tr>
	</table>
</div>
<div id="newPost" class="reviewDiv">
	<p class="infoTitle">최신 글</p>

</div>
<div id="newReply" class="reviewDiv">
	<p class="infoTitle">최신 댓글</p>
</div>
<div id="newPayment" class="reviewDiv">
	<p class="infoTitle">최근 결제 내역</p>
</div>
<div id="reviewList" class="reviewDiv">
	<ul id="reviewCategory">
		<li class="rCategoryOption rOptionActive">업체 연결 서비스</li>
		<li class="rCategoryOption">입/투찰 서비스</li>
	</ul>
</div>
<button id="btn">button</button>
<script src='/resources/js/mypage/mypageNormal.js'></script>
<%@include file="../include/footer.jsp"%>