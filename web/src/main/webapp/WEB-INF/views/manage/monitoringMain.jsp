<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="resources/css/manage/monitoringMain.css">
	<div id="airCheck">
		<button id="in" class="button btn-inside">실내</button>
		<button id="out" class="button btn-outside">실외</button>
	</div>
	<div id="inside">
		<%-- AmChart 부분 시작 --%>
		<div id="chartdiv"></div>
		<%-- AmChart 부분 끝 --%>
	</div>
	<div id="outside">
		<%--지도를 나타내주는 곳  시작--%>
		<div id="map"></div>
		<%-- 지도 부분 끝 --%>
	</div>

<script src="resources/js/core.js"></script>
<script src="resources/js/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=tpllhjh4tl&submodules=geocoder"></script>
<script type="text/javascript" src="https://navermaps.github.io/maps.js.ncp/docs/js/MarkerClustering.js"></script>
<script src="resources/js/manage/inside.js"></script>
<script src="resources/js/manage/monitoringMain.js"></script>
<%@include file="../include/footer.jsp"%>