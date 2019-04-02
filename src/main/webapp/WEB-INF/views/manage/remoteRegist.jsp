<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/manage/remoteRegist.css" />
<div class="re_container">
	<div class="contain">
		<div class="column-6 form-select">
			<select name="id" onchange="SelectValue(this.value)">
				<option selected>원격제어 종류</option>
				<option value="보일러">보일러</option>
				<option value="창문">창문</option>
				<option value="공기청정기">공기청정기</option>
				<option value="환풍기">환풍기</option>
			</select>

		</div>

		<div class="column-7 form-select">
			<select name="id" onchange="SelectValue2(this.value)">
				<option selected>위치</option>
				<option value="거실">거실</option>
				<option value="안방">안방</option>
				<option value="아이방">아이방</option>
				<option value="배란다">배란다</option>
			</select>
		</div>
	</div>
	<br />

	<div class="text">
		<input type="text" id="s_id" placeholder="원격제어 종류"><br /> <input
			type="text" id="s_id2" placeholder="위치"><br />
			
	<button id="btn-reg">등록하기</button>
	<button id="btn-can">취소</button>
	</div>

</div>

<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src='resources/js/manage/remoteRegist.js'></script>
<%@include file="../include/footer.jsp"%>