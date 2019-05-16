<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageNormalPosts.css" />
    <div class="container">
    <p></p>
<div id="form1">
        <section class="content">
            <main>
           <%--상단 부분 시작 --%>
       <div class="form1">
       <div class="A">제목</div>
       <div class="AA">내용</div>
           <div class="B">글쓴이</div>
            <select class="C"id="change">
            	<option value="0">모든 글 보기</option>
                <option value="1" id="selectA">입찰 서비스</option>
                <option value="3" id="selectC">커뮤니티</option>
            </select>
            </div>
        <%--상단 부분 끝 --%>
        <br>
        <%-- 하단부분 시작 --%>
        <%-- TENDER --%>
        <c:forEach var="tenderList" items="${tenderList}">
        <div class="form2" id="select1">

            <div class="tender_title">${tenderList.tender_title }</div> 
            <div class="requirement">${tenderList.requirement }</div> 
            <div class="tender_name">${tenderList.member_id }</div>
            <div class="t_creation_date">${tenderList.t_creation_date }</div>
            <a href="<c:url value='/mypageNormalPosts/${tenderList.tender_code }' />" class="btn btn-lg btn-danger">글 삭제</a>
        </div>
        </c:forEach>
        
        <%-- POST --%>
        <c:forEach var="postNMP" items="${postNMP}">
        <div class="form4" id="select3">

            <div class="post_title">${postNMP.post_title }</div> 
            <div class="post_content">${postNMP.post_content }</div> 
            <div class="member_id">${postNMP.member_id }</div>
            <div class="p_creation_date">${postNMP.p_creation_date }</div>
            <a href="<c:url value='/mypageNormalPostsPost/${postNMP.post_code }' />" class="btn btn-lg btn-danger">글 삭제</a>
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