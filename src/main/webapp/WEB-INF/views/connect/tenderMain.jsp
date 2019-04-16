<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/connect/tenderMain.css" rel="stylesheet" />
<link href="/resources/css/include/table.css" rel="stylesheet" />
<%--입찰 공고 테이블 시작 --%>
<form action="/tenderboardWrite" method="post">
	<div id="tenderContainer">
		<h1 id="tenderTitle" class="tenderTitle">입찰 공고</h1>
		<div id="tenderSelectDiv" class="tenderSelectDiv">
			<select class="tenderSelect">
				<option>전체 글 보기</option>
				<option>내가 쓴 글 보기</option>
			</select> <select class="tenderSelect">
				<option>참여업체수</option>
				<option>마감기한</option>
			</select>
		</div>
		<ul class="tableList">
			<li class="tableListHeader">
				<div class="tableColumn tableCol-10-1">번호</div>
				<div class="tableColumn tableCol-30">제목</div>
				<div class="tableColumn tableCol-15">글쓴이</div>
				<div class="tableColumn tableCol-15">등록일</div>
				<div class="tableColumn tableCol-15">참여업체수</div>
				<div class="tableColumn tableCol-15">마감기한</div>
			</li>
			<c:forEach var="tenderList" items="${tenderList}">
				<li class="tableListContent tenderLiContent" id="${tenderList.tender_code }">
					<div class="tableColumn tableCol-10-1" data-label="번호">${tenderList.rownum }</div>
					<div class="tableColumn tableCol-30" data-label="제목">${tenderList.tender_title }</div>
					<div class="tableColumn tableCol-15" data-label="글쓴이">${tenderList.member_id }</div>
					<div class="tableColumn tableCol-15" data-label="등록일">${tenderList.t_creation_date }</div>
					<div class="tableColumn tableCol-15" data-label="참여업체수"></div>
					<div class="tableColumn tableCol-15" data-label="마감기한">${tenderList.tender_deadline }</div>
				</li>
			</c:forEach>
		</ul>
		<div id="tenderWriteDiv" class="tenderWriteDiv">
			<input type="submit" id="tenderWrite" class="tenderWriteBtn" name="tenderWrite" value="작성하기">
		</div>
	</div>
</form>
<%--입찰 공고 테이블 끝 --%>

<script src="/resources/js/connect/tenderMain.js"></script>

<%@include file="../include/footer.jsp"%>
