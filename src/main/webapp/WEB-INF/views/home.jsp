<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<h1>test branch 테스트중입니다.</h1>
<h3>branch 4차 test</h3>
<c:forEach var="member" items="${list }">
	<p>${member.id}</p>
	<p>${member.password}</p>
	<p>${member.name}</p>
	<p>${member.email}</p>
	<p>${member.tel}</p>
	<p>${member.address}</p><br/>
</c:forEach>
</body>
</html>
