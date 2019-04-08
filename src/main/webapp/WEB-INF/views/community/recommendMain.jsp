<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="resources/css/comunity/comunity-header.css">


<%-- 커뮤니티 - 상품추천 헤더 시작 --%>
<div class="page-header">
	<h3>커뮤니티 - 상품추천</h3>
	<p>Product Recommand</p>
</div>
<%-- 커뮤니티 - 상품추천 헤더 끝 --%>

<%-- 커뮤니티 - 상품추천 리스트 시작 --%>
<div class="album py-5 bg-light">
	<div class="row">
		<c:forEach var="post" items="${posts}">
			<div class="col-md-4">
				<div class="card mb-4 ">
					<img src="${post.post_thumbnail}" class="card-img-top" style="height:200px;overflow:hidden" alt="...">
					<div class="card-body">
						<h5 class="card-title">${post.post_title}</h5>
						<a href="recommendDetail?post_code=${post.post_code}" class="btn btn-primary">자세히</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


	<div class="d-flex flex-row-reverse bd-highlight">
		<div class="p-2 bd-highlight">
			<button class="btn btn-primary" type="submit" id="recommend-write">글작성</button>
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
	<%-- 페이지네이션 끝 --%>
</div>



<%-- 커뮤니티 - 상품추천 리스트 끝 --%>

<%-- 스크립트 링크 시작 --%>

<script src="resources/js/community/community.js"></script>

<%-- 스크립트 링크 끝 --%>


<%@include file="../include/footer.jsp"%>