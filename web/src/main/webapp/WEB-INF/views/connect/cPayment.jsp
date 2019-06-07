<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.cPayment-wrap {
	
}

.product-info {
	padding: 1rem;
	border: 1px solid #000;
	background: #fff;
	margin-bottom: 1rem;
}

.location-info {
	padding: 1rem;
	border: 1px solid #000;
	background: #fff;
}

.info-title {
	font-size: 1.5rem;
	font-weight: bold;
	padding: .5rem;
}

.info-title span {
	font-size: 0.75rem;
	font-weight: 400;
	color: rgb(131, 131, 131);
	text-transform: uppercase;
}

.cPayment-title {
	background: #fff;
	text-align: center;
	font-size: 24px;
	font-weight: bold;
	padding: 16px;
}

.cPayment-wrap form {
	border: 1px solid #000;
	border-radius: 1rem;
	overflow: hidden;
	background: #ddd;
	padding: 16px;
}

.cPayment-box {
	display: flex;
	border: 1px solid #000;
	border-bottom: none;
	padding: .25rem;
}

.cPayment-box:last-child {
	border-bottom: 1px solid #000;
}

.cPayment-subTitle {
	padding: 0 1rem;
	font-weight: bold;
	min-width: 8rem;
	text-align: center;
	margin: auto 0;
}

.cPayment-subContent {
	padding: 0 1rem;
	border-left: 1px solid #000;
}

.phone-number {
	width: 3rem;
	height: 1.5rem;
}
.order-btn{
	text-align:center;
	padding: 1rem;
}
#cOrder {
	width: 10rem;
	font-size:16px;
	height:2.5rem;
}
</style>
<link rel="stylesheet" href="/resources/css/connect/jquery-ui.css">
<link rel="stylesheet"
	href="/resources/css/connect/wickedpicker.min.css">
<script src="/resources/js/include/jquery-3.3.1.min.js"></script>
<script src="/resources/js/connect/jquery-ui.js"></script>
<script src="/resources/js/connect/wickedpicker.min.js"></script>
</head>
<body>
	<%--광역시/도/시/구/동 선택 api키값 시작 --%>
	<input type="hidden" id="sido_key" value="12685d425f1af0872d756c" />
	<input type="hidden" id="sigoon_key" value="b0888bae39fbd0463a9252" />
	<input type="hidden" id="dong_key" value="91afccaa8d7f499151ee3b" />
	<input type="hidden" name="apiKey"
		value="E4A59B05-0CF4-3654-BD0C-A169F70CCB34" />
	<%--광역시/도/시/구/동 선택 api키값 끝 --%>

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
					<div class="cPayment-subContent">
						${productContent.product_name}</div>
				</div>

				<div class="cPayment-box">
					<div class="cPayment-subTitle">서비스 회사명</div>
					<div class="cPayment-subContent">
						${productContent.companyVO.company_name}</div>
				</div>


				<div class="cPayment-box">
					<div class="cPayment-subTitle">가격</div>
					<div class="cPayment-subContent">
						${productContent.product_price}</div>
				</div>



			</div>


			<div class="location-info">
				<div class="info-title">
					서비스장소 <span>service-location</span>
				</div>


				<div class="cPayment-box">
					<div class="cPayment-subTitle">신청자</div>
					<div class="cPayment-subContent">
						${productContent.product_name}</div>
				</div>


				<div class="cPayment-box">
					<div class="cPayment-subTitle">전화번호</div>
					<div class="cPayment-subContent">
						<select name="" id="" class="phone-number">
							<option value="">선택하세요</option>
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
						</select> - <input type="text" name="" id="" class="phone-number">
						- <input type="text" name="" id="" class="phone-number">
					</div>
				</div>


				<div class="cPayment-box">
					<div class="cPayment-subTitle">서비스장소</div>
					<div class="cPayment-subContent">
						<input type="text" id="d_zipcode" name="d_zipcode"
							value="${addr.m_zipcode}" placeholder="우편번호"> <input
							type="button" onclick="sample4_execDaumPostcode()"
							value="우편번호 찾기"><br>
						<div class="location-detail">
							<input type="text" id="d_zipcode" name="d_zipcode"
								value="${addr.m_zipcode}" placeholder="우편번호"> <input
								type="text" id="d_road_addr" name="d_road_addr"
								value="${addr.m_road_addr}" placeholder="도로명주소"><br>
							<input type="text" id="d_addr" name="d_addr"
								value="${addr.m_addr}" placeholder="지번주소"> <span
								id="guide" style="color: #999; display: none"></span> <input
								type="text" id="d_addr_detail" name="d_addr_detail"
								value="${addr.m_addr_detail}" placeholder="상세주소"> <input
								type="text" id="sample4_extraAddress" placeholder="참고항목"><br>
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
	<script>
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDay() + 2;

		$('#datepicker').val(year + '년' + month + '월' + day + '일');

		$.datepicker.setDefaults({
			dateFormat : 'yymmdd',
			prevText : '이전 달',
			nextText : '다음 달',
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ],
			monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ],
			dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
			showMonthAfterYear : true,
			yearSuffix : '년'
		});
		$("#datepicker").datepicker({
			dateFormat : "yy년mm월dd일",
		});
		$("#timepicker").wickedpicker({
			title : '시간 선택'
		});
	</script>




	<input type="hidden" id="sido_key" value="12685d425f1af0872d756c" />
	<input type="hidden" id="sigoon_key" value="b0888bae39fbd0463a9252" />
	<input type="hidden" id="dong_key" value="91afccaa8d7f499151ee3b" />
	<input type="hidden" name="apiKey"
		value="E4A59B05-0CF4-3654-BD0C-A169F70CCB34" />
	<input type="hidden" id="product_code"
		value="${productContent.product_code}">
	<%--결제정보 끝 --%>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="/resources/js/connect/cPayment.js"></script>
</body>
</html>