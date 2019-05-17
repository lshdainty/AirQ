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
       <div class="A">게시판 목록</div>
       <div class="AA">제목</div>
           <div class="B">글 정보</div>
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
        <c:forEach var="tenderNMP" items="${tenderNMP}">
        <div class="form2" id="select1">
            <div class="tender_name">입찰 서비스</div> 
            <div class="title">${tenderNMP.tender_title }</div> 
            <div class="tender_A">참여업체수:${tenderNMP.company_count},입찰마감일자:${tenderNMP.t_creation_date}, 신고수:${tenderNMP.report_count}
        	</div>
            <div class="t_creation_date">${tenderNMP.t_creation_date }</div>
<%--             <a href="<c:url value='/mypageNormalPosts/${tenderList.tender_code }' />" class="btn btn-lg btn-danger">글 삭제</a> --%>
            <a href="<c:url value='/tenderContentGo/${tenderNMP.tender_code }' />" class="btn btn-primary">상세정보</a>           
            <div class="">
        	</div>
        </div>
        </c:forEach>
        
        <%-- POST --%>
        <c:forEach var="postNMP" items="${postNMP}">
        <div class="form4" id="select3">
            <div class="post_name">${postNMP.board_name }</div> 
            <div class="post_title">${postNMP.post_title }</div> 
            <div class="post_A">조회수:${postNMP.view_num },추천수:${postNMP.recommend_num },댓글수:${postNMP.reply_count }, 신고수:${postNMP.report_count }</div>
            <div class="p_creation_date">${postNMP.p_creation_date }</div>
            <a href="<c:url value='/postDetail?post_code=${postNMP.post_code }' />" class="btn btn-primary">상세정보</a>
<%--             <a href="<c:url value='/mypageNormalPostsPost/${postNMP.post_code }' />" class="btn btn-lg btn-danger">글 삭제</a> --%>

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