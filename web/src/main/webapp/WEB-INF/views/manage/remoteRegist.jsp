<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/manage/remoteRegist.css" />
<!-- <form action="remoteReg" method="POST"> -->
<div class="re_container">

<h3>당신의 기기 별명을 지어주세요!</h3>
<input type="text" id="nickname" placeholder="자신만의 별명을 지어주세요!" style="width: 300px;">
<button id="btn-nickname">중복 확인</button>
<span class="msg"></span><br/><br/>

	<div class="contain">
		<div class="column-6 form-select">
			<select id="selid" name="id">
				<option selected>원격제어 종류</option>
				<option value="보일러">보일러</option>
				<option value="창문">창문</option>
				<option value="공기청정기">공기청정기</option>
				<option value="환풍기">환풍기</option>
			</select>

		</div>

		<div class="column-7 form-select">
			<select id="selid2" name="id">
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
<!-- 		<input type="text" id="s_id" placeholder="원격제어 종류"><br />
		<input type="text" id="s_id2" placeholder="위치"><br /> -->
			
	<button id="btn-reg" disabled="disabled">등록하기</button>
	<button id="btn-can">취소</button>
	</div>

</div>
<!-- </form> -->

<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src='resources/js/manage/remoteRegist.js'></script>
<%@include file="../include/footer.jsp"%>