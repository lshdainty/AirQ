<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="resources/css/manage/monitoringMain.css">


<div id="airCheck">
	<button id="in" class="button btn-inside">실내</button>
	<button id="out" class="button btn-outside">실외</button>
</div>
	
<div id="outside">
	<%--지도를 나타내주는 곳  시작--%>
	<h1>실외 모니터링 페이지 입니다.</h1>
	
	<div id="map" style="width: 100%; height: 800px;"></div>
	
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=tpllhjh4tl&submodules=geocoder"></script>
	<script type="text/javascript" src="https://navermaps.github.io/maps.js.ncp/docs/js/MarkerClustering.js"></script>
<%-- 지도 부분 끝 --%>
</div>

<style>
#chartdiv {
	width: 100%;
	height: 500px;
}
</style>

<div id="inside" style="display:none">
	<%-- AmChart 부분 시작 --%>
	<h1>실내 모니터링 페이지 입니다.</h1>
	
	<div id="chartdiv"></div>

	
	<script src="resources/js/core.js"></script>
	<script src="resources/js/charts.js"></script>
	<script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
	<script src="resources/js/manage/inside.js"></script>
	<%-- AmChart 부분 끝 --%>
</div>

<script src="resources/js/manage/monitoringMain.js"></script>
<%@include file="../include/footer.jsp"%>