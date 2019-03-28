<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
	<%-- 각 도의 시목록 api 키값 시작 --%>
		<input type="hidden" id="sigoon_key" value="b0888bae39fbd0463a9252" />
		<%-- <input type="hidden" name="apiKey" value="E4A59B05-0CF4-3654-BD0C-A169F70CCB34" /> --%>
	<%-- 각 도의 시목록 api 키값 끝 --%>

	<%-- 지도 나오는 부분 시작 --%>
		<div>
			<div id="chartdiv"></div>
			<div id="chartContentdiv">
				<select id="sigoon_code">
					<option>선택</option>
				</select>
				<input id="datetest" type="date">
				<button id="check">선택확인</button>
			</div>
		</div>
	<%-- 지도 나오는 부분 끝 --%>

	<script src="resources/js/connect/core.js"></script>
	<script src="resources/js/connect/maps.js"></script>
	<script src="resources/js/connect/southKoreaHigh.js"></script>
	<script src="resources/js/connect/animated.js"></script>
	<script src="resources/js/connect/compare.js"></script>
<%@include file="../include/footer.jsp" %>