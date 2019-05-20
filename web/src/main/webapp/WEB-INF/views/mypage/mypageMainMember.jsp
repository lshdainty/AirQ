<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/mypageMainMember.css" />
    <div class="container">
    <div class="Member">
		<p></p>    
        </div>
        <section class="content">
            <main>
        <div class="form1">
        <div class="A">ID</div>
        <div class="AA">이름</div>
        <div class="AAA">전화번호</div>
        <div class="AAAA">이메일</div>
        <div class="AAAAA">주소지</div>
        <div class="AAAAAA">회원분류</div>
            <select class="C"id="change">
            	<option value="0">모든사용자</option>
                <option value="1" id="selectB">일반사용자</option>
                <option value="2" id="selectC">판매사용자</option>
            </select>
        </div>
            <br>
        <c:forEach var="getMemberList" items="${getMemberList}">
        <div class="form3" id="select0">
            <div class="member_id">${getMemberList.member_id }</div>
            <div class="member_name">${getMemberList.member_name }</div> 
            <div class="member_tel">${getMemberList.member_tel }</div>
            <div class="member_email">${getMemberList.member_email }</div>
            <div class="m_addr_do">${getMemberList.m_addr_do }</div>
            <div class="member_devision">${getMemberList.member_devision}</div>
            <a href="<c:url value='/mypageMainMember/${getMemberList.member_id }' />" class="btn btn-lg btn-danger">회원 삭제</a>
        </div>
        </c:forEach>

            </main>
            </section>
        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='/resources/js/mypage/mypageMainMember.js'></script>
<%@include file="../include/footer.jsp" %>