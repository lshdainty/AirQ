<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<input type="hidden" id="original_code" name="original_code" value="${original_code}" />
	
	<label for="report_title">신고 제목 : </label>
	<input type="text" id="report_title" name="report_title" /><br/>
	
	<label for="report_content">신고 내용 : </label>
	<textarea id="report_content" name="report_content"></textarea><br/>
	
	<button id="reportSubmit">신고 작성</button>
	<button id="reportCancel">신고 취소</button>
	<script src="/resources/js/report.js"></script>
</body>
</html>