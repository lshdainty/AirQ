<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<%--지도를 나타내주는 곳  시작--%>
	<div id="map" style="width:500px;height:400px;"></div>
<%--지도를 나타내주는 곳  끝--%>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5d7fa1315630f585572f6d7cd683066d&libraries=services,clusterer"></script>
	<script src="resources/js/manage/monitoringMain.js"></script>
<%@include file="../include/footer.jsp" %>