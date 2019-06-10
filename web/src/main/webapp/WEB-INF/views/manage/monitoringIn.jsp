<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/manage/monitoringMain.css">
<div id="inside">
	<%-- AmChart 시작 --%>
	<div id="chartdiv"></div>
	<%-- AmChart 끝 --%>

	<%-- 달력 선택 시작 --%>
	<input type="date" id="measureDate" onchange="measureDate(this)" />
	<%-- 달력 선택 끝 --%>

	<div id="chartList">
		<h3>측정 상세 정보</h3>
		<table class="table">
			<th class="table__heading">Today</th>
			<th class="table__heading">측정 값<sub>(㎍/㎥)</sub></th>
			<th class="table__heading">기기 ID</th>
			<th class="table__heading">측정 코드</th>
			<tbody class="chartList-list"></tbody>
		</table>
	</div>
</div>
<script src="resources/js/core.js"></script>
<script src="resources/js/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
<script src="resources/js/manage/monitoringIn.js"></script>
<%@include file="../include/footer.jsp"%>