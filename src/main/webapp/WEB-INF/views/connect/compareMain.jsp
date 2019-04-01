<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
	<link rel="stylesheet" href="/resources/css/connect/compareMain.css">
	<%-- 각 도의 시목록 api 키값 시작 --%>
		<input type="hidden" id="sigoon_key" value="b0888bae39fbd0463a9252" />
		<%-- <input type="hidden" name="apiKey" value="E4A59B05-0CF4-3654-BD0C-A169F70CCB34" /> --%>
	<%-- 각 도의 시목록 api 키값 끝 --%>

	<%-- 페이지 시작 --%>
		<div id="chartTotal">
			<div id="chartTop">
			<%-- 지도 나오는 부분 시작 --%>
				<div id="chartdiv"></div>
			<%-- 지도 나오는 부분 끝 --%>
			<%-- 데이터 값 선택 시작 --%>
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
			<%-- 데이터 값 선택 끝 --%>
			</div>
		<%-- 상품목록 시작 --%>
			<div id="compareTable">
				<form action="#" method="post">
					<div id="compareContainer">
						<div id="compareSelectDiv">
							<select class="compareSelect">
								<option>판매순</option>
								<option>가격 높은순</option>
								<option>가격 낮은순</option>
								<option>별점 평균순</option>
							</select>
							<select class="compareSelect" id="contentnum">
								<option value="5">5</option>
								<option value="10">10</option>
							</select>
						</div>
						<ul id="compareBoardUl">
							<li id="compareLiHeader">
								<div class="col col-10-1">상품코드</div>
								<div class="col col-15">상품이름</div>
								<div class="col col-30">상품 상세설명</div>
								<div class="col col-10-1">가격</div>
								<div class="col col-15">측정 적절 평수</div>
								<div class="col col-10-1">측정 지점</div>
								<div class="col col-15">서비스 가능지역</div>
								<div class="col col-10-1">별점 평균</div>
								<div class="col col-10-1">판매 건수</div>
							</li>
							<c:forEach var="pList" items="${pList }">
								<li class="compareLiContent">
									<div class="col col-10-1" data-label="상품코드">${pList.product_code}</div>
									<div class="col col-15" data-label="상품이름">${pList.product_name}</div>
									<div class="col col-30" data-label="상품 상세설명">${pList.detail}</div>
									<div class="col col-10-1" data-label="가격">${pList.price}</div>
									<div class="col col-15" data-label="측정 적절 평수">${pList.area}</div>
									<div class="col col-10-1" data-label="측정 지점">${pList.branch}</div>
									<div class="col col-15" data-label="서비스 가능지역">${pList.service_area}</div>
									<div class="col col-10-1" data-label="별점 평균">${pList.star_average}</div>
									<div class="col col-10-1" data-label="판매 건수">${pList.sell_num}</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</form>
			</div>
			<div>
				<c:if test="${criteria.prev}">
					<a href="javascript:page(${criteria.getStartPage()-1});">&laquo;</a>
				</c:if>
				<c:forEach begin="${criteria.getStartPage() }" end="${criteria.getEndPage() }" var="idx">
					<a href="javascript:page(${idx });">${idx}</a>
				</c:forEach>
				<c:if test="${criteria.next}">
					<a href="javascript:page(${criteria.getEndPage()+1});">&raquo;</a>
				</c:if>
			</div>
		<%-- 상품목록 끝 --%>
		</div>
	<%-- 페이지 끝 --%>

	<script src="resources/js/connect/core.js"></script>
	<script src="resources/js/connect/maps.js"></script>
	<script src="resources/js/connect/southKoreaHigh.js"></script>
	<script src="resources/js/connect/animated.js"></script>
	<script src="resources/js/connect/compareMain.js"></script>
<%@include file="../include/footer.jsp" %>