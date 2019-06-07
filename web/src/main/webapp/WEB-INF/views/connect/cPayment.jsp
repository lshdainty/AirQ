<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/resources/js/include/jquery-3.3.1.min.js"></script>
</head>
<body>
	<%--광역시/도/시/구/동 선택 api키값 시작 --%>
	<input type="hidden" id="sido_key" value="12685d425f1af0872d756c" />
	<input type="hidden" id="sigoon_key" value="b0888bae39fbd0463a9252" />
	<input type="hidden" id="dong_key" value="91afccaa8d7f499151ee3b" />
	<input type="hidden" name="apiKey" value="E4A59B05-0CF4-3654-BD0C-A169F70CCB34" />
	<%--광역시/도/시/구/동 선택 api키값 끝 --%>
	
	<%--결제정보 시작 --%>
	<form>
		<input type="hidden" id="product_code" value="${productContent.product_code}">
		<label for="product_name">상품명 : </label>
		<input type="text" id="product_name" value="${productContent.product_name}" readonly><br/>
		<label for="company_name">서비스 회사명  : </label>
		<input type="text" id="company_name" value="${productContent.companyVO.company_name}" readonly><br/>
		<label for="payment_price">가격 : </label>
		<input type="text" id="payment_price" value="${productContent.product_price}" readonly><br/>
		<label>우편번호</label>
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="d_zipcode" name="d_zipcode" value="${addr.m_zipcode}" placeholder="우편번호">
		<input type="text" id="d_road_addr" name="d_road_addr" value="${addr.m_road_addr}" placeholder="도로명주소"><br>
		<input type="text" id="d_addr" name="d_addr" value="${addr.m_addr}" placeholder="지번주소">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="d_addr_detail" name="d_addr_detail" value="${addr.m_addr_detail}" placeholder="상세주소">
		<input type="text" id="sample4_extraAddress" placeholder="참고항목"><br>
		
		<label for="d_service_date">서비스 날짜선택 : </label>
		<input type="datetime-local" id="d_service_date" min="" required>
		<button type="button" id="cOrder">주문</button>
	</form>
	<%--결제정보 끝 --%>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="/resources/js/connect/cPayment.js"></script>
</body>
</html>