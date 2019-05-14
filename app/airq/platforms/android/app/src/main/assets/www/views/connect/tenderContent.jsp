<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/connect/tenderContent.css" rel="stylesheet" />


<%--입찰 공고 세부 내용 시작 --%>

<h2 id="tenderTitle">${tenderContent.tender_title }</h2>
<div>
	<span id="tenderWriter">${tenderContent.member_id }</span> | <span
		id="tenderDate">${tenderContent.t_creation_date }</span> <span
		id="tenderDeadline">입찰 마감 일자 : ${tenderContent.tender_deadline }</span>
	<input type="hidden" id="tcode" name="tcode"
		value="${tenderContent.tender_code }">
</div>
<hr />

<table id="tenderTbl">
	<tr>
		<td>입찰자 명</td>
		<td>${tenderContent.tender_name }</td>
	</tr>
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
	<c:if test="${sessionScope.user.member_devision == 'no' }">
		<a href="/tenderDelete/${tenderContent.tender_code }"
			onclick="return confirm('삭제하시겠습니까?');">삭제</a> <span>|</span> 
		<a href="/tenderModify/${tenderContent.tender_code }"
			onclick="return confirm('수정하시겠습니까?');">수정</a> <span>|</span> 
	</c:if>
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
		<c:forEach var="bidContent" items="${bidContent}">
			<tr>
				<td scope="row"><input type="radio" value="${bidContent.company_code}" name="bidContent" ></td>
				<td class="listC" data-label="순위">0</td>
				<td id="company_name" name="company_name" class="listC" data-label="업체명">${bidContent.company_name }</td>
				<td id="member_id" name="member_id" class="listC" data-label="대표자">${bidContent.member_id }</td>
				<td id="bid_price" name="bid_price" data-label="금액">${bidContent.bid_price }</td>
				<td data-label="건수">${bidContent.bidNum }</td>
				<td data-label="별점">${bidContent.star_score_avg }</td>
				<td data-label="첨부파일">${bidContent.bid_ppt_name }</td>
				<td data-label="첨부파일 점수"><input type="text" id="bid_ppt_score" name="bid_ppt_score"><button>입력</button></td>
				<td data-label="비고">${bidContent.note }</td>
				<td data-label="TOTAL 점수">0</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
	<c:if test="${sessionScope.user.member_devision == 'se' }">
		<button id="bidWrite">투찰하기</button>
		<button id="bidComplete">작성완료</button>
	</c:if>
	<c:if test="${sessionScope.user.member_devision == 'no' }">
		<button id="tenderApplicationBtn">입찰신청</button>
	</c:if>
</div>
<%-- 참여 업체 리스트 테이블 끝 --%>

<script src="/resources/js/connect/tenderContent.js"></script>
<%@include file="../include/footer.jsp"%>
