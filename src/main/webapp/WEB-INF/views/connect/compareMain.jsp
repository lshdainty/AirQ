<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
	<link rel="stylesheet" href="/resources/css/connect/compare.css">
	<%-- 각 도의 시목록 api 키값 시작 --%>
		<input type="hidden" id="sigoon_key" value="b0888bae39fbd0463a9252" />
		<%-- <input type="hidden" name="apiKey" value="E4A59B05-0CF4-3654-BD0C-A169F70CCB34" /> --%>
	<%-- 각 도의 시목록 api 키값 끝 --%>

	<%-- 지도 나오는 부분 시작 --%>
		<div id="chartTotal">
			<div id="chartTop">
				<div id="chartdiv"></div>
				<div id="chartContentDiv">
					<form>
						<input type="text" id="sido_code" value="광역시/도" readonly>
						<select id="sigoon_code">
							<option>지역선택</option>
						</select>
						<select id="space">
							<option>평수 선택</option>
							<option>1~10</option>
							<option>11~20</option>
							<option>21~30</option>
							<option>31~40</option>
							<option>41~50</option>
							<option>51~60</option>
							<option>61~70</option>
							<option>71~80</option>
							<option>81~90</option>
							<option>91~100</option>
							<option>100~</option>
						</select>
						<button id="check">선택확인</button>
					</form>
				</div>
			</div>
			<div id="compareTable">
				<form action="#" method="post">
					<div id="tenderBoardContainer">
						<div id="tenderSelectDiv">
							<select class="tenderSelect">
								<option>판매순</option>
								<option>가격 높은순</option>
								<option>가격 낮은순</option>
								<option>별점 평균순</option>
							</select> 
						</div>
						<ul id="tenderBoardUl">
							<li id="tenderLiHeader">
								<div class="col col-10-1">번호</div>
								<div class="col col-10-1">상품이름</div>
								<div class="col col-10-1">서비스 업체 이름</div>
								<div class="col col-30">측정 물질</div>
								<div class="col col-10-1">평수</div>
								<div class="col col-10-1">가격</div>
								<div class="col col-10-1">별점 평균</div>
							</li>
							<li class="tenderLiContent">
								<div class="col col-10-1" data-label="번호">1</div>
								<div class="col col-10-1" data-label="제목"></div>
								<div class="col col-10-1" data-label="글쓴이">goeun</div>
								<div class="col col-30" data-label="등록일">2019-03-28</div>
								<div class="col col-10-1" data-label="조회수">100</div>
								<div class="col col-10-1" data-label="참여업체수">6</div>
								<div class="col col-10-1" data-label="마감기한">D-7</div>
							</li>
							<li class="tenderLiContent">
								<div class="col col-10-1" data-label="번호">2</div>
								<div class="col col-10-1" data-label="제목">world</div>
								<div class="col col-10-1" data-label="글쓴이">kim</div>
								<div class="col col-30" data-label="등록일">2019-03-27</div>
								<div class="col col-10-1" data-label="조회수">6</div>
								<div class="col col-10-1" data-label="참여업체수">5</div>
								<div class="col col-10-1" data-label="마감기한">D-11</div>
							</li>
						</ul>
					</div>
				</form>
			</div>
		</div>
	<%-- 지도 나오는 부분 끝 --%>

	<script src="resources/js/connect/core.js"></script>
	<script src="resources/js/connect/maps.js"></script>
	<script src="resources/js/connect/southKoreaHigh.js"></script>
	<script src="resources/js/connect/animated.js"></script>
	<script src="resources/js/connect/compareMain.js"></script>
<%@include file="../include/footer.jsp" %>