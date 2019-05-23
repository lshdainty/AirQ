<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainPostsIn.css" />
   <div class="container">
        <p></p>

<div id="form1">
        <section class="content">
            <main>
            		    <c:forEach var="mypageMainRIn" items="${mypageMainRIn}">
            		    <div class="top">
            	            <div class="report_title">${mypageMainRIn.report_title }</div>
            	            <div class="member_id">${mypageMainRIn.member_id }</div> 
            	            <div class="report_date">${mypageMainRIn.report_date}</div>
            	            <div class="report_count">신고된 횟수:${mypageMainRIn.report_count}</div>
            	        </div>
            	        	신고 내용 
            	        	<br>
            	            <div class="report_content">${mypageMainRIn.report_content }</div>
            	            <div class="link">
            	            <c:choose>
            	            <c:when test="${mypageMainRIn.report_classification eq 'td' }">
           				    <a href="<c:url value='/tenderContent/${mypageMainRIn.original_code }' />" class="btn btn-primary">상세정보</a>
           					</c:when>
           					<c:when test="${mypageMainRIn.report_classification eq 'pd' }">
           					<a href="<c:url value='/product?product_code=${mypageMainRIn.original_code }' />" class="btn btn-primary">상세정보</a>
           					</c:when>
           					<c:when test="${mypageMainRIn.report_classification eq 'ps' }">
           					<a href="<c:url value='/postDetail?post_code=${mypageMainRIn.original_code }' />" class="btn btn-primary">상세정보</a>
           					</c:when>
           					</c:choose>
           					</div>
           				</c:forEach>
            </main>
        </section>
        </div>
        <footer>

        </footer>
        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- <script src='/resources/js/mypage/mypageMainPostsIn.js'></script> -->
<%@include file="../include/footer.jsp" %>