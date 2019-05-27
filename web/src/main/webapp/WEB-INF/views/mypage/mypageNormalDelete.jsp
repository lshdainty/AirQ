<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<link rel="stylesheet" type="text/css" href="/resources/css/mypage/.css" />
<h1>일반 사용자-회원 탈퇴 페이지 입니다.</h1>
<form action="A" method="get">
		<input type="text" id="pw" name="pw">
		<input type = "submit" value = "탈퇴하기">
</form>
<%@include file="../include/footer.jsp" %>