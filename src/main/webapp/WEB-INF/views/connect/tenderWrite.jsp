<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/connect/tenderWrite.css" rel="stylesheet" />

<%--입찰 공고 작성 테이블 시작 --%>
<h1 id="tenderWriteTitle">입찰 작성</h1>
<form action="/tenderWriteComplete" method="POST">
	<table id="tenderWriteTbl">
		<tr>
			<td class="tr">제목</td>
			<td class="tr"><input type="text" id="ttitle" name="ttitle"></td>
		</tr>
		<tr>
			<td>입찰자 명</td>
			<td><input type="text" id="tname" name="tname"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" id="taddress" name="taddress"></td>
		</tr>
		<tr>
			<td>측정 일자</td>
			<td><input type="date" id="tmeasurementdate"
				name="tmeasurementdate"></td>
		</tr>
		<tr>
			<td>마감 기한</td>
			<td><input type="date" id="tdeadline" name="tdeadline"></td>
		</tr>
		<tr>
			<td>평수</td>
			<td><input type="text" id="tfloorspace" name="tfloorspace"></td>
		</tr>
		<tr>
			<td>층수</td>
			<td><input type="text" id="tlayers" name="tlayers"></td>
		</tr>
		<tr>
			<td>요구사항</td>
			<td><textarea rows="5" cols="30" id="trequirement" name="trequirement"></textarea></td>
		</tr>
	</table>
	<div id="tenderWriteBtnDiv">
		<input type="submit" id="tenderWriteBtn" name="tenderWriteBtn" value="작성완료">
	</div>
</form>


<%--입찰 공고 작성 테이블 끝 --%>

<script src="/resources/js/connect/tenderWrite.js"></script>
<%@include file="../include/footer.jsp"%>