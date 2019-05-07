<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/connect/product.css" rel="stylesheet" />
<div id="product-page-straightflexxing">
	<!-- Details Start here -->
	<div class="product-page-product-details-section" id="product">
		<div class="product-page-product-image-block">
			<div class="product-page-hero-product-image">
				<img alt="" src="https://www.hopsy.beer/image/catalog/DraftForHome/assets/products/brand_up_2l.png" />
			</div>
		</div>
		<div class="product-page-product-details-list-block">
			<div class="product-page-info-section title">
				<h1 id="product_name" itemprop="name">${productContent.product_name}</h1>
			</div>
			<div class="product-group cart">
				<div class="product-page-info-section brewery">
					<h2 id="product_code" class="product-page-h2-heading" itemprop="type">
						<span class="product-page-heading-type">상품 코드</span> : ${productContent.product_code}
					</h2>
				</div>
				<div class="product-page-info-section brewery">
					<h2 class="product-page-h2-heading" itemprop="type">
						<span class="product-page-heading-type">적절 평수</span> : 
						<c:choose>
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
					</h2>
				</div>
				<div class="product-page-info-section brewery">
					<h2 class="product-page-h2-heading" itemprop="type">
						<span class="product-page-heading-type">측정 지점</span> : ${productContent.measure_point}곳
					</h2>
				</div>
				<div class="product-page-info-section brewery">
					<h2 class="product-page-h2-heading" itemprop="type">
						<span class="product-page-heading-type">서비스 가능지역</span> : 
						<c:forEach var="aList" items="${productContent.areaVO }">
							${aList.area_si }
						</c:forEach>
					</h2>
				</div>
				<div class="product-page-info-section brewery">
					<h2 class="product-page-h2-heading" itemprop="type">
						<span class="product-page-heading-type">회사 이름</span> : ${productContent.companyVO.company_name}
					</h2>
				</div>
			</div>
			<!-- end of product-page-amazingsalescopy-->
			<div class="product-page-info-section type">
				<h2 class="product-page-h2-heading" itemprop="type">
					<span class="product-page-heading-type">판매 개수</span> : ${productContent.sellnum}
				</h2>
				<h2 class="product-page-h2-heading" itemprop="abv">
					<span class="product-page-heading-type">만족도 평균</span> : ${productContent.staravg}점
				</h2>
			</div>
			<div class="product-page-info-section price">
				<h2 class="product-page-h2-heading price-previous" id="DFH-price-previous-usd">${productContent.product_price}</h2>
				<h2 class="product-page-h2-heading price" id="DFH-price-usd" itemprop="price">가격 : ${productContent.product_price}원</h2>
				<span id="DFH-price-per-unit-usd" style="display: none;">${productContent.product_price}</span>
			</div>
			<button id="paymentButton" class="product-page-buybutton button-cart button-cart-DFH" data-loading-text="Yesss..." type="button">
				<span class="button-cart-text">Add to Cart</span>
			</button>
			<c:if test="${sessionScope.user.member_devision == 'se' }">
				<button id="productModify">상품수정</button>
				<button id="productDelete">상품삭제</button>
			</c:if>
		</div>
	</div>
	<!-- end of product-page-product-details-list-block -->
	<div id="productDetail">
		${productContent.product_detail}
	</div>
</div>
<!-- end of product-page-product-details-section-->
<script src="/resources/js/connect/productContent.js"></script>
<%@include file="../include/footer.jsp"%>