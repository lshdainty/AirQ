<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/connect/tenderModify.css" rel="stylesheet" />

<%--입찰 공고 수정 테이블 시작 --%>
<h1 id="tenderModifyTitle">입찰 작성</h1>
<form action="/tenderModifyComplete" method="POST">
	<input type="hidden" id="tender_code" name="tender_code" value="${tenderModify.tender_code}">
	<table id="tenderModifyTbl">
		<tr>
			<td class="tr">제목</td>
			<td class="tr"><input type="text" id="tender_title" name="tender_title" value="${tenderModify.tender_title }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>입찰자 명</td>
			<td><input type="text" id="tender_name" name="tender_name" value="${tenderModify.tender_name }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td></td>
		</tr>
		<tr>
			<td>측정 일자</td>
			<td><input type="date" id="service_date" name="service_date" value="${tenderModify.service_date }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>마감 기한</td>
			<td><input type="date" id="tender_deadline" name="tender_deadline" value="${tenderModify.tender_deadline }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>평수</td>
			<td><input type="text" id="t_space" name="t_space" value="${tenderModify.t_space }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>층수</td>
			<td><input type="text" id="floor_number" name="floor_number" value="${tenderModify.floor_number }"  required autocomplete="off"></td>
		</tr>
		<tr>
			<td>요구사항</td>
			<td><textarea rows="5" cols="30" id="requirement" name="requirement"  required autocomplete="off"> ${tenderModify.requirement }</textarea></td>
		</tr>
	</table>
	<div id="tenderModifyBtnDiv">
		<input type="submit" id="tenderModifyCBtn" name="tenderModifyCBtn" value="수정완료">
	</div>
</form>

<%--입찰 공고 수정 테이블 끝 --%>

<script src="/resources/js/connect/tenderModify.js"></script>
<%@include file="../include/footer.jsp"%>