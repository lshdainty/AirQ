<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<input type="hidden" id="sido_key" value="12685d425f1af0872d756c" />	
<div class="container">
	<div class="row">
		<div class="col-md-12 order-md-4">
			<form class="needs-validation" enctype="multipart/form-data" action="productInsert" method="get" novalidate >
				<%-- 상품 이름 시작 --%>
				<div class="row">
					<div style="width: 100%">
						<label for="firstName">서비스 상품 이름</label> 
						<input type="text" class="form-control" id="product_title" placeholder="Product Name" required name="product_title">
						<div class="invalid-feedback">ProductName is empty.</div>
					</div>
				</div>
				<%-- 상품 이름 끝 --%>
				<%--상품 기본 정보 선택 시작 --%>
				<div class="product_detail">
					<label for="product_detail">서비스 상품 상세 정보</label><br/>
					<label for="payment_price">가격 : </label>
					<input type="number" id="payment_price" name="payment_price" placeholder="예시:10000"><br/>
					<label for="payment_price">측정 가능지역 : </label>
					<select id="sido_code" class="select">
						<option>광역시/도</option>
					</select>
					<input type="hidden" id="d_addr_do" name="d_addr_do" />
					<select id="sigoon_code" class="select">
						<option>시/구</option>
					</select>
					<input type="hidden" id="d_addr_si" name="d_addr_si" />
					<button id="areaAdd" type="button">가능지역 추가하기</button><br/>
					<div id="possibleArea">
					</div>
					<label for="payment_price">측정 적절 평수 : </label>
					<select id="p_space" class="select">
						<option>선택</option>
						<option value="1">1~10평</option>
						<option value="2">11~20평</option>
						<option value="3">21~30평</option>
						<option value="4">31~40평</option>
						<option value="5">41~50평</option>
						<option value="6">51~60평</option>
						<option value="7">61~70평</option>
						<option value="8">71~80평</option>
						<option value="9">81~90평</option>
						<option value="10">91~100평</option>
						<option value="11">100평~</option>
					</select><br/>
					<label for="payment_price">측정 지점 : </label>
					<input type="number" id="measure_point" name="measure_point" placeholder="예시:3"/>
				</div>
				<%--상품 기본 정보 선택 끝 --%>
				<%-- 상품 내용 시작 --%>
				<div class="mb-3">
					<label for="username">서비스 상품 내용</label>
					<div class="input-group">
						<textarea rows="20" cols="100" class="form-control" id="product_content"
							placeholder="Product Content" name="product_content" required></textarea>
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
<script src="resources/js/connect/productWrite.js"></script>
<%@include file="../include/footer.jsp"%>