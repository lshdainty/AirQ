<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/connect/tender.css" rel="stylesheet" />


<%--입찰 공고 세부 내용 시작 --%>

<h1 id="tenderTitle">Hello World!</h1>
<div id="d">
	<span id="tenderWriter">goeun</span> | <span id="tenderDate">2019.01.25
		11:01</span> <span id="tenderDeadline">마감 일자 : 2019.04.03</span>
</div>
<hr />

<table id="tenderTbl">
	<tr>
		<td>주소</td>
		<td>대구광역시 북구 복현로 35</td>
	</tr>
	<tr>
		<td>평수</td>
		<td>45</td>
	</tr>
	<tr>
		<td>층수</td>
		<td>4</td>
	</tr>
	<tr>
		<td>요구사항</td>
		<td>Lorem Ipsum is simply dummy text of the printing and
			typesetting industry. Lorem Ipsum has been the industry's standard
			dummy text ever since the 1500s, when an unknown printer took a
			galley of type and scrambled it to make a type specimen book. It has
			survived not only five centuries, but also the leap into electronic
			typesetting, remaining essentially unchanged. It was popularised in
			the 1960s with the release of Letraset sheets containing Lorem Ipsum
			passages, and more recently with desktop .</td>
	</tr>
</table>
<div id="tenderModifyBtnnDiv">
	<button id="tenderModifyBtn">수정</button>
	<button id="tenderDeleteBtn">삭제</button>
</div>
<%--입찰 공고 세부 내용 끝 --%>


<%-- 참여 업체 리스트 테이블 시작 --%>
<h2 id="tenderParticipationList">참여 업체 리스트</h2>

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

<%@include file="../include/footer.jsp"%>
