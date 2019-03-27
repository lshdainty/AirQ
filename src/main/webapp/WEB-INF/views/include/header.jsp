<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AirQ</title>
<link rel="stylesheet" type="text/css" href="resources/css/include/header.css">
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">

		<!-- nav header 시작  -->
		<div class="navbar-header">

			<!-- 768px 미만 해상도 마이페이지  -->
			<button type="button" class="navbar-toggle collapsed "
				data-toggle="collapse" data-target="#nav-mainMenu"
				aria-expanded="false">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

			<!-- 768px 미만 해상도 로그인  -->
			<button type="button" class="navbar-toggle collapsed "
				data-toggle="collapse" data-target="#access" aria-expanded="false"
				id="button-access" style="float: left">
				<span class="glyphicon glyphicon-user"></span>
			</button>

			<!-- 768px 미만 해상도 메뉴  -->
			<button type="button" class="navbar-toggle collapsed "
				data-toggle="collapse" data-target="#myPage" aria-expanded="false"
				id="button-myPage" style="float: left">
				<span class="glyphicon glyphicon-user"></span>
			</button>
			<!-- 786px 해상도 미만 아이콘 끝  -->


			<!-- 웹 네비게이션 시작  -->
			<a class="navbar-brand">AirQ</a>
		</div>
		<!-- nav header 끝  -->

		<!-- 웹 메뉴 시작  -->
		<div class="collapse navbar-collapse nav-buttons" id="nav-mainMenu">
			<ul class="nav navbar-nav" style="width: 100%;">
				<li class="active"><a href="/">Home<span class="sr-only"></span></a></li>
				<li><a href="introMain">서비스소개</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">업체연결서비스<span class="caret"></span>
				</a>
					<ul class="dropdown-menu">

						<!-- 업체연결 드랍다운 메뉴 시작  -->
						<li><a href="compareMain">업체 분석/비교</a></li>
						<li><a href="tenderMain">입찰</a></li>
						<!-- 커뮤니티 드랍다운 메뉴 끝  -->
						
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">커뮤니티<span class="caret"></span></a>
					<ul class="dropdown-menu">
					
						<!-- 커뮤니티 드랍다운 메뉴 시작  -->
						<li><a href="recommendMain">상품추천</a></li>
						<li><a href="libertyMain">자유게시판</a></li>
						<li><a href="metterMain">대기오염 물질</a></li>
						<li><a href="improveMain">공기질 향상 방법</a></li>
						<li><a href="healthMain">건강 지킴이</a></li>
						<!-- 커뮤니티 드랍다운 메뉴 끝  -->
						
					</ul></li>

				<!-- 마이페이지 시작 -->
				<li class="dropdown" id="menu-right"><a href=" #"
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">마이페이지<span
						class="caret"></span></a>
					<ul class="dropdown-menu">

						<!-- 접속하기 드랍다운 메뉴 시작  -->
						<li><a href="mypageMain">마이페이지</a></li>
						<li><a href="#">글관리</a></li>
						<li><a href="#">댓글관리</a></li>
						<li><a href="#">회원관리</a></li>
						<li><a href="#">카테고리관리</a></li>
						<!-- 접속하기 드랍다운 메뉴 끝  -->

					</ul></li>
				<!-- 접속하기 끝 -->
				
				<!-- 접속하기 시작 -->
				<li class="dropdown" id="menu-right"><a href=" #"
					class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expanded="false">접속하기<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<!-- 접속하기 드랍다운 메뉴 시작  -->
						<c:if test="${session.user == null }">
							<li><a href="loginMain">로그인</a></li>
						</c:if>
						<c:if test="${session.user }">
							<li><a href="logout">로그아웃</a></li>
						</c:if>
						<li><a href="joinMain">회원가입</a></li>
						<!-- 접속하기 드랍다운 메뉴 끝  -->
					</ul></li>
				<!-- 접속하기 끝 -->
				
				<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">공기질 관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
					
						<!-- 공기질 드랍다운 메뉴 시작  -->
						<li><a href="monitoringMain">공기질 모니터링</a></li>
						<li><a href="remoteMain">IOT 원격제어</a></li>
						<!-- 공기질 드랍다운 메뉴 끝  -->
						
					</ul>
				</li>
			</ul>
		</div>
		<!-- 웹 메뉴 끝  -->
		
		<div class="collapse navbar-collapse" id="myPage" class="nav-buttons">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="mypageMain">마이페이지</a></li>
				<li><a href="#">글관리</a></li>
				<li><a href="#">댓글관리</a></li>
				<li><a href="#">회원관리</a></li>
				<li><a href="#">카테고리관리</a></li>
			</ul>
		</div>
		<div class="collapse navbar-collapse" id="access" class="nav-buttons">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="mypageMain">마이페이지</a></li>
				<li><a href="#">내가쓴글</a></li>
			</ul>
		</div>
	</div>
</nav>
	<div id="content">