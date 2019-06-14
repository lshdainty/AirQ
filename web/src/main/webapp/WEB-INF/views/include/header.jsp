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
<script src="/resources/js/include/jquery-3.3.1.min.js"></script>
<script src="/resources/js/include/bootstrap.js"></script>
<script src="/resources/js/include/swiper.js"></script>
<script src="/resources/js/include/navigation_top.js"></script>
<script src="/resources/js/include/TweenLite.js"></script>
<script src="/resources/js/include/TweenMax.js"></script>
<script src="/resources/js/include/animation.js"></script>
<%-- Chart.js cdn 시작 --%>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
<%-- Chart.js cdn 끝 --%>

</head>
<body>
	<!-- top navigation start -->

    <nav class="navbar navbar-expand-lg fixed-top shadow navbar-light bg-white">
        <div class="container-fluid">
            <div class="d-flex align-items-center"><a href="/" class="navbar-brand py-1"><img
                        src="/resources/images/airqWebLogo.png" alt="AirQ" style="height:35px;"></a>
            </div>
            <button type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse"
                aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler navbar-toggler-right"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 30 30" role="img" focusable="false"><title>Menu</title><path stroke="currentColor" stroke-linecap="round" stroke-miterlimit="10" stroke-width="2" d="M4 7h22M4 15h22M4 23h22"></path></svg></button>
            <!-- Navbar Collapse -->
            <div id="navbarCollapse" class="collapse navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a href="/" class="nav-link">HOME</a></li>
                    <li class="nav-item dropdown"><a id="communityDropdownMenuLink" href="#" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle ">

                            업체연결 서비스</a>
                        <div aria-labelledby="connectDropdownMenuLink" class="dropdown-menu dropdown-menu-right">
                            <h6 class="dropdown-header font-weight-normal">개인 사용자</h6>
                            <a href="/compareMain" class="dropdown-item">분석/비교 서비스 </a>
                            <div class="dropdown-divider"></div>


                            <h6 class="dropdown-header font-weight-normal">단체 사용자</h6><a
                                href="/tenderMain" class="dropdown-item">입찰 지원 서비스 </a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                        <a id="communityDropdownMenuLink" href="#" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false" class="nav-link dropdown-toggle ">
                            커뮤니티
                        </a>
                        <div aria-labelledby="communityDropdownMenuLink" class="dropdown-menu dropdown-menu-right">
                            <h6 class="dropdown-header font-weight-normal">상품 게시판</h6>
                            <a href="/thumbnailBoardMain?board_code=bd_rec&pagenum=1" class="dropdown-item">상품추천 </a>
                            <a href="/tableBoardMain?board_code=bd_lib&pagenum=1" class="dropdown-item">자유게시판</a>
                            <div class="dropdown-divider"></div>


                            <h6 class="dropdown-header font-weight-normal">공기 게시판</h6>
                            <a href="/thumbnailBoardMain?board_code=bd_met&pagenum=1" class="dropdown-item">대기오염 물질정보</a>
                            <a href="/thumbnailBoardMain?board_code=bd_imp&pagenum=1" class="dropdown-item">공기질 향상방법</a>
                            <a href="/thumbnailBoardMain?board_code=bd_hea&pagenum=1" class="dropdown-item">건강지킴이</a>
                        </div>
                    </li>
                    
                    <li class="nav-item dropdown">
                        <a id="communityDropdownMenuLink" href="#" data-toggle="dropdown" aria-haspopup="true"
                            aria-expanded="false" class="nav-link dropdown-toggle ">
                            공기질 관리
                        </a>
                        <div aria-labelledby="communityDropdownMenuLink" class="dropdown-menu dropdown-menu-right">
                            <h6 class="dropdown-header font-weight-normal">모니터링</h6>
                            <a href="/monitoringIn" class="dropdown-item">실내 모니터링 </a>
                            <a href="/monitoringOut" class="dropdown-item">실외 모니터링 </a>
                            <div class="dropdown-divider"></div>


                            <h6 class="dropdown-header font-weight-normal">IoT</h6>
                            <a href="/remoteMain" class="dropdown-item">IOT 원격제어</a>
                        </div>
                    </li>
                    
					<c:if test="${sessionScope.user==null}">
                    <li class="nav-item"><a href="/loginMain" class="nav-link">Sign in</a></li>
                    <li class="nav-item"><a href="/joinMain" class="nav-link">Sign up</a></li>
					</c:if>
					
					<c:if test="${sessionScope.user!=null }">
						<c:choose>
							<c:when test="${sessionScope.user.member_devision eq 'no' }">
								<li class="nav-item"><a class="nav-link" href="/logout">LOGOUT</a></li>
								
								<li class="nav-item dropdown">
		                        <a id="communityDropdownMenuLink" href="#" data-toggle="dropdown" aria-haspopup="true"
		                            aria-expanded="false" class="nav-link dropdown-toggle ">
		                            	마이페이지
		                        </a>
			                        <div aria-labelledby="communityDropdownMenuLink" class="dropdown-menu dropdown-menu-right">
			                            <h6 class="dropdown-header font-weight-normal">내 정보</h6>
			                            <a href="/mypageNormal" class="dropdown-item">MyPage</a>
			                            <a href="/mypageNormalPosts" class="dropdown-item">글 관리</a>
			                            <a href="/mypageNormalComment" class="dropdown-item">댓글 관리</a>
			                            <a href="/mypageNormalPay" class="dropdown-item">결제 내역</a>
			                            <a href="/mypageNormalDelete" class="dropdown-item">회원 탈퇴</a>			                            
			                            <div class="dropdown-divider"></div>
			                        </div>
			                    </li>
							</c:when>

							<c:when test="${sessionScope.user.member_devision eq 'se' }">
								<li class="nav-item"><a class="nav-link" href="/logout">LOGOUT</a></li>
								
								<li class="nav-item dropdown">
		                        <a id="communityDropdownMenuLink" href="#" data-toggle="dropdown" aria-haspopup="true"
		                            aria-expanded="false" class="nav-link dropdown-toggle ">
		                            	마이페이지
		                        </a>
			                        <div aria-labelledby="communityDropdownMenuLink" class="dropdown-menu dropdown-menu-right">
			                            <h6 class="dropdown-header font-weight-normal">내 정보</h6>
			                            <a href="/mypageSeller" class="dropdown-item">MyPage</a>
			                            <a href="/mypageSellerPosts" class="dropdown-item">글 관리</a>
			                            <a href="/mypageSellerComment" class="dropdown-item">댓글 관리</a>
			                            <a href="/mypageSellerSales" class="dropdown-item">매출 관리</a>
			                            <a href="/mypageSellerDelete" class="dropdown-item">회원 탈퇴</a>			                            
			                            <div class="dropdown-divider"></div>
			                        </div>
			                    </li>
							</c:when>

							<c:when test="${sessionScope.user.member_devision eq 'ma' }">
								<li class="nav-item"><a class="nav-link" href="/logout">LOGOUT</a></li>
								
								<li class="nav-item dropdown">
		                        <a id="communityDropdownMenuLink" href="#" data-toggle="dropdown" aria-haspopup="true"
		                            aria-expanded="false" class="nav-link dropdown-toggle ">
		                            	마이페이지
		                        </a>
			                        <div aria-labelledby="communityDropdownMenuLink" class="dropdown-menu dropdown-menu-right">
			                            <h6 class="dropdown-header font-weight-normal">내 정보</h6>
			                            <a href="/mypageMain" class="dropdown-item">MyPage</a>
			                            <a href="/mypageMainPosts" class="dropdown-item">신고글 관리</a>
			                            <a href="/mypageMainComment" class="dropdown-item">댓글 관리</a>
			                            <a href="/mypageMainMember" class="dropdown-item">회원 관리</a>
			                            <div class="dropdown-divider"></div>
			                        </div>
			                    </li>
							</c:when>
						</c:choose>
					</c:if>
                </ul>
            </div>
        </div>
    </nav>

    <!--  top navigation end  -->
	<%-- <nav class="navbar navbar-expand-lg fixed-top text-white navbar-dark"
		style="background-image: linear-gradient(94deg, #1ea1f7, #46cfa7);">
		<div class="container">
			모바일 화면 버튼 시작
			<a class="navbar-brand" href="#">AirQ</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExample07" aria-controls="navbarsExample07"
				aria-expanded="false" aria-label="Toggle navigatvion">
				<span class="navbar-toggler-icon"></span>
			</button>
			모바일 화면 버튼 끝 

			웹 시작 
			<div class="collapse navbar-collapse" id="navbarsExample07">
				왼쪽 메뉴 시작 
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
								href="/tableBoardMain?board_code=bd_lib&pagenum=1">자유게시판</a> <a
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
				왼쪽 메뉴 끝 


				오른쪽 메뉴 시작 
				<ul class="navbar-nav justify-content-end navbar-nav">

					로그인 전
					<c:if test="${sessionScope.user==null}">
						<li class="nav-item"><a class="nav-link" href="/loginMain">LOGIN</a></li>
						<li class="nav-item"><a class="nav-link" href="/joinMain">회원가입</a></li>
					</c:if>

					로그인 후
					<c:if test="${sessionScope.user!=null }">
						<c:choose>
							일반 사용자 로그인 시작
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
							일반 사용자 로그인 끝

							판매자 로그인 시작
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
							판매자 로그인 끝

							관리자 로그인 시작
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
											class="dropdown-item" href="/mypageMainMember">회원 관리</a> 
									</div></li>
							</c:when>
							관리자 로그인 끝
						</c:choose>
					</c:if>
				</ul>
				오른쪽 메뉴 끝 
			</div>
		</div>
	</nav> --%>
	<div class="load-gate">Loading...</div>
	<div id="content">