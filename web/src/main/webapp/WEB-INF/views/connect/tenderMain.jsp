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
		<h2 id="tenderTitle" class="tenderTitle">입찰 공고</h2>
		<div id="tenderSelectDiv" class="tenderSelectDiv"></div>
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
				<li class="tableListContent tenderLiContent post-item"
					id="${tenderList.tender_code }">
					<div class="tableColumn tableCol-10-1" data-label="번호">${tenderList.rownum }</div>
					<div class="tableColumn tableCol-30" data-label="제목">${tenderList.tender_title }</div>
					<div class="tableColumn tableCol-15" data-label="글쓴이">${tenderList.member_id }</div>
					<div class="tableColumn tableCol-15" data-label="등록일">${tenderList.t_creation_date }</div>
					<div class="tableColumn tableCol-15" data-label="참여업체수">${tenderList.company_count }</div>
					<div class="tableColumn tableCol-15" data-label="마감기한">${tenderList.d_day }</div>
				</li>
			</c:forEach>
		</ul>
		<div id="tenderWriteDiv" class="tenderWriteDiv"></div>
		<nav aria-label="Page navigation example">
			<div class="d-flex justify-content-center">
				<ul class="pagination">
					<c:if test="${criteria.prev}">
						<li class="page-item"><a class="page-link"
							href="javascript:page(${criteria.getStartPage()-1});"
							aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					</c:if>
					<c:forEach begin="${criteria.getStartPage() }"
						end="${criteria.getEndPage() }" var="idx">
						<li class="page-item"><a class="page-link"
							href="javascript:page(${idx });">${idx}</a></li>
					</c:forEach>
					<c:if test="${criteria.next}">
						<li class="page-item"><a class="page-link"
							href="javascript:page(${criteria.getEndPage()+1});"
							aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>
</form>
<%--입찰 공고 테이블 끝 --%>

<script src="/resources/js/connect/tenderMain.js"></script>

<%@include file="../include/footer.jsp"%>
