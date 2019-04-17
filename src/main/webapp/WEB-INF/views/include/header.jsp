<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AirQ</title>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/include/header.css">
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.js"></script>
<%-- Chart.js cdn 시작 --%>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
<%-- Chart.js cdn 끝 --%>

</head>
<body>
	<nav class="navbar navbar-expand-lg fixed-top text-white navbar-dark"
		style="background-image: linear-gradient(94deg, #1ea1f7, #46cfa7);">
		<div class="container">
			<%--모바일 화면 버튼 시작 --%>
			<a class="navbar-brand" href="#">AirQ</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExample07" aria-controls="navbarsExample07"
				aria-expanded="false" aria-label="Toggle navigatvion">
				<span class="navbar-toggler-icon"></span>
			</button>
			<%-- 모바일 화면 버튼 끝  --%>

			<%-- 웹 시작  --%>
			<div class="collapse navbar-collapse" id="navbarsExample07">
				<%-- 왼쪽 메뉴 시작  --%>
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/">Home<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link" href="/introMain">서비스
							소개</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="dropdown06"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">업체연결
							서비스</a>
						<div class="dropdown-menu" aria-labelledby="dropdown06">
							<a class="dropdown-item" href="/compareMain">업체 분석/비교</a> <a
								class="dropdown-item" href="/tenderMain">입찰 서비스</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="dropdown07"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">커뮤니티</a>
						<div class="dropdown-menu" aria-labelledby="dropdown07">
							<a class="dropdown-item"
								href="/thumbnailBoardMain?board_code=bd_rec&pagenum=1">상품추천</a>
							<a class="dropdown-item"
								href="tableBoardMain?board_code=bd_lib&pagenum=1">자유게시판</a> <a
								class="dropdown-item"
								href="/thumbnailBoardMain?board_code=bd_met&pagenum=1">대기오염
								물질정보</a> <a class="dropdown-item"
								href="/thumbnailBoardMain?board_code=bd_imp&pagenum=1">공기질
								향상방법</a> <a class="dropdown-item"
								href="/thumbnailBoardMain?board_code=bd_hea&pagenum=1">건강
								지킴이</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="dropdown08"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">공기질
							관리</a>
						<div class="dropdown-menu" aria-labelledby="dropdown08">
							<a class="dropdown-item" href="/monitoringMain">공기질 모니터링</a> <a
								class="dropdown-item" href="/remoteMain">IOT 원격제어</a>
						</div></li>
				</ul>
				<%-- 왼쪽 메뉴 끝  --%>


				<%-- 오른쪽 메뉴 시작  --%>
				<ul class="navbar-nav justify-content-end navbar-nav">

					<%-- 로그인 전 --%>
					<c:if test="${sessionScope.user==null}">
						<li class="nav-item"><a class="nav-link" href="/loginMain">LOGIN</a></li>
						<li class="nav-item"><a class="nav-link" href="/joinMain">회원가입</a></li>
					</c:if>

					<%-- 로그인 후 --%>
					<c:if test="${sessionScope.user!=null }">
						<c:choose>
							<%-- 일반 사용자 로그인 시작 --%>
							<c:when test="${sessionScope.user.member_devision eq 'no' }">
								<li class="nav-item"><a class="nav-link" href="/logout">LOGOUT</a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" id="dropdown09"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">마이페이지</a>

									<div class="dropdown-menu" aria-labelledby="dropdown09">
										<a class="dropdown-item" href="/mypageNormal">MyPage</a> <a
											class="dropdown-item" href="/mypageNormalPosts">글 관리</a> <a
											class="dropdown-item" href="/mypageNormalComment">댓글 관리</a> <a
											class="dropdown-item" href="/mypageNormalPay">결제 내역</a> <a
											class="dropdown-item" href="/mypageNormalDelete">회원 탈퇴</a>
									</div></li>
							</c:when>
							<%-- 일반 사용자 로그인 끝 --%>

							<%-- 판매자 로그인 시작 --%>
							<c:when test="${sessionScope.user.member_devision eq 'se' }">
								<li class="nav-item"><a class="nav-link" href="/logout">LOGOUT</a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" id="dropdown09"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">마이페이지</a>

									<div class="dropdown-menu" aria-labelledby="dropdown09">
										<a class="dropdown-item" href="/mypageSeller">MyPage</a> <a
											class="dropdown-item" href="/mypageSellerPosts">글 관리</a> <a
											class="dropdown-item" href="/mypageSellerComment">댓글 관리</a> <a
											class="dropdown-item" href="/mypageSellerSales">매출 관리</a> <a
											class="dropdown-item" href="/mypageSellerDelete">회원 탈퇴</a>
									</div></li>
							</c:when>
							<%-- 판매자 로그인 끝 --%>

							<%-- 관리자 로그인 시작 --%>
							<c:when test="${sessionScope.user.member_devision eq 'ma' }">
								<li class="nav-item"><a class="nav-link" href="/logout">LOGOUT</a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" id="dropdown09"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">마이페이지</a>

									<div class="dropdown-menu" aria-labelledby="dropdown09">
										<a class="dropdown-item" href="/mypageMain">MyPage</a> <a
											class="dropdown-item" href="/mypageMainPosts">글 관리</a> <a
											class="dropdown-item" href="/mypageMainComment">댓글 관리</a> <a
											class="dropdown-item" href="/mypageMainMember">회원 관리</a> <a
											class="dropdown-item" href="/mypageMainCategory">카테고리 관리</a>
									</div></li>
							</c:when>
							<%-- 관리자 로그인 끝 --%>
						</c:choose>
					</c:if>
				</ul>
				<%-- 오른쪽 메뉴 끝  --%>
			</div>
		</div>
	</nav>
	<div id="content">