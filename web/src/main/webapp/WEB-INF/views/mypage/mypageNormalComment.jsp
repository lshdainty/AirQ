<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageNormalComment.css" />
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
           <div class="A_date">댓글 작성날짜</div>
           
            <select class="C"id="change">
                <option value="1">모든 댓글 보기</option>
                <option value="2">커뮤니티</option>
                <option value="3">업체 분석/비교</option>
            </select>
            </div>
        <%--상단 부분 끝 --%>
        <br>
        
        <%-- 하단부분 시작 --%>
        <c:forEach var="ReplyN" items="${ReplyN}"> 
        <div class="form2">
        	<c:choose>
        		<c:when test="${ReplyN.board_name ne null }">
            		<div class="board">${ReplyN.board_name }</div>
            	</c:when>
            	<c:when test="${ReplyN.board_name eq null }">
            		<div class="board">업체 분석/비교</div>
            	</c:when>
            </c:choose>
            <c:choose>
        		<c:when test="${ReplyN.product_name ne null }">
            		<div class="name_title">${ReplyN.product_name }</div>
            	</c:when>
            	<c:when test="${ReplyN.product_name eq null }">
            		<div class="name_title">${ReplyN.post_title }</div>
            	</c:when>            	
            </c:choose>
            
            <div class="reply_content">${ReplyN.reply_content }</div>
            <div class="r_creation_date">${ReplyN.r_creation_date }</div>
            <c:choose>
            	<c:when test="${ReplyN.post_code eq null }">
            		<a href="<c:url value='/product?product_code=${ReplyN.product_code }' />" class="btn btn-primary">상세정보</a>        
                </c:when>
                <c:when test="${ReplyN.product_code eq null }">
            		<a href="<c:url value='/postDetail?post_code=${ReplyN.post_code }' />" class="btn btn-primary">상세정보</a>        
                </c:when>
           	</c:choose>			
           	<a href="<c:url value='/mypageNormalComment/${ReplyN.reply_code }' />" class="btn btn-lg btn-danger">삭제</a>
        </div>
        </c:forEach>

        <c:forEach var="ReplyNPost" items="${ReplyNPost}"> 
        <div class="form3">
            <div class="board">${ReplyNPost.board_name }</div>
            <div class="name_title">${ReplyNPost.post_title }</div>
            <div class="reply_content">${ReplyNPost.reply_content }</div>
            <div class="r_creation_date">${ReplyNPost.r_creation_date }</div>
            <a href="<c:url value='/postDetail?post_code=${ReplyNPost.post_code }' />" class="btn btn-primary">상세정보</a>        
           	<a href="<c:url value='/mypageNormalComment/${ReplyNPost.reply_code }' />" class="btn btn-lg btn-danger">삭제</a>
        </div>
        </c:forEach>
        
        <c:forEach var="ReplyNProduct" items="${ReplyNProduct}"> 
        <div class="form4">
            <div class="board">업체 분석/비교</div>
            <div class="name_title">${ReplyNProduct.product_name }</div>
            <div class="reply_content">${ReplyNProduct.reply_content }</div>
            <div class="r_creation_date">${ReplyNProduct.r_creation_date }</div>
            <a href="<c:url value='/product?product_code=${ReplyNProduct.product_code }' />" class="btn btn-primary">상세정보</a>        
			<a href="<c:url value='/mypageNormalComment/${ReplyNProduct.reply_code }' />" class="btn btn-lg btn-danger">삭제</a>
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
<script src='/resources/js/mypage/mypageNormalComment.js'></script>
<%@include file="../include/footer.jsp" %>