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
        <div class="form1">
           <input type="checkbox" id="delete" name="delete">
           <button class="delete">삭제</button>
           <div class="check"><button type="submit" id="check1" class="btn btn-check">확인</button></div>
           
           <div class="B">글쓴이</div>
            <select class="C"id="변경2">
            	<option value="1">모든사용자</option>
                <option value="1">일반사용자</option>
                <option value="1">판매사용자</option>
            </select>
        <c:forEach var="getMemberList" items="${getMemberList}"
        varStatus="index" begin="0" end="4">
        
            <div class="member_information">ID:${getMemberList.member_id } 이름: ${getMemberList.member_name }, 
            ${getMemberList.member_tel }, ${getMemberList.member_email }, ${getMemberList.m_addr_do }</div>
                    </c:forEach>
            </div>
            </main>
            </section>
                </form>
        </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src='/resources/js/mypage/mypageMainMember.js'></script>
<%@include file="../include/footer.jsp" %>