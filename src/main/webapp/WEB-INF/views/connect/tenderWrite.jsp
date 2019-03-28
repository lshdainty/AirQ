<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/connect/tenderWrite.css" rel="stylesheet" />

<%@include file="../include/header.jsp"%>

<%--입찰 공고 작성 테이블 시작 --%>
<h1>입찰 작성</h1>
<form action="/tenderList" method="post">
	<table id="tenderWriteTbl">
		<tr>
			<td class="tr">제목</td>
			<td class="tr"><input type="text" id="tTitle" name="tTitle"></td>
		</tr>
		<tr>
			<td>입찰자 명</td>
			<td><input type="text" id="tName" name="tName"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" id="address" name="address"></td>
		</tr>
		<tr>
			<td>측정 날짜</td>
			<td><input type="date" id="measurementDate" name="measureDate"></td>
		</tr>
		<tr>
			<td>마감 기한</td>
			<td><input type="date" id="deadline" name="deadline"></td>
		</tr>
		<tr>
			<td>평수</td>
			<td><input type="text" id="floorspace" name="floorspace"></td>
		</tr>
		<tr>
			<td>층수</td>
			<td><input type="text" id="layers" name="layers"></td>
		</tr>
		<tr>
			<td>요구사항</td>
			<td><textarea rows="5" cols="30" id="requirement"
					name="requirement"></textarea></td>
		</tr>
	</table>
	<input type="submit" id="tenderWriteBtn" name="tenderWriteBtn" value="작성완료">
</form>
<%--입찰 공고 작성 테이블 끝 --%>

<%@include file="../include/footer.jsp"%>