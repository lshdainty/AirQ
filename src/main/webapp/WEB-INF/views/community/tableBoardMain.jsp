<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="resources/css/comunity/comunity.css">
<link href="/resources/css/include/table.css" rel="stylesheet" />
<input type="hidden" id="board_code" value="${board_code}">
<%-- 커뮤니티 - 상품추천 헤더 시작 --%>
<div class="page-header">
	<h3>커뮤니티 - 자유게시판</h3>
	<p>Liberty Board</p>
</div>
<%-- 커뮤니티 - 상품추천 헤더 끝 --%>
<div class="py-5">
	<%-- 	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">#</th>
				<th scope="col">TITLE</th>
				<th scope="col">CONTENT</th>
				<th scope="col">WRITER</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="post" items="${posts}">
			<tr>
				<th scope="row">1</th>
				<td>${post.post_title}</td>
				<td class="post-detail col-sm-10">${post.post_content}<input type="hidden" value="${post.post_code}"></td>
				<td>${post.member_id}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table> --%>
	<ul class="tableList">
		<li class="tableListHeader">
			<div class="tableColumn tableCol-10-1">번호</div>
			<div class="tableColumn tableCol-30">제목</div>
			<div class="tableColumn tableCol-15">내용</div>
			<div class="tableColumn tableCol-15">작성자</div>
			<div class="tableColumn tableCol-15">등록일</div>
		</li>
		<c:forEach var="post" items="${posts}">
			<li class="tableListContent post-detail">
				<input type="hidden" value="${post.post_code}">
				<div class="tableColumn tableCol-10-1" data-label="번호">${post.rownum }</div>
				<div class="tableColumn tableCol-30" data-label="제목">${post.post_title } [${post.reply_count }]</div>
				<div class="tableColumn tableCol-15" data-label="내용">${post.post_content }</div>
				<div class="tableColumn tableCol-15" data-label="작성자">${post.member_id}</div>
				<div class="tableColumn tableCol-15" data-label="작성일">${post.p_creation_date}</div>
			</li>
		</c:forEach>
	</ul>


	<div class="d-flex flex-row-reverse bd-highlight">
		<div class="p-2 bd-highlight">
			<button class="btn btn-primary" type="submit" id="post-write">글작성</button>
		</div>
	</div>

	<%-- 페이지네이션 시작 --%>
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
	<%-- 페이지네이션 끝 --%>
</div>

<%-- 스크립트 링크 시작 --%>
<script src="resources/js/community/community.js"></script>
<script>
function page(idx){
	var pagenum = idx;
	var board_code = $('#board_code').val();
	var pageURL="/tableBoardMain?board_code="+board_code+"&pagenum="+pagenum;
	window.location.href=pageURL;
}
</script>
<%-- 스크립트 링크 끝 --%>
<%@include file="../include/footer.jsp"%>