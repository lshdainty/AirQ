<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
	<h1>로그인 메인페이지입니다.</h1>
	<c:if test="${sessionScope.user == null }">
		<form action="login" method="post">
			<input name="id" type="text"></input>
			<input name="password" type="password"></input>
			<input type="submit" value="login">
		</form>
	</c:if>
	<c:if test="${sessionScope.user != null}">
		<a href="logout">logout</a>
	</c:if>
<%@include file="../include/footer.jsp" %>