<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainPosts.css" />
    <div class="container">
    <div class="Posts">
        <p>mypageMainPosts page</p>
    </div >
<div id="form1">
        <section class="content">
            <main>
           <%--상단 부분 시작 --%>
       <div class="form1">
          <input type="checkbox" id="all" name="all">
			<a href="<c:url value=' ' />" class="btn btn-lg btn-danger">글 삭제</a>           
           <div class="B">글쓴이</div>
            <select class="C"id="change">
            	<option value="0">모든 글 보기</option>
                <option value="1" id="selectA">입찰 서비스</option>
                <option value="2" id="selectB">업체 분석/비교</option>
                <option value="3" id="selectC">커뮤니티</option>
            </select>
            </div>
        <%--상단 부분 끝 --%>
        <br>
        <%-- 하단부분 시작 --%>
        <%-- TENDER --%>
        <c:forEach var="tenderList" items="${tenderList}"
        varStatus="index" begin="0" end="20">
        <div class="form2" id="select1">

            <div class="tender_title"><input type="checkbox" id="cb" name="cb">${tenderList.tender_title }</div> 
            <div class="requirement">${tenderList.requirement }</div> 
            <div class="tender_name">${tenderList.tender_name }</div>
            <div class="t_creation_date">${tenderList.t_creation_date }</div>
            <a href="<c:url value='/mypageMainPosts/${tenderList.tender_code }' />" class="btn btn-lg btn-danger">글 삭제</a>
        </div>
        </c:forEach>
        
        <%-- PRODUCT --%>
        <c:forEach var="productMP" items="${productMP}"
        varStatus="index" begin="0" end="20">
        <div class="form3" id="select2">

            <div class="product_code"><input type="checkbox" id="cb" name="cb">${productMP.product_code }</div> 
            <div class="product_detail">${productMP.product_detail }</div> 
            <div class="product_name">${productMP.product_name }</div>
            <a href="<c:url value='/mypageMainPostsProduct/${productMP.product_code }' />" class="btn btn-lg btn-danger">글 삭제</a>
        </div>
        </c:forEach>
        
        <%-- POST --%>
        <c:forEach var="postMP" items="${postMP}"
        varStatus="index" begin="0" end="20">
        <div class="form4" id="select3">

            <div class="post_title"><input type="checkbox" id="cb" name="cb">${postMP.post_title }</div> 
            <div class="post_content">${postMP.post_content }</div> 
            <div class="member_id">${postMP.member_id }</div>
            <div class="p_creation_date">${postMP.p_creation_date }</div>
            <a href="<c:url value='/mypageMainPostsPost/${postMP.post_code }' />" class="btn btn-lg btn-danger">글 삭제</a>
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
<script src='/resources/js/mypage/mypageMainPosts.js'></script>
<%@include file="../include/footer.jsp" %>