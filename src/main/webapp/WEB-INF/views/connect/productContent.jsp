<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
여기까지는 왔다.
${productContent.product_code}<br/>
${productContent.product_name}<br/>
${productContent.product_detail}<br/>
${productContent.product_price}<br/>
<c:choose>
	<c:when test="${productContent.p_space == '1'}">1~10평</c:when>
	<c:when test="${productContent.p_space == '2'}">11~20평</c:when>
	<c:when test="${productContent.p_space == '3'}">21~30평</c:when>
	<c:when test="${productContent.p_space == '4'}">31~40평</c:when>
	<c:when test="${productContent.p_space == '5'}">41~50평</c:when>
	<c:when test="${productContent.p_space == '6'}">51~60평</c:when>
	<c:when test="${productContent.p_space == '7'}">61~70평</c:when>
	<c:when test="${productContent.p_space == '8'}">71~80평</c:when>
	<c:when test="${productContent.p_space == '9'}">81~90평</c:when>
	<c:when test="${productContent.p_space == '10'}">91~100평</c:when>
	<c:when test="${productContent.p_space == '11'}">100~평</c:when>
</c:choose>
${productContent.measure_point}<br/>
<c:forEach var="aList" items="${productContent.areaVO }">
	${aList.area_si }<br/>
</c:forEach>
${productContent.staravg}<br/>
${productContent.sellnum}<br/>
<%@include file="../include/footer.jsp"%>
