<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="resources/css/comunity/comunity.css">
<input type="hidden" id="board_code" value="${board_code}">
<c:if test="${board_code eq 'bd_rec'}">
	<%-- 커뮤니티 - 상품추천 헤더 시작 --%>
	<div class="page-header">
		<h3>커뮤니티 - 상품추천</h3>
		<p>Product Recommand</p>
	</div>
	<%-- 커뮤니티 - 상품추천 헤더 끝 --%>
</c:if>
<c:if test="${board_code eq 'bd_met'}">
	<%-- 커뮤니티 - 대기오염물질 헤더 시작 --%>
	<div class="page-header">
		<h3>커뮤니티 - 대기오염물질</h3>
		<p>atmosphere pollution matter</p>
	</div>
	<%-- 커뮤니티 - 대기오염물질 헤더 끝 --%>
</c:if>


<c:if test="${board_code eq 'bd_imp'}">
	<%-- 커뮤니티 - 대기오염물질 헤더 시작 --%>
	<div class="page-header">
		<h3>커뮤니티 - 공기질향상방법</h3>
		<p>Air Quality Enhancement Methodr</p>
	</div>
	<%-- 커뮤니티 - 대기오염물질 헤더 끝 --%>
</c:if>


<c:if test="${board_code eq 'bd_hea'}">
	<%-- 커뮤니티 - 대기오염물질 헤더 시작 --%>
	<div class="page-header">
		<h3>커뮤니티 - 건강지킴이</h3>
		<p>health guard</p>
	</div>
	<%-- 커뮤니티 - 대기오염물질 헤더 끝 --%>
</c:if>
<%-- 커뮤니티 - 상품추천 리스트 시작 --%>
<div class="album py-5">
	<div class="row">
		<c:forEach var="post" items="${posts}">
			<div class="col-md-4 post-item">
				<div class="card mb-4 ">
					<img src="${post.post_thumbnail}" class="card-img-top"
						style="height: 200px; overflow: hidden" alt="...">
					<div class="card-body">
						<h5 class="card-title">${post.post_title} [${post.reply_count }]</h5>
						<a href="postDetail?post_code=${post.post_code}"
							class="btn btn-primary">자세히</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


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

<button id="fcmTest">TEST</button>

<%-- 커뮤니티 - 상품추천 리스트 끝 --%>

<%-- 스크립트 링크 시작 --%>
<script>
function page(idx){
	var pagenum = idx;
	var board_code = $('#board_code').val();
	var pageURL="/thumbnailBoardMain?board_code="+board_code+"&pagenum="+pagenum;
	window.location.href=pageURL;
}
</script>
<script src="/resources/js/community/community.js"></script>
<%-- 스크립트 링크 끝 --%>


<%@include file="../include/footer.jsp"%>