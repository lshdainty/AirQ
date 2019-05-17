<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageSellerPosts.css" />
    <div class="container">
    <div class="Posts">
        <p></p>
    </div >
<div id="form1">
        <section class="content">
            <main>
           <%--상단 부분 시작 --%>
       <div class="form1">
       <div class="A">게시판 목록</div>
       <div class="AA">제목</div>
           <div class="B">글 정보</div>
            <select class="C"id="change">
            	<option value="0">모든 글 보기</option>
                <option value="2" id="selectB">업체 분석/비교</option>
                <option value="3" id="selectC">커뮤니티</option>
            </select>
            </div>
        <%--상단 부분 끝 --%>
        <br>
        <%-- 하단부분 시작 --%>
        
        <%-- PRODUCT --%>
        <c:forEach var="productSMP" items="${productSMP}">
        <div class="form3" id="select2">
            <div class="product_">업체 분석/비교</div> 
            <div class="product_name">${productSMP.product_name }</div> 
            <div class="product_A">가격:${productSMP.product_price},측정지점:${productSMP.measure_point}</div>
            <a href="<c:url value='/product?product_code=${productSMP.product_code }' />" class="btn btn-primary">상세정보</a>
<%--             <a href="<c:url value='/mypageSellerPostsProduct/${productSMP.product_code }' />" class="btn btn-danger">글삭제</a>         --%>    
        	</div>
        </c:forEach>
        
        <%-- POST --%>
        <c:forEach var="postNMP" items="${postNMP}">
        <div class="form4" id="select3">
            <div class="post_name">${postNMP.board_name }</div> 
            <div class="post_title">${postNMP.post_title }</div> 
            <div class="post_A">조회수:${postNMP.view_num },추천수:${postNMP.recommend_num },댓글수:${postNMP.reply_count }</div>
            <div class="p_creation_date">${postNMP.p_creation_date }</div>
            <a href="<c:url value='/postDetail?post_code=${postNMP.post_code }' />" class="btn btn-primary">상세정보</a>
<%--             <a href="<c:url value='/mypageSellerPostsPost/${postNMP.post_code }' />" class="btn btn-danger">글삭제</a>                 --%>      
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
<script src='/resources/js/mypage/mypageSellerPosts.js'></script>

<%@include file="../include/footer.jsp" %>