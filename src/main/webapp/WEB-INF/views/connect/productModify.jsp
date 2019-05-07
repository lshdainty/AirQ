<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<input type="hidden" id="sido_key" value="12685d425f1af0872d756c" />	
<div class="container">
	<div class="row">
		<div class="col-md-12 order-md-4">
			<form class="needs-validation" enctype="multipart/form-data" action="/productUpdate" method="get" novalidate >
				<input type="hidden" name="product_code" value="${productContent.product_code}"/>
				<%-- 상품 이름 시작 --%>
				<div class="row">
					<div style="width: 100%">
						<label for="firstName">서비스 상품 이름</label> 
						<input type="text" class="form-control" id="product_name" placeholder="Product Name" required name="product_name" value="${productContent.product_name}">
						<div class="invalid-feedback">ProductName is empty.</div>
					</div>
				</div>
				<%-- 상품 이름 끝 --%>
				<%--상품 기본 정보 선택 시작 --%>
				<div class="product_info">
					<label for="product_info">서비스 상품 상세 정보</label><br/>
					<label for="product_price">가격 : </label>
					<input type="number" id="product_price" name="product_price" placeholder="예시:10000" value="${productContent.product_price}"><br/>
					<label for="possible_area">측정 가능지역 : </label>
					<select id="sido_code" class="select">
						<option>광역시/도</option>
					</select>
					<select id="sigoon_code" class="select">
						<option>시/구</option>
					</select>
					<button id="areaAdd" type="button">가능지역 추가하기</button><br/>
					<div id="p_possible_area">
						<c:forEach var="aList" items="${productContent.areaVO }">
							<label for="area_code">${aList.area_do }:${aList.area_si }</label>
							<input type="hidden" id="area_code" name="area_code" value="${aList.area_code }" /><br/>
						</c:forEach>
					</div>
					<label for="p_space">측정 적절 평수 : </label>
					<select id="p_space" name="p_space" class="select">
						<option>선택</option>
						<option value="1" <c:if test="${productContent.p_space == 1}">selected</c:if>>1~10평</option>
						<option value="2" <c:if test="${productContent.p_space == 2}">selected</c:if>>11~20평</option>
						<option value="3" <c:if test="${productContent.p_space == 3}">selected</c:if>>21~30평</option>
						<option value="4" <c:if test="${productContent.p_space == 4}">selected</c:if>>31~40평</option>
						<option value="5" <c:if test="${productContent.p_space == 5}">selected</c:if>>41~50평</option>
						<option value="6" <c:if test="${productContent.p_space == 6}">selected</c:if>>51~60평</option>
						<option value="7" <c:if test="${productContent.p_space == 7}">selected</c:if>>61~70평</option>
						<option value="8" <c:if test="${productContent.p_space == 8}">selected</c:if>>71~80평</option>
						<option value="9" <c:if test="${productContent.p_space == 9}">selected</c:if>>81~90평</option>
						<option value="10" <c:if test="${productContent.p_space == 10}">selected</c:if>>91~100평</option>
						<option value="11" <c:if test="${productContent.p_space == 11}">selected</c:if>>100평~</option>
					</select><br/>
					<label for="measure_point">측정 지점 : </label>
					<input type="number" id="measure_point" name="measure_point" placeholder="예시:3" value="${productContent.measure_point}"/>
				</div>
				<%--상품 기본 정보 선택 끝 --%>
				<%-- 상품 내용 시작 --%>
				<div class="mb-3">
					<label for="username">서비스 상품 내용</label>
					<div class="input-group">
						<textarea rows="20" cols="100" class="form-control" id="product_detail"
							placeholder="Product Content" name="product_detail" required>${productContent.product_detail}</textarea>
						<div class="invalid-feedback" style="width: 100%;">ProductContent is empty.</div>
					</div>
				</div>
				<%-- 상품 내용 끝 --%>
				<hr class="mb-4">
				<button class="btn btn-primary btn-lg btn-block" type="submit">Write</button>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script src="/resources/js/connect/productWrite.js"></script>
<%@include file="../include/footer.jsp"%>