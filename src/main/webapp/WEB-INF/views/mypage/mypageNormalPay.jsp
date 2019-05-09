<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageNormalPay.css" />
<h1>일반 사용자-결제 내역 페이지 입니다.</h1>

    <div class="container">
<div id="form1">
        <section class="content">
            <main>
           <%--상단 부분 시작 --%>
       <div class="form1">
       	   <div class="A">업체</div>        
           <div class="B">내용</div>
           <div class="topdate">날짜</div>
           <div class="topscore">별점</div>
            <select class="C"id="change">
                <option value="1" id="selectA">모든항목 </option>
                <option value="2" id="selectB">점수 등록필요</option>
                <option value="3" id="selectC">점수 등록완료</option>

            </select>
            </div>
        <%--상단 부분 끝 --%>
        <br>
        <%-- 하단부분 시작 --%>
        <%-- star_score all --%>
        <c:forEach var="mypay" items="${mypay}"
        varStatus="index" begin="0" end="20">
        <div class="form2" id="select1">
        	<div class="aa">${mypay.payment_code}</div>
            <div class="company_name">${mypay.company_name}</div> 
            <div class="product_detail">${mypay.product_detail}</div> 
            <div class="day">${mypay.day}</div>
            <div class="star_score">
            <c:if test="${mypay.star_score eq '0'}">
            <div class="star_number"><input type="number" class="star" name="star"/></div>
            <div class="star_scoreBtn"><button id="gavestar" class="gavestar" name="gavestar">별점 주기</button></div>
            </c:if>
            <c:if test="${mypay.star_score ne '0'}">
            ${mypay.star_score}
            </c:if>
            </div>
        </div>
        </c:forEach>
        
        <%-- star_score null --%>
        <c:forEach var="mypayNull" items="${mypayNull}"
        varStatus="index" begin="0" end="20">
        <div class="form3" id="select2">
        	<div class="bb">${mypayNull.payment_code}</div>
            <div class="company_name">${mypayNull.company_name}</div> 
            <div class="product_detail">${mypayNull.product_detail}</div> 
            <div class="day">${mypayNull.day}</div>
			<input type="number" class="star" name="star"/>
            <button id="gavestar" class="gavestar" name="gavestar">별점 주기</button>
        </div>
        </c:forEach>
        
        <%-- star_score not null --%>
        <c:forEach var="mypayNotNull" items="${mypayNotNull}"
        varStatus="index" begin="0" end="20">
        <div class="form4" id="select3">

            <div class="company_name">${mypayNotNull.company_name}</div> 
            <div class="product_detail">${mypayNotNull.product_detail}</div> 
            <div class="day">${mypayNotNull.day}</div>
            <div class="star_score">${mypayNotNull.star_score}</div>
        </div>
        </c:forEach>
        
        <%--하단부분 끝 --%>
            </main>
        </section>
        </div>
        <footer>

        </footer>
        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='/resources/js/mypage/mypageNormalPay.js'></script>
<%@include file="../include/footer.jsp" %>