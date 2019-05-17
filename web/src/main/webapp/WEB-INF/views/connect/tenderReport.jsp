<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<link href="/resources/css/connect/tenderReport.css" rel="stylesheet" />
</head>
<body>
	<!-- 입찰 신고 form 시작 -->
	<form id="reportForm">
		<input type="text" placeholder="Title" class="rTextbox" />
		<textarea rows="8" placeholder="Content" class="rTextbox"></textarea>
		<button id="reportButton">submit</button>
	</form>
	<!-- 입찰 신고 form 끝 -->
	<script src="/resources/js/connect/tenderReport.js"></script>
</body>
</html>