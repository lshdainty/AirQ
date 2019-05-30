<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/include/swiper.css">
<link rel="stylesheet" href="/resources/css/service/main.css">

<style>
#content {
	max-width: 100% !important;
}
.matter-box{
	display:flex;
	flex-wrap:wrap;
}
.matter-box ul{
	display:flex;
	flex-direction:column;
	justify-content:space-around;
	text-align:center;
}
.matter-box ul li{
	padding:1rem;
	background:#ddd;
	font-weight:bold;
}


#chartdiv {
  width: 86%;
  height: 500px;
}
.areaBox{
	text-align:center !important;
	font-size:1.5rem;
	padding-top:1.5rem !important;
}
</style>
<!--  body content start  -->

<section class="hero-home">
	<div
		class="swiper-container hero-slider swiper-container-fade swiper-container-horizontal">
		<div class="swiper-wrapper dark-overlay"
			style="transition-duration: 0ms;">
			<div
				style="background-image: url(&quot;https://d19m59y37dris4.cloudfront.net/directory/1-2/img/photo/photo-1501621965065-c6e1cf6b53e2.jpg&quot;); width: 1903px; opacity: 1; transform: translate3d(0px, 0px, 0px); transition-duration: 0ms;"
				class="swiper-slide swiper-slide-prev"></div>
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
					<p class="subtitle letter-spacing-4 mb-2 text-secondary text-shadow">DEVELOPE-YOUR-AIR-QUALITY</p>
					<h1 class="display-3 font-weight-bold text-shadow">전문가의 맞춤 공기질 개선</h1>
				</div>
			</div>
		</div>
	</div>
</section>
<div style="width:75%; margin:auto; max-width:900px">
	<div class="measure-container"></div>
	<div class="areaBox"><span class="areaname"></span>의 <span class="mattername"></span>수치</div>
	<div style="display:flex;">
	<div id="chartdiv"></div>
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
</div>
<span id="currentArea" style="display:none"></span>
<!--  body content end  -->
<!-- Global site tag (gtag.js) - Google Analytics -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-140827148-1"></script>
<script src="resources/js/home.js"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag('js', new Date());

	gtag('config', 'UA-140827148-1');
</script>
<%@include file="include/footer.jsp"%>