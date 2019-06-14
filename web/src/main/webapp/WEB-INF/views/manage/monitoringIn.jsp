<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/manage/monitoringIn.css">
<div id="inside">
	<%-- AmChart 시작 --%>
	<div id="chartdiv"></div>
	<%-- AmChart 끝 --%>
	<div class="contain">
		<div class="circle-container">
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

		<div class="circle-container">
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

		<div class="circle-container">
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
</div>
<script src="/resources/js/core.js"></script>
<script src="/resources/js/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
<script src="/resources/js/manage/monitoringIn.js"></script>
<%@include file="../include/footer.jsp"%>