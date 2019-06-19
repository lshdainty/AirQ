<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/connect/jquery-ui.css">
<link rel="stylesheet" href="/resources/css/connect/wickedpicker.min.css">
<link rel="stylesheet" href="/resources/css/connect/cPayment.css">
<script src="/resources/js/include/jquery-3.3.1.min.js"></script>
<script src="/resources/js/connect/jquery-ui.js"></script>
<script src="/resources/js/connect/wickedpicker.min.js"></script>
</head>
<body>
	<%--결제정보 시작 --%>
	<div class="cPayment-wrap">
		<div class="cPayment-title">결제 페이지</div>
		<form>
			<div class="product-info">
				<div class="info-title">
					상품정보 <span>product-info</span>
				</div>
				<div class="cPayment-box">
					<div class="cPayment-subTitle">상품명</div>
					<div class="cPayment-subContent">${productContent.product_name}</div>
				</div>
				<div class="cPayment-box">
					<div class="cPayment-subTitle">서비스 회사명</div>
					<div class="cPayment-subContent">
						${productContent.companyVO.company_name}</div>
				</div>
				<div class="cPayment-box">
					<div class="cPayment-subTitle">가격</div>
					<div id="payment_price" class="cPayment-subContent">
						${productContent.product_price}</div>
				</div>
			</div>
			<div class="location-info">
				<div class="info-title">
					서비스장소 <span>service-location</span>
				</div>
				<div class="cPayment-box">
					<div class="cPayment-subTitle">신청자</div>
					<div class="cPayment-subContent">${member.member_name}</div>
				</div>
				<div class="cPayment-box">
					<div class="cPayment-subTitle">전화번호</div>
					<div class="cPayment-subContent">
						<select name="first_num" id="first_num" class="phone-number">
							<option value="">선택하세요</option>
							<option value="010" <c:if test="${first_num == 010}">selected</c:if>>010</option>
							<option value="011" <c:if test="${first_num == 011}">selected</c:if>>011</option>
							<option value="016" <c:if test="${first_num == 016}">selected</c:if>>016</option>
							<option value="017" <c:if test="${first_num == 017}">selected</c:if>>017</option>
							<option value="018" <c:if test="${first_num == 018}">selected</c:if>>018</option>
							<option value="019" <c:if test="${first_num == 019}">selected</c:if>>019</option>
						</select> - <input type="text" name="middle_num" id="middle_num" class="phone-number" value="${middle_num}">
						- <input type="text" name="last_num" id="last_num" class="phone-number" value="${last_num}">
					</div>
				</div>
				<div class="cPayment-box">
					<div class="cPayment-subTitle">서비스장소</div>
					<div class="cPayment-subContent">
						<input type="text" id="d_zipcode" name="d_zipcode" value="${member.m_zipcode}" placeholder="우편번호">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
						<div class="location-detail">
							<input type="text" id="d_zipcode" name="d_zipcode" value="${member.m_zipcode}" placeholder="우편번호"> 
							<input type="text" id="d_road_addr" name="d_road_addr" value="${member.m_road_addr}" placeholder="도로명주소"><br>
							<input type="text" id="d_addr" name="d_addr" value="${member.m_addr}" placeholder="지번주소"> 
							<span id="guide" style="color: #999; display: none"></span> 
							<input type="text" id="d_addr_detail" name="d_addr_detail" value="${member.m_addr_detail}" placeholder="상세주소">
							<input type="text" id="sample4_extraAddress" placeholder="참고항목"><br>
						</div>
					</div>
				</div>
				<div class="cPayment-box">
					<div class="cPayment-subTitle">서비스날짜</div>
					<div class="cPayment-subContent">
						<input type="text" id="datepicker">
					</div>
				</div>
				<div class="cPayment-box">
					<div class="cPayment-subTitle">서비스시간</div>
					<div class="cPayment-subContent">
						<input type="text" id="timepicker">
					</div>
				</div>
			</div>
		</form>
		<div class="order-btn">
			<button type="button" id="cOrder">주문하기</button>
		</div>
	</div>
	<input type="hidden" id="sido_key" value="12685d425f1af0872d756c" />
	<input type="hidden" id="sigoon_key" value="b0888bae39fbd0463a9252" />
	<input type="hidden" id="dong_key" value="91afccaa8d7f499151ee3b" />
	<input type="hidden" name="apiKey" value="E4A59B05-0CF4-3654-BD0C-A169F70CCB34" />
	<input type="hidden" id="product_code" value="${productContent.product_code}">
	<%--결제정보 끝 --%>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="/resources/js/connect/cPayment.js"></script>
</body>
</html>