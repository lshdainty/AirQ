<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/connect/tenderWrite.css" rel="stylesheet" />

<%--입찰 공고 작성 테이블 시작 --%>
<h1 id="tenderWriteTitle">입찰 작성</h1>
<!-- <form action="/tenderWriteComplete" method="POST">
	<table id="tenderWriteTbl">
		<tr>
			<td class="tr">제목</td>
			<td class="tr"><input type="text" id="tender_title"
				name="tender_title" required autocomplete="off"></td>
		</tr>
		<tr>
			<td>담당자</td>
			<td><input type="text" id="tender_name" name="tender_name"
				required autocomplete="off"></td>
		</tr>
		<tr>
			<td>단체명</td>
			<td><input type="text" id="group_name" name="group_name"
				required autocomplete="off"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="button" onclick="sample4_execDaumPostcode()"
				value="우편번호 찾기"><br> <input type="text"
				id="sample4_postcode" name="t_zipcode" placeholder="우편번호"> <input
				type="text" id="sample4_roadAddress" name="t_road_addr"
				placeholder="도로명주소"><br> <input type="text"
				id="sample4_jibunAddress" name="t_addr" placeholder="지번주소">
				<span id="guide" style="color: #999; display: none"></span> <input
				type="text" id="sample4_detailAddress" name="t_addr_detail"
				placeholder="상세주소"> <input type="text"
				id="sample4_extraAddress" placeholder="참고항목"></td>
		</tr>
		<tr>
			<td>측정 일자</td>
			<td><input type="datetime-local" id="service_date"
				name="service_date" required autocomplete="off"></td>
		</tr>
		<tr>
			<td>마감 기한</td>
			<td><input type="datetime-local" id="tender_deadline"
				name="tender_deadline" required autocomplete="off"></td>
		</tr>
		<tr>
			<td>개찰 일시</td>
			<td><input type="datetime-local" id="bid_open_date"
				name="bid_open_date" required autocomplete="off"></td>
		</tr>
		<tr>
			<td>예산</td>
			<td><input type="text" id="budget" name="budget" required
				autocomplete="off"></td>
		</tr>
		<tr>
			<td>평수</td>
			<td><input type="text" id="t_space" name="t_space" required
				autocomplete="off"></td>
		</tr>
		<tr>
			<td>층수</td>
			<td><input type="text" id="floor_number" name="floor_number"
				required autocomplete="off"></td>
		</tr>
		<tr>
			<td>계산 기간</td>
			<td><select id="calculate_period" name="calculate_period">
					<option value="0">전체</option>
					<option value="-3">3개월</option>
					<option value="-6">6개월</option>
					<option value="-9">9개월</option>
					<option value="-12">1년</option>
			</select> <span id="calculatePeriodN"> 사용자 지정에 따라 점수 계산 기간을 지정할 수 있습니다.</span>
			</td>
		</tr>
		<tr>
			<td>낙찰 결정 방법</td>
			<td><textarea rows="2" cols="50" id="winning_bid_way"
					name="winning_bid_way" required autocomplete="off"></textarea></td>
		</tr>
		<tr>
			<td>요구사항</td>
			<td><textarea rows="8" cols="50" id="requirement"
					name="requirement" required autocomplete="off"></textarea></td>
		</tr>
	</table>
	<div id="tenderWriteBtnDiv">
		<input type="submit" id="tenderWriteBtn" name="tenderWriteBtn"
			value="작성완료">
	</div>
</form> -->


	<table id="tenderWriteTbl">
		<tr>
			<td class="tr">제목</td>
			<td class="tr"><input type="text" id="tender_title"
				name="tender_title" required autocomplete="off"></td>
		</tr>
		<tr>
			<td>담당자</td>
			<td><input type="text" id="tender_name" name="tender_name"
				required autocomplete="off"></td>
		</tr>
		<tr>
			<td>단체명</td>
			<td><input type="text" id="group_name" name="group_name"
				required autocomplete="off"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="button" onclick="sample4_execDaumPostcode()"
				value="우편번호 찾기"><br> 
				<input type="text" id="sample4_postcode" name="t_zipcode" placeholder="우편번호"> 
				<input type="text" id="sample4_roadAddress" name="t_road_addr"
				placeholder="도로명주소"><br> 
				<input type="text" id="sample4_jibunAddress" name="t_addr" placeholder="지번주소">
				<span id="guide" style="color: #999; display: none"></span> 
				<input type="text" id="sample4_detailAddress" name="t_addr_detail"
				placeholder="상세주소"> 
				<input type="text" id="sample4_extraAddress" placeholder="참고항목"></td>
		</tr>
		<tr>
			<td>측정 일자</td>
			<td><input type="date" id="service_date"
				name="service_date" required autocomplete="off"></td>
		</tr>
		<tr>
			<td>마감 기한</td>
			<td><input type="date" id="tender_deadline"
				name="tender_deadline" required autocomplete="off"></td>
		</tr>
		<tr>
			<td>개찰 일시</td>
			<td><input type="date" id="bid_open_date"
				name="bid_open_date" required autocomplete="off"></td>
		</tr>
		<tr>
			<td>예산</td>
			<td><input type="text" id="budget" name="budget" required
				autocomplete="off"></td>
		</tr>
		<tr>
			<td>평수</td>
			<td><input type="text" id="t_space" name="t_space" required
				autocomplete="off"></td>
		</tr>
		<tr>
			<td>층수</td>
			<td><input type="text" id="floor_number" name="floor_number"
				required autocomplete="off"></td>
		</tr>
		<tr>
			<td>계산 기간</td>
			<td><select id="calculate_period" name="calculate_period">
					<option value="0">전체</option>
					<option value="-3">3개월</option>
					<option value="-6">6개월</option>
					<option value="-9">9개월</option>
					<option value="-12">1년</option>
			</select> <span id="calculatePeriodN"> 사용자 지정에 따라 점수 계산 기간을 지정할 수 있습니다.</span>
			</td>
		</tr>
		<tr>
			<td>낙찰 결정 방법</td>
			<td><textarea rows="2" cols="50" id="winning_bid_way"
					name="winning_bid_way" required autocomplete="off"></textarea></td>
		</tr>
		<tr>
			<td>요구사항</td>
			<td><textarea rows="8" cols="50" id="requirement"
					name="requirement" required autocomplete="off"></textarea></td>
		</tr>
	</table>
	<div id="tenderWriteBtnDiv">
		<button id="tenderWriteBtn">작성완료</button>
	</div>



<%--입찰 공고 작성 테이블 끝 --%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/connect/tenderWrite.js"></script>
<%@include file="../include/footer.jsp"%>