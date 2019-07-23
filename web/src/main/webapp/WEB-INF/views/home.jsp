<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/include/swiper.css">
<link rel="stylesheet" href="/resources/css/service/main.css">

<!--  body content start  -->


<!-- ----------------------------------  Slide section ---------------------------------   -->
<section class="hero-home">
	<div
		class="swiper-container hero-slider swiper-container-fade swiper-container-horizontal">
		<div class="swiper-wrapper dark-overlay"
			style="transition-duration: 0ms;">
			<div
				style="background-image: url(&quot;https://d19m59y37dris4.cloudfront.net/directory/1-2/img/photo/photo-1519974719765-e6559eac2575.jpg&quot;); width: 1903px; opacity: 1; transform: translate3d(-1903px, 0px, 0px); transition-duration: 0ms;"
				class="swiper-slide swiper-slide-active"></div>
			<div
				style="background-image: url(&quot;https://d19m59y37dris4.cloudfront.net/directory/1-2/img/photo/photo-1490578474895-699cd4e2cf59.jpg&quot;); width: 1903px; opacity: 0; transform: translate3d(-3806px, 0px, 0px); transition-duration: 0ms;"
				class="swiper-slide swiper-slide-next"></div>
			<div
				style="background-image: url(&quot;https://d19m59y37dris4.cloudfront.net/directory/1-2/img/photo/photo-1534850336045-c6c6d287f89e.jpg&quot;); width: 1903px; opacity: 0; transform: translate3d(-5709px, 0px, 0px); transition-duration: 0ms;"
				class="swiper-slide"></div>
		</div>
		<span class="swiper-notification" aria-live="assertive"
			aria-atomic="true"></span>
	</div>
	<div class="container py-6 py-md-7 text-white z-index-20">
		<div class="row">
			<div class="col-xl-10">
				<div class="text-center text-lg-left">
					<p
						class="subtitle letter-spacing-4 mb-2 text-secondary text-shadow">DEVELOPE-YOUR-AIR-QUALITY</p>
					<h1 class="display-3 font-weight-bold text-shadow">전문가의 맞춤 공기질
						개선</h1>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- ----------------------------------  Slide section ---------------------------------   -->




<!-- ----------------------------------  2nd section ---------------------------------   -->
<div style="width: 100%; margin: auto; max-width: 1000px">


	<c:if test="${sessionScope.user==null}">

		<div class="measure-container"></div>
		<div class="areaBox">
			<span class="areaname"></span> <span class="mattername"></span> 수치
		</div>
		<div style="display: flex;">
			<div id="outsideMatChart" style="width: 88%; height: 500px;"></div>
			<div class="matter-box">
				<ul>
					<li class="matter" value="PM10">미세먼지</li>
					<li class="matter" value="PM25">초미세먼지</li>
					<li class="matter" value="NO2">이산화질소</li>
					<li class="matter" value="O3">오존</li>
					<li class="matter" value="CO">일산화탄소</li>
					<li class="matter" value="SO2">아황산가스</li>
				</ul>
			</div>
		</div>

	</c:if>

	<c:if test="${sessionScope.user!=null}">

		<!-- Material measure Content \ Outside \  -->
		<div class="sideQBox" id="outsideBox">
			<div class="outsideTitle">실외 공기질 측정 현황</div>
			<div class="sideContent">
				<div class="sideSWrap">
					<!-- Material Select Box Start \ Outside \ -->
					<div class="matSBox">

						<select name="" id="areaSelectBox">
							<option value="seoul" class="areaname">서울</option>
							<option value="busan" class="areaname">부산</option>
							<option value="daegu" class="areaname">대구</option>
						</select> <select name="" id="matterSelectBox">
							<option value="PM10">미세먼지</option>
							<option value="PM25">초미세먼지</option>
							<option value="NO2">이산화질소</option>
							<option value="O3">오존</option>
							<option value="CO">일산화탄소</option>
							<option value="SO2">아황산가스</option>
						</select>

					</div>
					<!-- Material Select Box End \ Outside \ -->
					<div class="matViewBox">

						<div class="matGrade">최고</div>
						<div class="matFBox">
							<img id="outsideFace" src="/resources/images/face_1.svg">
						</div>
						<div class="matValue">44</div>

					</div>

				</div>

				<!-- Chart Start - Material \ Outside \ -->
				<div id="outsideMatChart" style="width: 100%;"></div>
				<!-- Chart End - Material \ Inside \ -->
			</div>
		</div>
		<!-- ------------------------------------ -->



		<!-- Material measure Content \ Inside \  -->
		<div class="sideQBox" id="insideBox">
			<div class="insideTitle">실내 공기질 측정 현황</div>
			<div class="sideContent">
				<div class="sideSWrap">
					<!-- Material Select Box Start \ Outside \ -->
					<div class="matSBox">

						<select name="" id="iot_id">
						</select> <select name="" id="matter_list">
						</select>

					</div>
					<!-- Material Select Box End \ Outside \ -->
					<div class="matViewBox">

						<div class="matGrade">최고</div>
						<div class="matFBox">
							<img id="insideFace" src="/resources/images/face_1.svg">
						</div>
						<div class="matValue">44</div>

					</div>

				</div>

				<!-- Chart Start - Material \ Outside \ -->
				<div id="insideMatChart" style="width: 100%;"></div>
				<!-- Chart End - Material \ Inside \ -->
			</div>
		</div>
		<!-- ------------------------------------ -->
	</c:if>
</div>

<!-- ----------------------------------  2nd section ---------------------------------   -->


<span id="currentArea" style="display: none"></span>
<!--  body content end  -->
<!-- Global site tag (gtag.js) - Google Analytics -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
<script async
	src="https://www.googletagmanager.com/gtag/js?id=UA-140827148-1"></script>
<script src="/resources/js/home.js"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag('js', new Date());

	gtag('config', 'UA-140827148-1');
</script>
<%@include file="include/footer.jsp"%>