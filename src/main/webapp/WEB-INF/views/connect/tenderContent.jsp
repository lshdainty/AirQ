<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/connect/tender.css" rel="stylesheet" />


<%--입찰 공고 세부 내용 시작 --%>

<h2 id="tenderTitle">${tenderContent.tender_title }</h2>
<div>
	<span id="tenderWriter">${tenderContent.tender_name }</span> | <span id="tenderDate">${tenderContent.t_creation_date }</span> <span id="tenderDeadline">입찰 마감 일자 : ${tenderContent.tender_deadline }</span>
	<input type="hidden" id="tcode" name="tcode" value="${tenderContent.tender_code }">
</div>
<hr />

<table id="tenderTbl">
	<tr>
		<td>주소</td>
		<td>${tenderContent.t_addr_do }${tenderContent.t_addr_si }${tenderContent.t_addr_dong }${tenderContent.t_addr_detail }</td>
	</tr>
	<tr>
		<td>평수</td>
		<td>${tenderContent.t_space }</td>
	</tr>
	<tr>
		<td>층수</td>
		<td>${tenderContent.floor_number }</td>
	</tr>
	<tr>
		<td>서비스 일자</td>
		<td>${tenderContent.service_date }</td>
	</tr>
	<tr>
		<td>요구사항</td>
		<td>${tenderContent.requirement }</td>
	</tr>
</table>
<div id="tenderADiv">
	<a href="/tenderDelete/${tenderContent.tender_code }" onclick="return confirm('삭제하시겠습니까?');">삭제</a>
	<span>|</span>
	<a href="/tenderModify/${tenderContent.tender_code }" onclick="return confirm('수정하시겠습니까?');">수정</a>
	<span>|</span>
	<a href="/tenderMain">목록</a>
	<!-- <button id="tenderModifyBtn">수정</button>
	<button id="tenderDeleteBtn">삭제</button> -->
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
			<th scope="col">비고</th>
			<th scope="col">TOTAL 점수</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td scope="row"><input type="radio"></td>
			<td class="listC" data-label="순위">1</td>
			<td class="listC" data-label="업체명">에어체크업</td>
			<td class="listC" data-label="대표자">aaa</td>
			<td data-label="금액">500,000</td>
			<td data-label="건수">15</td>
			<td data-label="별점">8.5</td>
			<td data-label="첨부파일">ff</td>
			<td data-label="비고">없음</td>
			<td data-label="TOTAL 점수">35</td>
		</tr>
		<tr>
			<td scope="row"><input type="radio"></td>
			<td data-label="순위">2</td>
			<td data-label="업체명">미세청</td>
			<td data-label="대표자">bbb</td>
			<td data-label="금액">450,000</td>
			<td data-label="건수">0</td>
			<td data-label="별점">0</td>
			<td data-label="첨부파일">d</td>
			<td data-label="비고">신생기업</td>
			<td data-label="TOTAL 점수">20</td>
		</tr>
	</tbody>
</table>
<div>
	<button id="tenderApplicationBtn">입찰신청</button>
</div>
<%-- 참여 업체 리스트 테이블 끝 --%>

<script src="/resources/js/connect/tender.js"></script>
<%@include file="../include/footer.jsp"%>
