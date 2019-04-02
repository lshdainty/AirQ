<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>


<div>
	"${detailBoard.board_name}"
	"${detailBoard.board_content}";
	"${detailBoard.board_author}";
</div>

<%@include file="../include/footer.jsp" %>