<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/resources/css/mypage/mypageNormalReview.css" />
	<script src="/resources/js/include/jquery-3.3.1.min.js"></script>

</head>
<body>
	<input type="text" id="code" name="code" value="${code }">
	<div id="reviewForm">
		<h3 id="reviewTitle">Review</h3>
		<textarea placeholder="Review Content" id="reviewContent"></textarea>
		<select id="reviewStar">
			<option value="10">10점 - ★★★★★★★★★★</option>
			<option value="9">9점 - ★★★★★★★★★☆</option>
			<option value="8">8점 - ★★★★★★★★☆☆</option>
			<option value="7">7점 - ★★★★★★★☆☆☆</option>
			<option value="6">6점 - ★★★★★★☆☆☆☆</option>
			<option value="5">5점 - ★★★★★☆☆☆☆☆</option>
			<option value="4">4점 - ★★★★☆☆☆☆☆☆</option>
			<option value="3">3점 - ★★★☆☆☆☆☆☆☆</option>
			<option value="2">2점 - ★★☆☆☆☆☆☆☆☆</option>
			<option value="1">1점 - ★☆☆☆☆☆☆☆☆☆</option>
			<option value="0">0점 - ☆☆☆☆☆☆☆☆☆☆</option>
		</select>
		<button id="reviewButton">리뷰등록하기</button>
	</div>
	<script src='/resources/js/mypage/mypageNormalReview.js'></script>
</body>
</html>