<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<%--광역시/도/시/구/동 선택 api키값 시작 --%>
	<input type="hidden" id="sido_key" value="12685d425f1af0872d756c" />
	<input type="hidden" id="sigoon_key" value="b0888bae39fbd0463a9252" />
	<input type="hidden" id="dong_key" value="91afccaa8d7f499151ee3b" />
	<input type="hidden" name="apiKey" value="E4A59B05-0CF4-3654-BD0C-A169F70CCB34" />
	<%--광역시/도/시/구/동 선택 api키값 끝 --%>
	
	<%--결제정보 시작 --%>
	<input type="hidden" id="product_code" value="${productContent.product_code}">
	<label for="product_name">상품명 : </label>
	<input type="text" id="product_name" value="${productContent.product_name}" readonly><br/>
	<label for="company_name">서비스 회사명  : </label>
	<input type="text" id="company_name" value="${productContent.companyVO.company_name}" readonly><br/>
	<label for="payment_price">가격 : </label>
	<input type="text" id="payment_price" value="${productContent.product_price}" readonly><br/>
	<select id="sido_code" class="select">
		<option>선택</option>
	</select>
	<input type="hidden" id="d_addr_do" name="d_addr_do" />
	<select id="sigoon_code" class="select">
		<option>선택</option>
	</select>
	<input type="hidden" id="d_addr_si" name="d_addr_si" />
	<select id="sidong_code" class="select">
		<option>선택</option>
	</select>
	<input type="hidden" id="d_addr_dong" name="d_addr_dong" />
	<input type="text" id="d_addr_detail" name="d_addr_detail" required autocomplete="off">
	<br/>
	<label for="d_service_date">서비스 날짜선택 : </label>
	<input type="datetime-local" id="d_service_date">
	<button id="cOrder">주문</button>
	<%--결제정보 끝 --%>
	<script src="/resources/js/connect/cPayment.js"></script>
</body>
</html>