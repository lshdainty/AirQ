<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/js/include/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/reservation.css" />
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>

</head>
<body>
	<input type="text" id="member_id" value="${memberId }" />
	<h1>${memberId }님의 모니터링입니다.</h1>
	<div id="chartdiv"></div>
	<script src="/resources/js/mypage/reservation.js"></script>
</body>
</html>