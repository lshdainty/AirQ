<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="/resources/js/jquery-3.3.1.min.js"></script>
	<link href="/resources/css/Report.css" rel="stylesheet" />
</head>
<body>
	<form id="reportForm">
		<input type="hidden" id="original_code" name="original_code" value="${original_code}" />
		<input type="text" id="report_title" name="report_title" class="Textbox" placeholder="신고제목"/>
		<textarea id="report_content" name="report_content" class="Textbox" rows="8" placeholder="신고내용"></textarea>
	
		<button type="button" id="reportSubmit" class="reportButton">신고 작성</button>
		<button type="button" id="reportCancel" class="reportButton">신고 취소</button>
	</form>
	<script src="/resources/js/report.js"></script>
</body>
</html>