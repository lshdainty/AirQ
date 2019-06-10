<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<li class="category-option option-active" value="sellnum">
			<select name="sido_code" id="sido_code" class="order-option ">
				<option value="광역시/도">광역시/도</option>
			</select>
		</li>
		<li class="category-option" value="hprice">
			<select name="sigoon_code" id="sigoon_code" class="order-option">
				<option value="선택">시/군</option>
			</select>
		</li>
		<li class="category-option" value="lprice">
			<select name="matter" id="matter" class="order-option">
				<option value="측정 물질">측정 물질</option>
			</select>
		</li>
	</ul>
	<div class="table-container">
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
					<th rowspan="2">날짜<br>(월-일:시)
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
				<tr>
					<th>06-10:20</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>15</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>9</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.023</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.029</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.003</td>
				</tr>
			</tbody>
		</table>
	</div>
	<%--외부 데이터 표시하기--%>
</div>
<script src="resources/js/core.js"></script>
<script src="resources/js/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=tpllhjh4tl&submodules=geocoder"></script>
<script type="text/javascript" src="https://navermaps.github.io/maps.js.ncp/docs/js/MarkerClustering.js"></script>
<script src="resources/js/manage/monitoringOut.js"></script>
<%@include file="../include/footer.jsp"%>