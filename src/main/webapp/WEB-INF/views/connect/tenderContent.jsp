<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/connect/tenderContent.css" rel="stylesheet" />


<%--입찰 공고 세부 내용 시작 --%>
<div id="tenderContentDiv">
	<input type="hidden" id="tcode" name="tcode" value="${tender_code }">
</div>
<hr/>

<table id="tenderTbl">
	
</table>

<div id="tenderADiv">
	<a href="/tenderMain">목록</a>
</div>

<%--입찰 공고 세부 내용 끝 --%>


<%-- 참여 업체 리스트 테이블 시작 --%>
<h3 id="tenderParticipationList">참여 업체 리스트</h3>

<table id="tenderParticipationTbl">
	<thead>
		<tr>
			<th scope="col"></th>
			<th scope="col">순위</th>
			<th scope="col">업체명</th>
			<th scope="col">대표자</th>
			<th scope="col">금액</th>
			<th scope="col">건수</th>
			<th scope="col">별점</th>
			<th scope="col">첨부파일</th>
			<th scope="col">첨부파일 점수</th>
			<th scope="col">비고</th>
			<th scope="col">TOTAL 점수</th>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>
<div id="bidBtnBiv">
</div>
<%-- 참여 업체 리스트 테이블 끝 --%>

<script src="/resources/js/connect/tenderContent.js"></script>
<%@include file="../include/footer.jsp"%>
