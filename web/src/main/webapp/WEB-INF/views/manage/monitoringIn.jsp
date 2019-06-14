<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/manage/monitoringIn.css">


<!-----------------------------------------------container Start--------------------------------------->
<div class="container">

	<div>
		<select>
			<option>기기종류</option>
		</select>
	</div>



	<!-- live chart container start  -->
	<div class="liveChart_container">

		<!-- live chart start  -->
		<div class="liveChart_chart" id="chartdiv"></div>
		<!--  live chart end   -->


		<!-- live chart info start -->
		<div class="liveChart_info__container">

			<!-- live chart explain start  -->


			<!-- 좋음 :  background :  #b0e867  color : #718b3a -->
			<!-- 보통 :  background :  #ffdf58  color : #a57f23 -->
			<!-- 나쁨 :  background :  #ffa968  color : #b25826 -->
			<!-- 심각 :  background :  #af2c3b  color : #af2c3b -->


			<div class="info_box">

				<div class="info_grade__container grade_good">
					<div class="info_grade__face">
						<img
							src="https://www.airvisual.com/assets/aqi/ic-face-1-green.svg" />
					</div>
					<div class="info_grade__value">최고</div>
				</div>

				<div class="info_explain">
					<div class="info_table__container">
						<div class="info_table__box">
							<div class="info_table__value">13</div>
							<div class="info_table__title">현재 수치</div>
						</div>
						<div class="info_table__box">
							<div class="info_table__value">1</div>
							<div class="info_table__title">평균 수치</div>
						</div>
						<div class="info_table__box">
							<div class="info_table__value">12</div>
							<div class="info_table__title">임계치초과</div>
						</div>
					</div>
				</div>


				<div class="info_behavior__container">
					<div class="info_behavior">asdasdasdasdsaads</div>
				</div>
			</div>
			<!--  live chart explain end   -->

		</div>
		<!-- live chart info end   -->

	</div>
	<!-- live chart container end  -->




	<!-- time chart start -->

	<div class="timeChart_container">

		<div class="innerChart_container">
			<div class="hourChart_container">
				<div id="hourChart"></div>
			</div>
		</div>

		<div class="innerChart_container">
			<div class="dayChart_container">
				<div id="dayChart"></div>
			</div>
		</div>

		<div class="innerChart_container">
			<div class="monthChart_container">
				<div id="monthChart"></div>
			</div>
		</div>


	</div>


	<!--  time chart end  -->






	<!-- 
	<div class="circle-container">
		<div class="circle-box">
			<div id="average" class="circle">
				<div class="inside-val">
					<p>
						<span class="font" id="measure_value_avg">1</span><span>µg/m³</span>
					</p>
				</div>
			</div>
			<div class="circle-info">
				<div class="info-title">평균 미세먼지 수치(7일)</div>
			</div>
		</div>

		<div class="circle-box">
			<div id="bad" class="circle">
				<div class="inside-val">
					<p>
						<span class="font" id="badNum">1</span><span>번</span>
					</p>
				</div>
			</div>
			<div class="circle-info">
				<div class="info-title">나쁨 이상 횟수(7일)</div>
			</div>
		</div>

		<div class="circle-box">
			<div id="realTime" class="circle">
				<div class="inside-val">
					<p>
						<span class="font" id="measure_value">1</span><span>µg/m³</span>
					</p>
				</div>
			</div>
			<div class="circle-info">
				<div class="info-title">미세먼지 수치(7일)</div>
			</div>
		</div>
	</div>
	--------------------------------------Circle Container End------------------------------- -->

	<!-- 좋음 :  background :  #b0e867  color : #718b3a -->
	<!-- 보통 :  background :  #ffdf58  color : #a57f23 -->
	<!-- 나쁨 :  background :  #ffa968  color : #b25826 -->
	<!-- 심각 :  background :  #af2c3b  color : #af2c3b -->




</div>
<!-----------------------------------------------container End----------------------------------------->
<script src="/resources/js/core.js"></script>
<script src="/resources/js/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
<script src="/resources/js/manage/monitoringIn.js"></script>
<%@include file="../include/footer.jsp"%>