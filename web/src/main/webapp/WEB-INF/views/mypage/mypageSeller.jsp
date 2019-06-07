<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/mypage/mypageSeller.css" />
<h1>판매자-메인 페이지 입니다.</h1>
<div id="newPost" class="reviewDiv">
	<p class="infoTitle color_green">예약자 현황</p>
	<table id="newPostTbl" class="reviewTbl">
		<thead class="green_thead">
			<tr>
				<th>구매자</th>
				<th>구매상품</th>
				<th>서비스일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="reservation" items="${reservation}">
				<tr>
					<td>${reservation.MEMBER_ID}</td>
					<td>${reservation.PRODUCT_NAME}</td>
					<td>${reservation.D_SERVICE_DATE}</td>
				</tr>
			
			</c:forEach>
		</tbody>
	</table>
</div>
<div id="newReply" class="reviewDiv">
	<p class="infoTitle color_yellow">인기 상품</p>
	<table id="newReplyTbl" class="reviewTbl">
		<thead class="yellow_thead">
			<tr>
				<th>상품명</th>
				<th>판매량</th>
				<th>평점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${hotItems}" begin="0" end="5">
				<tr>
					<td>${item.PRODUCT_NAME}</td>
					<td>${item.COUNT}</td>
					<td>${item.STAR}</td>
				</tr>
			
			</c:forEach>
		</tbody>
	</table>
</div>
<div id="chartdiv"></div>
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
<script src="resources/js/mypage/mypageSeller.js"></script>
<%@include file="../include/footer.jsp"%>