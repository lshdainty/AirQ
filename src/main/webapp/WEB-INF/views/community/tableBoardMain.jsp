<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="resources/css/comunity/comunity.css">
<%-- 커뮤니티 - 상품추천 헤더 시작 --%>
<div class="page-header">
	<h3>커뮤니티 - 자유게시판</h3>
	<p>Liberty Board</p>
</div>
<%-- 커뮤니티 - 상품추천 헤더 끝 --%>
<div class="bg-light py-5">
	<table class="table">
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
	</table>


	<div class="d-flex flex-row-reverse bd-highlight">
		<div class="p-2 bd-highlight">
			<button class="btn btn-primary" type="submit" id="post-write">글작성</button>
		</div>
	</div>

	<%-- 페이지네이션 시작 --%>
	<nav aria-label="Page navigation example">
		<div class="d-flex justify-content-center">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</div>
	</nav>
</div>
<%-- 페이지네이션 끝 --%>

<%-- 스크립트 링크 시작 --%>
<script src="resources/js/community/community.js"></script>

<%-- 스크립트 링크 끝 --%>
<%@include file="../include/footer.jsp"%>