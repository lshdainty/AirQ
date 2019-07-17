<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/include/swiper.css">
<link rel="stylesheet" href="/resources/css/service/main.css">

<style>
.quality_cards {
	display: flex;
}

#content {
	max-width: 100% !important;
}

.matter-box {
	display: flex;
	flex-wrap: wrap;
}

.matter-box ul {
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	text-align: center;
	margin: 0;
}

.matter-box ul li {
	cursor: pointer;
	padding: 1rem;
	background: #ddd;
	font-weight: bold;
	border-radius: 1rem;
	border: 1px solid #000;
}

#chartdiv {
	width: 88%;
	height: 500px;
}

.areaBox {
	text-align: center !important;
	font-size: 1.5rem;
	padding-top: 1.5rem !important;
}

.aqi-container {
	flex-direction: row;
	box-sizing: border-box;
	display: flex;
	place-content: stretch center;
	align-items: stretch;
	justify-content: space-around;
	flex-direction: column;
}

.aqi {
	font-size: 23px;
	margin-bottom: 5px;
}

p {
	margin: 0;
}

.pollutant {
	font-size: 10px;
	font-weight: bold;
	background: #fff;
	border-radius: 4px;
	overflow: hidden;
	place-content: center;
	align-items: center;
	/*   flex-direction: column; */
	box-sizing: border-box;
	display: flex;
	padding-bottom: .5rem;
}

.quality_cards {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
}

.quality_info {
	width: 25%;
	border: 1px solid #000;
	border-radius: 1rem;
	overflow: hidden;
}

.quality_main {
	border-bottom: 1px solid #000;
	display: flex;
	background: #B2EBF4;
	height: 4rem;
}

.quality_main img {
	height: 100%;
}

.quality_main div {
	width: 100%;
	text-align: center;
	margin: auto;
}

.quality_face {
	border: 1px solid #000;
}

.matter_info {
	display: flex;
	vertical-align: bottom;
	justify-content: space-around;
	border-bottom: 1px solid #000;
}

.matter_info:last-child {
	border-bottom: none;
}

.matter_info div {
	width: 100%;
	text-align: center;
}

.demention_line {
	border: .5px solid #000;
}
.qBox{
	border: 1px solid;
	border-radius: 1rem;
	overflow: hidden;
	margin-top: 1rem;
}
.qTitle{
	font-size:18px;
	padding: 1rem;
	background: #000;
	color: #fff;
}
.inside_box{
	padding: 1rem;
}
</style>
<!--  body content start  -->

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
<div style="width: 100%; margin: auto; max-width: 1000px">
	
<div class="qBox">
		<div class="qTitle">
			실내 공기질 현황
		</div>
		<div class="quality_cards inside_box">
		<div class="quality_info">


			<div class="quality_main">
				<div class="quaility_face">
					<img src="/resources/images/face_1.svg">
				</div>
				<div class="quality_area">
					<p>서울</p>
				</div>
			</div>

			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>
		</div>

		<div class="quality_info">


			<div class="quality_main">
				<div class="quaility_face">
					<img src="/resources/images/face_1.svg">
				</div>
				<div class="quality_area">
					<p>부산</p>
				</div>
			</div>

			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>
		</div>

		<div class="quality_info">


			<div class="quality_main">
				<div class="quaility_face">
					<img src="/resources/images/face_1.svg">
				</div>
				<div class="  ity_area">
					<p>대구</p>
				</div>
			</div>

			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>
		</div>


	</div>
		
	</div>
	
	
	
	<div class="qBox">
		<div class="qTitle">
			실외 공기질 현황
		</div>
		<div class="quality_cards inside_box">
		<div class="quality_info">


			<div class="quality_main">
				<div class="quaility_face">
					<img src="/resources/images/face_1.svg">
				</div>
				<div class="quality_area">
					<p>서울</p>
				</div>
			</div>

			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>
		</div>

		<div class="quality_info">


			<div class="quality_main">
				<div class="quaility_face">
					<img src="/resources/images/face_1.svg">
				</div>
				<div class="quality_area">
					<p>부산</p>
				</div>
			</div>

			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>
		</div>

		<div class="quality_info">


			<div class="quality_main">
				<div class="quaility_face">
					<img src="/resources/images/face_1.svg">
				</div>
				<div class="  ity_area">
					<p>대구</p>
				</div>
			</div>

			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>


			<div class="matter_info">

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>미세먼지</p>
					</span>
					</span>
				</div>

				<span class="demention_line"></span>

				<div class="aqi-container">
					<span class="aqi">
						<p>7</p>
					</span> <span class="pollutant" fxlayoutalign="center center">
						µg/m³ <span class="matter_code">
							<p>초미세먼지</p>
					</span>
					</span>
				</div>

			</div>
		</div>


	</div>
		
	</div>

</div>

<button class="layout1">Layout1</button>
<button class="layout2">Layout2</button>
<button class="layout3">Layout3</button>
<script>
	$(function() {
		$(".layout1").click(function() {
			window.location.href = "layout?layoutNum=1";
		});

		$(".layout2").click(function() {
			window.location.href = "layout?layoutNum=2";
		});

		$(".layout3").click(function() {
			window.location.href = "layout?layoutNum=3";
		});
	});
</script>
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