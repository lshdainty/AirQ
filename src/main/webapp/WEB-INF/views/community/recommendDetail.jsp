<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>

<input type="hidden" value="${detailBoard.board_id}" id="test2" name="board_id">
<div>
	"${detailBoard.board_name}"
	"${detailBoard.board_content}";
	"${detailBoard.board_author}";
</div>
<a href="recommendDelete?board_id=${detailBoard.board_id}" class="btn btn-primary" id="test">삭제</a>
<a href="recommendModify?board_id=${detailBoard.board_id}" class="btn btn-primary" id="test">수정</a>
<script>
$(document).ready(function(){
	$('#test').click(function(){
		alert($('#test2').val());
	});
});
</script>
<%@include file="../include/footer.jsp" %>
