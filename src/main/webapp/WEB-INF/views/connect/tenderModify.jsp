<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/connect/tenderModify.css" rel="stylesheet" />

<%--입찰 공고 수정 테이블 시작 --%>
<h1 id="tenderModifyTitle">입찰 작성</h1>
	<form action="/tenderModifyComplete" method="POST">
	<table id="tenderModifyTbl">
		<tr>
			<td><input type="hidden" id="tcode" name="tcode" value="${tenderModify.tcode}"></td>
		</tr>
		<tr>
			<td class="tr">제목</td>
			<td class="tr"><input type="text" id="ttitle" name="ttitle" value="${tenderModify.ttitle }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>입찰자 명</td>
			<td><input type="text" id="tname" name="tname" value="${tenderModify.tname }"  required autocomplete="off"></td>
		</tr>
		<tr id="${tenderModify.tcreated }">
			<td>주소</td>
			<td><input type="text" id="taddress" name="taddress" value="${tenderModify.taddress }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>측정 일자</td>
			<td><input type="date" id="tmeasurementdate" name="tmeasurementdate" value="${tenderModify.tmeasurementdate }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>마감 기한</td>
			<td><input type="date" id="tdeadline" name="tdeadline" value="${tenderModify.tdeadline }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>평수</td>
			<td><input type="text" id="tfloorspace" name="tfloorspace" value="${tenderModify.tfloorspace }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>층수</td>
			<td><input type="text" id="tlayers" name="tlayers" value="${tenderModify.tlayers }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>요구사항</td>
			<td><textarea rows="5" cols="30" id="trequirement" name="trequirement"  required autocomplete="off"> ${tenderModify.trequirement }</textarea></td>
		</tr>
	</table>
	<div id="tenderModifyBtnDiv">
	<input type="submit" id="tenderModifyCBtn" name="tenderModifyCBtn" value="수정완료">
</div>
</form>

<%--입찰 공고 수정 테이블 끝 --%>

<script src="/resources/js/connect/tenderModify.js"></script>
<%@include file="../include/footer.jsp"%>