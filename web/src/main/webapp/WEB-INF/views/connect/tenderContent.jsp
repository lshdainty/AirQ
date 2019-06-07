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
<h1 id="tenderTitle">전자 입찰 공고</h1>
<div id="tenderBoard">
	<!-- <div id="tenderContent" class="tBoard">
		<table id="tenderTbl">
			<tr>
				<th>공고명</th>
				<td colspan="3">입찰입니다.</td>
			</tr>
			<tr>
				<th>담당자</th>
				<td>김고은</td>
				<th>전화번호</th>
				<td>01087224235</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>abc@naver.com</td>
				<th>예산</th>
				<td>5000000</td>
			</tr>
			<tr>
				<th>장소</th>
				<td colspan="3">대구 북구 복현로 25-2 300호</td>
			</tr>
			<tr>
				<th>평수</th>
				<td>100</td>
				<th>층수</th>
				<td>2</td>
			</tr>
			<tr>
				<th>낙찰 결정방법</th>
				<td colspan="3">예정 가격 이하 총액 최저가 낙찰제</td>
			</tr>
			<tr>
				<th>요구사항</th>
				<td colspan="3" id="requirement">of "de Fini</td>
			</tr>
		</table>
	</div>
	<div id="tenderSituation" class="tBoard">
		<p id="tenderST">>> 입찰 진행 상황</p>
		<p class="tenderD">>> | 게시일 2019.06.05</p>
		<p class="p">↓</p>
		<p class="tenderD">>> | 투찰마감 2019.06.10</p>
		<p class="p">↓</p>
		<p class="tenderD">>> | 개찰 일시 2019.06.11</p>
		<p class="p">↓</p>
		<p class="tenderD">>> | 서비스 일자 2019.06.25</p>
	</div> -->
</div>

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
<div id="bidBtnBiv"></div>
<%-- 참여 업체 리스트 테이블 끝 --%>

<script src="/resources/js/connect/tenderContent.js"></script>
<%@include file="../include/footer.jsp"%>
