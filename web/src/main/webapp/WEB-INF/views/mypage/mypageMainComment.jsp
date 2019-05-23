<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainComment.css" />
    <div class="container">
        <p></p>
<form id="form1">
        <section class="content">
            <main>
           <%--상단 부분 시작 --%>
       <div class="form1">
       	   <div class="A_select">구분</div>        
           <div class="A_title">글 제목</div>
           <div class="A_content">댓글 내용</div>           
           <div class="A_member">댓글 작성자</div>
           <div class="A_date">댓글 작성날짜</div>
           
            <select class="C"id="change">
                <option value="1">모든 댓글 보기</option>
                <option value="2">업체연결서비스</option>
                <option value="3">커뮤니티</option>
            </select>
            </div>
        <%--상단 부분 끝 --%>
        <br>
        
        <%-- 하단부분 시작 --%>
        <c:forEach var="Reply" items="${Reply}"> 
        <div class="form2">
        	<c:choose>
        		<c:when test="${Reply.board_name ne null }">
            		<div class="board">${Reply.board_name }</div>
            	</c:when>
            	<c:when test="${Reply.board_name eq null }">
            		<div class="board">업체 분석/비교</div>
            	</c:when>
            </c:choose>
            <c:choose>
        		<c:when test="${Reply.product_name ne null }">
            		<div class="name_title">${Reply.product_name }</div>
            	</c:when>
            	<c:when test="${Reply.product_name eq null }">
            		<div class="name_title">${Reply.post_title }</div>
            	</c:when>            	
            </c:choose>
            
            <div class="reply_content">${Reply.reply_content }</div>
            <div class="member_id">${Reply.member_id }</div> 
            <div class="r_creation_date">${Reply.r_creation_date }</div>
			<a href="<c:url value='/mypageMainComment/${Reply.reply_code }' />" class="btn btn-lg btn-danger">삭제</a>
        </div>
        </c:forEach>
        
        <c:forEach var="ReplyPost" items="${ReplyPost}"> 
        <div class="form3">
            <div class="board">${ReplyPost.board_name }</div>
            <div class="name_title">${ReplyPost.post_title }</div>
            <div class="reply_content">${ReplyPost.reply_content }</div>
            <div class="member_id">${ReplyPost.member_id }</div> 
            <div class="r_creation_date">${ReplyPost.r_creation_date }</div>
			<a href="<c:url value='/mypageMainComment/${ReplyPost.reply_code }' />" class="btn btn-lg btn-danger">삭제</a>
        </div>
        </c:forEach>
        
        <c:forEach var="ReplyProduct" items="${ReplyProduct}"> 
        <div class="form4">
            <div class="board">업체 분석/비교</div>
            <div class="name_title">${ReplyProduct.product_name }</div>
            <div class="reply_content">${ReplyProduct.reply_content }</div>
            <div class="member_id">${ReplyProduct.member_id }</div> 
            <div class="r_creation_date">${ReplyProduct.r_creation_date }</div>
			<a href="<c:url value='/mypageMainComment/${ReplyProduct.reply_code }' />" class="btn btn-lg btn-danger">삭제</a>
        </div>
        </c:forEach>
        
        <%--하단부분 끝 --%>
            </main>
        </section>
        </form>
        <footer>

        </footer>
        </div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='/resources/js/mypage/mypageMainComment.js'></script>
<%@include file="../include/footer.jsp" %>