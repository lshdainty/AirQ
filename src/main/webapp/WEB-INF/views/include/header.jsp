<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
	<%-- Chart.js cdn 끝 --%>
	
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color: #e3f2fd;">
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
					<li class="nav-item active"><a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link" href="/introMain">서비스 소개</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="dropdown06"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">업체연결 서비스</a>
						<div class="dropdown-menu" aria-labelledby="dropdown06">
							<a class="dropdown-item" href="/compareMain?pagenum=1&contentnum=10">업체 분석/비교</a> 
							<a class="dropdown-item" href="/tenderMain">입찰 서비스</a> 
						</div>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="dropdown07"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">커뮤니티</a>
						<div class="dropdown-menu" aria-labelledby="dropdown07">
							<a class="dropdown-item" href="/recommendMain">상품추천</a> 
							<a class="dropdown-item" href="/libertyMain">자유게시판</a> 
							<a class="dropdown-item" href="/metterMain">대기오염 물질정보</a>
							<a class="dropdown-item" href="/improveMain">공기질 향상방법</a>
							<a class="dropdown-item" href="/healthMain">건강 지킴이</a>
						</div>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" id="dropdown08"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">공기질 관리</a>
						<div class="dropdown-menu" aria-labelledby="dropdown08">
							<a class="dropdown-item" href="/monitoringMain">공기질 모니터링</a> 
							<a class="dropdown-item" href="/remoteMain">IOT 원격제어</a>
						</div>
					</li>
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
						<li class="nav-item"><a class="nav-link" href="/logout">LOGOUT</a></li>
						<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" id="dropdown09"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">마이페이지</a>
						<div class="dropdown-menu" aria-labelledby="dropdown09">
							<a class="dropdown-item" href="/mypageMain">mypage</a>
							<a class="dropdown-item" href="/mypageMainCategory">카테고리관리</a>
							<a class="dropdown-item" href="/mypageMainPosts">글 관리</a>
							<a class="dropdown-item" href="/mypageMainComment">댓글 관리</a>
							<a class="dropdown-item" href="/mypageMainMember">회원 관리</a>
						</div>
						 </li>
					</c:if>
            	</ul>
            <%-- 오른쪽 메뉴 끝  --%>
			</div>
		</div>
	</nav>
	<div id="content">