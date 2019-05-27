<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMain.css" />

<%-- use strict 시작 (.js 파일로 나누지 않은 이유는 검색 결과.. 한 파일 안에 있어야 됨) --%>
<%-- use strict 끝 --%>

<%-- 방문자 수 그래프 시작 --%>
<div class="container">
<!-- 	<div class="login-main-text"> -->

<!-- 		<br> <br> -->
<!-- 	</div> -->
 <%-- 방문자 수 그래프 끝 --%>
<!-- <div id="chartdiv"></div> -->

	<section class="content">
		<main>

		<h2>최신글 목록</h2>
<!-- 업체 분석/비교	 -->
	<p>업체 분석/비교</p>
	<div class="row">
	<c:forEach var="productMP" items="${productMP}" varStatus="status"
	begin="0" end="2">
			<div class="col-md-4">
				<div class="card mb-4">
					<img src="resources/images/test2.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text">업체 분석/비교</p>
						<h5 class="card-title">${productMP.product_name}</h5>
						<p class="card-text">작성자:${productMP.member_id}</p>
						<p class="card-text">가격:${productMP.product_price}</p>
           				<a href="<c:url value='/product?product_code=${productMP.product_code}'/>" class="btn btn-primary">상세정보</a>
					</div>
				</div>
			</div>	
	</c:forEach>
	</div>
<!-- 입찰 서비스	 -->
	<p>입찰 서비스</p>
	<div class="row">
	<c:forEach var="tenderMP" items="${tenderMP}" varStatus="status"
	begin="0" end="2">
			<div class="col-md-4">
				<div class="card mb-4">
					<img src="resources/images/test2.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text">입찰 서비스</p>
						<h5 class="card-title">${tenderMP.tender_title }</h5>
						<p class="card-text">작성자:${tenderMP.member_id }</p>
						<p class="card-text">입찰마감일자:${fn:substring(tenderMP.tender_deadline,0,10) }</p>
           				<a href="<c:url value='/tenderContent/${tenderMP.tender_code }' />" class="btn btn-primary">상세정보</a>
					</div>
				</div>
			</div>	
	</c:forEach>
	</div>			
<!-- 상품추천	 -->
	<p>상품추천</p>
	<div class="row">
	<c:forEach var="postMPrec" items="${postMPrec}" varStatus="status"
	begin="0" end="2">
	<c:if test="${postMPrec.board_code eq 'bd_rec'}">
			<div class="col-md-4">
				<div class="card mb-4">
					<img src="resources/images/test2.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text">${postMPrec.board_name }</p>
						<h5 class="card-title">${postMPrec.post_title }</h5>
						<p class="card-text">작성자:${postMPrec.member_id }</p>
						<p class="card-text">조회수:${postMPrec.view_num }</p>
           				<a href="<c:url value='/postDetail?post_code=${postMPrec.post_code }' />" class="btn btn-primary">상세정보</a>
					</div>
				</div>
			</div>	
	</c:if>
	</c:forEach>
	</div>	
<!-- 	공기질 향상 -->
	<p>공기질 향상방법</p>
	<div class="row">	
	<c:forEach var="postMPimp" items="${postMPimp}" varStatus="status"
	begin="0" end="2">
	<c:if test="${postMPimp.board_code eq 'bd_imp'}" >
			<div class="col-md-4">
				<div class="card mb-4">
					<img src="resources/images/test2.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text">${postMPimp.board_name }</p>
						<h5 class="card-title">${postMPimp.post_title }</h5>
						<p class="card-text">작성자:${postMPimp.member_id }</p>
						<p class="card-text">조회수:${postMPimp.view_num }</p>
           				<a href="<c:url value='/postDetail?post_code=${postMPimp.post_code }' />" class="btn btn-primary">상세정보</a>
					</div>
				</div>
			</div>	
	</c:if>
	</c:forEach>
	</div>
<!-- 	자유게시판 -->
	<p>자유게시판</p>	
	<div class="row">
	<c:forEach var="postMPlib" items="${postMPlib}" varStatus="status"
	begin="0" end="2">
	<c:if test="${postMPlib.board_code eq 'bd_lib'}">
			<div class="col-md-4">
				<div class="card mb-4">
					<img src="resources/images/test2.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text">${postMPlib.board_name }</p>
						<h5 class="card-title">${postMPlib.post_title }</h5>
						<p class="card-text">작성자:${postMPlib.member_id }</p>
						<p class="card-text">조회수:${postMPlib.view_num }</p>
           				<a href="<c:url value='/postDetail?post_code=${postMPlib.post_code }' />" class="btn btn-primary">상세정보</a>
					</div>
				</div>
			</div>	
	</c:if>
	</c:forEach>
	</div>
<!-- 		건강지킴이 -->
	<p>건강지킴이</p>
	<div class="row">
	<c:forEach var="postMPhea" items="${postMPhea}" varStatus="status"
	begin="0" end="2">
	<c:if test="${postMPhea.board_code eq 'bd_hea'}">
			<div class="col-md-4">
				<div class="card mb-4">
					<img src="resources/images/test2.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text">${postMPhea.board_name }</p>
						<h5 class="card-title">${postMPhea.post_title }</h5>
						<p class="card-text">작성자:${postMPhea.member_id }</p>
						<p class="card-text">조회수:${postMPhea.view_num }</p>
           				<a href="<c:url value='/postDetail?post_code=${postMPhea.post_code }' />" class="btn btn-primary">상세정보</a>
					</div>
				</div>
			</div>	
	</c:if>
	</c:forEach>
	</div>
<!-- 	대기오염물질정보 -->
	<p>대기오염 물질정보</p>
	<div class="row">
	<c:forEach var="postMPmet" items="${postMPmet}" varStatus="status"
	begin="0" end="2">
	<c:if test="${postMPmet.board_code eq 'bd_met'}">
			<div class="col-md-4">
				<div class="card mb-4">
					<img src="resources/images/test2.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<p class="card-text">${postMPmet.board_name }</p>
						<h5 class="card-title">${postMPmet.post_title }</h5>
						<p class="card-text">작성자:${postMPmet.member_id }</p>
						<p class="card-text">조회수:${postMPmet.view_num }</p>
           				<a href="<c:url value='/postDetail?post_code=${postMPmet.post_code }' />" class="btn btn-primary">상세정보</a>
					</div>
				</div>
			</div>	
	</c:if>
	</c:forEach>
	</div>					
		</main>
		<nav>
			<ul>
			</ul>
		</nav>
		<aside></aside>

	</section>
</div>
<footer>
				


</footer>
<script src="resources/js/core.js"></script>
<script src="resources/js/charts.js"></script>
<script src="resources/js/animated.js"></script>
<script>
am4core.ready(function() {

// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

var chart = am4core.create("chartdiv", am4charts.XYChart);
chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

chart.data = [
  {
    country: "USA",
    visits: 23725
  },
  {
    country: "China",
    visits: 1882
  },
  {
    country: "Japan",
    visits: 1809
  },
  {
    country: "Germany",
    visits: 1322
  },
  {
    country: "UK",
    visits: 1122
  },
  {
    country: "France",
    visits: 1114
  },
  {
    country: "India",
    visits: 984
  },
  {
    country: "Spain",
    visits: 711
  },
  {
    country: "Netherlands",
    visits: 665
  },
  {
    country: "Russia",
    visits: 580
  },
  {
    country: "South Korea",
    visits: 443
  },
  {
    country: "Canada",
    visits: 441
  }
];

var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
categoryAxis.renderer.grid.template.location = 0;
categoryAxis.dataFields.category = "country";
categoryAxis.renderer.minGridDistance = 40;
categoryAxis.fontSize = 11;

var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
valueAxis.min = 0;
valueAxis.max = 24000;
valueAxis.strictMinMax = true;
valueAxis.renderer.minGridDistance = 30;
// axis break
var axisBreak = valueAxis.axisBreaks.create();
axisBreak.startValue = 2100;
axisBreak.endValue = 22900;
axisBreak.breakSize = 0.005;

// make break expand on hover
var hoverState = axisBreak.states.create("hover");
hoverState.properties.breakSize = 1;
hoverState.properties.opacity = 0.1;
hoverState.transitionDuration = 1500;

axisBreak.defaultState.transitionDuration = 1000;
/*
// this is exactly the same, but with events
axisBreak.events.on("over", function() {
  axisBreak.animate(
    [{ property: "breakSize", to: 1 }, { property: "opacity", to: 0.1 }],
    1500,
    am4core.ease.sinOut
  );
});
axisBreak.events.on("out", function() {
  axisBreak.animate(
    [{ property: "breakSize", to: 0.005 }, { property: "opacity", to: 1 }],
    1000,
    am4core.ease.quadOut
  );
});*/

var series = chart.series.push(new am4charts.ColumnSeries());
series.dataFields.categoryX = "country";
series.dataFields.valueY = "visits";
series.columns.template.tooltipText = "{valueY.value}";
series.columns.template.tooltipY = 0;
series.columns.template.strokeOpacity = 0;

// as by default columns of the same series are of the same color, we add adapter which takes colors from chart.colors color set
series.columns.template.adapter.add("fill", function(fill, target) {
  return chart.colors.getIndex(target.dataItem.index);
});

}); // end am4core.ready()
</script>

<script src='resources/js/mypage/mypageMain.js'></script>
<%@include file="../include/footer.jsp"%>