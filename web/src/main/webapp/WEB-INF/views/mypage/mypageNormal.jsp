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
	</table>
</div>
<div id="newPost" class="reviewDiv">
	<p class="infoTitle">최신 글</p>
	<table id="newPostTbl" class="reviewTbl">
		<thead>
			<tr>
				<th>게시판 목록</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
			
		</tbody>
	</table>
</div>
<div id="newReply" class="reviewDiv">
	<p class="infoTitle">최신 댓글</p>
	<table id="newReplyTbl" class="reviewTbl">
		<thead>
			<tr>
				<th>게시판 목록</th>
				<th>글제목</th>
				<th>내용</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
</div>
<div id="newPayment" class="reviewDiv">
	<p class="infoTitle">최근 결제 내역</p>
	<table id="newPaymentTbl" class="reviewTbl">
		<thead>
			<tr>
				<th>구분</th>
				<th>제목</th>
				<th>결제일자</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
</div>
<div id="reviewList" class="reviewDiv">
<p class="infoTitle">리뷰 관리</p>
	<ul id="reviewCategory">
		<li id="compare" class="rCategoryOption rOptionActive">업체 연결 서비스</li>
		<li id="tender" class="rCategoryOption">입/투찰 서비스</li>
	</ul>
</div>
<script src='/resources/js/mypage/mypageNormal.js'></script>
<%@include file="../include/footer.jsp"%>