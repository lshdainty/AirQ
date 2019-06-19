<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/js/include/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/reservation.css" />
<script src="/resources/js/core.js"></script>
<script src="/resources/js/charts.js"></script>
<script src="/resources/js/include/animated.js"></script>
</head>
<body>
	<input type="hidden" id="member_id" value="${memberId }" />
	<p id="reservationTitle">${memberId }님의 실내 미세먼지 측정 데이터입니다.</p>
	<span id="p">*최근 7일간의 데이터입니다.</span>
	<select id="graphSelect">
		<option value="day">일별 그래프</option>
		<option value="time">시간별 그래프</option>
	</select>
	<div id="graph">
		<div id="chartdiv"></div>
	</div>
	<div class="contain">
		<div class="circle-container">
			<div id="average" class="circle">
				<div class="inside-val">
					<p>
						<span class="font" id="measure_value_avg"></span> <span>µg/m³</span>
					</p>
				</div>
			</div>
			<div class="circle-info">
				<div class="info-title">평균 미세먼지 수치(7일)</div>
			</div>
		</div>

		<div class="circle-container">
			<div id="bad" class="circle">
				<div class="inside-val">
					<p>
						<span class="font" id="badNum"></span> <span>번</span>
					</p>
				</div>
			</div>
			<div class="circle-info">
				<div class="info-title">나쁨 이상 횟수(7일)</div>
			</div>
		</div>

		<div class="circle-container">
			<div id="realTime" class="circle">
				<div class="inside-val">
					<p>
						<span class="font" id="measure_value"></span><span>µg/m³</span>
					</p>
				</div>
			</div>
			<div class="circle-info">
				<div class="info-title">미세먼지 수치(7일)</div>
			</div>
		</div>
	</div>
	<script src="/resources/js/mypage/reservation.js"></script>
</body>
</html>