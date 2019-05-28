<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/mypage/mypageNormal.css" />
<h1 id="h1">일반 사용자-메인 페이지 입니다.</h1>
<button id="btn">button</button>

<div class="reviewCompareList">
	<div class="reviewPost">
		<div class="compareThumb">
			<img src="resources/images/800490.png" alt="이미지">
		</div>
		<div class="reviewInfo">
			<div class="compareTitle">
				<span>에어체크업 방문측정</span>
			</div>
			<div class="compareContent">
				측정 평수 : <span>ㅇㅇ</span><br/>
				측정 지점 : <span>ㅇㅇ</span><br/>
				측정 물질 : <span>ㅇㅇ</span><br/>
				서비스 받은 날짜 : <span>ㅇㅇ</span>
			</div>
			<div class="comparePrice">
				<span>dd</span>
			</div>
		</div>
	</div>
</div>
<script src='/resources/js/mypage/mypageNormal.js'></script>
<%@include file="../include/footer.jsp"%>