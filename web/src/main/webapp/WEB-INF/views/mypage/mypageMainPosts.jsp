<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainPosts.css" />
    <div class="container">
        <div class="page-header">
			<h3>마이페이지 - 신고글 관리</h3>
		</div>
<div id="form1">
        <section class="content">
            <main>
           <%--상단 부분 시작 --%>
       <div class="form1">
       <div class="A">제목</div>
       <div class="AA">신고자</div>
       <div class="AAA">게시글 코드</div>
<!--        <div class="AAAA">신고횟수</div> -->
       <div class="AAAAA">신고 날짜</div>
       <div class="B">신고 횟수</div>
       <div class="AAAAAA">삭제 여부</div>
       
            <select class="C"id="change">
            	<option value="0">모든 글 보기</option>
                <option value="1" id="selectA">업체 분석/비교</option>
                <option value="2" id="selectB">커뮤니티</option>
                <option value="3" id="selectC">입찰서비스</option>
            </select>
            </div>
        <%--상단 부분 끝 --%>
        <br>
        
		<%-- 하단부분 시작  --%>
		    <c:forEach var="mypageMainR" items="${mypageMainR}">
		    	<c:choose>
		    	
		    		<c:when test="${mypageMainR.report_classification eq 'pd'}">
      					<div class="form2" id="${mypageMainR.report_code}">
           		 		<div class="report_title">${mypageMainR.report_title }</div> 
            			<div class="member_id">${mypageMainR.member_id }</div> 
            			<div class="original_code">${mypageMainR.original_code }</div>
            			<div class="report_date">${fn:substring(mypageMainR.report_date, 0 ,10) }</div>
            			<div class="report_count">${mypageMainR.report_count}</div>
            			<div class="delete_whether">${mypageMainR.delete_whether }</div>
        				</div>
        			</c:when>
        			
        			<c:when test="${mypageMainR.report_classification eq 'ps'}">
      					<div class="form3" id="${mypageMainR.report_code}"> 
           		 		<div class="report_title">${mypageMainR.report_title }</div> 
            			<div class="member_id">${mypageMainR.member_id }</div> 
            			<div class="original_code">${mypageMainR.original_code }</div>
            			<div class="report_date">${fn:substring(mypageMainR.report_date, 0 ,10) }</div>
            			<div class="report_count">${mypageMainR.report_count}</div>
            			<div class="delete_whether">${mypageMainR.delete_whether }</div>
        				</div>
        			</c:when>
        			
		    		<c:when test="${mypageMainR.report_classification eq 'td'}">
      					<div class="form4" id="${mypageMainR.report_code}"> 
           		 		<div class="report_title">${mypageMainR.report_title }</div> 
            			<div class="member_id">${mypageMainR.member_id }</div> 
            			<div class="original_code">${mypageMainR.original_code }</div>
            			<div class="report_date">${fn:substring(mypageMainR.report_date, 0 ,10) }</div>
            			<div class="report_count">${mypageMainR.report_count}</div>
            			<div class="delete_whether">${mypageMainR.delete_whether }</div>
        				</div>
        			</c:when>
        			 
        		</c:choose>
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