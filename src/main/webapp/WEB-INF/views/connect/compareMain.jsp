<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
	<link rel="stylesheet" href="/resources/css/connect/compareMain.css">
	<link rel="stylesheet" href="/resources/css/include/table.css">
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
					<input type="text" id="sido_code" value="광역시/도" readonly>
					<select id="sigoon_code">
						<option value="선택">선택</option>
					</select>
					<select id="space">
						<option value="0">평수 선택</option>
						<option value="1">1~10</option>
						<option value="2">11~20</option>
						<option value="3">21~30</option>
						<option value="4">31~40</option>
						<option value="5">41~50</option>
						<option value="6">51~60</option>
						<option value="7">61~70</option>
						<option value="8">71~80</option>
						<option value="9">81~90</option>
						<option value="10">91~100</option>
						<option value="11">100~</option>
					</select>
				</div>
			<%-- 데이터 값 선택 끝 --%>
			</div>
		<%-- 상품목록 시작 --%>
			<div id="compareTable">
				<div id="compareContainer">
					<div id="compareSelectDiv">
						<select class="compareSelect">
							<option value="sellnum">판매순</option>
							<option value="hprice">가격 높은순</option>
							<option value="lprice">가격 낮은순</option>
							<option value="staravg">만족도 평균순</option>
						</select>
					</div>
					<ul class="tableList">
						<li class="tableListHeader" id="tableListHeader">
							<div class="tableColumn tableCol-15">상품이름</div>
							<div class="tableColumn tableCol-30">상품 상세설명</div>
							<div class="tableColumn tableCol-10-1">가격</div>
							<div class="tableColumn tableCol-15">측정 적절 평수</div>
							<div class="tableColumn tableCol-10-1">측정 지점</div>
							<div class="tableColumn tableCol-15">서비스 가능지역</div>
							<div class="tableColumn tableCol-10-1">만족도 평균</div>
							<div class="tableColumn tableCol-10-1">판매 건수</div>
						</li>
						<c:forEach var="pList" items="${pList }">
							<li class="tableListContent post-item" id="${pList.product_code}">
								<div class="tableColumn tableCol-15" data-label="상품이름">${pList.product_name}</div>
								<div class="tableColumn tableCol-30" data-label="상품 상세설명">${pList.product_detail}</div>
								<div class="tableColumn tableCol-10-1" data-label="가격">${pList.product_price}</div>
								<div class="tableColumn tableCol-15" data-label="측정 적절 평수">
									<c:choose>
										<c:when test="${pList.p_space == '1'}">1~10평</c:when>
										<c:when test="${pList.p_space == '2'}">11~20평</c:when>
										<c:when test="${pList.p_space == '3'}">21~30평</c:when>
										<c:when test="${pList.p_space == '4'}">31~40평</c:when>
										<c:when test="${pList.p_space == '5'}">41~50평</c:when>
										<c:when test="${pList.p_space == '6'}">51~60평</c:when>
										<c:when test="${pList.p_space == '7'}">61~70평</c:when>
										<c:when test="${pList.p_space == '8'}">71~80평</c:when>
										<c:when test="${pList.p_space == '9'}">81~90평</c:when>
										<c:when test="${pList.p_space == '10'}">91~100평</c:when>
										<c:when test="${pList.p_space == '11'}">100~평</c:when>
									</c:choose>
								</div>
								<div class="tableColumn tableCol-10-1" data-label="측정 지점">${pList.measure_point}</div>
								<div class="tableColumn tableCol-15" data-label="서비스 가능지역">
									<c:forEach var="aList" items="${pList.areaVO }">
										${aList.area_si }
									</c:forEach>
								</div>
								<div class="tableColumn tableCol-10-1" data-label="만족도 평균">${pList.staravg}</div>
								<div class="tableColumn tableCol-10-1" data-label="판매 건수">${pList.sellnum}</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div>
				<c:if test="${sessionScope.user.member_devision == 'se' }">
					<button id="productWrite">상품등록</button>
				</c:if>
			</div>
			<nav aria-label="Page navigation example">
				<div class="d-flex justify-content-center">
					<ul class="pagination">
						<c:if test="${criteria.prev}">
							<li class="page-item"><a class="page-link" href="javascript:page(${criteria.getStartPage()-1});" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
						</c:if>
						<c:forEach begin="${criteria.getStartPage() }" end="${criteria.getEndPage() }" var="idx">
							<li class="page-item"><a class="page-link" href="javascript:page(${idx });">${idx}</a></li>
						</c:forEach>
						<c:if test="${criteria.next}">
							<li class="page-item"><a class="page-link" href="javascript:page(${criteria.getEndPage()+1});" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
						</c:if>
					</ul>
				</div>
			</nav>
		<%-- 상품목록 끝 --%>
		</div>
	<%-- 페이지 끝 --%>

	<script src="resources/js/core.js"></script>
	<script src="resources/js/maps.js"></script>
	<script src="resources/js/southKoreaHigh.js"></script>
	<script src="resources/js/animated.js"></script>
	<script src="resources/js/connect/compareMain.js"></script>
<%@include file="../include/footer.jsp" %>