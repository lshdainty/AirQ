<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/connect/product.css" rel="stylesheet" />

<main class="site_main view miw1180">
<section class="viewdetail clear">
	<h3 class="s_out">상품상세정보</h3>
	<div class="imgs on_w">
		<div class="visual">
			<a href="#largeviewLayer" data-type="largeviewlayer"
				class="custom_cursor"> <img alt=""
				src="resources/uploadFile/images/${productContent.file_name}" />
			</a>
		</div>
	</div>
	<div class="info">
		<a class="brand ellipsis tc_1">${productContent.companyVO.company_name}</a>
		<h1 class="name tc_3">${productContent.product_name}</h1>
		<dl class="price clear">
			<dt class="final">적절평수</dt>
			<dd>
				<strong class=""> <c:choose>
						<c:when test="${productContent.p_space == '1'}">1~10평</c:when>
						<c:when test="${productContent.p_space == '2'}">11~20평</c:when>
						<c:when test="${productContent.p_space == '3'}">21~30평</c:when>
						<c:when test="${productContent.p_space == '4'}">31~40평</c:when>
						<c:when test="${productContent.p_space == '5'}">41~50평</c:when>
						<c:when test="${productContent.p_space == '6'}">51~60평</c:when>
						<c:when test="${productContent.p_space == '7'}">61~70평</c:when>
						<c:when test="${productContent.p_space == '8'}">71~80평</c:when>
						<c:when test="${productContent.p_space == '9'}">81~90평</c:when>
						<c:when test="${productContent.p_space == '10'}">91~100평</c:when>
						<c:when test="${productContent.p_space == '11'}">100~평</c:when>
					</c:choose>
				</strong>
			</dd>
			<dt class="final">상품코드</dt>
			<dd>
				<strong class="" id="product_code">${productContent.product_code}</strong>
			</dd>
			<dt class="final">측정지점</dt>
			<dd>
				<strong class="">${productContent.measure_point}곳</strong>
			</dd>
			<dt class="final">측정물질</dt>
			<dd>
				<strong class="" style="white-space: nowrap;"> <c:forEach
						var="mList" items="${productContent.matterVO }" varStatus="status">
						<span>${mList.matter_name }<c:if test="${!status.last}">, </c:if></span>
					</c:forEach>
				</strong>
			</dd>
			<dt class="final">판매수량</dt>
			<dd>
				<strong class="">${productContent.sellnum}개</strong>
			</dd>
			<dt class="final">만족도평균</dt>
			<dd>
				<strong class="">${productContent.staravg}점</strong>
			</dd>
		</dl>
		<dl class="price lc_e5 clear">
			<dt class="final">상품가격</dt>
			<dd>
				<strong class="now tc_3">${productContent.product_price}원</strong>
			</dd>
		</dl>
		<div class="on_w">
			<div class="option_cale" style="margin-top: 0px;">
				<ul class="option_list"></ul>
				<!---->
			</div>
			<div class="btns clear">
				<button type="button" id="paymentButton" class="btn_add large">구매하기</button>
				<button type="button" id="reportButton" class="btn_buy dark large">신고하기</button>
			</div>

			<c:if
				test="${(sessionScope.user.member_devision == 'se') ||  (sessionScope.user.member_devision == 'ma')}">
				<div class="btns clear">
					<button id="productModify" type="button" class="btn_add large">상품수정</button>
					<button id="productDelete" type="button" class="btn_buy dark large">상품삭제</button>
				</div>
			</c:if>
		</div>
	</div>
</section>

<article class="cont_product lc_e5 view">
	<div class="info-tab">
		<div class="detail_tab active">상품정보</div>
		<div class="review_tab">상품후기</div>
	</div>
	${productContent.product_detail}
</article>
</main>

<div class="cont_review">

	<div class="info-tab">
		<div class="detail_tab">상품정보</div>
		<div class="review_tab active">상품후기</div>
	</div>

	<div id="replys">
		<c:forEach var="reply" items="${productReply}">
			<div class="companyReview">
				<p class="reviewId">
					${reply.member_id}<span class="reviewDate">${reply.r_creation_date}</span>
				</p>
				<p class="memberStar">
					별점7<span class="star">★★★★★★★</span>
				</p>
				<div class="reviewText">
					<p>${reply.reply_content}</p>
				</div>
				<c:if test="${sessionScope.user.member_id==reply.member_id}">
					<div class="comment-button">
						<button class="comment__button comment__button--red reply-delete">삭제</button>
						<input type="hidden" class="reply_code"
							value="${reply.reply_code}">
					</div>
				</c:if>
				<input type="hidden" class="reply_code" value="${reply.reply_code}">
			</div>
		</c:forEach>
	</div>
</div>

<!-- end of product-page-product-details-section-->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
	function fnMove(seq) {
		var offset = $("#div" + seq).offset();
		$('html, body').animate({
			scrollTop : offset.top
		}, 400);
	}

	$(function() {
		$('.detail_tab').click(function() {
			var offset = $('.cont_product').offset();
			console.log(offset);
			$('html, body').animate({
				scrollTop : offset.top - 66
			});
		});
		$('.review_tab').click(function() {
			var offset = $('.cont_review').offset();
			console.log(offset);
			$('html, body').animate({
				scrollTop : offset.top - 66
			});
		});
	});
</script>


<!-- end of product-page-product-details-section-->
<script src="/resources/js/connect/productContent.js"></script>
<%@include file="../include/footer.jsp"%>