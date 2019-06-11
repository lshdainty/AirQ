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

	<%-----------------지역/측정물질 선택------------------%>
	<ul class="category-container__border">
		<li class="category-option option-active" value="sellnum"><select
			name="sido_code" id="sido_code" class="order-option ">
				<option value="광역시/도">광역시/도</option>
		</select></li>
		<li class="category-option" value="hprice"><select
			name="sigoon_code" id="sigoon_code" class="order-option">
				<option value="선택">시/군</option>
		</select></li>
		<li class="category-option" value="lprice"><select name="matter"
			id="matter" class="order-option">
				<option value="측정 물질">측정 물질</option>
		</select></li>
	</ul>
	<%-----------------------------------------------%>


	<%-----------------지역/측정물질 값 ------------------%>

	<div class="table-container">
		<%------------ 테이블 시작 ------------%>
		
		
		
		<%-- img url --%>
		<!-- Blue : https://www.airkorea.or.kr/web/images/sub/item01.png -->
		<!-- Green : https://www.airkorea.or.kr/web/images/sub/item02.png -->
		<!-- Yellow :  https://www.airkorea.or.kr/web/images/sub/item03.png -->
		<!-- Red : https://www.airkorea.or.kr/web/images/sub/item04.png  -->
		<%-------------%>
		<table class="measure-table">
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
			<tbody>
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
				<tr>
					<th>06-10:19</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>9</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>5</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.030</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.024</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:18</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>11</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>5</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.030</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.023</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:17</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>9</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>2</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.030</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.023</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:16</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>12</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.026</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.025</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:15</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>10</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.026</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.024</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:14</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>7</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.029</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.021</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:13</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>7</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>5</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.030</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.020</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.003</td>
				</tr>
				<tr>
					<th>06-10:12</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>10</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.025</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.024</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:11</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>6</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>5</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.024</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.023</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.5</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:10</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>6</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.020</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.026</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.6</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.003</td>
				</tr>
				<tr>
					<th>06-10:09</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>2</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.017</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.028</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:08</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>6</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.019</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.026</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:07</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>5</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>2</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.024</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.020</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:06</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>5</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item02.png" alt="등급"></td>
					<td>0.032</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.012</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:05</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>4</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item02.png" alt="등급"></td>
					<td>0.036</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.008</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:04</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>7</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>5</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item02.png" alt="등급"></td>
					<td>0.038</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.008</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:03</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>11</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>7</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item02.png" alt="등급"></td>
					<td>0.040</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.007</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.003</td>
				</tr>
				<tr>
					<th>06-10:02</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>10</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>6</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item02.png" alt="등급"></td>
					<td>0.039</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.011</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
				<tr>
					<th>06-10:01</th>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>11</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>6</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item02.png" alt="등급"></td>
					<td>0.038</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.013</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.3</td>
					<td><img src="https://www.airkorea.or.kr/web/images/sub/item01.png" alt="등급"></td>
					<td>0.002</td>
				</tr>
			</tbody>
		</table>
		<%------------ 테이블 종료 ------------%>
	</div>
	<%-----------------------------------------------%>
</div>
<!------------------------------------------------------------------->
<script src="resources/js/core.js"></script>
<script src="resources/js/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/spiritedaway.js"></script>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=tpllhjh4tl&submodules=geocoder"></script>
<script type="text/javascript"
	src="https://navermaps.github.io/maps.js.ncp/docs/js/MarkerClustering.js"></script>
<script src="resources/js/manage/inside.js"></script>
<script src="resources/js/manage/monitoringMain.js"></script>
<%@include file="../include/footer.jsp"%>