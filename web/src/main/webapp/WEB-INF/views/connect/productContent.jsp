<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/connect/product.css" rel="stylesheet" />
<%-- <div id="product-page-straightflexxing">
	<!-- Details Start here -->
	<div class="product-page-product-details-section" id="product">
		<div class="product-page-product-image-block">
			<div class="product-page-hero-product-image">
			</div>
		</div>
\
				</div>
\
			</div>
			<!-- end of product-page-amazingsalescopy-->
			<div class="product-page-info-section type">
				<h2 class="product-page-h2-heading" itemprop="type">
				</h2>
				<h2 class="product-page-h2-heading" itemprop="abv">
				</h2>
			</div>
			<div class="product-page-info-section price">
				<h2 class="product-page-h2-heading price-previous" id="DFH-price-previous-usd">${productContent.product_price}</h2>
				<h2 class="product-page-h2-heading price" id="DFH-price-usd" itemprop="price">가격 : </h2>
				<span id="DFH-price-per-unit-usd" style="display: none;">${productContent.product_price}</span>
			</div>
			<button id="paymentButton" class="product-page-buybutton button-cart button-cart-DFH" data-loading-text="Yesss..." type="button">
				<span class="button-cart-text">Add to Cart</span>
			</button>
			<button id="reportButton">신고하기</button>
			<c:if test="${(sessionScope.user.member_devision == 'se') ||  (sessionScope.user.member_devision == 'ma')}">
				<button id="productModify">상품수정</button>
				<button id="productDelete">상품삭제</button>
			</c:if>
		</div>
	</div>
	<!-- end of product-page-product-details-list-block -->
</div>
<div id="productDetail">
	${productContent.product_detail}
</div>
<div id="comment">
	<div class="comment-wrap">
		<div class="comment-header">
			<h2 class="comment__title">상품평</h2>
			<span class="comment__count">총 <em id="reply_count">${productContent.reply_count}</em>개</span>
		</div>
		<div>
			<div id="replys">
				<c:forEach var="reply" items="${productReply}">
					<div class="comment-list">
						<div class="comment-l">
							<div class="comment">
								<div class="comment-meta">
									<span class="comment__name"><a href="#">${reply.member_id}</a></span>
									<span class="comment__date">${reply.r_creation_date}</span>
								</div>
								<div class="comment-content">
									<div><p><br> ${reply.reply_content}</p></div>
								</div>
								<c:if test="${sessionScope.user.member_id==reply.member_id}" >
									<div class="comment-button">
										<button class="comment__button comment__button--red reply-delete" >삭제</button>
										<input type="hidden" class="reply_code" value="${reply.reply_code}">
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
 --%>

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
					<button id="productModify" type="button" 
						class="btn_add large">상품수정</button>
					<button id="productDelete" type="button" 
						class="btn_buy dark large">상품삭제</button>
				</div>
			</c:if>
		</div>
	</div>
</section>

<article class="cont_product lc_e5 view">
	${productContent.product_detail}</article>
</main>



<!-- end of product-page-product-details-section-->
<script src="/resources/js/connect/productContent.js"></script>
<%@include file="../include/footer.jsp"%>