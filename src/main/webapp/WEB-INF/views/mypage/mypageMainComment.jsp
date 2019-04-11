<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainComment.css" />
    <div class="container">
    <div class="Posts">
        <p>mypageMainComment page</p>
    </div >
<form id="form1">
        <section class="content">
            <main>
           <%--상단 부분 시작 --%>
       <div class="form1">
          <input type="checkbox" id="all" name="all">
           <select class="A"id="변경">
           	   <option value="1">선택</option>
               <option value="1">비공개</option>
               <option value="2">공개</option>
               <option value="3">삭제</option>
           </select>
           <div class="check"><button type="submit" id="check1" class="btn btn-check">확인</button></div>
           
           <div class="B">글쓴이</div>
            <select class="C"id="변경2">
                <option value="1">모든글보기</option>
                <option value="1">공개글보기</option>
                <option value="1">업체연결서비스</option>
                <option value="1">커뮤니티</option>
            </select>
            </div>
        <%--상단 부분 끝 --%>
        <br>
        <%-- 하단부분 시작 --%>
        <c:forEach var="Reply" items="${Reply}"
        varStatus="index" begin="0" end="15"> 
        <div class="form2">

            <div class="post_code"><input type="checkbox" id="cb" name="cb">${Reply.post_code }</div> 
            <div class="reply_content">${Reply.reply_content }</div>
            <div class="member_id">${Reply.member_id }</div> 
            <div class="r_creation_date">${Reply.r_creation_date }</div>
			<a href="<c:url value='/mypageMainComment/${Reply.reply_code }' />" class="btn btn-lg btn-danger">댓글 삭제</a>
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