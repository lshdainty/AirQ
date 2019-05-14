<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainMember.css" />
    <div class="container">
    <div class="Member">
        mypageMainMember<br>
    </div>
        <section class="content">
            <main>
        <div class="form1">
            <select class="A"id="select">
            	<option value="1">모든사용자</option>
                <option value="1">일반사용자</option>
                <option value="1">판매사용자</option>
            </select>
            </div>
            <div class="form2">
        <c:forEach var="getMemberList" items="${getMemberList}"
        varStatus="index" begin="1" end="30">
        <div class="B">
            <div class="member_id">ID:${getMemberList.member_id }</div>
            <div class="member_name">이름: ${getMemberList.member_name }</div> 
            <div class="member_tel">${getMemberList.member_tel }</div>
            <div class="member_email">${getMemberList.member_email }</div>
            <div class="m_addr_do">${getMemberList.m_addr_do }</div>
            <div class="member_devision">회원 분류:${getMemberList.member_devision}</div>
            <a href="<c:url value='/mypageMainMember/${getMemberList.member_id }' />" class="btn btn-lg btn-danger">회원 삭제</a>
        </div>
        </c:forEach>
            </div>
            </main>
            </section>
        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='/resources/js/mypage/mypageMainMember.js'></script>
<%@include file="../include/footer.jsp" %>