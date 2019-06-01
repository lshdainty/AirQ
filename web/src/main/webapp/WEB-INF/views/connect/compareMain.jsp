<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
	<link rel="stylesheet" href="/resources/css/connect/compareMain.css">
	<link rel="stylesheet" href="/resources/css/include/table.css">
	<%-- 각 도의 시목록 api 키값 시작 --%>
	<input type="hidden" id="sido_key" value="12685d425f1af0872d756c" />
	<input type="hidden" id="sigoon_key" value="b0888bae39fbd0463a9252" />
	<%-- 각 도의 시목록 api 키값 끝 --%>
	<!-- Web Wrapper -->
    <div class="compare-wrap">
        <!-- recommanded posts -->
        <div class="compare-recommand">
            <div class="recommand-explain">
                <p class="smart_recommand">SMART추천</p>
                <p class="smart_explain">고객님이 사는 지역에서 많이 팔린 상품들입니다.</p>
            </div>
            <div class="compare-recommand__posts">
            <c:forEach var="recommend" items="${recommend}">
                <div class="compare-recommand__post" id="${recommend.product_code}">
                    <!-- post thumbnail -->
                    <div class="recommanded-thumbnail">
                        <img src="/resources/uploadFile/images/${recommend.file_name }" alt="이미지X">
                    </div>
                    <!-- post title -->
                    <div class="recommanded-title"><span>${recommend.product_name}</span></div>
                </div>
            </c:forEach>
            </div>
        </div>
        <div class="order-address">
            <select name="sido_code" id="sido_code" class="order-option ">
                <option value="광역시/도">광역시/도</option>
            </select>
            <select name="sigoon_code" id="sigoon_code" class="order-option">
                <option value="선택">선택</option>
            </select>
            <select name="space" id="space" class="order-option">
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
            <select name="matter" id="matter" class="order-option">
                <option value="측정 물질">측정 물질</option>
            </select>
        </div>
        <ul class="compare-category">
            <li class="category-option option-active" value="sellnum">판매순</li>
            <li class="category-option" value="hprice">가격 높은 순</li>
            <li class="category-option" value="lprice">가격 낮은 순</li>
            <li class="category-option" value="staravg">만족도 평균순</li>
        </ul>
        <div class="compare-list">
        	<c:forEach var="pList" items="${pList }">
            <div class="compare-post post-item" id="${pList.product_code}">
                <div class="compare-thumb">
                    <img src="/resources/uploadFile/images/${pList.file_name }" alt="이미지X">
                </div>
                <div class="compare-info">
                    <div class="compare__title"><span>${pList.product_name}</span></div>
                    <div class="compare__content">
                    	측정 적절 평수 : <span>
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
										</span><br/>
						측정 지점 : <span>${pList.measure_point}</span><br/>
						만족도 평균 : <span>${pList.staravg}</span><br/>
						판매 건수 : <span>${pList.sellnum}</span><br/>
						측정 물질 : <c:forEach var="mList" items="${pList.matterVO }" varStatus="status">
										<span>${mList.matter_name }<c:if test="${!status.last}">, </c:if></span>
									</c:forEach>
                    </div>
                    <div class="compare__price"><span>${pList.product_price}</span>원</div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
	<div class="productWriteDiv">
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
	<script src="resources/js/connect/compareMain.js"></script>
<%@include file="../include/footer.jsp" %>