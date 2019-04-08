<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainMember.css" />
    <div class="container">
    <div class="Member">
        mypageMainMember<br>
    </div>
    <form class="form1">
        <section class="content">
            <main>
        <div class="fomr1">
           <input type="checkbox" id="all" name="all">
           <select class="A"id="변경">
               <option value="2">공개</option>
               <option value="3">삭제</option>
           </select>
           <div class="check"><button type="submit" id="check1" class="btn btn-check">확인</button></div>
           
           <div class="B">글쓴이</div>
            <select class="C"id="변경2">
                <option value="1">일반사용자</option>
                <option value="1">판매업체</option>
            </select>
            </div>
            </main>
            </section>
                </form>
        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='/resources/js/mypage/mypageMainMember.js'></script>
<%@include file="../include/footer.jsp" %>