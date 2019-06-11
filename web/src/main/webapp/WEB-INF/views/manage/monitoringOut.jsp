<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" href="/resources/css/manage/monitoring_out.css">
<!------------------------- 외부 공기질 모니터링   ------------------------->
<div id="outside">
	<%--지도를 나타내주는 곳  시작--%>
	<%--<div id="map"></div> --%>
	<%-- 지도 부분 끝 --%>
	<%-- 차트 생성 --%>
	<div id="outchartdiv"></div>
	<%------------%>
	<%--외부 데이터 표시하기--%>
	<ul class="category-container__border">
		<li class="category-option option-active" value="sellnum"><select
			name="sido_code" id="sido_code" class="order-option ">
				<option value="서울">서울</option>
				<option value="부산">부산</option>
				<option value="대구">대구</option>
				<option value="인천">인천</option>
				<option value="광주">광주</option>
				<option value="대전">대전</option>
				<option value="울산">울산</option>
				<option value="경기">경기</option>
				<option value="강원">강원</option>
				<option value="충북">충북</option>
				<option value="충남">충남</option>
				<option value="전북">전북</option>
				<option value="전남">전남</option>
				<option value="경북">경북</option>
				<option value="경남">경남</option>
				<option value="제주">제주</option>
				<option value="세종">세종</option>
		</select></li>
		<li class="category-option" value="hprice"><select
			name="sigoon_code" id="sigoon_code" class="order-option">
		</select></li>
		<li class="category-option" value="lprice"><select name="matter"
			id="matter" class="order-option">
				<option value="pm10Value">미세먼지</option>
				<option value="pm25Value">초미세먼지</option>
				<option value="o3Value">오존</option>
				<option value="no2Value">이산화질소</option>
				<option value="coValue">일산화탄소</option>
				<option value="so2Value">아황산가스</option>
		</select></li>
	</ul>
	<div class="table-container">
		<div class="grade-table">
			<div class="grade-box">
				<div class="grade-img">
					<img class="point" src="/resources/images/point_1.png" alt="1">
				</div>
				<div class="grade-explain">최고</div>
			</div>
			<div class="grade-box">
				<div class="grade-img">
					<img class="point" src="/resources/images/point_1.png" alt="1">
				</div>
				<div class="grade-explain">좋음</div>
			</div>
			<div class="grade-box">
				<div class="grade-img">
					<img class="point" src="/resources/images/point_1.png" alt="1">
				</div>
				<div class="grade-explain">양호</div>
			</div>
			<div class="grade-box">
				<div class="grade-img">
					<img class="point" src="/resources/images/point_1.png" alt="1">
				</div>
				<div class="grade-explain">보통</div>
			</div>
			<div class="grade-box">
				<div class="grade-img">
					<img class="point" src="/resources/images/point_1.png" alt="1">
				</div>
				<div class="grade-explain">나쁨</div>
			</div>
			<div class="grade-box">
				<div class="grade-img">
					<img class="point" src="/resources/images/point_1.png" alt="1">
				</div>
				<div class="grade-explain">상당히 나쁨</div>
			</div>
			<div class="grade-box">
				<div class="grade-img">
					<img class="point" src="/resources/images/point_1.png" alt="1">
				</div>
				<div class="grade-explain">매우 나쁨</div>
			</div>
			<div class="grade-box">
				<div class="grade-img">
					<img class="point" src="/resources/images/point_1.png" alt="1">
				</div>
				<div class="grade-explain">최악</div>
			</div>
		</div>
		<input id="areaName" type="hidden" />
		<table class="measure-table">
					<caption>측정자료 검색 결과</caption>
			<colgroup>
				<col style="width: 100px">
				<col style="width: 35px">
				<col style="width: 65px">
				<col style="width: 35px">
				<col style="width: 65px">
				<col style="width: 35px">
				<col style="width: 65px">
				<col style="width: 35px">
				<col style="width: 65px">
				<col style="width: 35px">
				<col style="width: 65px">
				<col style="width: 35px">
				<col style="width: 65px">
			</colgroup>
			<thead>
				<tr>
					<th rowspan="2">날짜<br>(년-월-일 시:분)
					</th>
					<th colspan="2">PM<sub>10</sub><br>(㎍/㎥)
					</th>
					<th colspan="2">PM<sub>2.5</sub><br>(㎍/㎥)
					</th>
					<th colspan="2">오존<br>(ppm)
					</th>
					<th colspan="2">이산화질소<br>(ppm)
					</th>
					<th colspan="2">일산화탄소<br>(ppm)
					</th>
					<th colspan="2">아황산가스<br>(ppm)
					</th>
				</tr>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
	</div>
	<%--외부 데이터 표시하기--%>
</div>
<script src="/resources/js/core.js"></script>
<script src="/resources/js/charts.js"></script>
<script src="/resources/js/include/animated.js"></script>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=tpllhjh4tl&submodules=geocoder"></script>
<script type="text/javascript"
	src="https://navermaps.github.io/maps.js.ncp/docs/js/MarkerClustering.js"></script>
<script src="/resources/js/manage/monitoringOut.js"></script>
<%@include file="../include/footer.jsp"%>