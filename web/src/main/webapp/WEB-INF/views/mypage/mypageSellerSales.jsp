<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageSellerSales.css" />
<h1>판매자-매출 관리 페이지 입니다.</h1>
<%--             <div class="company_code"><input type="checkbox" id="cb" name="cb">${Gra.company_code }</div>  --%>
<%--             <div class="member_id">${Gra.member_id }</div> --%>
<%--             <div class="demand_date">${Gra.demand_date }</div>  --%>
<%--             <div class="payment_price">${Gra.payment_price }</div> --%>
<div id="chartdiv"></div>
<!-- <input type="hidden" id ="sum1" value=${cList[0].sum}> -->
<%-- <div class="cList" id ="cList">${cList[0].sum }</div> --%>
<%-- ${cList[1].company_code} --%>
<%-- ${cList[2].company_code} --%>
<%-- ${cList[0].sum} --%>
<script type="text/javascript">
// $(function(){
// 	var result = new Array();
	
// 	<c:forEach items ="${cList[0].sum}" var="cList[0].sum">
// 		var json=new Object();
// 		json.sum ="${cList[0].sum}";
// 		result.push(json);
// 	</c:forEach>
// 	alert("jsoninfojsp="+JSON.stringify(result));
// })
</script>
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
<script src="resources/js/mypage/mypageSellerSales.js"></script>
<%@include file="../include/footer.jsp" %>